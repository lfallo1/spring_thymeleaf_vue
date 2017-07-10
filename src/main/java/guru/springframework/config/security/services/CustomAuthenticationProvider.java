package guru.springframework.config.security.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import guru.springframework.config.security.domain.CustomUsernamePasswordAuthenticationToken;

/**
 * "custom" auth provider. really all this does is use the user details service, and does not check for a pwd.
 * uses a custom shouldAuthenticateAgainstThirdPartySystem method to determine if auth check should even be attempted
 * @author lfallon
 *
 */
@Component
public class CustomAuthenticationProvider
  implements AuthenticationProvider {
	
	@Autowired
	private UserDetailsService userDetailsService;
 
    @Override
    public Authentication authenticate(Authentication authentication) 
      throws AuthenticationException {
  
        String name = authentication.getName();
        String password = authentication.getCredentials().toString();
         
        if (shouldAuthenticateAgainstThirdPartySystem()) {
  
            // use the credentials
            // and authenticate against the third-party system
        	UserDetails user = userDetailsService.loadUserByUsername(name);
            return new CustomUsernamePasswordAuthenticationToken(
              user, password, user.getAuthorities());
        } else {
            return null;
        }
    }
 
    private boolean shouldAuthenticateAgainstThirdPartySystem() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(
        		CustomUsernamePasswordAuthenticationToken.class);
    }
}
