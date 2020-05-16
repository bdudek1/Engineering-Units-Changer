package com.abc.uc.unitschanger;

import android.app.ActionBar;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.content.DialogInterface;
import android.app.AlertDialog;
import android.content.Context;
import android.text.Html;


public class SubstanceBuilderActivity extends AppCompatActivity {
    public double atomicMass = 0;
    public void dopisz (int a, TextView subsString, String[] elSyms, int[] counter, int symlet) {
        if (symlet == 1) {
            if ((subsString.getText().charAt(subsString.length() - 1) != elSyms[a].charAt(0))) {
                subsString.setText(subsString.getText() + elSyms[a]);
                counter[a]++;
                for (int i = 0; i < 117; i++) {
                    if (i != a) {
                        counter[i] = 1;
                    }
                }
            } else if (counter[a] == 1) {
                subsString.setText(subsString.getText().toString().substring(0, subsString.getText().toString().length())+Integer.toString(counter[a]) +elSyms[a]);
                counter[a]++;
            } else if (counter[a] == 2) {
                subsString.setText(subsString.getText().toString().substring(0, subsString.getText().toString().length() - 1) + Integer.toString(counter[a]) + elSyms[a]);
                counter[a]++;
            } else if (counter[a] < 10) {
                subsString.setText(subsString.getText().toString().substring(0, subsString.getText().toString().length() - 2) + Integer.toString(counter[a]) + elSyms[a]);
                counter[a]++;
            } else if (counter[a] == 10) {
                subsString.setText(subsString.getText().toString().substring(0, subsString.getText().toString().length() - 2) + Integer.toString(counter[a]) + elSyms[a]);
                counter[a]++;
            } else if (counter[a] < 100) {
                subsString.setText(subsString.getText().toString().substring(0, subsString.getText().toString().length() - 3) + Integer.toString(counter[a]) + elSyms[a]);
                counter[a]++;
            }
        }else{
            if (subsString.getText().charAt(subsString.length() - 1) != elSyms[a].charAt(1) || subsString.getText().charAt(subsString.length() - 2) != elSyms[a].charAt(0)) {
                subsString.setText(subsString.getText() + elSyms[a]);
                counter[a]++;
                for (int i = 0; i < 117; i++) {
                    if (i != a) {
                        counter[i] = 1;
                    }
                }
            } else if (counter[a] == 1) {
                subsString.setText(subsString.getText().toString().substring(0, subsString.getText().toString().length()) + Integer.toString(counter[a]) + elSyms[a]);
                counter[a]++;
            } else if (counter[a] == 2) {
                subsString.setText(subsString.getText().toString().substring(0, subsString.getText().toString().length() - 2) + Integer.toString(counter[a]) + elSyms[a]);
                counter[a]++;
            } else if (counter[a] < 10) {
                subsString.setText(subsString.getText().toString().substring(0, subsString.getText().toString().length() - 3) + Integer.toString(counter[a]) + elSyms[a]);
                counter[a]++;
            } else if (counter[a] == 10) {
                subsString.setText(subsString.getText().toString().substring(0, subsString.getText().toString().length() - 3) + Integer.toString(counter[a]) + elSyms[a]);
                counter[a]++;
            } else if (counter[a] < 100) {
                subsString.setText(subsString.getText().toString().substring(0, subsString.getText().toString().length() - 4) + Integer.toString(counter[a]) + elSyms[a]);
                counter[a]++;
            }
        }
    }

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

        TextView textView = new TextView(this);
        textView.setText("Create your substance by adding elements to it.");
        textView.setTextSize(19);
        textView.setLayoutParams(params);


        final TextView elString = new TextView(this);
        elString.setText("Your substance: ");
        elString.setTextSize(19);
        elString.setLayoutParams(params);


        final TextView substanceString = new TextView(this);
        substanceString.setText(" ");
        substanceString.setTextSize(19);
        substanceString.setLayoutParams(params);

        Button buttonaddElement = new Button(this);
        buttonaddElement.setText("Add an element to your substance");
        buttonaddElement.setLayoutParams(params);

        Button buttonReset = new Button(this);
        buttonReset.setText("Reset substance");
        buttonReset.setLayoutParams(params);

        Button buttonConcentration = new Button(this);
        buttonConcentration.setText("Calculate concentration");
        buttonConcentration.setLayoutParams(params);

        Button buttonmolarConcentration = new Button(this);
        buttonmolarConcentration.setText("Calculate molar concentration");
        buttonmolarConcentration.setLayoutParams(params);

        final Context context = this;
        // setup the alert builder
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Add an element");

// add a list
        final double[] elAtMass = {1.00794, 4.002602, 6.941, 9.012182, 10.811, 12.011, 14.00674, 	15.9994, 18.9984032, 20.1797,
                22.989768, 24.305, 26.981539, 28.0855, 30.973762, 32.066, 35.4527, 39.948, 39.0983, 40.078, 44.95591,
                47.88, 	50.9415,  51.9961, 54.93805, 55.847, 	58.9332, 58.69, 	63.546, 65.39, 	69.723, 72.61, 	74.92159,
                78.96, 79.904, 	83.8, 	85.4678,	87.62, 88.90585, 91.224, 92.90638, 95.94, 98.9063, 101.07, 102.9055, 106.42,
                107.8682, 	112.411, 114.82, 118.71, 121.75, 127.6 , 126.90447, 131.29, 	132.90543, 137.327, 138.9055, 140.115,	140.90765, 144.24, 146.9151,
                150.36, 151.965, 157.25, 158.92534,	162.5, 	164.93032,	167.26, 168.93421, 173.04, 174.967, 178.49, 	180.9479,	183.85, 186.207, 190.2,
                192.22, 195.08, 196.96654,	200.59, 	204.3833, 207.2,	208.98037, 208.9824, 209.9871,	222.0176, 	223.0197, 226.0254,	227.0278, 	232.0381, 	231.0359,	238.0289, 	237.0482, 	244.0642,
                243.0614, 	247.0703, 	247.0703,	251.0796, 	252.0829, 257.0951,	258.0986, 	259.1009, 	260.1053,	261.1087, 	262.1138, 	263.1182,	262.1229, 265, 	266,
                269, 	272, 285, 284, 289, 288, 292, 294, 294};


        final int[] counters;
        final TextView atMass = new TextView(this);
        atMass.setText("The molar mass of substance = " + String.format("%1.4f", atomicMass) + " [u]");
        atMass.setTextSize(19);
        atMass.setLayoutParams(params);

        final TextView molarMass = new TextView(this);
        molarMass.setText("The molar mass of substance = " + String.format("%1.4f", atomicMass) + " [g/mol]");
        molarMass.setTextSize(19);
        molarMass.setLayoutParams(params);

