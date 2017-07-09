package guru.springframework.config;

import java.util.Collection;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

@Component("restServicePreAuth")
public class RestServicePreAuth {
	public Boolean hasRole(Authentication auth, String roleName) {
		if (auth == null) {
			return false;
		}
		Collection<? extends GrantedAuthority> roles = auth.getAuthorities();
		for(GrantedAuthority role : roles){
			if(role.getAuthority().equals(roleName)){
				return true;
			}
		}
		return false;
	}
}
