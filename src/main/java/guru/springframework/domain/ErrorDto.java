package guru.springframework.domain;

public class ErrorDto {

	private String msg;
	private Integer status;

	public ErrorDto() {
	}

	public ErrorDto(String msg, Integer status) {
		this.msg = msg;
		this.status = status;
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

}