        counters = new int[118];
        for(int i = 0; i < 117; i++){
            counters[i] = 1;
        }
        final String[] elSymbols = {"H", "He", "Li", "Be", "B", "C", "N", "O", "F", "Ne",
                "Na", "Mg", "Al", "Si", "P", "S", "Cl", "Ar", "K", "Ca",
                "Sc", "Ti", "V", "Cr","Mn", "Fe", "Co", "Ni","Cu", "Zn", "Ga", "Ge",
                "As", "Se", "Br", "Kr","Rb", "Sr", "Y","Zr", "Nb", "Mo","Tc", "Ru", "Rh",
                "Pd", "Ag", "Cd","In", "Sn", "Sb","Te", "I", "Xe","Cs", "Ba", "La","Ce", "Pr", "Nd",
                "Pm", "Sm", "Eu","Gd", "Tb", "Dy","Ho", "Er", "Tm","Yb", "Lu", "Hf","Ta", "W", "Re",
                "Os", "Ir", "Pt","Au", "Hg", "Tl","Pb", "Bi", "Po","At", "Rn", "Fr","Ra", "Ac", "Th","Pa", "U", "Np",
                "Pu", "Am", "Cm","Bk", "Cf", "Es","Fm", "Md", "No","Lr", "Rf", "Db","Sg", "Bh", "Hs",
                "Mt", "Ds", "Rg", "Cn", "Nh","Fl", "Mc", "Lv", "Ts", "Og"};


