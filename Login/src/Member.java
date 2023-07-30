
public class Member {
	
	private String name, password1, password2;

	
	
	public Member() {
		super();
	}

	public Member(String name, String password1, String password2) {
		super();
		this.name = name;
		this.password1 = password1;
		this.password2 =password2;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword1() {
		return password1;
	}

	public void setPassword1(String password1) {
		this.password1 = password1;
	}
	//------------------------------------------------
	public String getPassword2() {
		return password2;
	}

	public void setPassword2(String password2) {
		this.password2 = password2;
	}
	
	
}
