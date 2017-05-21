package com.gani.web.htmlform;

import android.content.Context;
import android.widget.CheckBox;
import android.widget.RelativeLayout;

import org.jsoup.nodes.Element;

public class HTMLCheckBox extends CheckBox {

    private static final String ATTR_NAME = "name";
    private static final String CHECKED_ATTR  = "checked";
    private static final String VALUE_ATTR = "value";

    private final Element mField;

    private String value;

    public HTMLCheckBox(Context context, Element field, RelativeLayout.LayoutParams params) {
        super(context);

        this.mField = field;
        setLayoutParams(params);
        setDefaultListeners();
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public HTMLCheckBox(Context context, Element field) {
        super(context);

        this.mField = field;
        setDefaultListeners();
    }

    private void setDefaultListeners() {
        setValue(mField.attr(VALUE_ATTR));
        setChecked(mField.hasAttr(CHECKED_ATTR));
        setTag(mField.attr(ATTR_NAME));
        setText(mField.parent().text());

//        setOnCheckedChangeListener(new HTMLFieldValidation(mField, this));
    }
}
