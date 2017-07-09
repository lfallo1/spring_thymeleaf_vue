package guru.springframework.domain;

public class ErrorDto {

	private String msg;
	private Integer status;
	private String description;
	private String image;

	public ErrorDto() {
	}

	public ErrorDto(String msg, Integer status, String description, String image) {
		this.msg = msg;
		this.status = status;
		this.description = description;
		this.image = image;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

}
