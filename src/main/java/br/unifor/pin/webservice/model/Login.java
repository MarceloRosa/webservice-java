package br.unifor.pin.webservice.model;

public class Login {

	private String email;
	private String password;
	
	public Login(String email, String password) {
		this.email = email;
		this.password = password;
	}
	
	public Login() {
		// TODO Auto-generated constructor stub
	}

	public String getEmail() {
		return email;
	}
	
	public String getPassword() {
		return password;
	}

}
