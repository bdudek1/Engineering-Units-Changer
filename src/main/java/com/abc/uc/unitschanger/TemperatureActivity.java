package com.abc.uc.unitschanger;

import android.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

public class TemperatureActivity extends AppCompatActivity {

    private boolean isEmpty(EditText etText) {
        if (etText.getText().toString().trim().length() > 0)
            return false;

        return true;
    }
    boolean isChecked1 = false;
    boolean isChecked2 = false;
    boolean convertFrombool = false;
    boolean convertTobool = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        //Create a layout---------------
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        ScrollView scrollView = new ScrollView(getApplicationContext());
        scrollView.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

        TextView textView = new TextView(this);
        TextView textView3 = new TextView(this);
        TextView textSI = new TextView(this);
        final TextView textView4 = new TextView(this);

        final EditText editText = new EditText(this);
        editText.setLayoutParams(params);
        editText.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL | InputType.TYPE_NUMBER_FLAG_SIGNED);


        final RadioButton[] rb = new RadioButton[3];
        final RadioGroup rg1 = new RadioGroup(this); //create the RadioGroup
        rg1.setOrientation(RadioGroup.VERTICAL);//or RadioGroup.VERTICAL
        rb[0] = new RadioButton(this);
        rb[0].setText("Celsius degree [C]");

        rb[1] = new RadioButton(this);
        rb[1].setText("Kelvin degree [K]");

        rb[2] = new RadioButton(this);
        rb[2].setText("Fahrenheit degree [F]");






        final RadioButton[] rb2 = new RadioButton[3];
        final RadioGroup rg2 = new RadioGroup(this); //create the RadioGroup
        rg2.setOrientation(RadioGroup.VERTICAL);//or RadioGroup.VERTICAL
        rb2[0] = new RadioButton(this);
        rb2[0].setText("Celsius degree [C]");

        rb2[1] = new RadioButton(this);
        rb2[1].setText("Kelvin degree [K]");

        rb2[2] = new RadioButton(this);
        rb2[2].setText("Fahrenheit degree [F]");






        final Button convert = new Button(this);
        convert.setText("Convert");
        convert.setLayoutParams(params);

        final Button convertFrom = new Button(this);
        convertFrom.setText("Convert from: ");
        convertFrom.setLayoutParams(params);

        final Button convertTo = new Button(this);
        convertTo.setText("Convert to: ");
        convertTo.setLayoutParams(params);

        convertFrom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                if(convertFrombool == false){
                    for(int i = 0; i < 3; i++) {
                        rg1.addView(rb[i]);
                    }
                    convertFrombool = true;
                }else{
                    for(int i = 0; i < 3; i++) {
                        rg1.removeView(rb[i]);
                    }
                    convertFrombool = false;
                }
            }
        });

        convertTo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                if(convertTobool == false){
                    for(int i = 0; i < 3; i++) {
                        rg2.addView(rb2[i]);
                    }
                    convertTobool = true;
                }else{
                    for(int i = 0; i < 3; i++) {
                        rg2.removeView(rb2[i]);
                    }
                    convertTobool = false;
                }
            }
        });

        convert.setOnClickListener(new View.OnClickListener() {
            double calc1;
            double calc2;
            String str1;
            String str2;
            @Override
            public void onClick(View v) {
                if(isEmpty(editText) == false){
                double a = Double.parseDouble(editText.getText().toString());
                if (rb[0].isChecked()) {
                    calc1 = a;
                    str1 = "Celsius degree(s)";
                    isChecked1 = true;
                }
                if (rb[1].isChecked()) {
                    calc1 = a;
                    str1 = "Kelvin degree(s)";
                    isChecked1 = true;
                }
                if (rb[2].isChecked()) {
                    calc1 = a;
                    str1 = "Fahrenheit degree(s)";
                    isChecked1 = true;
                }


                if (rb2[0].isChecked()) {
                    str2 = "Celsius degree(s)";
                    if (rb[0].isChecked()) {
                        calc2 = calc1;
                        isChecked2 = true;
                    }
                    if (rb[1].isChecked()) {
                            calc2 = calc1 - 273.15;
                        isChecked2 = true;
                    }
                    if (rb[2].isChecked()) {
                        calc2 = (calc1 - 32) * 5 / 9;
                        isChecked2 = true;
                    }
                }
                if (rb2[1].isChecked()) {
                    str2 = "Kelvin degree(s)";
                    if (rb[0].isChecked()) {
                        calc2 = calc1 + 273.15;
                        isChecked2 = true;
                    }
                    if (rb[1].isChecked()) {
                        calc2 = calc1;
                        isChecked2 = true;
                    }
                    if (rb[2].isChecked()) {
                        calc2 = (calc1 + 459.67) * 5 / 9;
                        isChecked2 = true;
                    }
                }
                if (rb2[2].isChecked()) {
                    str2 = "Fahrenheit degree(s)";
                    if (rb[0].isChecked()) {
                        calc2 = calc1 * 1.8 + 32;
                        isChecked2 = true;
                    }
                    if (rb[1].isChecked()) {
                        calc2 = calc1 * 9 / 5 - 459.67;
                        isChecked2 = true;
                    }
                    if (rb[2].isChecked()) {
                        calc2 = calc1;
                        isChecked2 = true;
                    }
                }


                if(isChecked1 == true && isChecked2 == true && isEmpty(editText) == false) {
                    textView4.setText(a + " " + str1 + " equals" + " " + String.format("%1.4f", calc2) + " " + str2);
                    textView4.setTextSize(15);
                    textView4.refreshDrawableState();
                }else{
                    Toast.makeText(TemperatureActivity.this,
                            "Please select units and fill all the fields.", Toast.LENGTH_LONG).show();
                }

            }else{
                    Toast.makeText(TemperatureActivity.this,
                            "Please select units and fill all the fields.", Toast.LENGTH_LONG).show();
                }
            }
        });



        textView.setText("Temperature unit converter");
        textView.setTextSize(22);
        textView.setLayoutParams(params);


        textView3.setText("Enter value = ");
        textView3.setTextSize(22);
        textView3.setLayoutParams(params);

        textSI.setText("SI unit of temperature = [Celsius degree]");
        textSI.setTextSize(22);
        textSI.setLayoutParams(params);

        linearLayout.addView(textView);
        linearLayout.addView(textSI);
        linearLayout.addView(convertFrom);
        linearLayout.addView(rg1);
        linearLayout.addView(convertTo);
        linearLayout.addView(rg2);
        linearLayout.addView(textView3);
        linearLayout.addView(editText);
        linearLayout.addView(convert);
        linearLayout.addView(textView4);

        scrollView.addView(linearLayout);


        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ActionBar.LayoutParams.FILL_PARENT, ActionBar.LayoutParams.WRAP_CONTENT);
        this.addContentView(scrollView, layoutParams);


    }
}
