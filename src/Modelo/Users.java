package Modelo;

public class Users {
	private String id;
	private String name_users;
	private String password;
	private String name;
	private String surname;
	private int age;
	
	public Users(String id, String name_users, String password, String name, String surname, int age) {
		this.id = id;
		this.name_users = name_users;
		this.password = password;
		this.name = name;
		this.surname = surname;
		this.age = age;
	}
	
	public Users(String name_users, String password) {
		this.name_users = name_users;
		this.password = password;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String pasword) {
		this.password = pasword;
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
		return "Users [id=" + id + ", name_users=" + name_users + ", pasword=" + password + ", name=" + name
				+ ", surname=" + surname + ", age=" + age + "]";
	}
}
