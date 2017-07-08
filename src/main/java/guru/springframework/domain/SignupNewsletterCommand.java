package guru.springframework.domain;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class SignupNewsletterCommand {

	@NotEmpty
	@Email
	private String email;
	
	@NotEmpty
	@Size(min=2, max=20)
	private String name;
	private Boolean receiveOffers;
	
	public SignupNewsletterCommand(){}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Boolean getReceiveOffers() {
		return receiveOffers;
	}
	public void setReceiveOffers(Boolean receiveOffers) {
		this.receiveOffers = receiveOffers;
	}
	
}
