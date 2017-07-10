package guru.springframework.config.security.services;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import guru.springframework.config.security.domain.UserPrivileges;

@Service
public class UserRepository extends JdbcDaoSupport {

	RowMapper<GrantedAuthority> USER_AUTHORITIES_ROW_MAPPER = (rs,rownum) -> {
		return new SimpleGrantedAuthority(rs.getString("role"));
	};
	
	RowMapper<UserPrivileges> USER_ROW_MAPPER = (rs, rownum) -> {
		UserPrivileges user = new UserPrivileges();
		
		user.setAuthenticated(true);
		user.setUsername(rs.getString("username"));
		user.setPassword(rs.getString("password"));
	
		user.setUsing2fa(rs.getBoolean("is_using_2fa"));
		user.setSecret(rs.getString("secret"));
		
		if(user.getUsername().equals("lfallon")){
			user.setFullname("lance fallon");
			user.setSuitDescription("some suit description");
			user.setPowerLevel(43000);
		}

		user.setAccountNonExpired(true);
		user.setAccountNonLocked(true);
		user.setCredentialsNonExpired(true);
//		user.setAuthenticated(true);
		user.setEnabled(rs.getBoolean("enabled"));
		return user;
	};
	
	public UserRepository(@Autowired DataSource dataSource){
		setDataSource(dataSource);
	}
	
	
	public UserPrivileges findByUsername(String username){
		try{
			UserPrivileges user = getJdbcTemplate().queryForObject("select username,password, enabled, is_using_2fa, secret from users where username=?", new Object[]{ username }, USER_ROW_MAPPER);
			if(user != null){
				List<GrantedAuthority> authorities = getJdbcTemplate().query("select username, role from user_roles where username=?", new Object[]{ username }, USER_AUTHORITIES_ROW_MAPPER);
				user.setAuthorities(authorities);
				return user;
			}
			return null;
		} catch(DataAccessException e){ 
			return null; 
		}
	}
}