        final String[] elements = {"[H] hydrogen", "[He] helium", "[Li] lithium", "[Be] beryllium", "[B] boron", "[C] carbon", "[N] nitrogen", "[O] oxygen", "[F] fluorine", "[Ne] neon",
                            "[Na] sodium", "[Mg] magnesium", "[Al] aluminum", "[Si] silicon", "[P] phosphorus", "[S] sulfur", "[Cl] chlorine", "[Ar] argon", "[K] potassium", "[Ca] calcium",
                             "[Sc] scandium", "[Ti] titanium", "[V] vanadium", "[Cr] chrome","[Mn] manganese", "[Fe] iron", "[Co] cobalt", "[Ni] nickel","[Cu] copper", "[Zn] zinc", "[Ga] gallium", "[Ge] germanium",
                             "[As] arsenic", "[Se] selenium", "[Br] bromine", "[Kr] krypton","[Rb] rubidium", "[Sr] strontium", "[Y] yttrium","[Zr] zirconium", "[Nb] niobium", "[Mo] molybdenum","[Tc] technetium", "[Ru] ruthenium", "[Rh] rhodium",
                             "[Pd] palladium", "[Ag] silver", "[Cd] cadmium","[In] indium", "[Sn] tin", "[Sb] antimony","[Te] tellurium", "[I] iodine", "[Xe] xenon","[Cs] cesium", "[Ba] barium", "[La] lanthanum","[Ce] cerium", "[Pr] praseodymium", "[Nd] neodymium",
                             "[Pm] illinium", "[Sm] samarium", "[Eu] europium","[Gd] gadolinium", "[Tb] terbium", "[Dy] dysprosium","[Ho] holmium", "[Er] erbium", "[Tm] thulium","[Yb] ytterbium", "[Lu] lutecium", "[Hf] hafnium","[Ta] tantalum", "[W] tungsten", "[Re] rhenium",
                             "[Os] osmium", "[Ir] iridium", "[Pt] platinum","[Au] gold", "[Hg] mercury", "[Tl] Thallium","[Pb] lead", "[Bi] bismuth", "[Po] polonium","[At] astatine", "[Rn] radon", "[Fr] fransium","[Ra] radium", "[Ac] actinium", "[Th] thorium","[Pa] protactinium", "[U] uranium", "[Np] neptunium",
                             "[Pu] plutonium", "[Am] americium", "[Cm] curium","[Bk] berkelium", "[Cf] californium", "[Es] einsteinium","[Fm] fermium", "[Md] mendelevium", "[No] nobelium","[Lr] lawrencium", "[Rf] rutherfordium", "[Db] dubnium","[Sg] seaborgium", "[Bh] bohrium", "[Hs] hassium",
                             "[Mt] meitnerium", "[Ds] darmstadtium", "[Rg] roentgenium", "[Cn] copernicium", "[Nh] nihonium","[Fl] flerovium", "[Mc] moscovium", "[Lv] livermorium", "[Ts] tennessine", "[Og] oganesson"};
        builder.setItems(elements, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which) {
                    case 0: {
                        dopisz(which, substanceString, elSymbols, counters, elSymbols[which].length());
                        atomicMass = atomicMass + elAtMass[which];
                        atMass.setText("The atomic mass of substance = " + Double.toString(atomicMass) +" [u]");
                        molarMass.setText("The molar mass of substance = " + Double.toString(atomicMass) + " [g/mol]");
                           break;
                    }
                    case 1:{
                        dopisz(which, substanceString, elSymbols, counters, elSymbols[which].length());
                        atomicMass = atomicMass + elAtMass[which];
                        atMass.setText("The atomic mass of substance = " + Double.toString(atomicMass) +" [u]");
                        molarMass.setText("The molar mass of substance = " + Double.toString(atomicMass) + " [g/mol]");
                            break;} // cow
                    case 2:{
                        dopisz(which, substanceString, elSymbols, counters, elSymbols[which].length());
                        atomicMass = atomicMass + elAtMass[which];
                        atMass.setText("The atomic mass of substance = " + Double.toString(atomicMass) +" [u]");
                        molarMass.setText("The molar mass of substance = " + Double.toString(atomicMass) + " [g/mol]");
                            break;} // camel
                    case 3:{
                        dopisz(which, substanceString, elSymbols, counters, elSymbols[which].length());
                        atomicMass = atomicMass + elAtMass[which];
                        atMass.setText("The atomic mass of substance = " + Double.toString(atomicMass) +" [u]");
                        molarMass.setText("The molar mass of substance = " + Double.toString(atomicMass) + " [g/mol]");
                        break;} // sheep
                    case 4:{
                        dopisz(which, substanceString, elSymbols, counters, elSymbols[which].length());
                        atomicMass = atomicMass + elAtMass[which];
                        atMass.setText("The atomic mass of substance = " + Double.toString(atomicMass) +" [u]");
                        molarMass.setText("The molar mass of substance = " + Double.toString(atomicMass) + " [g/mol]");
                        break;}
                    case 5:{
                        dopisz(which, substanceString, elSymbols, counters, elSymbols[which].length());
                        atomicMass = atomicMass + elAtMass[which];
                        atMass.setText("The atomic mass of substance = " + Double.toString(atomicMass) +" [u]");
                        molarMass.setText("The molar mass of substance = " + Double.toString(atomicMass) + " [g/mol]");
                        break;}
                    case 6:{
                        dopisz(which, substanceString, elSymbols, counters, elSymbols[which].length());
                        atomicMass = atomicMass + elAtMass[which];
                        atMass.setText("The atomic mass of substance = " + Double.toString(atomicMass) +" [u]");
                        molarMass.setText("The molar mass of substance = " + Double.toString(atomicMass) + " [g/mol]");
                        break;}
                    case 7:{
                        dopisz(which, substanceString, elSymbols, counters, elSymbols[which].length());
                        atomicMass = atomicMass + elAtMass[which];
                        atMass.setText("The atomic mass of substance = " + Double.toString(atomicMass) +" [u]");
                        molarMass.setText("The molar mass of substance = " + Double.toString(atomicMass) + " [g/mol]");
                        break;}
                    case 8:{
                        dopisz(which, substanceString, elSymbols, counters, elSymbols[which].length());
                        atomicMass = atomicMass + elAtMass[which];
                        atMass.setText("The atomic mass of substance = " + Double.toString(atomicMass) +" [u]");
                        molarMass.setText("The molar mass of substance = " + Double.toString(atomicMass) + " [g/mol]");
                        break;}
                    case 9:{
                        dopisz(which, substanceString, elSymbols, counters, elSymbols[which].length());
                        atomicMass = atomicMass + elAtMass[which];
                        atMass.setText("The atomic mass of substance = " + Double.toString(atomicMass) +" [u]");
                        molarMass.setText("The molar mass of substance = " + Double.toString(atomicMass) + " [g/mol]");
                        break;}
                    case 10:{
                        dopisz(which, substanceString, elSymbols, counters, elSymbols[which].length());
                        atomicMass = atomicMass + elAtMass[which];
                        atMass.setText("The atomic mass of substance = " + Double.toString(atomicMass) +" [u]");
                        molarMass.setText("The molar mass of substance = " + Double.toString(atomicMass) + " [g/mol]");
                        break;}
                    case 11:{
                        dopisz(which, substanceString, elSymbols, counters, elSymbols[which].length());
                        atomicMass = atomicMass + elAtMass[which];
                        atMass.setText("The atomic mass of substance = " + Double.toString(atomicMass) +" [u]");
                        molarMass.setText("The molar mass of substance = " + Double.toString(atomicMass) + " [g/mol]");
                        break;}
                    case 12:{
                        dopisz(which, substanceString, elSymbols, counters, elSymbols[which].length());
                        atomicMass = atomicMass + elAtMass[which];
                        atMass.setText("The atomic mass of substance = " + Double.toString(atomicMass) +" [u]");
                        molarMass.setText("The molar mass of substance = " + Double.toString(atomicMass) + " [g/mol]");
                        break;}
                    case 13:{
                        dopisz(which, substanceString, elSymbols, counters, elSymbols[which].length());
                        atomicMass = atomicMass + elAtMass[which];
                        atMass.setText("The atomic mass of substance = " + Double.toString(atomicMass) +" [u]");
                        molarMass.setText("The molar mass of substance = " + Double.toString(atomicMass) + " [g/mol]");
                        break;}
                    case 14:{
                        dopisz(which, substanceString, elSymbols, counters, elSymbols[which].length());
                        atomicMass = atomicMass + elAtMass[which];
                        atMass.setText("The atomic mass of substance = " + Double.toString(atomicMass) +" [u]");
                        molarMass.setText("The molar mass of substance = " + Double.toString(atomicMass) + " [g/mol]");
                        break;}
                    case 15:{
                        dopisz(which, substanceString, elSymbols, counters, elSymbols[which].length());
                        atomicMass = atomicMass + elAtMass[which];
                        atMass.setText("The atomic mass of substance = " + Double.toString(atomicMass) +" [u]");
                        molarMass.setText("The molar mass of substance = " + Double.toString(atomicMass) + " [g/mol]");
                        break;}
                    case 16:{
                        dopisz(which, substanceString, elSymbols, counters, elSymbols[which].length());
                        atomicMass = atomicMass + elAtMass[which];
                        atMass.setText("The atomic mass of substance = " + Double.toString(atomicMass) +" [u]");
                        molarMass.setText("The molar mass of substance = " + Double.toString(atomicMass) + " [g/mol]");
                        break;}
                    case 17:{
                        dopisz(which, substanceString, elSymbols, counters, elSymbols[which].length());
                        atomicMass = atomicMass + elAtMass[which];
                        atMass.setText("The atomic mass of substance = " + Double.toString(atomicMass) +" [u]");
                        molarMass.setText("The molar mass of substance = " + Double.toString(atomicMass) + " [g/mol]");
                        break;}
                    case 18:{
                        dopisz(which, substanceString, elSymbols, counters, elSymbols[which].length());
                        atomicMass = atomicMass + elAtMass[which];
                        atMass.setText("The atomic mass of substance = " + Double.toString(atomicMass) +" [u]");
                        molarMass.setText("The molar mass of substance = " + Double.toString(atomicMass) + " [g/mol]");
                        break;}
                    case 19:{
                        dopisz(which, substanceString, elSymbols, counters, elSymbols[which].length());
                        atomicMass = atomicMass + elAtMass[which];
                        atMass.setText("The atomic mass of substance = " + Double.toString(atomicMass) +" [u]");
                        molarMass.setText("The molar mass of substance = " + Double.toString(atomicMass) + " [g/mol]");
                        break;}
                    case 20:{
                        dopisz(which, substanceString, elSymbols, counters, elSymbols[which].length());
                        atomicMass = atomicMass + elAtMass[which];
                        atMass.setText("The atomic mass of substance = " + Double.toString(atomicMass) +" [u]");
                        molarMass.setText("The molar mass of substance = " + Double.toString(atomicMass) + " [g/mol]");
                        break;}
                    case 21:{
                        dopisz(which, substanceString, elSymbols, counters, elSymbols[which].length());
                        atomicMass = atomicMass + elAtMass[which];
                        atMass.setText("The atomic mass of substance = " + Double.toString(atomicMass) +" [u]");
                        molarMass.setText("The molar mass of substance = " + Double.toString(atomicMass) + " [g/mol]");
                        break;}
                    case 22:{
                        dopisz(which, substanceString, elSymbols, counters, elSymbols[which].length());
                        atomicMass = atomicMass + elAtMass[which];
                        atMass.setText("The atomic mass of substance = " + Double.toString(atomicMass) +" [u]");
                        molarMass.setText("The molar mass of substance = " + Double.toString(atomicMass) + " [g/mol]");
                        break;}
                    case 23:{
                        dopisz(which, substanceString, elSymbols, counters, elSymbols[which].length());
                        atomicMass = atomicMass + elAtMass[which];
                        atMass.setText("The atomic mass of substance = " + Double.toString(atomicMass) +" [u]");
                        molarMass.setText("The molar mass of substance = " + Double.toString(atomicMass) + " [g/mol]");
                        break;}
                    case 24:{
                        dopisz(which, substanceString, elSymbols, counters, elSymbols[which].length());
                        atomicMass = atomicMass + elAtMass[which];
                        atMass.setText("The atomic mass of substance = " + Double.toString(atomicMass) +" [u]");
                        molarMass.setText("The molar mass of substance = " + Double.toString(atomicMass) + " [g/mol]");
                        break;}
                    case 25:{
                        dopisz(which, substanceString, elSymbols, counters, elSymbols[which].length());
                        atomicMass = atomicMass + elAtMass[which];
                        atMass.setText("The atomic mass of substance = " + Double.toString(atomicMass) +" [u]");
                        molarMass.setText("The molar mass of substance = " + Double.toString(atomicMass) + " [g/mol]");
                        break;}
                    case 26:{
                        dopisz(which, substanceString, elSymbols, counters, elSymbols[which].length());
                        atomicMass = atomicMass + elAtMass[which];
                        atMass.setText("The atomic mass of substance = " + Double.toString(atomicMass) +" [u]");
                        molarMass.setText("The molar mass of substance = " + Double.toString(atomicMass) + " [g/mol]");
                        break;}
                    case 27:{
                        dopisz(which, substanceString, elSymbols, counters, elSymbols[which].length());
                        atomicMass = atomicMass + elAtMass[which];
                        atMass.setText("The atomic mass of substance = " + Double.toString(atomicMass) +" [u]");
                        molarMass.setText("The molar mass of substance = " + Double.toString(atomicMass) + " [g/mol]");
                        break;}
                    case 28:{
                        dopisz(which, substanceString, elSymbols, counters, elSymbols[which].length());
                        atomicMass = atomicMass + elAtMass[which];
                        atMass.setText("The atomic mass of substance = " + Double.toString(atomicMass) +" [u]");
                        molarMass.setText("The molar mass of substance = " + Double.toString(atomicMass) + " [g/mol]");
                        break;}
                    case 29:{
                        dopisz(which, substanceString, elSymbols, counters, elSymbols[which].length());
                        atomicMass = atomicMass + elAtMass[which];
                        atMass.setText("The atomic mass of substance = " + Double.toString(atomicMass) +" [u]");
                        molarMass.setText("The molar mass of substance = " + Double.toString(atomicMass) + " [g/mol]");
                        break;}
                    case 30:{
                        dopisz(which, substanceString, elSymbols, counters, elSymbols[which].length());
                        atomicMass = atomicMass + elAtMass[which];
                        atMass.setText("The atomic mass of substance = " + Double.toString(atomicMass) +" [u]");
                        molarMass.setText("The molar mass of substance = " + Double.toString(atomicMass) + " [g/mol]");
                        break;}
                    case 31:{
                        dopisz(which, substanceString, elSymbols, counters, elSymbols[which].length());
                        atomicMass = atomicMass + elAtMass[which];
                        atMass.setText("The atomic mass of substance = " + Double.toString(atomicMass) +" [u]");
                        molarMass.setText("The molar mass of substance = " + Double.toString(atomicMass) + " [g/mol]");
                        break;}
                    case 32:{
                        dopisz(which, substanceString, elSymbols, counters, elSymbols[which].length());
                        atomicMass = atomicMass + elAtMass[which];
                        atMass.setText("The atomic mass of substance = " + Double.toString(atomicMass) +" [u]");
                        molarMass.setText("The molar mass of substance = " + Double.toString(atomicMass) + " [g/mol]");
                        break;}
                    case 33:{
                        dopisz(which, substanceString, elSymbols, counters, elSymbols[which].length());
                        atomicMass = atomicMass + elAtMass[which];
                        atMass.setText("The atomic mass of substance = " + Double.toString(atomicMass) +" [u]");
                        molarMass.setText("The molar mass of substance = " + Double.toString(atomicMass) + " [g/mol]");
                        break;}
                    case 34:{
                        dopisz(which, substanceString, elSymbols, counters, elSymbols[which].length());
                        atomicMass = atomicMass + elAtMass[which];
                        atMass.setText("The atomic mass of substance = " + Double.toString(atomicMass) +" [u]");
                        molarMass.setText("The molar mass of substance = " + Double.toString(atomicMass) + " [g/mol]");
                        break;}
                    case 35:{
                        dopisz(which, substanceString, elSymbols, counters, elSymbols[which].length());
                        atomicMass = atomicMass + elAtMass[which];
                        atMass.setText("The atomic mass of substance = " + Double.toString(atomicMass) +" [u]");
                        molarMass.setText("The molar mass of substance = " + Double.toString(atomicMass) + " [g/mol]");
                        break;}
                    case 36:{
                        dopisz(which, substanceString, elSymbols, counters, elSymbols[which].length());
                        atomicMass = atomicMass + elAtMass[which];
                        atMass.setText("The atomic mass of substance = " + Double.toString(atomicMass) +" [u]");
                        molarMass.setText("The molar mass of substance = " + Double.toString(atomicMass) + " [g/mol]");
                        break;}
                    case 37:{
                        dopisz(which, substanceString, elSymbols, counters, elSymbols[which].length());
                        atomicMass = atomicMass + elAtMass[which];
                        atMass.setText("The atomic mass of substance = " + Double.toString(atomicMass) +" [u]");
                        molarMass.setText("The molar mass of substance = " + Double.toString(atomicMass) + " [g/mol]");
                        break;}
                    case 38:{
                        dopisz(which, substanceString, elSymbols, counters, elSymbols[which].length());
                        atomicMass = atomicMass + elAtMass[which];
                        atMass.setText("The atomic mass of substance = " + Double.toString(atomicMass) +" [u]");
                        molarMass.setText("The molar mass of substance = " + Double.toString(atomicMass) + " [g/mol]");
                        break;}
                    case 39:{
                        dopisz(which, substanceString, elSymbols, counters, elSymbols[which].length());
                        atomicMass = atomicMass + elAtMass[which];
                        atMass.setText("The atomic mass of substance = " + Double.toString(atomicMass) +" [u]");
                        molarMass.setText("The molar mass of substance = " + Double.toString(atomicMass) + " [g/mol]");
                        break;}
                    case 40:{
                        dopisz(which, substanceString, elSymbols, counters, elSymbols[which].length());
                        atomicMass = atomicMass + elAtMass[which];
                        atMass.setText("The atomic mass of substance = " + Double.toString(atomicMass) +" [u]");
                        molarMass.setText("The molar mass of substance = " + Double.toString(atomicMass) + " [g/mol]");
                        break;}
                    case 41:{
                        dopisz(which, substanceString, elSymbols, counters, elSymbols[which].length());
                        atomicMass = atomicMass + elAtMass[which];
                        atMass.setText("The atomic mass of substance = " + Double.toString(atomicMass) +" [u]");
                        molarMass.setText("The molar mass of substance = " + Double.toString(atomicMass) + " [g/mol]");
                        break;}
                    case 42:{
                        dopisz(which, substanceString, elSymbols, counters, elSymbols[which].length());
                        atomicMass = atomicMass + elAtMass[which];
                        atMass.setText("The atomic mass of substance = " + Double.toString(atomicMass) +" [u]");
                        molarMass.setText("The molar mass of substance = " + Double.toString(atomicMass) + " [g/mol]");
                        break;}
                    case 43:{
                        dopisz(which, substanceString, elSymbols, counters, elSymbols[which].length());
                        atomicMass = atomicMass + elAtMass[which];
                        atMass.setText("The atomic mass of substance = " + Double.toString(atomicMass) +" [u]");
                        molarMass.setText("The molar mass of substance = " + Double.toString(atomicMass) + " [g/mol]");
                        break;}
                    case 44:{
                        dopisz(which, substanceString, elSymbols, counters, elSymbols[which].length());
                        atomicMass = atomicMass + elAtMass[which];
                        atMass.setText("The atomic mass of substance = " + Double.toString(atomicMass) +" [u]");
                        molarMass.setText("The molar mass of substance = " + Double.toString(atomicMass) + " [g/mol]");
                        break;}
                    case 45:{
                        dopisz(which, substanceString, elSymbols, counters, elSymbols[which].length());
                        atomicMass = atomicMass + elAtMass[which];
                        atMass.setText("The atomic mass of substance = " + Double.toString(atomicMass) +" [u]");
                        molarMass.setText("The molar mass of substance = " + Double.toString(atomicMass) + " [g/mol]");
                        break;}
                    case 46:{
                        dopisz(which, substanceString, elSymbols, counters, elSymbols[which].length());
                        atomicMass = atomicMass + elAtMass[which];
                        atMass.setText("The atomic mass of substance = " + Double.toString(atomicMass) +" [u]");
                        molarMass.setText("The molar mass of substance = " + Double.toString(atomicMass) + " [g/mol]");
                        break;}
                    case 47:{
                        dopisz(which, substanceString, elSymbols, counters, elSymbols[which].length());
                        atomicMass = atomicMass + elAtMass[which];
                        atMass.setText("The atomic mass of substance = " + Double.toString(atomicMass) +" [u]");
                        molarMass.setText("The molar mass of substance = " + Double.toString(atomicMass) + " [g/mol]");
                        break;}
                    case 48:{
                        dopisz(which, substanceString, elSymbols, counters, elSymbols[which].length());
                        atomicMass = atomicMass + elAtMass[which];
                        atMass.setText("The atomic mass of substance = " + Double.toString(atomicMass) +" [u]");
                        molarMass.setText("The molar mass of substance = " + Double.toString(atomicMass) + " [g/mol]");
                        break;}
                    case 49:{
                        dopisz(which, substanceString, elSymbols, counters, elSymbols[which].length());
                        atomicMass = atomicMass + elAtMass[which];
                        atMass.setText("The atomic mass of substance = " + Double.toString(atomicMass) +" [u]");
                        molarMass.setText("The molar mass of substance = " + Double.toString(atomicMass) + " [g/mol]");
                        break;}
                    case 50:{
                        dopisz(which, substanceString, elSymbols, counters, elSymbols[which].length());
                        atomicMass = atomicMass + elAtMass[which];
                        atMass.setText("The atomic mass of substance = " + Double.toString(atomicMass) +" [u]");
                        molarMass.setText("The molar mass of substance = " + Double.toString(atomicMass) + " [g/mol]");
                        break;}
                    case 51:{
                        dopisz(which, substanceString, elSymbols, counters, elSymbols[which].length());
                        atomicMass = atomicMass + elAtMass[which];
                        atMass.setText("The atomic mass of substance = " + Double.toString(atomicMass) +" [u]");
                        molarMass.setText("The molar mass of substance = " + Double.toString(atomicMass) + " [g/mol]");
                        break;}
                    case 52:{
                        dopisz(which, substanceString, elSymbols, counters, elSymbols[which].length());
                        atomicMass = atomicMass + elAtMass[which];
                        atMass.setText("The atomic mass of substance = " + Double.toString(atomicMass) +" [u]");
                        molarMass.setText("The molar mass of substance = " + Double.toString(atomicMass) + " [g/mol]");
                        break;}
                    case 53:{
                        dopisz(which, substanceString, elSymbols, counters, elSymbols[which].length());
                        atomicMass = atomicMass + elAtMass[which];
                        atMass.setText("The atomic mass of substance = " + Double.toString(atomicMass) +" [u]");
                        molarMass.setText("The molar mass of substance = " + Double.toString(atomicMass) + " [g/mol]");
                        break;}
                    case 54:{
                        dopisz(which, substanceString, elSymbols, counters, elSymbols[which].length());
                        atomicMass = atomicMass + elAtMass[which];
                        atMass.setText("The atomic mass of substance = " + Double.toString(atomicMass) +" [u]");
                        molarMass.setText("The molar mass of substance = " + Double.toString(atomicMass) + " [g/mol]");
                        break;}
                    case 55:{
                        dopisz(which, substanceString, elSymbols, counters, elSymbols[which].length());
                        atomicMass = atomicMass + elAtMass[which];
                        atMass.setText("The atomic mass of substance = " + Double.toString(atomicMass) +" [u]");
                        molarMass.setText("The molar mass of substance = " + Double.toString(atomicMass) + " [g/mol]");
                        break;}
                    case 56:{
                        dopisz(which, substanceString, elSymbols, counters, elSymbols[which].length());
                        atomicMass = atomicMass + elAtMass[which];
                        atMass.setText("The atomic mass of substance = " + Double.toString(atomicMass) +" [u]");
                        molarMass.setText("The molar mass of substance = " + Double.toString(atomicMass) + " [g/mol]");
                        break;}
                    case 57:{
                        dopisz(which, substanceString, elSymbols, counters, elSymbols[which].length());
                        atomicMass = atomicMass + elAtMass[which];
                        atMass.setText("The atomic mass of substance = " + Double.toString(atomicMass) +" [u]");
                        molarMass.setText("The molar mass of substance = " + Double.toString(atomicMass) + " [g/mol]");
                        break;}
                    case 58:{
                        dopisz(which, substanceString, elSymbols, counters, elSymbols[which].length());
                        atomicMass = atomicMass + elAtMass[which];
                        atMass.setText("The atomic mass of substance = " + Double.toString(atomicMass) +" [u]");
                        molarMass.setText("The molar mass of substance = " + Double.toString(atomicMass) + " [g/mol]");
                        break;}
                    case 59:{
                        dopisz(which, substanceString, elSymbols, counters, elSymbols[which].length());
                        atomicMass = atomicMass + elAtMass[which];
                        atMass.setText("The atomic mass of substance = " + Double.toString(atomicMass) +" [u]");
                        molarMass.setText("The molar mass of substance = " + Double.toString(atomicMass) + " [g/mol]");
                        break;}
                    case 60:{
                        dopisz(which, substanceString, elSymbols, counters, elSymbols[which].length());
                        atomicMass = atomicMass + elAtMass[which];
                        atMass.setText("The atomic mass of substance = " + Double.toString(atomicMass) +" [u]");
                        molarMass.setText("The molar mass of substance = " + Double.toString(atomicMass) + " [g/mol]");
                        break;}
                    case 61:{
                        dopisz(which, substanceString, elSymbols, counters, elSymbols[which].length());
                        atomicMass = atomicMass + elAtMass[which];
                        atMass.setText("The atomic mass of substance = " + Double.toString(atomicMass) +" [u]");
                        molarMass.setText("The molar mass of substance = " + Double.toString(atomicMass) + " [g/mol]");
                        break;}
                    case 62:{
                        dopisz(which, substanceString, elSymbols, counters, elSymbols[which].length());
                        atomicMass = atomicMass + elAtMass[which];
                        atMass.setText("The atomic mass of substance = " + Double.toString(atomicMass) +" [u]");
                        molarMass.setText("The molar mass of substance = " + Double.toString(atomicMass) + " [g/mol]");
                        break;}
                    case 63:{
                        dopisz(which, substanceString, elSymbols, counters, elSymbols[which].length());
                        atomicMass = atomicMass + elAtMass[which];
                        atMass.setText("The atomic mass of substance = " + Double.toString(atomicMass) +" [u]");
                        molarMass.setText("The molar mass of substance = " + Double.toString(atomicMass) + " [g/mol]");
                        break;}
                    case 64:{
                        dopisz(which, substanceString, elSymbols, counters, elSymbols[which].length());
                        atomicMass = atomicMass + elAtMass[which];
                        atMass.setText("The atomic mass of substance = " + Double.toString(atomicMass) +" [u]");
                        molarMass.setText("The molar mass of substance = " + Double.toString(atomicMass) + " [g/mol]");
                        break;}
                    case 65:{
                        dopisz(which, substanceString, elSymbols, counters, elSymbols[which].length());
                        atomicMass = atomicMass + elAtMass[which];
                        atMass.setText("The atomic mass of substance = " + Double.toString(atomicMass) +" [u]");
                        molarMass.setText("The molar mass of substance = " + Double.toString(atomicMass) + " [g/mol]");
                        break;}
                    case 66:{
                        dopisz(which, substanceString, elSymbols, counters, elSymbols[which].length());
                        atomicMass = atomicMass + elAtMass[which];
                        atMass.setText("The atomic mass of substance = " + Double.toString(atomicMass) +" [u]");
                        molarMass.setText("The molar mass of substance = " + Double.toString(atomicMass) + " [g/mol]");
                        break;}
                    case 67:{
                        dopisz(which, substanceString, elSymbols, counters, elSymbols[which].length());
                        atomicMass = atomicMass + elAtMass[which];
                        atMass.setText("The atomic mass of substance = " + Double.toString(atomicMass) +" [u]");
                        molarMass.setText("The molar mass of substance = " + Double.toString(atomicMass) + " [g/mol]");
                        break;}
                    case 68:{
                        dopisz(which, substanceString, elSymbols, counters, elSymbols[which].length());
                        atomicMass = atomicMass + elAtMass[which];
                        atMass.setText("The atomic mass of substance = " + Double.toString(atomicMass) +" [u]");
                        molarMass.setText("The molar mass of substance = " + Double.toString(atomicMass) + " [g/mol]");
                        break;}
                    case 69:{
                        dopisz(which, substanceString, elSymbols, counters, elSymbols[which].length());
                        atomicMass = atomicMass + elAtMass[which];
                        atMass.setText("The atomic mass of substance = " + Double.toString(atomicMass) +" [u]");
                        molarMass.setText("The molar mass of substance = " + Double.toString(atomicMass) + " [g/mol]");
                        break;}
                    case 70:{
                        dopisz(which, substanceString, elSymbols, counters, elSymbols[which].length());
                        atomicMass = atomicMass + elAtMass[which];
                        atMass.setText("The atomic mass of substance = " + Double.toString(atomicMass) +" [u]");
                        molarMass.setText("The molar mass of substance = " + Double.toString(atomicMass) + " [g/mol]");
                        break;}
                    case 71:{
                        dopisz(which, substanceString, elSymbols, counters, elSymbols[which].length());
                        atomicMass = atomicMass + elAtMass[which];
                        atMass.setText("The atomic mass of substance = " + Double.toString(atomicMass) +" [u]");
                        molarMass.setText("The molar mass of substance = " + Double.toString(atomicMass) + " [g/mol]");
                        break;}
                    case 72:{
                        dopisz(which, substanceString, elSymbols, counters, elSymbols[which].length());
                        atomicMass = atomicMass + elAtMass[which];
                        atMass.setText("The atomic mass of substance = " + Double.toString(atomicMass) +" [u]");
                        molarMass.setText("The molar mass of substance = " + Double.toString(atomicMass) + " [g/mol]");
                        break;}
                    case 73:{
                        dopisz(which, substanceString, elSymbols, counters, elSymbols[which].length());
                        atomicMass = atomicMass + elAtMass[which];
                        atMass.setText("The atomic mass of substance = " + Double.toString(atomicMass) +" [u]");
                        molarMass.setText("The molar mass of substance = " + Double.toString(atomicMass) + " [g/mol]");
                        break;}
                    case 74:{
                        dopisz(which, substanceString, elSymbols, counters, elSymbols[which].length());
                        atomicMass = atomicMass + elAtMass[which];
                        atMass.setText("The atomic mass of substance = " + Double.toString(atomicMass) +" [u]");
                        molarMass.setText("The molar mass of substance = " + Double.toString(atomicMass) + " [g/mol]");
                        break;}
                    case 75:{
                        dopisz(which, substanceString, elSymbols, counters, elSymbols[which].length());
                        atomicMass = atomicMass + elAtMass[which];
                        atMass.setText("The atomic mass of substance = " + Double.toString(atomicMass) +" [u]");
                        molarMass.setText("The molar mass of substance = " + Double.toString(atomicMass) + " [g/mol]");
                        break;}
                    case 76:{
                        dopisz(which, substanceString, elSymbols, counters, elSymbols[which].length());
                        atomicMass = atomicMass + elAtMass[which];
                        atMass.setText("The atomic mass of substance = " + Double.toString(atomicMass) +" [u]");
                        molarMass.setText("The molar mass of substance = " + Double.toString(atomicMass) + " [g/mol]");
                        break;}
                    case 77:{
                        dopisz(which, substanceString, elSymbols, counters, elSymbols[which].length());
                        atomicMass = atomicMass + elAtMass[which];
                        atMass.setText("The atomic mass of substance = " + Double.toString(atomicMass) +" [u]");
                        molarMass.setText("The molar mass of substance = " + Double.toString(atomicMass) + " [g/mol]");
                        break;}
                    case 78:{
                        dopisz(which, substanceString, elSymbols, counters, elSymbols[which].length());
                        atomicMass = atomicMass + elAtMass[which];
                        atMass.setText("The atomic mass of substance = " + Double.toString(atomicMass) +" [u]");
                        molarMass.setText("The molar mass of substance = " + Double.toString(atomicMass) + " [g/mol]");
                        break;}
                    case 79:{
                        dopisz(which, substanceString, elSymbols, counters, elSymbols[which].length());
                        atomicMass = atomicMass + elAtMass[which];
                        atMass.setText("The atomic mass of substance = " + Double.toString(atomicMass) +" [u]");
                        molarMass.setText("The molar mass of substance = " + Double.toString(atomicMass) + " [g/mol]");
                        break;}
                    case 80:{
                        dopisz(which, substanceString, elSymbols, counters, elSymbols[which].length());
                        atomicMass = atomicMass + elAtMass[which];
                        atMass.setText("The atomic mass of substance = " + Double.toString(atomicMass) +" [u]");
                        molarMass.setText("The molar mass of substance = " + Double.toString(atomicMass) + " [g/mol]");
                        break;}
                    case 81:{
                        dopisz(which, substanceString, elSymbols, counters, elSymbols[which].length());
                        atomicMass = atomicMass + elAtMass[which];
                        atMass.setText("The atomic mass of substance = " + Double.toString(atomicMass) +" [u]");
                        molarMass.setText("The molar mass of substance = " + Double.toString(atomicMass) + " [g/mol]");
                        break;}
                    case 82:{
                        dopisz(which, substanceString, elSymbols, counters, elSymbols[which].length());
                        atomicMass = atomicMass + elAtMass[which];
                        atMass.setText("The atomic mass of substance = " + Double.toString(atomicMass) +" [u]");
                        molarMass.setText("The molar mass of substance = " + Double.toString(atomicMass) + " [g/mol]");
                        break;}
                    case 83:{
                        dopisz(which, substanceString, elSymbols, counters, elSymbols[which].length());
                        atomicMass = atomicMass + elAtMass[which];
                        atMass.setText("The atomic mass of substance = " + Double.toString(atomicMass) +" [u]");
                        molarMass.setText("The molar mass of substance = " + Double.toString(atomicMass) + " [g/mol]");
                        break;}
                    case 84:{
                        dopisz(which, substanceString, elSymbols, counters, elSymbols[which].length());
                        atomicMass = atomicMass + elAtMass[which];
                        atMass.setText("The atomic mass of substance = " + Double.toString(atomicMass) +" [u]");
                        molarMass.setText("The molar mass of substance = " + Double.toString(atomicMass) + " [g/mol]");
                        break;}
                    case 85:{
                        dopisz(which, substanceString, elSymbols, counters, elSymbols[which].length());
                        atomicMass = atomicMass + elAtMass[which];
                        atMass.setText("The atomic mass of substance = " + Double.toString(atomicMass) +" [u]");
                        molarMass.setText("The molar mass of substance = " + Double.toString(atomicMass) + " [g/mol]");
                        break;}
                    case 86:{
                        dopisz(which, substanceString, elSymbols, counters, elSymbols[which].length());
                        atomicMass = atomicMass + elAtMass[which];
                        atMass.setText("The atomic mass of substance = " + Double.toString(atomicMass) +" [u]");
                        molarMass.setText("The molar mass of substance = " + Double.toString(atomicMass) + " [g/mol]");
                        break;}
                    case 87:{
                        dopisz(which, substanceString, elSymbols, counters, elSymbols[which].length());
                        atomicMass = atomicMass + elAtMass[which];
                        atMass.setText("The atomic mass of substance = " + Double.toString(atomicMass) +" [u]");
                        molarMass.setText("The molar mass of substance = " + Double.toString(atomicMass) + " [g/mol]");
                        break;}
                    case 88:{
                        dopisz(which, substanceString, elSymbols, counters, elSymbols[which].length());
                        atomicMass = atomicMass + elAtMass[which];
                        atMass.setText("The atomic mass of substance = " + Double.toString(atomicMass) +" [u]");
                        molarMass.setText("The molar mass of substance = " + Double.toString(atomicMass) + " [g/mol]");
                        break;}
                    case 89:{
                        dopisz(which, substanceString, elSymbols, counters, elSymbols[which].length());
                        atomicMass = atomicMass + elAtMass[which];
                        atMass.setText("The atomic mass of substance = " + Double.toString(atomicMass) +" [u]");
                        molarMass.setText("The molar mass of substance = " + Double.toString(atomicMass) + " [g/mol]");
                        break;}
                    case 90:{
                        dopisz(which, substanceString, elSymbols, counters, elSymbols[which].length());
                        atomicMass = atomicMass + elAtMass[which];
                        atMass.setText("The atomic mass of substance = " + Double.toString(atomicMass) +" [u]");
                        molarMass.setText("The molar mass of substance = " + Double.toString(atomicMass) + " [g/mol]");
                        break;}
                    case 91:{
                        dopisz(which, substanceString, elSymbols, counters, elSymbols[which].length());
                        atomicMass = atomicMass + elAtMass[which];
                        atMass.setText("The atomic mass of substance = " + Double.toString(atomicMass) +" [u]");
                        molarMass.setText("The molar mass of substance = " + Double.toString(atomicMass) + " [g/mol]");
                        break;}
                    case 92:{
                        dopisz(which, substanceString, elSymbols, counters, elSymbols[which].length());
                        atomicMass = atomicMass + elAtMass[which];
                        atMass.setText("The atomic mass of substance = " + Double.toString(atomicMass) +" [u]");
                        molarMass.setText("The molar mass of substance = " + Double.toString(atomicMass) + " [g/mol]");
                        break;}
                    case 93:{
                        dopisz(which, substanceString, elSymbols, counters, elSymbols[which].length());
                        atomicMass = atomicMass + elAtMass[which];
                        atMass.setText("The atomic mass of substance = " + Double.toString(atomicMass) +" [u]");
                        molarMass.setText("The molar mass of substance = " + Double.toString(atomicMass) + " [g/mol]");
                        break;}
                    case 94:{
                        dopisz(which, substanceString, elSymbols, counters, elSymbols[which].length());
                        atomicMass = atomicMass + elAtMass[which];
                        atMass.setText("The atomic mass of substance = " + Double.toString(atomicMass) +" [u]");
                        molarMass.setText("The molar mass of substance = " + Double.toString(atomicMass) + " [g/mol]");
                        break;}
                    case 95:{
                        dopisz(which, substanceString, elSymbols, counters, elSymbols[which].length());
                        atomicMass = atomicMass + elAtMass[which];
                        atMass.setText("The atomic mass of substance = " + Double.toString(atomicMass) +" [u]");
                        molarMass.setText("The molar mass of substance = " + Double.toString(atomicMass) + " [g/mol]");
                        break;}
                    case 96:{
                        dopisz(which, substanceString, elSymbols, counters, elSymbols[which].length());
                        atomicMass = atomicMass + elAtMass[which];
                        atMass.setText("The atomic mass of substance = " + Double.toString(atomicMass) +" [u]");
                        molarMass.setText("The molar mass of substance = " + Double.toString(atomicMass) + " [g/mol]");
                        break;}
                    case 97:{
                        dopisz(which, substanceString, elSymbols, counters, elSymbols[which].length());
                        atomicMass = atomicMass + elAtMass[which];
                        atMass.setText("The atomic mass of substance = " + Double.toString(atomicMass) +" [u]");
                        molarMass.setText("The molar mass of substance = " + Double.toString(atomicMass) + " [g/mol]");
                        break;}
                    case 98:{
                        dopisz(which, substanceString, elSymbols, counters, elSymbols[which].length());
                        atomicMass = atomicMass + elAtMass[which];
                        atMass.setText("The atomic mass of substance = " + Double.toString(atomicMass) +" [u]");
                        molarMass.setText("The molar mass of substance = " + Double.toString(atomicMass) + " [g/mol]");
                        break;}
                    case 99:{
                        dopisz(which, substanceString, elSymbols, counters, elSymbols[which].length());
                        atomicMass = atomicMass + elAtMass[which];
                        atMass.setText("The atomic mass of substance = " + Double.toString(atomicMass) +" [u]");
                        molarMass.setText("The molar mass of substance = " + Double.toString(atomicMass) + " [g/mol]");
                        break;}
                    case 100:{
                        dopisz(which, substanceString, elSymbols, counters, elSymbols[which].length());
                        atomicMass = atomicMass + elAtMass[which];
                        atMass.setText("The atomic mass of substance = " + Double.toString(atomicMass) +" [u]");
                        molarMass.setText("The molar mass of substance = " + Double.toString(atomicMass) + " [g/mol]");
                        break;}
                    case 101:{
                        dopisz(which, substanceString, elSymbols, counters, elSymbols[which].length());
                        atomicMass = atomicMass + elAtMass[which];
                        atMass.setText("The atomic mass of substance = " + Double.toString(atomicMass) +" [u]");
                        molarMass.setText("The molar mass of substance = " + Double.toString(atomicMass) + " [g/mol]");
                        break;}
                    case 102:{
                        dopisz(which, substanceString, elSymbols, counters, elSymbols[which].length());
                        atomicMass = atomicMass + elAtMass[which];
                        atMass.setText("The atomic mass of substance = " + Double.toString(atomicMass) +" [u]");
                        molarMass.setText("The molar mass of substance = " + Double.toString(atomicMass) + " [g/mol]");
                        break;}
                    case 103:{
                        dopisz(which, substanceString, elSymbols, counters, elSymbols[which].length());
                        atomicMass = atomicMass + elAtMass[which];
                        atMass.setText("The atomic mass of substance = " + Double.toString(atomicMass) +" [u]");
                        molarMass.setText("The molar mass of substance = " + Double.toString(atomicMass) + " [g/mol]");
                        break;}
                    case 104:{
                        dopisz(which, substanceString, elSymbols, counters, elSymbols[which].length());
                        atomicMass = atomicMass + elAtMass[which];
                        atMass.setText("The atomic mass of substance = " + Double.toString(atomicMass) +" [u]");
                        molarMass.setText("The molar mass of substance = " + Double.toString(atomicMass) + " [g/mol]");
                        break;}
                    case 105:{
                        dopisz(which, substanceString, elSymbols, counters, elSymbols[which].length());
                        atomicMass = atomicMass + elAtMass[which];
                        atMass.setText("The atomic mass of substance = " + Double.toString(atomicMass) +" [u]");
                        molarMass.setText("The molar mass of substance = " + Double.toString(atomicMass) + " [g/mol]");
                        break;}
                    case 106:{
                        dopisz(which, substanceString, elSymbols, counters, elSymbols[which].length());
                        atomicMass = atomicMass + elAtMass[which];
                        atMass.setText("The atomic mass of substance = " + Double.toString(atomicMass) +" [u]");
                        molarMass.setText("The molar mass of substance = " + Double.toString(atomicMass) + " [g/mol]");
                        break;}
                    case 107:{
                        dopisz(which, substanceString, elSymbols, counters, elSymbols[which].length());
                        atomicMass = atomicMass + elAtMass[which];
                        atMass.setText("The atomic mass of substance = " + Double.toString(atomicMass) +" [u]");
                        molarMass.setText("The molar mass of substance = " + Double.toString(atomicMass) + " [g/mol]");
                        break;}
                    case 108:{
                        dopisz(which, substanceString, elSymbols, counters, elSymbols[which].length());
                        atomicMass = atomicMass + elAtMass[which];
                        atMass.setText("The atomic mass of substance = " + Double.toString(atomicMass) +" [u]");
                        molarMass.setText("The molar mass of substance = " + Double.toString(atomicMass) + " [g/mol]");
                        break;}
                    case 109:{
                        dopisz(which, substanceString, elSymbols, counters, elSymbols[which].length());
                        atomicMass = atomicMass + elAtMass[which];
                        atMass.setText("The atomic mass of substance = " + Double.toString(atomicMass) +" [u]");
                        molarMass.setText("The molar mass of substance = " + Double.toString(atomicMass) + " [g/mol]");
                        break;}
                    case 110:{
                        dopisz(which, substanceString, elSymbols, counters, elSymbols[which].length());
                        atomicMass = atomicMass + elAtMass[which];
                        atMass.setText("The atomic mass of substance = " + Double.toString(atomicMass) +" [u]");
                        molarMass.setText("The molar mass of substance = " + Double.toString(atomicMass) + " [g/mol]");
                        break;}
                    case 111:{
                        dopisz(which, substanceString, elSymbols, counters, elSymbols[which].length());
                        atomicMass = atomicMass + elAtMass[which];
                        atMass.setText("The atomic mass of substance = " + Double.toString(atomicMass) +" [u]");
                        molarMass.setText("The molar mass of substance = " + Double.toString(atomicMass) + " [g/mol]");
                        break;}
                    case 112:{
                        dopisz(which, substanceString, elSymbols, counters, elSymbols[which].length());
                        atomicMass = atomicMass + elAtMass[which];
                        atMass.setText("The atomic mass of substance = " + Double.toString(atomicMass) +" [u]");
                        molarMass.setText("The molar mass of substance = " + Double.toString(atomicMass) + " [g/mol]");
                        break;}
                    case 113:{
                        dopisz(which, substanceString, elSymbols, counters, elSymbols[which].length());
                        atomicMass = atomicMass + elAtMass[which];
                        atMass.setText("The atomic mass of substance = " + Double.toString(atomicMass) +" [u]");
                        molarMass.setText("The molar mass of substance = " + Double.toString(atomicMass) + " [g/mol]");
                        break;}
                    case 114:{
                        dopisz(which, substanceString, elSymbols, counters, elSymbols[which].length());
                        atomicMass = atomicMass + elAtMass[which];
                        atMass.setText("The atomic mass of substance = " + Double.toString(atomicMass) +" [u]");
                        molarMass.setText("The molar mass of substance = " + Double.toString(atomicMass) + " [g/mol]");
                        break;}
                    case 115:{
                        dopisz(which, substanceString, elSymbols, counters, elSymbols[which].length());
                        atomicMass = atomicMass + elAtMass[which];
                        atMass.setText("The atomic mass of substance = " + Double.toString(atomicMass) +" [u]");
                        molarMass.setText("The molar mass of substance = " + Double.toString(atomicMass) + " [g/mol]");
                        break;}
                    case 116:{
                        dopisz(which, substanceString, elSymbols, counters, elSymbols[which].length());
                        atomicMass = atomicMass + elAtMass[which];
                        atMass.setText("The atomic mass of substance = " + Double.toString(atomicMass) +" [u]");
                        molarMass.setText("The molar mass of substance = " + Double.toString(atomicMass) + " [g/mol]");
                        break;}
                    case 117:{
                        dopisz(which, substanceString, elSymbols, counters, elSymbols[which].length());
                        atomicMass = atomicMass + elAtMass[which];
                        atMass.setText("The atomic mass of substance = " + Double.toString(atomicMass) +" [u]");
                        molarMass.setText("The molar mass of substance = " + Double.toString(atomicMass) + " [g/mol]");
                        break;}

                }
            }

        });
        atMass.setText("The atomic mass of substance = " + String.format("%1.4f", atomicMass));
        atMass.setText("The atomic mass of substance = " + String.format("%1.4f", atomicMass) +" [u]");
        molarMass.setText("The molar mass of substance = " + String.format("%1.4f", atomicMass) + " [g/mol]");
        substanceString.setHeight(70);
