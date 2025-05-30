package com.goutampersonal.springboot.Helpers.Binders;

import java.beans.PropertyEditorSupport;

public class LowerCaseStringTransformation extends PropertyEditorSupport {

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        setValue(text.trim().toLowerCase());
    }
}
