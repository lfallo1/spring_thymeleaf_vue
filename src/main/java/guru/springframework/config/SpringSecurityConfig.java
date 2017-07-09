package guru.springframework.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource dataSource;

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		// @formatter:off

		auth.jdbcAuthentication().dataSource(dataSource)
				.usersByUsernameQuery("select username,password, enabled from users where username=?")
				.authoritiesByUsernameQuery("select username, role from user_roles where username=?");
		 
			// @formatter:on
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
//		// @formatter:off
		http
			.authorizeRequests().antMatchers("/bower/**", "/dist/**", "/images/**", "/**/favicon.ico").permitAll()
			.and().authorizeRequests().antMatchers("/", "/newsletter/**", "/product/**", "/api/products").permitAll()
			.and().formLogin().loginPage("/login").defaultSuccessUrl("/").permitAll()
			.and().authorizeRequests().antMatchers("/superhero").hasRole("SUPERHERO")
			.and().authorizeRequests().antMatchers("/logout-success", "/login").anonymous()
			.and().authorizeRequests().anyRequest().authenticated()
			.and().logout()
				.deleteCookies("remove")
				.invalidateHttpSession(true)
				.logoutUrl("/logout")
				.logoutSuccessUrl("/logout-success")
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
//		// @formatter:on
	}
	

}