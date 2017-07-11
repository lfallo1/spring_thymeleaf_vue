package guru.springframework.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import guru.springframework.domain.JmsBroker;

@Configuration
public class ExternalPropsPropertySourceTestConfig {
	
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
}
