package model;

public class Country {
	private int id;
	private String Code;
	private String Name;
	private String Description;

	public String getCode() {
		return Code;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		this.Name = name;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		this.Description = description;
	}

	public void setCode(String code) {
		this.Code = code;
	}

	@Override
	public String toString() {
		return "Country: ID=" + this.id + " Name=" + this.Name + " Code=" + this.Code
				+ " Description=" + this.Description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
