package guru.springframework.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * pull configuration props from application-{env}.properties files
 * @author lfallon
 *
 */
@Configuration
public class AppProperties {

	// jdbc
	@Value("${jdbc.driver}")
	private String jdbcDriver;

	@Value("${jdbc.url}")
	private String jdbcUrl;

	@Value("${jdbc.username}")
	private String jdbcUsername;

	@Value("${jdbc.password}")
	private String jdbcPassword;

	// jms
	@Value("${guru.jms.server}")
	String jmsServer;

	@Value("${guru.jms.port}")
	Integer jmsPort;

	@Value("${guru.jms.user}")
	String jmsUser;

	@Value("${guru.jms.password}")
	String jmsPassword;

	public String getJdbcDriver() {
		return jdbcDriver;
	}

	public String getJdbcUrl() {
		return jdbcUrl;
	}

	public String getJdbcUsername() {
		return jdbcUsername;
	}

	public String getJdbcPassword() {
		return jdbcPassword;
	}

	public String getJmsServer() {
		return jmsServer;
	}

	public Integer getJmsPort() {
		return jmsPort;
	}

	public String getJmsUser() {
		return jmsUser;
	}

	public String getJmsPassword() {
		return jmsPassword;
	}

}
