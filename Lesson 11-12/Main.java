package Lesson11home_work;

import java.util.Arrays;

public class Main {
	public static void main(String [] args) {
		Page page = new Page(1, "NEWS");	
		
		Button button1 = new Button("OK", "successAction");
		Button button2 = new Button("Cancel", "cancelAction");
		System.out.println("All buttons");
		page.addButton(button1); 
		page.addButton(button2);		
		page.printButtons();		
		System.out.println("After button removal");
		page.removeButton(button1);
		page.printButtons();		
		System.out.println("After button change");
		page.replaceButton(button1, 0);
		page.printButtons();
		System.out.println();
		
		Field field1=new Field(1, "field1");
		Field field2=new Field(2, "field2");
		System.out.println("All fields");
		page.addField(field1);
		page.addField(field2);
		page.printFields();
		System.out.println("After field removal");
		page.removeField(field1);
		page.printFields();
		System.out.println("After field change");
		page.replaceField(field1, 0);
		page.printFields();
		System.out.println();
		
		Label label1=new Label("Label1");
		Label label2=new Label("Label2");
		System.out.println("All labels");
		page.addLabel(label1);
		page.addLabel(label2);
		page.printLabels();
		System.out.println("After label removal");
		page.removeLabel(label1);
		page.printLabels();
		System.out.println("After label change");
		page.replaceLabel(label1);
		page.printLabels();
		System.out.println();
		
		DropDown dropDown1=new DropDown("DropDown1", false, Arrays.asList("value1", "value2", "value3"));
		DropDown dropDown2=new DropDown("DropDown2", true, Arrays.asList("value1", "value2", "value3"));
		System.out.println("All dropDown");
		page.addDropDown(dropDown1, "DropDown1");
		page.addDropDown(dropDown2, "DropDown2");
		page.printDropDowns();
		System.out.println("After DropDown removal");
		page.removeDropDown("DropDown1");
		page.printDropDowns();
		System.out.println("After DropDown change");
		page.replaceDropDown(dropDown1, "DropDown2");
		page.printDropDowns();
		System.out.println();		
		
	}

}
