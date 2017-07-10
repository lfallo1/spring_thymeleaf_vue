package guru.springframework.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component("authProvider")
public class AuthProvider implements AuthenticationProvider {

	@Autowired
	private CustomUserDetailsService userDetailsService;
	
	@Override
	@Transactional
	public Authentication authenticate(Authentication authentication) {

		CustomAuthentication auth = null;
		if (authentication != null) {

			final Object username = authentication.getPrincipal();
			final Object password = authentication.getCredentials();
			
			//if a result was returned, check application's db for the user
			UserPrivileges user = (UserPrivileges) userDetailsService.loadUserByUsername(username.toString());

			// if a user was returned, create a new auth object and add the UserPrivileges to the object
			if (user != null) {
				auth = new CustomAuthentication(authentication.getPrincipal(),
						authentication.getCredentials(), user.getAuthorities());
				auth.setUserPrivileges(user);
			}
		}
		
		//return the auth. if null, same as no auth
		return auth;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return (UsernamePasswordAuthenticationToken.class).isAssignableFrom(authentication);
	}
}
