package guru.springframework.propertiestests.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import guru.springframework.domain.JmsBroker;

@Configuration
public class ExternalPropsPropertySourceTestConfig {
	
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
//
//	@Bean
//	public static PropertySourcesPlaceholderConfigurer properties() {
//		PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
//		return propertySourcesPlaceholderConfigurer;
//	}
	
//	@Autowired
//	private Environment env;

	@Bean
	public JmsBroker fakeJmsBroker() {
		JmsBroker fakeJmsBroker = new JmsBroker();
		fakeJmsBroker.setJmsServer(jmsServer);
		fakeJmsBroker.setJmsPort(jmsPort);
		fakeJmsBroker.setJmsUser(jmsUser);
		fakeJmsBroker.setJmsPassword(jmsPassword);
		return fakeJmsBroker;
	}
	
	@Bean
	public DataSource fakeDataSource(){
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName(jdbcDriver);
		ds.setUrl(jdbcUrl);
		ds.setUsername(jdbcUsername);
		ds.setPassword(jdbcPassword);
		return ds;
	}
}
