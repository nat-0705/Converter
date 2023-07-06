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

public class LengthFragment extends Fragment {

    TextView textViewTemp1,textViewTemp2,textViewResult;
    EditText editTextValue;
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_length, container, false);

        final Spinner spinner1 = root.findViewById(R.id.spinner1);
        final Spinner spinner2 = root.findViewById(R.id.spinner2);

        textViewTemp1 = root.findViewById(R.id.textViewTemp1);
        textViewTemp2 = root.findViewById(R.id.textViewTemp2);
        textViewResult = root.findViewById(R.id.textViewResult);

        editTextValue = root.findViewById(R.id.editTextValue1);

        String[] temperature = {"Nanometers","Microns","Millimeters", "Centimeters", "Meters",
                                "Kilometers","Inches","Feet","Yards","Miles","Nautical Miles"};

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
            a = Long.valueOf(editTextValue.getText().toString());

        if(str1.equals("Nanometers")){
            if(str2.equals("Microns")){
                a = a / 1000;
            }
            else if(str2.equals("Millimeters")){
                a = a /1000000;
            }
            else if(str2.equals("Centimeters")){
                a = a /10000000;
            }
            else if(str2.equals("Meters")){
                a = a / 1000000000;
            }
            else if(str2.equals("Kilometers")){
                a = (a / 1000000) / 1000000;
            }
            else if(str2.equals("Inches")){
                a = (a / 2.54)/ 10000000;
            }
            else if(str2.equals("Feet")){
                a = (a / 3.048)/ 100000000;
            }
            else if(str2.equals("Yards")){
                a = (a / 9.144)/ 100000000;
            }
            else if(str2.equals("Miles")){
                a = (a / 1.609000)/ 1000000000;
            }
            else if(str2.equals("Nautical Miles")){
                a = (a / 1.852000)/ 1000000000;
            }
        }
        else if(str1.equals("Microns")){

            if(str2.equals("Nanometers")){
                a = a * 1000;
            }
            else if(str2.equals("Millimeters")){
                a = a /1000;
            }
            else if(str2.equals("Centimeters")){
                a = a /10000;
            }
            else if(str2.equals("Meters")){
                a = a / 1000000;
            }
            else if(str2.equals("Kilometers")){
                a = a / 1000000000;
            }
            else if(str2.equals("Inches")){
                a = a / 25400;
            }
            else if(str2.equals("Feet")){
                a = a / 304800;
            }
            else if(str2.equals("Yards")){
                a = a /  914400;
            }
            else if(str2.equals("Miles")){
                a = (a / 1.609)/ 1000000000;
            }
            else if(str2.equals("Nautical Miles")){
                a = (a / 1.852)/ 1000000000;
            }
        }
        else if(str1.equals("Millimeters")){

            if(str2.equals("Nanometers")){
                a = a * 1000000;
            }
            else if(str2.equals("Microns")){
                a = a * 1000;
            }
            else if(str2.equals("Centimeters")){
                a = a /10;
            }
            else if(str2.equals("Meters")){
                a = a / 1000;
            }
            else if(str2.equals("Kilometers")){
                a = a / 1000000;
            }
            else if(str2.equals("Inches")){
                a = a / 25.4;
            }
            else if(str2.equals("Feet")){
                a = a / 305;
            }
            else if(str2.equals("Yards")){
                a = a /  914;
            }
            else if(str2.equals("Miles")){
                a = (a / 1.609) / 1000000;
            }
            else if(str2.equals("Nautical Miles")){
                a = (a / 1.852) / 1000000;
            }
        }
        else if(str1.equals("Centimeters")){

            if(str2.equals("Nanometers")){
                a = a * 10000000;
            }
            else if(str2.equals("Microns")){
                a = a * 10000;
            }
            else if(str2.equals("Millimeters")){
                a = a * 10;
            }
            else if(str2.equals("Meters")){
                a = a / 100;
            }
            else if(str2.equals("Kilometers")){
                a = a / 10000;
            }
            else if(str2.equals("Inches")){
                a = a / 2.54;
            }
            else if(str2.equals("Feet")){
                a = a / 30.48;
            }
            else if(str2.equals("Yards")){
                a = a /  91.44;
            }
            else if(str2.equals("Miles")){
                a = a / 160934;
            }
            else if(str2.equals("Nautical Miles")){
                a = a / 185200;
            }
        }
        else if(str1.equals("Meters")){
            if(str2.equals("Nanometers")){
                a = a * 1000000000;
            }
            else if(str2.equals("Microns")){
                a = a * 1000000;
            }
            else if(str2.equals("Millimeters")){
                a = a * 10;
            }
            else if(str2.equals("Centimeters")){
                a = a * 1000;
            }
            else if(str2.equals("Kilometers")){
                a = a / 1000;
            }
            else if(str2.equals("Inches")){
                a = a * 39.37;
            }
            else if(str2.equals("Feet")){
                a = a * 3.281;
            }
            else if(str2.equals("Yards")){
                a = a * 1.094;
            }
            else if(str2.equals("Miles")){
                a = a / 1609;
            }
            else if(str2.equals("Nautical Miles")){
                a = a / 1852;
            }
        }
        else if(str1.equals("Kilometers")){
            if(str2.equals("Nanometers")){
                a = a * 1000000 * 1000000;
            }
            else if(str2.equals("Microns")){
                a = a * 1000000000;
            }
            else if(str2.equals("Millimeters")){
                a = a * 1000000;
            }
            else if(str2.equals("Centimeters")){
                a = a * 100000;
            }
            else if(str2.equals("Meters")){
                a = a * 1000;
            }
            else if(str2.equals("Inches")){
                a = a * 39370;
            }
            else if(str2.equals("Feet")){
                a = a * 3281;
            }
            else if(str2.equals("Yards")){
                a = a * 1094;
            }
            else if(str2.equals("Miles")){
                a = a / 1.609;
            }
            else if(str2.equals("Nautical Miles")){
                a = a / 1.852;
            }
        }
        else if(str1.equals("Inches")){
            if(str2.equals("Nanometers")){
                a = a * 2.540000000;
            }
            else if(str2.equals("Microns")){
                a = a * 25400;
            }
            else if(str2.equals("Millimeters")){
                a = a * 25.4;
            }
            else if(str2.equals("Centimeters")){
                a = a * 2.54;
            }
            else if(str2.equals("Meters")){
                a = a / 39.37;
            }
            else if(str2.equals("Kilometers")){
                a = a / 39370;
            }
            else if(str2.equals("Feet")){
                a = a / 12;
            }
            else if(str2.equals("Yards")){
                a = a / 36;
            }
            else if(str2.equals("Miles")){
                a = a / 63360;
            }
            else if(str2.equals("Nautical Miles")){
                a = a / 72913;
            }
        }
        else if(str1.equals("Feet")){
            if(str2.equals("Nanometers")){
                a = a * 3.04800000000;
            }
            else if(str2.equals("Microns")){
                a = a * 304800;
            }
            else if(str2.equals("Millimeters")){
                a = a * 305;
            }
            else if(str2.equals("Centimeters")){
                a = a * 30.48;
            }
            else if(str2.equals("Meters")){
                a = a / 3.281;
            }
            else if(str2.equals("Kilometers")){
                a = a / 3281;
            }
            else if(str2.equals("Inches")){
                a = a * 12;
            }
            else if(str2.equals("Yards")){
                a = a / 3;
            }
            else if(str2.equals("Miles")){
                a = a / 5280;
            }
            else if(str2.equals("Nautical Miles")){
                a = a / 6076;
            }
        }
        else if(str1.equals("Yards")){
            if(str2.equals("Nanometers")){
                a = a * 9.14400000000;
            }
            else if(str2.equals("Microns")){
                a = a * 914400;
            }
            else if(str2.equals("Millimeters")){
                a = a * 914;
            }
            else if(str2.equals("Centimeters")){
                a = a * 91.44;
            }
            else if(str2.equals("Meters")){
                a = a / 1.094;
            }
            else if(str2.equals("Kilometers")){
                a = a / 1094;
            }
            else if(str2.equals("Inches")){
                a = a * 36;
            }
            else if(str2.equals("Feet")){
                a = a * 3;
            }
            else if(str2.equals("Miles")){
                a = a / 1760;
            }
            else if(str2.equals("Nautical Miles")){
                a = a / 2025;
            }
        }
        else if(str1.equals("Miles")){
            if(str2.equals("Nanometers")){
                a = a * 1.60900000000000;
            }
            else if(str2.equals("Microns")){
                a = a * 1.609000000000;
            }
            else if(str2.equals("Millimeters")){
                a = a * 1.609000000;
            }
            else if(str2.equals("Centimeters")){
                a = a * 160934;
            }
            else if(str2.equals("Meters")){
                a = a * 1609;
            }
            else if(str2.equals("Kilometers")){
                a = a * 1.609;
            }
            else if(str2.equals("Inches")){
                a = a * 63360;
            }
            else if(str2.equals("Feet")){
                a = a * 5280;
            }
            else if(str2.equals("Yard")){
                a = a * 1760;
            }
            else if(str2.equals("Nautical Miles")){
                a = a / 1.151;
            }
        }
        else if(str1.equals("Nautical Miles")){
            if(str2.equals("Nanometers")){
                a = a * 1.852000000000000;
            }
            else if(str2.equals("Microns")){
                a = a * 1.852000000000;
            }
            else if(str2.equals("Millimeters")){
                a = a * 1.852000000;
            }
            else if(str2.equals("Centimeters")){
                a = a * 185200;
            }
            else if(str2.equals("Meters")){
                a = a * 1852;
            }
            else if(str2.equals("Kilometers")){
                a = a * 1.852;
            }
            else if(str2.equals("Inches")){
                a = a * 72913;
            }
            else if(str2.equals("Feet")){
                a = a * 6076;
            }
            else if(str2.equals("Yard")){
                a = a * 2025;
            }
            else if(str2.equals("Miles")){
                a = a * 1.151;
            }
        }

        String temp = String.valueOf(a);
        textViewResult.setText(temp);
    }
}