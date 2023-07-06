package com.example.converter.ui;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.converter.R;

public class TemperatureFragment extends Fragment {

    TextView textViewTemp1,textViewTemp2,textViewResult;
    EditText editTextValue;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_temperature, container, false);

        final Spinner spinner1 = root.findViewById(R.id.spinner1);
        final Spinner spinner2 = root.findViewById(R.id.spinner2);

        textViewTemp1 = root.findViewById(R.id.textViewTemp1);
        textViewTemp2 = root.findViewById(R.id.textViewTemp2);
        textViewResult = root.findViewById(R.id.textViewResult);

        editTextValue = root.findViewById(R.id.editTextValue1);

        String[] temperature = {"Celsius","Fahrenheit","Kelvin"};
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

    public void convert(){
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
        String type = "";
        double a;

        if(editTextValue.getText().toString().isEmpty())
            a = 0;
        else
            a = Double.valueOf(editTextValue.getText().toString());

        if(str1.equals("Celsius")){
            if(str2.equals("Fahrenheit")){
                a = a*(9/5)+32;
            }
            else if(str2.equals("Kelvin")){
                a = a + 273.15;
            }
        }
        else if(str1.equals("Fahrenheit")){
            if(str2.equals("Celsius")){
                a = (a - 32) * 5 / 9;
            }
            else if(str2.equals("Kelvin")){
                a = (a - 32)*(5/9)+273.15;
            }
        }
        else if(str1.equals("Kelvin")){
            if(str2.equals("Celsius")){
                a = a - 273.15;
            }
            else if(str2.equals("Fahrenheit")){
                a =(a-273.15)*(9/5)+32;
            }
        }

        String temp = String.valueOf(a);

        if(str2.equals("Fahrenheit"))
            type = " °F";
        else if(str2.equals("Celsius"))
            type = " °C";
        else if(str2.equals("Kelvin"))
            type = " K";

        textViewResult.setText(temp + type);
    }
}