package Modelo;

public class Criminals {
	private String dni;
	private String cri_name;
	private String cri_surname;
	private int age;
	private String cri_decription;
	private String crimes;
	
	public Criminals(String dni, String cri_name, String cri_surname, int age, String cri_decription, String crimes) {
		this.dni = dni;
		this.cri_name = cri_name;
		this.cri_surname = cri_surname;
		this.age = age;
		this.cri_decription = cri_decription;
		this.crimes = crimes;
	}
	
	public Criminals(String dni) {
		this.dni = dni;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getCri_name() {
		return cri_name;
	}

	public void setCri_name(String cri_name) {
		this.cri_name = cri_name;
	}

	public String getCri_surname() {
		return cri_surname;
	}

	public void setCri_surname(String cri_surname) {
		this.cri_surname = cri_surname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getCri_decription() {
		return cri_decription;
	}

	public void setCri_decription(String cri_decription) {
		this.cri_decription = cri_decription;
	}

	public String getCrimes() {
		return crimes;
	}

	public void setCrimes(String crimes) {
		this.crimes = crimes;
	}

	@Override
	public String toString() {
		return "Criminals [dni=" + dni + ", cri_name=" + cri_name + ", cri_surname=" + cri_surname + ", age=" + age
				+ ", cri_decription=" + cri_decription + ", crimes=" + crimes + "]";
	}	
}