// create and show the alert dialog
        final AlertDialog dialog = builder.create();





        linearLayout.addView(textView);
        linearLayout.addView(elString);
        linearLayout.addView(substanceString);
        linearLayout.addView(atMass);
        linearLayout.addView(molarMass);
        linearLayout.addView(buttonaddElement);
        linearLayout.addView(buttonReset);
        linearLayout.addView(buttonConcentration);
        linearLayout.addView(buttonmolarConcentration);


        scrollView.addView(linearLayout);


        buttonaddElement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.show();
            }

        });
        buttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                atomicMass = 0;
                substanceString.setText(" ");
                atMass.setText("The atomic mass of substance = " + Double.toString(atomicMass));
                molarMass.setText("The molar mass of substance = " + Double.toString(atomicMass) + " [g/mol]");
                for (int i = 0; i < 117; i++) {
                        counters[i] = 1;

                }
            }
            });


        //---Create a layout param for the layout-----------------
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ActionBar.LayoutParams.FILL_PARENT, ActionBar.LayoutParams.WRAP_CONTENT);
        this.addContentView(scrollView, layoutParams);

        buttonConcentration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SubstanceBuilderActivity.this, ConcetrationActivity.class);
                //setContentView(prefixLayout);
                ConcetrationActivity.atMa = atomicMass;
                SubstanceBuilderActivity.this.startActivity(intent);
            }
        });

        buttonmolarConcentration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SubstanceBuilderActivity.this, MolarConcentrationActivity.class);
                //setContentView(prefixLayout);
                MolarConcentrationActivity.atMa = atomicMass;
                SubstanceBuilderActivity.this.startActivity(intent);
            }
        });




    }
}
