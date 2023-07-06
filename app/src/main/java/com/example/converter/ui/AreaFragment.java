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

public class AreaFragment extends Fragment {

    TextView textViewTemp1,textViewTemp2,textViewResult;
    EditText editTextValue;
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_area, container, false);

        final Spinner spinner1 = root.findViewById(R.id.spinner1);
        final Spinner spinner2 = root.findViewById(R.id.spinner2);

        textViewTemp1 = root.findViewById(R.id.textViewTemp1);
        textViewTemp2 = root.findViewById(R.id.textViewTemp2);
        textViewResult = root.findViewById(R.id.textViewResult);

        editTextValue = root.findViewById(R.id.editTextValue1);

        String[] temperature = {"Square millimeters","Square centimeters","Square meters","Hectares", "Square kilometers",
                                "Square inches", "Square feet","Square yards","Acres","Square miles"};

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
        double a;

        if(editTextValue.getText().toString().isEmpty())
            a = 0;
        else
            a = Double.valueOf(editTextValue.getText().toString());


        if(str1.equals("Square millimeters")){
            if(str2.equals("Square centimeters")){
                a = a / 100;
            }
            else if(str2.equals("Square meters")){
                a = a / 100000;
            }
            else if(str2.equals("Hectares")){
                a = (a / 100000) / 100000;
            }
            else if(str2.equals("Square kilometers")){
                a = (a / 1000000) / 1000000;
            }
            else if(str2.equals("Square inches")){
                a = a / 645;
            }
            else if(str2.equals("Square feet")){
                a = a / 92903;
            }
            else if(str2.equals("Square yards")){
                a = a / 836127;
            }
            else if(str2.equals("Acres")){
                a = (a / 4.047) / 1000000000;
            }
            else if(str2.equals("Square miles")){
                a = ((a / 2.59) / 1000000) / 1000000;
            }
        }
        else if(str1.equals("Square centimeters")){
            if(str2.equals("Square millimeters")){
                a = a * 100;
            }
            else if(str2.equals("Square meters")){
                a = a / 10000;
            }
            else if(str2.equals("Hectares")){
                a = (a / 10000) / 10000;
            }
            else if(str2.equals("Square kilometers")){
                a = (a / 100000) / 100000;
            }
            else if(str2.equals("Square inches")){
                a = a / 6.452;
            }
            else if(str2.equals("Square feet")){
                a = a / 929.03;
            }
            else if(str2.equals("Square yards")){
                a = a / 8361.27;
            }
            else if(str2.equals("Acres")){
                a = (a / 4.047) / 10000000;
            }
            else if(str2.equals("Square miles")){
                a = ((a / 2.59) / 100000) / 100000;
            }
        }
        else if(str1.equals("Square meters")){
            if(str2.equals("Square millimeters")){
                a = a * 1000000;
            }
            else if(str2.equals("Square centimeters")){
                a = a * 10000;
            }
            else if(str2.equals("Hectares")){
                a = a / 10000;
            }
            else if(str2.equals("Square kilometers")){
                a = a / 1000000;
            }
            else if(str2.equals("Square inches")){
                a = a * 1550;
            }
            else if(str2.equals("Square feet")){
                a = a * 10.764;
            }
            else if(str2.equals("Square yards")){
                a = a * 1.196;
            }
            else if(str2.equals("Acres")){
                a = a / 4047;
            }
            else if(str2.equals("Square miles")){
                a = (a / 2.59) / 1000000;
            }
        }
        else if(str1.equals("Hectares")){
            if(str2.equals("Square millimeters")){
                a = a * 100000 * 100000;
            }
            else if(str2.equals("Square centimeters")){
                a = a * 100000000;
            }
            else if(str2.equals("Square meters")){
                a = a * 10000;
            }
            else if(str2.equals("Square kilometers")){
                a = a / 100;
            }
            else if(str2.equals("Square inches")){
                a = a * 15500031;
            }
            else if(str2.equals("Square feet")){
                a = a * 107639.1;
            }
            else if(str2.equals("Square yards")){
                a = a * 11959.9;
            }
            else if(str2.equals("Acres")){
                a = a * 2.471054;
            }
            else if(str2.equals("Square miles")){
                a = a / 259;
            }
        }
        else if(str1.equals("Square kilometers")){
            if(str2.equals("Square millimeters")){
                a = a * 1000000 * 1000000;
            }
            else if(str2.equals("Square centimeters")){
                a = a * 100000 * 100000;
            }
            else if(str2.equals("Square meters")){
                a = a * 1000000;
            }
            else if(str2.equals("Hectares")){
                a = a * 100;
            }
            else if(str2.equals("Square inches")){
                a = a * 1550003100;
            }
            else if(str2.equals("Square feet")){
                a = a * 10763910;
            }
            else if(str2.equals("Square yards")){
                a = a * 1195990;
            }
            else if(str2.equals("Acres")) {
                a = a * 247.1054;
            }
            else if(str2.equals("Square miles")){
                a = a / 2.59;
            }
        }
        else if(str1.equals("Square inches")){
            if(str2.equals("Square millimeters")) {
                a = a * 645.16;
            }
            else if(str2.equals("Square centimeters")){
                a = a * 6.4516;
            }
            else if(str2.equals("Square meters")){
                a = a / 1550;
            }
            else if(str2.equals("Hectares")){
                a = a / 1.550000000;
            }
            else if(str2.equals("Square kilometers")){
                a = a / 1.55000000000;
            }
            else if(str2.equals("Square feet")){
                a = a / 144;
            }
            else if(str2.equals("Square yards")){
                a = a / 1296;
            }
            else if(str2.equals("Acres")) {
                a = a / 6.273000000;
            }
            else if(str2.equals("Square miles")){
                a = a / 4.014000000000;
            }
        }
        else if(str1.equals("Square feet")){
            if(str2.equals("Square millimeters")) {
                a = a * 92903.04;
            }
            else if(str2.equals("Square centimeters")){
                a = a * 929.0304;
            }
            else if(str2.equals("Square meters")){
                a = a / 10.764;
            }
            else if(str2.equals("Hectares")){
                a = a / 107639;
            }
            else if(str2.equals("Square kilometers")){
                a = a / 1.0760000000;
            }
            else if(str2.equals("Square inches")){
                a = a * 144;
            }
            else if(str2.equals("Square yards")){
                a = a / 9;
            }
            else if(str2.equals("Acres")) {
                a = a / 43560;
            }
            else if(str2.equals("Square miles")){
                a = a / 2.7880000000;
            }
        }
        else if(str1.equals("Square yards")){
            if(str2.equals("Square millimeters")) {
                a = a * 836127.4;
            }
            else if(str2.equals("Square centimeters")){
                a = a * 8361.274;
            }
            else if(str2.equals("Square meters")){
                a = a *  0.8361274;
            }
            else if(str2.equals("Hectares")){
                a = a / 11960;
            }
            else if(str2.equals("Square kilometers")){
                a = a / 1.196000000;
            }
            else if(str2.equals("Square inches")){
                a = a * 1296;
            }
            else if(str2.equals("Square feet")){
                a = a * 9;
            }
            else if(str2.equals("Acres")) {
                a = a / 4840;
            }
            else if(str2.equals("Square miles")){
                a = a / 3.098000000;
            }
        }
        else if(str1.equals("Acres")){
            if(str2.equals("Square millimeters")) {
                a = a * 404685642.2 * 10;
            }
            else if(str2.equals("Square centimeters")){
                a = a * 40468564;
            }
            else if(str2.equals("Square meters")){
                a = a *  4046.8564;
            }
            else if(str2.equals("Hectares")){
                a = a / 0.40468564;
            }
            else if(str2.equals("Square kilometers")){
                a = a / 247;
            }
            else if(str2.equals("Square inches")){
                a = a * 6272640;
            }
            else if(str2.equals("Square feet")){
                a = a * 43560;
            }
            else if(str2.equals("Square yards")) {
                a = a * 4840;
            }
            else if(str2.equals("Square miles")){
                a = a / 640;
            }
        }
        else if(str1.equals("Square miles")){
            if(str2.equals("Square millimeters")) {
                a = a * 2589988110.336 * 1000;
            }
            else if(str2.equals("Square centimeters")){
                a = a * 258998811.03 * 100;
            }
            else if(str2.equals("Square meters")){
                a = a * 2589988;
            }
            else if(str2.equals("Hectares")){
                a = a * 258.9988;
            }
            else if(str2.equals("Square kilometers")){
                a = a * 2.589988;
            }
            else if(str2.equals("Square inches")){
                a = a * 40144896 * 100;
            }
            else if(str2.equals("Square feet")){
                a  = a * 27878400;
            }
            else if(str2.equals("Square yards")) {
                a = a * 3097600;
            }
            else if(str2.equals("Acres")){
                a = a * 640;
            }
        }

        String temp = String.valueOf(a);
        textViewResult.setText(temp);
    }
}