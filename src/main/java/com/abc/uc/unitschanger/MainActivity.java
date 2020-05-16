package com.abc.uc.unitschanger;

import android.app.AlertDialog;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.ActionBar;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.view.View;
import android.content.Intent;
import com.google.android.gms.ads.*;



public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        //Create params for views---------------
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        //Create a layout---------------
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        ScrollView scrollView = new ScrollView(getApplicationContext());
        scrollView.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));


        MobileAds.initialize(this, "ca-app-pub-2337287186342241~8617631551");

        AdView adView = new AdView(this);
        adView.setAdSize(AdSize.BANNER);
        adView.setAdUnitId("ca-app-pub-2337287186342241/5963548058");
        adView.setLayoutParams(params);
        AdRequest adRequest = new AdRequest.Builder().build();


        //-----Create a Button--------

        Button buttonLength = new Button(this);
        buttonLength.setText("Convert length units");
        buttonLength.setLayoutParams(params);

        Button buttonSurface = new Button(this);
        buttonSurface.setText("Convert surface units");
        buttonSurface.setLayoutParams(params);

        Button buttonVolume = new Button(this);
        buttonVolume.setText("Convert volume units");
        buttonVolume.setLayoutParams(params);

        Button buttonPressure = new Button(this);
        buttonPressure.setText("Convert pressure units");
        buttonPressure.setLayoutParams(params);

        Button buttonForce = new Button(this);
        buttonForce.setText("Convert force units");
        buttonForce.setLayoutParams(params);

        Button buttonSpeed = new Button(this);
        buttonSpeed.setText("Convert speed units");
        buttonSpeed.setLayoutParams(params);

        Button buttonTime = new Button(this);
        buttonTime.setText("Convert time units");
        buttonTime.setLayoutParams(params);

        Button buttonMass = new Button(this);
        buttonMass.setText("Convert mass units");
        buttonMass.setLayoutParams(params);

        Button buttonTemperature = new Button(this);
        buttonTemperature.setText("Convert temperature units");
        buttonTemperature.setLayoutParams(params);

        Button buttonPower = new Button(this);
        buttonPower.setText("Convert power units");
        buttonPower.setLayoutParams(params);

        Button buttonEnergy = new Button(this);
        buttonEnergy.setText("Convert energy (work) units");
        buttonEnergy.setLayoutParams(params);

        Button buttonVoltage = new Button(this);
        buttonVoltage.setText("Convert voltage units");
        buttonVoltage.setLayoutParams(params);

        Button buttonCurrent = new Button(this);
        buttonCurrent.setText("Convert current units");
        buttonCurrent.setLayoutParams(params);

        Button buttonDensity = new Button(this);
        buttonDensity.setText("Convert density units");
        buttonDensity.setLayoutParams(params);

        Button buttonFrequency = new Button(this);
        buttonFrequency.setText("Convert frequency units");
        buttonFrequency.setLayoutParams(params);

        Button buttonAngle = new Button(this);
        buttonAngle.setText("Convert angle units");
        buttonAngle.setLayoutParams(params);

        Button buttonangleSpeed = new Button(this);
        buttonangleSpeed.setText("Convert angular speed units");
        buttonangleSpeed.setLayoutParams(params);

        Button buttonResistance = new Button(this);
        buttonResistance.setText("Convert electrical resistance units");
        buttonResistance.setLayoutParams(params);

        Button buttonvolumeFlow = new Button(this);
        buttonvolumeFlow.setText("Convert volume flow units");
        buttonvolumeFlow.setLayoutParams(params);

        Button buttonmassFlow = new Button(this);
        buttonmassFlow.setText("Convert mass flow units");
        buttonmassFlow.setLayoutParams(params);

        Button buttonmagneticFlux = new Button(this);
        buttonmagneticFlux.setText("Convert magnetic flux units");
        buttonmagneticFlux.setLayoutParams(params);

        Button buttonmagneticField = new Button(this);
        buttonmagneticField.setText("Convert magnetic field units");
        buttonmagneticField.setLayoutParams(params);

        Button buttonelectricalCapacity = new Button(this);
        buttonelectricalCapacity.setText("Convert electrostatic capacitance units");
        buttonelectricalCapacity.setLayoutParams(params);

        Button buttonelectricField = new Button(this);
        buttonelectricField.setText("Convert electric field units");
        buttonelectricField.setLayoutParams(params);

        Button buttonChemistryModule = new Button(this);
        buttonChemistryModule.setText("Chemistry module");
        buttonChemistryModule.setLayoutParams(params);

        Button buttonfinancialModule = new Button(this);
        buttonfinancialModule.setText("Finanacial module");
        buttonfinancialModule.setLayoutParams(params);

        Button buttonfuelConsumptionModule = new Button(this);
        buttonfuelConsumptionModule.setText("Fuel consumption module");
        buttonfuelConsumptionModule.setLayoutParams(params);




        linearLayout.addView(adView);
        linearLayout.addView(buttonAngle);
        linearLayout.addView(buttonFrequency);
        linearLayout.addView(buttonangleSpeed);
        linearLayout.addView(buttonLength);
        linearLayout.addView(buttonSurface);
        linearLayout.addView(buttonVolume);
        linearLayout.addView(buttonPressure);
        linearLayout.addView(buttonForce);
        linearLayout.addView(buttonSpeed);
        linearLayout.addView(buttonTime);
        linearLayout.addView(buttonMass);
        linearLayout.addView(buttonDensity);
        linearLayout.addView(buttonvolumeFlow);
        linearLayout.addView(buttonmassFlow);
        linearLayout.addView(buttonTemperature);
        linearLayout.addView(buttonPower);
        linearLayout.addView(buttonEnergy);
        linearLayout.addView(buttonVoltage);
        linearLayout.addView(buttonCurrent);
        linearLayout.addView(buttonelectricField);
        linearLayout.addView(buttonResistance);
        linearLayout.addView(buttonelectricalCapacity);
        linearLayout.addView(buttonmagneticFlux);
        linearLayout.addView(buttonmagneticField);
        linearLayout.addView(buttonChemistryModule);
        linearLayout.addView(buttonfinancialModule);
        linearLayout.addView(buttonfuelConsumptionModule);


        scrollView.addView(linearLayout);




        //---Create a layout param for the layout-----------------
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ActionBar.LayoutParams.FILL_PARENT, ActionBar.LayoutParams.WRAP_CONTENT);
        this.addContentView(scrollView, layoutParams);

        adView.loadAd(adRequest);

        buttonLength.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LengthActivity.class);
                //setContentView(prefixLayout);
                MainActivity.this.startActivity(intent);
            }
        });

        buttonSurface.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SurfaceActivity.class);
                //setContentView(prefixLayout);
                MainActivity.this.startActivity(intent);
            }
        });

        buttonAngle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AngleActivity.class);
                //setContentView(prefixLayout);
                MainActivity.this.startActivity(intent);
            }
        });

        buttonFrequency.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FrequencyActivity.class);
                //setContentView(prefixLayout);
                MainActivity.this.startActivity(intent);
            }
        });
        buttonangleSpeed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AngleSpeed.class);
                //setContentView(prefixLayout);
                MainActivity.this.startActivity(intent);
            }
        });

        buttonVolume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, VolumeActivity.class);
                //setContentView(prefixLayout);
                MainActivity.this.startActivity(intent);
            }
        });

        buttonPressure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PressureActivity.class);
                //setContentView(prefixLayout);
                MainActivity.this.startActivity(intent);
            }
        });

        buttonForce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ForceActivity.class);
                //setContentView(prefixLayout);
                MainActivity.this.startActivity(intent);
            }
        });

        buttonSpeed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SpeedActivity.class);
                //setContentView(prefixLayout);
                MainActivity.this.startActivity(intent);
            }
        });

        buttonTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TimeActivity.class);
                //setContentView(prefixLayout);
                MainActivity.this.startActivity(intent);
            }
        });

        buttonMass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MassActivity.class);
                //setContentView(prefixLayout);
                MainActivity.this.startActivity(intent);
            }
        });
        buttonDensity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DensityActivity.class);
                //setContentView(prefixLayout);
                MainActivity.this.startActivity(intent);
            }
        });
        buttonvolumeFlow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, VolumeFlowActivity.class);
                //setContentView(prefixLayout);
                MainActivity.this.startActivity(intent);
            }
        });
        buttonmassFlow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MassFlowActivity.class);
                //setContentView(prefixLayout);
                MainActivity.this.startActivity(intent);
            }
        });
        buttonTemperature.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TemperatureActivity.class);
                //setContentView(prefixLayout);
                MainActivity.this.startActivity(intent);
            }
        });
        buttonPower.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PowerActivity.class);
                //setContentView(prefixLayout);
                MainActivity.this.startActivity(intent);
            }
        });
        buttonEnergy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, EnergyActivity.class);
                //setContentView(prefixLayout);
                MainActivity.this.startActivity(intent);
            }
        });
        buttonVoltage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, VoltageActivity.class);
                //setContentView(prefixLayout);
                MainActivity.this.startActivity(intent);
            }
        });
        buttonCurrent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CurrentActivity.class);
                //setContentView(prefixLayout);
                MainActivity.this.startActivity(intent);
            }
        });
        buttonelectricField.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ElectricFieldActivity.class);
                //setContentView(prefixLayout);
                MainActivity.this.startActivity(intent);
            }
        });
        buttonResistance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ElectricalResistanceActivity.class);
                //setContentView(prefixLayout);
                MainActivity.this.startActivity(intent);
            }
        });
        buttonelectricalCapacity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ElectrostaticCapacitanceActivity.class);
                //setContentView(prefixLayout);
                MainActivity.this.startActivity(intent);
            }
        });
        buttonmagneticFlux.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MagneticFluxActivity.class);
                //setContentView(prefixLayout);
                MainActivity.this.startActivity(intent);
            }
        });
        buttonmagneticField.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MagneticFieldActivity.class);
                //setContentView(prefixLayout);
                MainActivity.this.startActivity(intent);
            }
        });
        buttonChemistryModule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SubstanceBuilderActivity.class);
                //setContentView(prefixLayout);
                MainActivity.this.startActivity(intent);
            }
        });

        buttonfinancialModule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FinancialModuleActivity.class);
                //setContentView(prefixLayout);
                MainActivity.this.startActivity(intent);
            }
        });

        buttonfuelConsumptionModule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FuelConsumptionActivity.class);
                //setContentView(prefixLayout);
                MainActivity.this.startActivity(intent);
            }
        });


    }

}
