package com.example.converter.ui;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.converter.R;

public class WeightFragment extends Fragment {

    TextView textViewTemp1,textViewTemp2,textViewResult;
    EditText editTextValue;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_weight, container, false);

        final Spinner spinner1 = root.findViewById(R.id.spinner1);
        final Spinner spinner2 = root.findViewById(R.id.spinner2);

        textViewTemp1 = root.findViewById(R.id.textViewTemp1);
        textViewTemp2 = root.findViewById(R.id.textViewTemp2);
        textViewResult = root.findViewById(R.id.textViewResult);

        editTextValue = root.findViewById(R.id.editTextValue1);

        String[] temperature = {"Carats","Milligrams","Centigrams","Decigrams","Grams","Dekagrams","Hectograms","Kilograms",
                                "Metric tonnes","Ounces","Pounds","Stone","Short tons (US)","Long tons (UK)"};

        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(getActivity(),   android.R.layout.simple_spinner_item, temperature);
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
        spinner1.setAdapter(spinnerArrayAdapter);
        spinner2.setAdapter(spinnerArrayAdapter);

        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View selectedItemView, int position, long id) {
                String str = parent.getItemAtPosition(position).toString();
                textViewTemp1.setText(str);
                convert();
                converter();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
            }

        });

        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String str = parent.getItemAtPosition(position).toString();
                textViewTemp2.setText(str);
                convert();
                converter();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        return root;
    }
    public void convert() {
        editTextValue.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                converter();
            }
        });
    }
    public void converter(){
        String str1 = textViewTemp1.getText().toString();
        String str2 = textViewTemp2.getText().toString();
        String type ="";
        double a;

        if(editTextValue.getText().toString().isEmpty())
            a = 0;
        else
            a = Double.valueOf(editTextValue.getText().toString());

        if(str1.equals("Carats")){
            if(str2.equals("Milligrams")){
                a = a * 200;
            }
            else if(str2.equals("Centigrams")){
                a = a * 20;
            }
            else if(str2.equals("Decigrams")){
                a = a * 2;
            }
            else if(str2.equals("Grams")){
                a = a / 5;
            }
            else if(str2.equals("Dekagrams")){
                a = a / 50;
            }
            else if(str2.equals("Hectograms")){
                a = a / 500;
            }
            else if(str2.equals("Kilograms")){
                a = a / 5000;
            }
            else if(str2.equals("Metric tonnes")){
                a = a / 5000000;
            }
            else if(str2.equals("Ounces")){
                a = a / 142;
            }
            else if(str2.equals("Pounds")){
                a = a / 2268;
            }
            else if(str2.equals("Stone")){
                a = a / 31751;
            }
            else if(str2.equals("Short tons (US)")){
                a = (a / 4.536) / 1000000;
            }
            else if(str2.equals("Long tons (UK)")){
                a = a / 5.08000000;
            }
        }
        else if(str1.equals("Milligrams")){
            if(str2.equals("Carats")){
                a = a / 200;
            }
            else if(str2.equals("Centigrams")){
                a = a / 10;
            }
            else if(str2.equals("Decigrams")){
                a = a / 100;
            }
            else if(str2.equals("Grams")){
                a = a / 1000;
            }
            else if(str2.equals("Dekagrams")){
                a = a / 10000;
            }
            else if(str2.equals("Hectograms")){
                a = a / 100000;
            }
            else if(str2.equals("Kilograms")){
                a = a / 1000000;
            }
            else if(str2.equals("Metric tonnes")){
                a = a / 1000000000;
            }
            else if(str2.equals("Ounces")){
                a = a / 28350;
            }
            else if(str2.equals("Pounds")){
                a = a / 453592;
            }
            else if(str2.equals("Stone")){
                a = (a / 6.35) / 1000000;
            }
            else if(str2.equals("Short tons (US)")){
                a = (a / 9.072) / 100000000;
            }
            else if(str2.equals("Long tons (UK)")){
                a = (a / 1.016) / 1000000000;
            }
        }
        else if(str1.equals("Centigrams")){
            if(str2.equals("Carats")){
                a = a / 20;
            }
            else if(str2.equals("Milligrams")){
                a = a * 10;
            }
            else if(str2.equals("Decigrams")){
                a = a / 10;
            }
            else if(str2.equals("Grams")){
                a = a / 100;
            }
            else if(str2.equals("Dekagrams")){
                a = a / 1000;
            }
            else if(str2.equals("Hectograms")){
                a = a / 10000;
            }
            else if(str2.equals("Kilograms")){
                a = a / 100000;
            }
            else if(str2.equals("Metric tonnes")){
                a = a / 100000000;
            }
            else if(str2.equals("Ounces")){
                a = a / 2835;
            }
            else if(str2.equals("Pounds")){
                a = a / 45359;
            }
            else if(str2.equals("Stone")){
                a = a / 635029;
            }
            else if(str2.equals("Short tons (US)")){
                a = (a / 9.072) / 10000000;
            }
            else if(str2.equals("Long tons (UK)")){
                a = (a / 1.016) / 100000000;
            }
        }
        else if(str1.equals("Decigrams")){
            if(str2.equals("Carats")){
                a = a / 2;
            }
            else if(str2.equals("Milligrams")){
                a = a * 100;
            }
            else if(str2.equals("Centigrams")){
                a = a * 10;
            }
            else if(str2.equals("Grams")){
                a = a / 10;
            }
            else if(str2.equals("Dekagrams")){
                a = a / 100;
            }
            else if(str2.equals("Hectograms")){
                a = a / 1000;
            }
            else if(str2.equals("Kilograms")){
                a = a / 10000;
            }
            else if(str2.equals("Metric tonnes")){
                a = a / 10000000;
            }
            else if(str2.equals("Ounces")){
                a = a / 283.5;
            }
            else if(str2.equals("Pounds")){
                a = a / 4536;
            }
            else if(str2.equals("Stone")){
                a = a / 63503;
            }
            else if(str2.equals("Short tons (US)")){
                a = (a / 9.072) / 1000000;
            }
            else if(str2.equals("Long tons (UK)")){
                a = (a / 1.016) / 10000000;
            }
        }
        else if(str1.equals("Grams")){
            if(str2.equals("Carats")){
                a = a * 5;
            }
            else if(str2.equals("Milligrams")){
                a = a * 1000;
            }
            else if(str2.equals("Centigrams")){
                a = a * 100;
            }
            else if(str2.equals("Decigrams")){
                a = a * 10;
            }
            else if(str2.equals("Dekagrams")){
                a = a / 10;
            }
            else if(str2.equals("Hectograms")){
                a = a / 100;
            }
            else if(str2.equals("Kilograms")){
                a = a / 1000;
            }
            else if(str2.equals("Metric tonnes")){
                a = a / 1000000;
            }
            else if(str2.equals("Ounces")){
                a = a / 28.35;
            }
            else if(str2.equals("Pounds")){
                a = a / 453.59;
            }
            else if(str2.equals("Stone")){
                a = a / 6350;
            }
            else if(str2.equals("Short tons (US)")){
                a = (a / 9.072) / 100000;
            }
            else if(str2.equals("Long tons (UK)")){
                a = (a / 1.016) / 1000000;
            }
        }
        else if(str1.equals("Dekagrams")){
            if(str2.equals("Carats")){
                a = a * 50;
            }
            else if(str2.equals("Milligrams")){
                a = a * 10000;
            }
            else if(str2.equals("Centigrams")){
                a = a * 1000;
            }
            else if(str2.equals("Decigrams")){
                a = a * 100;
            }
            else if(str2.equals("Grams")){
                a = a * 10;
            }
            else if(str2.equals("Hectograms")){
                a = a / 10;
            }
            else if(str2.equals("Kilograms")){
                a = a / 100;
            }
            else if(str2.equals("Metric tonnes")){
                a = a / 100000;
            }
            else if(str2.equals("Ounces")){
                a = a / 2.835;
            }
            else if(str2.equals("Pounds")){
                a = a / 45.359;
            }
            else if(str2.equals("Stone")){
                a = a / 635;
            }
            else if(str2.equals("Short tons (US)")){
                a = a / 90718;
            }
            else if(str2.equals("Long tons (UK)")){
                a = a / 101605;
            }
        }
        else if(str1.equals("Hectograms")){
            if(str2.equals("Carats")){
                a = a * 500;
            }
            else if(str2.equals("Milligrams")){
                a = a * 100000;
            }
            else if(str2.equals("Centigrams")){
                a = a * 10000;
            }
            else if(str2.equals("Decigrams")){
                a = a * 1000;
            }
            else if(str2.equals("Grams")){
                a = a * 100;
            }
            else if(str2.equals("Dekagrams")){
                a = a * 10;
            }
            else if(str2.equals("Kilograms")){
                a = a / 10;
            }
            else if(str2.equals("Metric tonnes")){
                a = a / 10000;
            }
            else if(str2.equals("Ounces")){
                a = a / 0.2835;
            }
            else if(str2.equals("Pounds")){
                a = a / 4.5359;
            }
            else if(str2.equals("Stone")){
                a = a / 63.503;
            }
            else if(str2.equals("Short tons (US)")){
                a = a / 9072;
            }
            else if(str2.equals("Long tons (UK)")){
                a = a / 10160.5;
            }
        }
        else if(str1.equals("Kilograms")){
            if(str2.equals("Carats")){
                a = a * 5000;
            }
            else if(str2.equals("Milligrams")){
                a = a * 1000000;
            }
            else if(str2.equals("Centigrams")){
                a = a * 100000;
            }
            else if(str2.equals("Decigrams")){
                a = a * 10000;
            }
            else if(str2.equals("Grams")){
                a = a * 1000;
            }
            else if(str2.equals("Dekagrams")){
                a = a * 100;
            }
            else if(str2.equals("Hectograms")){
                a = a * 10;
            }
            else if(str2.equals("Metric tonnes")){
                a = a / 1000;
            }
            else if(str2.equals("Ounces")){
                a = a / 0.02835;
            }
            else if(str2.equals("Pounds")){
                a = a / 0.45359;
            }
            else if(str2.equals("Stone")){
                a = a / 6.3503;
            }
            else if(str2.equals("Short tons (US)")){
                a = a / 907.2;
            }
            else if(str2.equals("Long tons (UK)")){
                a = a / 1016.05;
            }
        }
        else if(str1.equals("Metric tonnes")){
            if(str2.equals("Carats")){
                a = a * 5000000;
            }
            else if(str2.equals("Milligrams")){
                a = a * 1000000000;
            }
            else if(str2.equals("Centigrams")){
                a = a * 100000000;
            }
            else if(str2.equals("Decigrams")){
                a = a * 10000000;
            }
            else if(str2.equals("Grams")){
                a = a * 1000000;
            }
            else if(str2.equals("Dekagrams")){
                a = a * 100000;
            }
            else if(str2.equals("Hectograms")){
                a = a * 10000;
            }
            else if(str2.equals("Kilograms")){
                a = a * 1000;
            }
            else if(str2.equals("Ounces")){
                a = a * 35274;
            }
            else if(str2.equals("Pounds")){
                a = a * 2205;
            }
            else if(str2.equals("Stone")){
                a = a * 157;
            }
            else if(str2.equals("Short tons (US)")){
                a = a * 1.102;
            }
            else if(str2.equals("Long tons (UK)")){
                a = a / 1.016;
            }
        }
        else if(str1.equals("Ounces")){
            if(str2.equals("Carats")){
                a = a * 142;
            }
            else if(str2.equals("Milligrams")){
                a = a * 28349.5;
            }
            else if(str2.equals("Centigrams")){
                a = a * 2835;
            }
            else if(str2.equals("Decigrams")){
                a = a * 283.5;
            }
            else if(str2.equals("Grams")){
                a = a * 28.35;
            }
            else if(str2.equals("Dekagrams")){
                a = a * 2.835;
            }
            else if(str2.equals("Hectograms")){
                a = a * 0.2835;
            }
            else if(str2.equals("Kilograms")){
                a = a * 0.02835;
            }
            else if(str2.equals("Metric tonnes")){
                a = a / 35274;
            }
            else if(str2.equals("Pounds")){
                a = a / 16;
            }
            else if(str2.equals("Stone")){
                a = a / 224;
            }
            else if(str2.equals("Short tons (US)")){
                a = a / 32000;
            }
            else if(str2.equals("Long tons (UK)")){
                a = a / 35840;
            }
        }
        else if(str1.equals("Pounds")){
            if(str2.equals("Carats")){
                a = a * 2267.962;
            }
            else if(str2.equals("Milligrams")){
                a = a * 453592.4;
            }
            else if(str2.equals("Centigrams")){
                a = a * 45359.24;
            }
            else if(str2.equals("Decigrams")){
                a = a * 4535.924;
            }
            else if(str2.equals("Grams")){
                a = a * 453.5924;
            }
            else if(str2.equals("Dekagrams")){
                a = a * 45.35924;
            }
            else if(str2.equals("Hectograms")){
                a = a * 4.535924;
            }
            else if(str2.equals("Kilograms")){
                a = a * 0.4535924;
            }
            else if(str2.equals("Metric tonnes")){
                a = a / 2205;
            }
            else if(str2.equals("Ounces")){
                a = a * 16;
            }
            else if(str2.equals("Stone")){
                a = a / 14;
            }
            else if(str2.equals("Short tons (US)")){
                a = a / 2000;
            }
            else if(str2.equals("Long tons (UK)")){
                a = a / 2240;
            }
        }
        else if(str1.equals("Stone")){
            if(str2.equals("Carats")){
                a = a * 31751.47;
            }
            else if(str2.equals("Milligrams")){
                a = a * 6350293;
            }
            else if(str2.equals("Centigrams")){
                a = a * 635029.3;
            }
            else if(str2.equals("Decigrams")){
                a = a * 63502.93;
            }
            else if(str2.equals("Grams")){
                a = a * 6350.293;
            }
            else if(str2.equals("Dekagrams")){
                a = a * 635.0293;
            }
            else if(str2.equals("Hectograms")){
                a = a * 63.50293;
            }
            else if(str2.equals("Kilograms")){
                a = a * 6.350293;
            }
            else if(str2.equals("Metric tonnes")){
                a = a * 0.006350293;
            }
            else if(str2.equals("Ounces")){
                a = a * 224;
            }
            else if(str2.equals("Pounds")){
                a = a * 14;
            }
            else if(str2.equals("Short tons (US)")){
                a = a / 143;
            }
            else if(str2.equals("Long tons (UK)")){
                a = a / 160;
            }
        }
        else if(str1.equals("Short tons (US)")){
            if(str2.equals("Carats")){
                a = a * 4535924;
            }
            else if(str2.equals("Milligrams")){
                a = a * 907184740;
            }
            else if(str2.equals("Centigrams")){
                a = a * 90718474;
            }
            else if(str2.equals("Decigrams")){
                a = a * 9071847.4;
            }
            else if(str2.equals("Grams")){
                a = a * 907184.74;
            }
            else if(str2.equals("Dekagrams")){
                a = a * 90718.474;
            }
            else if(str2.equals("Hectograms")){
                a = a * 9071.8474;
            }
            else if(str2.equals("Kilograms")){
                a = a * 907.18474;
            }
            else if(str2.equals("Metric tonnes")){
                a = a * 0.90718474;
            }
            else if(str2.equals("Ounces")){
                a = a * 32000;
            }
            else if(str2.equals("Pounds")){
                a = a * 2000;
            }
            else if(str2.equals("Stone")){
                a = a * 143;
            }
            else if(str2.equals("Long tons (UK)")){
                a = a / 1.12;
            }
        }
        else if(str1.equals("Long tons (UK)")){
            if(str2.equals("Carats")){
                a = a * 5080235;
            }
            else if(str2.equals("Milligrams")){
                a = a * 1016046909;
            }
            else if(str2.equals("Centigrams")){
                a = a * 101604691;
            }
            else if(str2.equals("Decigrams")){
                a = a * 10160469.1;
            }
            else if(str2.equals("Grams")){
                a = a * 1016046.91;
            }
            else if(str2.equals("Dekagrams")){
                a = a * 101604.691;
            }
            else if(str2.equals("Hectograms")){
                a = a * 10160.4691;
            }
            else if(str2.equals("Kilograms")){
                a = a * 1016.04691;
            }
            else if(str2.equals("Metric tonnes")){
                a = a * 1.01604691;
            }
            else if(str2.equals("Ounces")){
                a = a * 35840;
            }
            else if(str2.equals("Pounds")){
                a = a * 2240;
            }
            else if(str2.equals("Stone")){
                a = a * 160;
            }
            else if(str2.equals("Short tons (US)")){
                a = a * 1.12;
            }
        }
        String temp = String.valueOf(a);
        textViewResult.setText(temp + type);
    }
}