package guru.springframework.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import guru.springframework.config.security.services.CustomAuthenticationProvider;
import guru.springframework.config.security.services.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
	
	/**
	 * autowire the custom user details service and custom authentication provider
	 */
	@Autowired
	private CustomUserDetailsService userDetailsService;

	@Autowired
	private CustomAuthenticationProvider customAuthenticationProvider;
	
	/**
	 * create a DaoAuthenticationProvider bean with the user details service and bcrypt password encoder
	 * @return
	 */
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
	    DaoAuthenticationProvider authProvider
	      = new DaoAuthenticationProvider();
	    authProvider.setUserDetailsService(userDetailsService);
	    authProvider.setPasswordEncoder(encoder());
	    return authProvider;
	}
	 
	/**
	 * bcrypt encoder
	 * @return
	 */
	@Bean
	public PasswordEncoder encoder() {
	    return new BCryptPasswordEncoder(11);
	}	
	
	/**
	 * used to establish an authentication mechanism by allowing AuthenticationProviders to be added easily: 
	 * e.g. The following defines the in-memory authentication with the in-built 'user' and 'admin' logins.
	 */
	@Override
	protected void configure(AuthenticationManagerBuilder auth)
	  throws Exception {
		//setup two authentication providers. first try the dao provider, and if that fails try the custom provider.
	    auth
	    	.authenticationProvider(authenticationProvider())
	    	.authenticationProvider(customAuthenticationProvider);
	}
	
	/**
	 * configuration of web based security at a resource level, based on a selection match - 
	 * e.g. The example below restricts the URLs that start with /admin/ to users that have ADMIN role, 
	 * and declares that any other URLs need to be successfully authenticated.
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
//		// @formatter:off
		http
			.authorizeRequests().antMatchers("/dist/**").permitAll() //vue
			.and().authorizeRequests().antMatchers("/", "/newsletter/**", "/product/**", "/api/products").permitAll() //routes
			.and().formLogin().loginPage("/login").defaultSuccessUrl("/").permitAll() //login
			.and().authorizeRequests().antMatchers("/superhero").hasRole("SUPERHERO") //dummy auth rule
			.and().authorizeRequests().antMatchers("/logout-success", "/login").anonymous() //require anonymous to access
			.and().authorizeRequests().anyRequest().authenticated() //require auth for other requests
			.and().logout() //logout handling
				.deleteCookies("remove")
				.invalidateHttpSession(true)
				.logoutUrl("/logout")
				.logoutSuccessUrl("/logout-success")
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
//		// @formatter:on
	}
	
	/**
	 * configuration settings that impact global security 
	 * (ignore resources, set debug mode, reject requests by implementing a custom firewall definition). 
	 * For example, the following method would cause any request that starts with /resources/ to be ignored 
	 * for authentication purposes.
	 */
	@Override
	public void configure(WebSecurity web) throws Exception {
	    web
        	.ignoring()
        	.antMatchers("/bower/**", "/images/**", "/**/favicon.ico"); //ignore static resources
	}

}