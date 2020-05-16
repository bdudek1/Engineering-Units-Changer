package com.abc.uc.unitschanger;

import android.app.ActionBar;
import android.content.Intent;
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

public class FuelConsumptionActivity extends AppCompatActivity {

    private boolean isEmpty(EditText etText) {
        if (etText.getText().toString().trim().length() > 0)
            return false;

        return true;
    }

    boolean isChecked1 = false;
    boolean isChecked2 = false;
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

        TextView textView = new TextView(this);
        TextView textView2 = new TextView(this);
        final TextView textView3 = new TextView(this);
        final TextView textView5 = new TextView(this);
        final TextView textView6 = new TextView(this);
        final TextView textView4 = new TextView(this);

        final EditText editText = new EditText(this);
        editText.setLayoutParams(params);
        editText.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL | InputType.TYPE_NUMBER_FLAG_SIGNED);

        final EditText editText2 = new EditText(this);
        editText2.setLayoutParams(params);
        editText2.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL | InputType.TYPE_NUMBER_FLAG_SIGNED);

        final EditText editText3 = new EditText(this);
        editText3.setLayoutParams(params);
        editText3.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL | InputType.TYPE_NUMBER_FLAG_SIGNED);


        final RadioButton[] rb = new RadioButton[2];
        RadioGroup rg1 = new RadioGroup(this); //create the RadioGroup
        rg1.setOrientation(RadioGroup.VERTICAL);//or RadioGroup.VERTICAL
        rb[0] = new RadioButton(this);
        rb[0].setText("Liters per 100km");
        rg1.addView(rb[0]);

        rb[1] = new RadioButton(this);
        rb[1].setText("Gallons per 100km");
        rg1.addView(rb[1]);


        rg1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // checkedId is the RadioButton selected
                if(checkedId == rb[0].getId()){
                    textView3.setText("Cost of one liter of fuel:");
                    textView5.setText("How much liters does your car burn per 100km:");
                }else if(checkedId == rb[1].getId()){
                    textView3.setText("Cost of one gallon of fuel:");
                    textView5.setText("How much gallons does your car burn per 100km:");
                }
            }
        });






        final Button convert = new Button(this);
        convert.setText("Calculate fuel cost and quantity");
        convert.setLayoutParams(params);

        convert.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                if (rb[0].isChecked()) {
                    isChecked1 = true;
                    isChecked2 = false;
                    textView3.setText("Cost of one liter of fuel:");
                    textView5.setText("How much liters does your car burn per 100km:");
                }
                if (rb[1].isChecked()) {
                    isChecked2 = true;
                    isChecked1 = false;
                    textView3.setText("Cost of one gallon of fuel:");
                    textView5.setText("How much gallons does your car burn per 100km:");
                }

                if ((isChecked1 == true || isChecked2 == true)&& isEmpty(editText) == false && isEmpty(editText2) == false && isEmpty(editText3) == false) {
                    if(isChecked1 == true){
                        double cost = Double.parseDouble(editText.getText().toString());
                        double length = Double.parseDouble(editText2.getText().toString());
                        double burn = Double.parseDouble(editText3.getText().toString());
                        double wynik = cost*length/100;
                        double ile = burn*length/100;
                        textView6.setText("To drive " + Double.toString(length) + " kilometers you will need " + String.format("%1.2f", ile) + " liters of fuel which will cost " + String.format("%1.2f", wynik) );
                    }else{
                        double cost = Double.parseDouble(editText.getText().toString());
                        double length = Double.parseDouble(editText2.getText().toString());
                        double burn = Double.parseDouble(editText3.getText().toString());
                        double wynik = cost*length/100;
                        double ile = burn*length/100;
                        textView6.setText("To drive " + Double.toString(length) + " kilometers you will need " + String.format("%1.2f", ile) + " gallons of fuel which will cost " + String.format("%1.2f", wynik) );
                    }
                } else {
                    Toast.makeText(FuelConsumptionActivity.this,
                            "Please select unit and fill all the data.", Toast.LENGTH_LONG).show();
                }
            }
        });




        textView.setText("Fuel consumption module");
        textView.setTextSize(22);
        textView.setLayoutParams(params);

        textView2.setText("Choose your fuel consumption unit:");
        textView2.setTextSize(22);
        textView2.setLayoutParams(params);

        textView3.setText("Cost of one liter/gallon of fuel:");
        textView3.setTextSize(22);
        textView3.setLayoutParams(params);

        textView4.setText("How much kilometers do you want to drive:");
        textView4.setTextSize(22);
        textView4.setLayoutParams(params);

        textView5.setText("How much liters/gallons does your car burn per 100km:");
        textView5.setTextSize(22);
        textView5.setLayoutParams(params);

        textView6.setTextSize(15);


        linearLayout.addView(textView);
        linearLayout.addView(textView2);
        linearLayout.addView(rg1);
        linearLayout.addView(textView3);
        linearLayout.addView(editText);
        linearLayout.addView(textView4);
        linearLayout.addView(editText2);
        linearLayout.addView(textView5);
        linearLayout.addView(editText3);
        linearLayout.addView(convert);
        linearLayout.addView(textView6);

        scrollView.addView(linearLayout);


        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ActionBar.LayoutParams.FILL_PARENT, ActionBar.LayoutParams.WRAP_CONTENT);
        this.addContentView(scrollView, layoutParams);


    }
}
