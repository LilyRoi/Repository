package Lesson11home_work;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class Page {
	ArrayList<Button> buttons = new ArrayList();
	LinkedList<Field>  fields = new LinkedList();
	HashSet<Label> labels = new HashSet<Label>();
	HashMap<String, DropDown>  dropDowns = new HashMap<String, DropDown>();
	float id;
	String title;
	
	public Page(float id, String title) {
		this.id = id;
		this.title = title;
	}
	
	
	public void addButton(Button button) {
		buttons.add(button);		
	}
	
	public void removeButton(Button button) {
		buttons.remove(button);		
	}
	
	public void replaceButton(Button button, int index) {
		buttons.set(index, button);
	}
	
	public void printButtons() {
		for(Button b: buttons) {
			System.out.println(b);			
		}		
	}
	
	public void addField(Field field) {
		fields.add(field);		
	}
	
	public void removeField(Field field) {
		fields.remove(field);		
	}
	
	public void replaceField(Field field, int index) {
		fields.set(index, field);
	}
	
	public void printFields() {
		for(Field f: fields) {
			System.out.println(f);			
		}		
	}
	
	public void addLabel(Label label) {
		labels.add(label);		
	}
	
	public void removeLabel(Label label) {
		labels.remove(label);		
	}
	
	public void replaceLabel(Label label) {
		labels.remove(label);
		labels.add(label);		
	}
	
	public void printLabels() {
		for(Label l: labels) {
			System.out.println(l);			
		}		
	}
	
	public void addDropDown(DropDown dropDown, String name) {
		dropDowns.put(name, dropDown);			
	}
	
	public void removeDropDown(String dropDownName) {
		dropDowns.remove(dropDownName);		
	}
	
	public void replaceDropDown(DropDown dropDown, String name) {
		dropDowns.replace(name, dropDown);		
	}
	
	public void printDropDowns() {
		for(String key: dropDowns.keySet()) {
			System.out.println(dropDowns.get(key));			
		}		
	}
}
