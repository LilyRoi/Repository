package Lesson11home_work;

import java.util.List;

public class DropDown {
	List<String> options;
	boolean isSelected;
	String name;
	
	public DropDown(String name, boolean isSelected, List<String> options) {
		this.options = options;
		this.isSelected = isSelected;
		this.name = name;
	}
	
	public String toString() {
		return "DropDown: [name=" + name + "; isSelected=" + isSelected + "]";
	}

}
