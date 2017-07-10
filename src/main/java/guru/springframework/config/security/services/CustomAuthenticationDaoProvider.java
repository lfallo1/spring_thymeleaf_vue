package guru.springframework.config.security.services;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

import guru.springframework.config.security.domain.CustomUsernamePasswordAuthenticationToken;
import guru.springframework.config.security.domain.CustomWebAuthenticationDetails;
import guru.springframework.config.security.domain.UserPrivileges;

@Deprecated
public class CustomAuthenticationDaoProvider extends DaoAuthenticationProvider {
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {

		String verificationCode = ((CustomWebAuthenticationDetails) authentication.getDetails()).getVerificationCode();
		String name = authentication.getName();

		UserPrivileges user = (UserPrivileges) super.getUserDetailsService().loadUserByUsername(name);
		
		//verification code authentication
		if (user.isUsing2fa()) {
			if (!user.getSecret().equals(verificationCode)) {
				throw new BadCredentialsException("Invalid verfication code");
			}
		}
		
		//normal authentication
		Authentication result = super.authenticate(authentication);
		return new CustomUsernamePasswordAuthenticationToken(user, result.getCredentials(), user.getAuthorities());
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}
	
	/**
	 * this unfortunately needs to be overridden. when allowing parent to handle, it will check for the
	 * user details service dependency prior to actually being set.
	 */
	@Override
	protected void doAfterPropertiesSet() throws Exception {
		if(super.getUserDetailsService() != null){
			System.out.println("UserDetailsService has been configured properly");
		}
	}
}
