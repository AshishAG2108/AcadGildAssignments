package com.acadgild;

import java.beans.PropertyEditorSupport;
import com.acadgild.PersonType;

public class PersonTypeEditor extends PropertyEditorSupport {
	public void setAsText(String text) {
		setValue(new PersonType(text.toUpperCase()));
	}
}
