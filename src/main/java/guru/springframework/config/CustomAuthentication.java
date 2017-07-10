package guru.springframework.config;

import java.util.Collection;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

public class CustomAuthentication  extends AbstractAuthenticationToken {
	private static final long serialVersionUID = 310L;
	private final Object principal;
	private Object credentials;
	private UserPrivileges userPrivileges;

	/**
	 * @return the userPrivileges
	 */
	public UserPrivileges getUserPrivileges() {
		return userPrivileges;
	}

	/**
	 * @param userPrivileges
	 *            the userPrivileges to set
	 */
	public void setUserPrivileges(UserPrivileges userPrivileges) {
		this.userPrivileges = userPrivileges;
	}

	public void setCredentials(Object credentials) {
		this.credentials = credentials;
	}

	public CustomAuthentication(final Object principal, final Object credentials) {
		super(null);
		this.principal = principal;
		this.credentials = credentials;
		setAuthenticated(false);
	}

	public CustomAuthentication(final Object principal, final Object credentials,
			final Collection<? extends GrantedAuthority> authorities) {
		super(authorities);
		this.principal = principal;
		this.credentials = credentials;
		super.setAuthenticated(true);
	}

	public Object getCredentials() {
		return this.credentials;
	}

	public Object getPrincipal() {
		return this.principal;
	}

	public void setAuthenticated(final boolean isAuthenticated) throws IllegalArgumentException {
		if (isAuthenticated) {
			throw new IllegalArgumentException(
					"Cannot set this token to trusted - use constructor which takes a GrantedAuthority list instead");
		}

		super.setAuthenticated(false);
	}

	public void eraseCredentials() {
		super.eraseCredentials();
		this.credentials = null;
	}
}
