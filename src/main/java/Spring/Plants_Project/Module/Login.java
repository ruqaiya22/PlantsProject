package Spring.Plants_Project.Module;

public class Login {
	
	private String username;
	private String email_id;
	private String password;
	
	public Login() {
		
		
	}

	public Login(String username, String email_id, String password) {
		super();
		this.username = username;
		this.email_id = email_id;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail_id() {
		return email_id;
	}

	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Login [username=" + username + ", email_id=" + email_id + ", password=" + password + "]";
	}
	
	
	
	
	

}
