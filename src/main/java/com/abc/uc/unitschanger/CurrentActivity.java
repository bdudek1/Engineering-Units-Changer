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
import android.text.Html;

public class CurrentActivity extends AppCompatActivity {

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


        final RadioButton[] rb = new RadioButton[6];
        final RadioGroup rg1 = new RadioGroup(this); //create the RadioGroup
        rg1.setOrientation(RadioGroup.VERTICAL);//or RadioGroup.VERTICAL
        rb[0] = new RadioButton(this);
        rb[0].setText("ampere [A]");

        rb[1] = new RadioButton(this);
        rb[1].setText("abampere [abA]");

        rb[2] = new RadioButton(this);
        rb[2].setText("biot [Bi]");

        rb[3] = new RadioButton(this);
        rb[3].setText("EMU of current");

        rb[4] = new RadioButton(this);
        rb[4].setText("miliampere [mA]");

        rb[5] = new RadioButton(this);
        rb[5].setText("kiloampere [kA]");










        final RadioButton[] rb2 = new RadioButton[6];
        final RadioGroup rg2 = new RadioGroup(this); //create the RadioGroup
        rg2.setOrientation(RadioGroup.VERTICAL);//or RadioGroup.VERTICAL
        rb2[0] = new RadioButton(this);
        rb2[0].setText("ampere [A]");

        rb2[1] = new RadioButton(this);
        rb2[1].setText("abampere [abA]");

        rb2[2] = new RadioButton(this);
        rb2[2].setText("biot [Bi]");

        rb2[3] = new RadioButton(this);
        rb2[3].setText("EMU of current");

        rb2[4] = new RadioButton(this);
        rb2[4].setText("miliampere [mA]");

        rb2[5] = new RadioButton(this);
        rb2[5].setText("kiloampere [kA]");









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
                    for(int i = 0; i < 6; i++) {
                        rg1.addView(rb[i]);
                    }
                    convertFrombool = true;
                }else{
                    for(int i = 0; i < 6; i++) {
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
                    for(int i = 0; i < 6; i++) {
                        rg2.addView(rb2[i]);
                    }
                    convertTobool = true;
                }else{
                    for(int i = 0; i < 6; i++) {
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
                if (rb[0].isChecked()) {
                    calc1 = 1;
                    str1 = "ampere(s)";
                    isChecked1 = true;
                }
                if (rb[1].isChecked()) {
                    calc1 = 10;
                    str1 = "abampere(s)";
                    isChecked1 = true;
                }
                if (rb[2].isChecked()) {
                    calc1 = 10;
                    str1 = "biot(s)";
                    isChecked1 = true;
                }
                if (rb[3].isChecked()) {
                    calc1 = 10;
                    str1 = "EMU of current";
                    isChecked1 = true;
                }
                if (rb[4].isChecked()) {
                    calc1 = 0.001;
                    str1 = "miliampere(s)";
                    isChecked1 = true;
                }
                if (rb[5].isChecked()) {
                    calc1 =  1000;
                    str1 = "kiloampere(s)";
                    isChecked1 = true;
                }




                if (rb2[0].isChecked()) {
                    calc2 = 1;
                    str2 = "ampere(s)";
                    isChecked2 = true;
                }
                if (rb2[1].isChecked()) {
                    calc2 = 10;
                    str2 = "abampere(s)";
                    isChecked2 = true;
                }
                if (rb2[2].isChecked()) {
                    calc2 = 10;
                    str2 = "biot(s)";
                    isChecked2 = true;
                }
                if (rb2[3].isChecked()) {
                    calc2 = 10;
                    str2 = "EMU of current";
                    isChecked2 = true;
                }
                if (rb2[4].isChecked()) {
                    calc2 = 0.001;
                    str2 = "miliampere";
                    isChecked2 = true;
                }
                if (rb2[5].isChecked()) {
                    calc2 = 1000;
                    str2 = "kiloampere(s)";
                    isChecked2 = true;
                }



                if(isChecked1 == true && isChecked2 == true && isEmpty(editText) == false) {
                    double a = Double.parseDouble(editText.getText().toString());
                    double wynik = calc1 / calc2 * a;
                    textView4.setText(a + " " + str1 + " equals" + " " + String.format("%1.4f", wynik) + " " + str2);
                    textView4.setTextSize(15);
                    textView4.refreshDrawableState();
                }else{
                    Toast.makeText(CurrentActivity.this,
                            "Please select units and fill all the fields.", Toast.LENGTH_LONG).show();
                }
            }
        });



        textView.setText("Current unit converter");
        textView.setTextSize(22);
        textView.setLayoutParams(params);


        textView3.setText("Enter value = ");
        textView3.setTextSize(22);
        textView3.setLayoutParams(params);

        textSI.setText(Html.fromHtml("SI unit of current = [C*s<sup>-1</sup>]"));
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
