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
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

public class InflationActivity extends AppCompatActivity {

    private boolean isEmpty(EditText etText) {
        if (etText.getText().toString().trim().length() > 0)
            return false;

        return true;
    }

    static double atMa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        //Create a layout---------------
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        ScrollView scrollView = new ScrollView(getApplicationContext());
        scrollView.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

        TextView textView3 = new TextView(this);
        TextView textView4 = new TextView(this);
        TextView textView5 = new TextView(this);
        TextView textView6 = new TextView(this);
        final TextView textCapital = new TextView(this);
        TextView textSI = new TextView(this);

        final EditText editText = new EditText(this);
        editText.setLayoutParams(params);
        editText.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL | InputType.TYPE_NUMBER_FLAG_SIGNED);

        final EditText editText2 = new EditText(this);
        editText2.setLayoutParams(params);
        editText2.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL | InputType.TYPE_NUMBER_FLAG_SIGNED);

        final EditText editText3 = new EditText(this);
        editText3.setLayoutParams(params);
        editText3.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_SIGNED);

        final EditText editText4 = new EditText(this);
        editText4.setLayoutParams(params);
        editText4.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL | InputType.TYPE_NUMBER_FLAG_SIGNED);

        final Button convert = new Button(this);
        convert.setText("Calculate");
        convert.setLayoutParams(params);

        convert.setOnClickListener(new View.OnClickListener() {

            double capital;
            double percent;
            double inflation;
            double cycles;
            @Override
            public void onClick(View v) {


                if (isEmpty(editText) == false && isEmpty(editText2) == false && isEmpty(editText3) == false&& isEmpty(editText4) == false) {

                    capital = Double.parseDouble(editText.getText().toString());
                    percent = Double.parseDouble(editText2.getText().toString())/100;
                    cycles = Double.parseDouble(editText3.getText().toString());
                    inflation = Double.parseDouble(editText4.getText().toString())/100;
                    percent = (percent - inflation)/(1-inflation);
                    for(int i = 0; i < cycles; i++){
                        capital = capital + capital*percent;
                    }

                    textCapital.setText("Capital after " + Double.toString(cycles) + " years equals = " + String.format("%1.2f", capital));
                    textCapital.setTextSize(15);
                    textCapital.setLayoutParams(params);


                }else{
                    Toast.makeText(InflationActivity.this,
                            "Please select units and fill all the fields.", Toast.LENGTH_LONG).show();
                }
            }
        });




        textView3.setText("Enter amount of capital = ");
        textView3.setTextSize(22);
        textView3.setLayoutParams(params);

        textView4.setText("Enter yearly percentage increase [%] = ");
        textView4.setTextSize(22);
        textView4.setLayoutParams(params);

        textView5.setText("Enter amount of years of investment = ");
        textView5.setTextSize(22);
        textView5.setLayoutParams(params);

        textView6.setText("Enter the value of yearly inflation [%] = ");
        textView6.setTextSize(22);
        textView6.setLayoutParams(params);


        textSI.setText("Investment calculation");
        textSI.setTextSize(22);
        textSI.setLayoutParams(params);

        linearLayout.addView(textSI);
        linearLayout.addView(textView3);
        linearLayout.addView(editText);
        linearLayout.addView(textView4);
        linearLayout.addView(editText2);
        linearLayout.addView(textView6);
        linearLayout.addView(editText4);
        linearLayout.addView(textView5);
        linearLayout.addView(editText3);
        linearLayout.addView(convert);
        linearLayout.addView(textCapital);

        scrollView.addView(linearLayout);


        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ActionBar.LayoutParams.FILL_PARENT, ActionBar.LayoutParams.WRAP_CONTENT);
        this.addContentView(scrollView, layoutParams);


    }
}
