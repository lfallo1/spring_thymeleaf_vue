package guru.springframework.domain;

public class JmsBroker {

	private String jmsServer;
	
	private Integer jmsPort;
	
	private String jmsUser;
		
	private String jmsPassword;

	public JmsBroker() {
	}

	public String getJmsServer() {
		return jmsServer;
	}

	public void setJmsServer(String jmsServer) {
		this.jmsServer = jmsServer;
	}

	public Integer getJmsPort() {
		return jmsPort;
	}

	public void setJmsPort(Integer jmsPort) {
		this.jmsPort = jmsPort;
	}

	public String getJmsUser() {
		return jmsUser;
	}

	public void setJmsUser(String jmsUser) {
		this.jmsUser = jmsUser;
	}

	public String getJmsPassword() {
		return jmsPassword;
	}

	public void setJmsPassword(String jmsPassword) {
		this.jmsPassword = jmsPassword;
	}

}
