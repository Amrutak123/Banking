package com.banking.auth.CustomerRequest;

public class UpdatePassword {
	
	private String email;
	private String newPassword;
	private String confirmPassword;
	public UpdatePassword() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UpdatePassword(String email, String oldPassword, String newPassword, String confirmPassword) {
		super();
		this.email = email;
		this.newPassword = newPassword;
		this.confirmPassword = confirmPassword;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	public String getNewPassword() {
		return newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	@Override
	public String toString() {
		return "UpdatePassword [email=" + email  + ", newPassword=" + newPassword
				+ ", confirmPassword=" + confirmPassword + "]";
	}
	
	

}
