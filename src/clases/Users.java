package clases;

public class Users {
	private String id;
	private String name_users;
	private String pasword;
	private String name;
	private String surname;
	private int age;
	
	public Users(String id, String name_users, String pasword, String name, String surname, int age) {
		this.id = id;
		this.name_users = name_users;
		this.pasword = pasword;
		this.name = name;
		this.surname = surname;
		this.age = age;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName_users() {
		return name_users;
	}

	public void setName_users(String name_users) {
		this.name_users = name_users;
	}

	public String getPasword() {
		return pasword;
	}

	public void setPasword(String pasword) {
		this.pasword = pasword;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Users [id=" + id + ", name_users=" + name_users + ", pasword=" + pasword + ", name=" + name
				+ ", surname=" + surname + ", age=" + age + "]";
	}
}
