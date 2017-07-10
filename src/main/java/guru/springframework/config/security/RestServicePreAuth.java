package guru.springframework.config.security;

import java.util.stream.Collectors;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

@Service("restServicePreAuth")
public class RestServicePreAuth {

	public boolean isProductAdministrator(Authentication auth){
		if(auth == null){
			return false;
		}
		User user = (User)auth.getPrincipal();
		return user.getAuthorities().size() > 1 && 
				user.getAuthorities().stream().filter(a->a.getAuthority().endsWith("ADMIN")).collect(Collectors.toList()).size() > 0;
	}
	
}
