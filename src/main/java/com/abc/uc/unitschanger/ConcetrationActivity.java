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

public class ConcetrationActivity extends AppCompatActivity {

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

        TextView textView = new TextView(this);
        TextView textView3 = new TextView(this);
        TextView textView4 = new TextView(this);
        final TextView textConcetration = new TextView(this);
        final TextView textVolume = new TextView(this);
        TextView textSI = new TextView(this);

        final EditText editText = new EditText(this);
        editText.setLayoutParams(params);
        editText.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL | InputType.TYPE_NUMBER_FLAG_SIGNED);

        final EditText editText2 = new EditText(this);
        editText2.setLayoutParams(params);
        editText2.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL | InputType.TYPE_NUMBER_FLAG_SIGNED);


        final Button convert = new Button(this);
        convert.setText("Calculate");
        convert.setLayoutParams(params);

        convert.setOnClickListener(new View.OnClickListener() {

            double c1;
            double v1;
            String str1;
            String str2;
            @Override
            public void onClick(View v) {


                if (isEmpty(editText) == false && isEmpty(editText2) == false) {

                    double a = Double.parseDouble(editText.getText().toString());
                    double b = Double.parseDouble(editText2.getText().toString());
                    v1 = a + b;
                    c1 = b / v1 * 100;
                    textConcetration.setText("Concetration = " + String.format("%1.4f", c1) + "%");
                    textConcetration.setTextSize(15);
                    textConcetration.setLayoutParams(params);

                    textVolume.setText("Volume of mixing = " + String.format("%1.4f", v1) + " [ml]");
                    textVolume.setTextSize(15);
                    textVolume.setLayoutParams(params);
                }else{
                    Toast.makeText(ConcetrationActivity.this,
                            "Please select units and fill all the fields.", Toast.LENGTH_LONG).show();
                }
            }
        });



        textView.setText("Atomic mass of substance = "+Double.toString(atMa)+ " [u]");
        textView.setTextSize(22);
        textView.setLayoutParams(params);

        textView3.setText("Enter amount of dissolvent [ml] = ");
        textView3.setTextSize(22);
        textView3.setLayoutParams(params);

        textView4.setText("Enter amount of substance [ml] = ");
        textView4.setTextSize(22);
        textView4.setLayoutParams(params);


        textSI.setText("Concentration calculator");
        textSI.setTextSize(22);
        textSI.setLayoutParams(params);

        linearLayout.addView(textView);
        linearLayout.addView(textSI);
        linearLayout.addView(textView3);
        linearLayout.addView(editText);
        linearLayout.addView(textView4);
        linearLayout.addView(editText2);
        linearLayout.addView(convert);
        linearLayout.addView(textConcetration);
        linearLayout.addView(textVolume);

        scrollView.addView(linearLayout);


        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ActionBar.LayoutParams.FILL_PARENT, ActionBar.LayoutParams.WRAP_CONTENT);
        this.addContentView(scrollView, layoutParams);


    }
}
