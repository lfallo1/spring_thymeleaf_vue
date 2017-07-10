package guru.springframework.config.security.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import guru.springframework.config.security.domain.CustomUsernamePasswordAuthenticationToken;
import guru.springframework.config.security.domain.CustomWebAuthenticationDetails;
import guru.springframework.config.security.domain.UserPrivileges;

@Component
public class CustomAuthenticationDaoProvider implements AuthenticationProvider {
	@Autowired
	private UserDetailsService userDetailsService;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {

		String verificationCode = ((CustomWebAuthenticationDetails) authentication.getDetails()).getVerificationCode();
		String name = authentication.getName();

		// use the credentials
		// and authenticate against the third-party system
		UserPrivileges user = (UserPrivileges) userDetailsService.loadUserByUsername(name);

		if (user.isUsing2fa()) {
			if (!user.getSecret().equals(verificationCode)) {
				throw new BadCredentialsException("Invalid verfication code");
			}
		}
		
		return new CustomUsernamePasswordAuthenticationToken(user, authentication.getCredentials(), user.getAuthorities());
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}
}
