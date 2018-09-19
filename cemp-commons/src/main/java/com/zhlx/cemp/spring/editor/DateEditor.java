package com.zhlx.cemp.spring.editor;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.util.StringUtils;

public class DateEditor extends PropertyEditorSupport {
    
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
    
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		if (!StringUtils.hasText(text)) {
			setValue(null);
		} else {
			try {
                setValue(DATE_FORMAT.parse(text));
            } catch (ParseException e) {
                e.printStackTrace();
            }
		}
	}

	@Override
	public String getAsText() {
		return getValue().toString();
	}
}
