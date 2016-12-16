package br.unifor.pin.webservice.model;

public class Response {
	
	public enum Status{
		OK,
		ERROR
	}
	
	private Status status;
	private String description;
	
	public Response(Status status, String description) {
		this.status = status;
		this.description = description;
	}
	
	public Status getStatus() {
		return status;
	}
	
	public String getDescription() {
		return description;
	}

}
