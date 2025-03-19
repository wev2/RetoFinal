package clases;

public class Cases {
	private String code_cases;
	private String name_c;
	private String description;
	private int number_ag;
	private int number_cr;
	
	public Cases(String code_cases, String name_c, String description, int number_ag, int number_cr) {
		this.code_cases = code_cases;
		this.name_c = name_c;
		this.description = description;
		this.number_ag = number_ag;
		this.number_cr = number_cr;
	}

	public String getCode_cases() {
		return code_cases;
	}

	public void setCode_cases(String code_cases) {
		this.code_cases = code_cases;
	}

	public String getName_c() {
		return name_c;
	}

	public void setName_c(String name_c) {
		this.name_c = name_c;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getNumber_ag() {
		return number_ag;
	}

	public void setNumber_ag(int number_ag) {
		this.number_ag = number_ag;
	}

	public int getNumber_cr() {
		return number_cr;
	}

	public void setNumber_cr(int number_cr) {
		this.number_cr = number_cr;
	}

	@Override
	public String toString() {
		return "Cases [code_cases=" + code_cases + ", name_c=" + name_c + ", description=" + description
				+ ", number_ag=" + number_ag + ", number_cr=" + number_cr + "]";
	}
}