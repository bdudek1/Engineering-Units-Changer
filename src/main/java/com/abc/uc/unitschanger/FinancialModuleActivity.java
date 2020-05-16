package com.abc.uc.unitschanger;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

public class FinancialModuleActivity extends AppCompatActivity {

    boolean isChecked1 = false;
    boolean isChecked2 = false;
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
        TextView textView2 = new TextView(this);
        TextView textView3 = new TextView(this);
        TextView textSI = new TextView(this);
        final TextView textView4 = new TextView(this);

        final EditText editText = new EditText(this);
        editText.setLayoutParams(params);
        editText.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL | InputType.TYPE_NUMBER_FLAG_SIGNED);


        final RadioButton[] rb = new RadioButton[8];
        RadioGroup rg1 = new RadioGroup(this); //create the RadioGroup
        rg1.setOrientation(RadioGroup.VERTICAL);//or RadioGroup.VERTICAL
        rb[0] = new RadioButton(this);
        rb[0].setText("include inflation");
        rg1.addView(rb[0]);

        rb[1] = new RadioButton(this);
        rb[1].setText("exclude inflation");
        rg1.addView(rb[1]);










        final Button convert = new Button(this);
        convert.setText("Calculate investment");
        convert.setLayoutParams(params);

        convert.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                if (rb[0].isChecked()) {
                    isChecked1 = true;
                    isChecked2 = false;
                }
                if (rb[1].isChecked()) {
                    isChecked2 = true;
                    isChecked1 = false;
                }

                    if (isChecked1 == true || isChecked2 == true) {
                        if(isChecked1 == true){
                           Intent intent = new Intent(FinancialModuleActivity.this, InflationActivity.class);
                            //setContentView(prefixLayout);
                           FinancialModuleActivity.this.startActivity(intent);
                        }else{
                            Intent intent = new Intent(FinancialModuleActivity.this, noInflationActivity.class);
                            //setContentView(prefixLayout);
                            FinancialModuleActivity.this.startActivity(intent);
                        }
                    } else {
                        Toast.makeText(FinancialModuleActivity.this,
                                "Please select option.", Toast.LENGTH_LONG).show();
                    }
                }
            });




        textView.setText("Financial module");
        textView.setTextSize(22);
        textView.setLayoutParams(params);

        textView2.setText("Choose your option:");
        textView2.setTextSize(22);
        textView2.setLayoutParams(params);


        linearLayout.addView(textView);
        linearLayout.addView(textView2);
        linearLayout.addView(rg1);
        linearLayout.addView(convert);

        scrollView.addView(linearLayout);


        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ActionBar.LayoutParams.FILL_PARENT, ActionBar.LayoutParams.WRAP_CONTENT);
        this.addContentView(scrollView, layoutParams);


    }
}
