package guru.springframework.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("userDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserPrivileges user = new UserPrivileges();
		user.setAuthenticated(true);
		user.setDbList(Arrays.asList("default", "backup"));
		user.setUserID(1);
		user.setUsername(username);
		
		if(username.equals("captainjustice")){
			user.setFullname("lance fallon");
			user.setSuitDescription("suit boots belt gloves");
			user.setPowerLevel(43000);
		}
		
		user.setAccountNonExpired(true);
		user.setAccountNonLocked(true);
		user.setCredentialsNonExpired(true);
		user.setAuthenticated(true);
		user.setEnabled(true);
		final List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
		String role = username.equals("captainjustice") ? "ROLE_SUPERHERO" : "ROLE_USER";
		grantedAuthorities.add(new SimpleGrantedAuthority(role));
		user.setAuthorities(grantedAuthorities);
		if (username.toLowerCase().contains("x")) {
			throw new UsernameNotFoundException("username not found");
		}
		return user;
	}

}
