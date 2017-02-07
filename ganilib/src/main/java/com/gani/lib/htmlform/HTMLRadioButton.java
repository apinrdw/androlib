package com.gani.lib.htmlform;

import android.content.Context;
import android.widget.RadioButton;
import android.widget.RelativeLayout;

import org.jsoup.nodes.Element;

public class HTMLRadioButton extends RadioButton {
    private final String CHECKED_ATTR  = "checked";

    private final Element mField;

    public HTMLRadioButton(Context context, Element field, RelativeLayout.LayoutParams params) {
        super(context);

        this.mField = field;
        setLayoutParams(params);
        setDefaultListeners();
    }

    public HTMLRadioButton(Context context, Element field) {
        super(context);

        this.mField = field;
        setDefaultListeners();
    }

    private void setDefaultListeners() {
        setChecked(mField.hasAttr(CHECKED_ATTR));
        setText(mField.parent().text());

        setOnCheckedChangeListener(new HTMLFieldValidation(mField, this));
    }
}
