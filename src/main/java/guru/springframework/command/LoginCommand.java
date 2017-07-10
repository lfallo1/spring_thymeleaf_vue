package guru.springframework.command;

import org.hibernate.validator.constraints.NotEmpty;

public class LoginCommand {
	@NotEmpty
	private String username;

	@NotEmpty
	private String password;

	private String code;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
