package com.example.conversormoedas;

import android.widget.EditText;
import android.widget.TextView;

public class Actions {

    public static void ClearFields (TextView textView, EditText editText)
    {
        editText.setText("");
        textView.setText("");
    }


}
