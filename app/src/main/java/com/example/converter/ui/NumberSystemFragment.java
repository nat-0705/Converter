package com.example.converter.ui;

import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputType;
import android.text.Spanned;
import android.text.TextWatcher;
import android.text.method.DigitsKeyListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.converter.R;

import java.util.Scanner;

public class NumberSystemFragment extends Fragment {

    TextView textViewTemp1, textViewTemp2, textViewResult;
    EditText editTextValue;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_number_system, container, false);


        final Spinner spinner1 = root.findViewById(R.id.spinner1);
        final Spinner spinner2 = root.findViewById(R.id.spinner2);

        textViewTemp1 = root.findViewById(R.id.textViewTemp1);
        textViewTemp2 = root.findViewById(R.id.textViewTemp2);
        textViewResult = root.findViewById(R.id.textViewResult);

        editTextValue = root.findViewById(R.id.editTextValue1);

        String[] temperature = {"Binary", "Octal", "Decimal", "Hexadecimal"};
        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, temperature);
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

        String stringToBlock = "";
        final String blockCharacterSet;

        if(str1.equals("Hexadecimal")){
           // stringToBlock = "QWRTYUIOPSGHJKLZXVNM,[];'./,!@#$%^&*()-_+={}:<>?";
            stringToBlock = ".";
        }else if (str1.equals("Decimal")) {
          //  stringToBlock = "QWERTYUIOPASDFGHJKLZXCVBNM,[];'./,!@#$%^&*()-_+={}:<>?";
            stringToBlock = ".ABCDEFabcdef";
        } else if (str1.equals("Octal")) {
           // stringToBlock = "9QWERTYUIOPASDFGHJKLZXCVBNM,[];'./,!@#$%^&*()-_+={}:<>?";
            stringToBlock = "9.ABCDEFabcdef";
        } else if (str1.equals("Binary")) {
          //  stringToBlock = "23456789QWERTYUIOPASDFGHJKLZXCVBNM,[];'./,!@#$%^&*()-_+={}:<>?";
            stringToBlock = "23456789.ABCDEFabcdef";
        }

        blockCharacterSet = stringToBlock;
        InputFilter filter = new InputFilter() {
            @Override
            public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
                if (source != null && blockCharacterSet.contains(("" + source))) {
                    return "";
                }
                return null;
            }
        };
        editTextValue.setFilters(new InputFilter[]{filter});

        String a;
        if (editTextValue.getText().toString().isEmpty())
            a = "0";
        else
            a = editTextValue.getText().toString();

        if(str1.equals(str2)) {
            String temp = a;
            textViewResult.setText(temp);
        }
        else if (str1.equals("Binary")) {
            if (str2.equals("Octal")) {
                numSystemOctal(2);
            }
            else if (str2.equals("Decimal")) {
                numSystemDecimal(2);
            }
            else if (str2.equals("Hexadecimal")){
                numSystemHexadecimal(2);
            }
        }
        else if (str1.equals("Octal")) {
            if (str2.equals("Binary")) {
                numSystemBinary(8);
            }
            else if (str2.equals("Decimal")) {
                numSystemDecimal(8);
            }
            else if (str2.equals("Hexadecimal")) {
                numSystemHexadecimal(8);
            }
        }
        else if (str1.equals("Decimal")) {
            if (str2.equals("Binary")) {
                numSystemBinary(10);
            } else if (str2.equals("Octal")) {
                numSystemOctal(10);
            }
            else if (str2.equals("Hexadecimal")) {
                numSystemHexadecimal(10);
            }
        }
        else if (str1.equals("Hexadecimal")) {
            if (str2.equals("Binary")) {
                numSystemBinary(16);
            }
            else if (str2.equals("Octal")) {
                numSystemOctal(16);
            }
            else if (str2.equals("Decimal")) {
                numSystemDecimal(16);
            }
        }
    }

    public void numSystemDecimal(int x){
        try {
            String textHolder = editTextValue.getText().toString();
            int temp1 = Integer.parseInt(textHolder, x);
            String temp2 = String.valueOf(temp1);
            textViewResult.setText(temp2);
        }
        catch(Exception e){
        }
    }
    public void numSystemBinary(int x){
        try {
            String textHolder = editTextValue.getText().toString();
            int temp1 = Integer.parseInt(textHolder, x);
            String temp2 = Integer.toBinaryString(temp1);
            textViewResult.setText(temp2);
        }
        catch(Exception e){
        }
    }
    public void numSystemOctal(int x){
        try {
            String textHolder = editTextValue.getText().toString();
            int temp1 = Integer.parseInt(textHolder, x);
            String temp2 = Integer.toOctalString(temp1);
            textViewResult.setText(temp2);
        }
        catch(Exception e){
        }
    }
    public void numSystemHexadecimal(int x){
        try {
            String textHolder = editTextValue.getText().toString();
            int temp1 = Integer.parseInt(textHolder, x);
            String temp2 = Integer.toHexString(temp1).toUpperCase();
            textViewResult.setText(temp2);
        }
        catch(Exception e){
        }
    }
}
