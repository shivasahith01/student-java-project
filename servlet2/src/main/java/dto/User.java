package dto;

public class User {
	private int id;
	private String name;
	private String qualification;
	private String email;
	private long phone;
	private int age;
	private String password;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User(int id, String name, String qualification, String email, long phone, int age, String password) {
		super();
		this.id = id;
		this.name = name;
		this.qualification = qualification;
		this.email = email;
		this.phone = phone;
		this.age = age;
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", qualification=" + qualification + ", email=" + email
				+ ", phone=" + phone + ", age=" + age + ", password=" + password + "]";
	}

}
