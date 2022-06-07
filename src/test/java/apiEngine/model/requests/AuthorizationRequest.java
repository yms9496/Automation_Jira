package apiEngine.model.requests;

public class AuthorizationRequest {

    public String userName;
    public String password;

    public AuthorizationRequest(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

	public String getUsername() {
		return userName;
	}

	public void setUsername(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
    
    
}