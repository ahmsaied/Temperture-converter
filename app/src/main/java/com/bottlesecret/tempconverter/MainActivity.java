package com.bottlesecret.tempconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import java.io.IOException;
import java.security.cert.PKIXRevocationChecker;
import java.security.cert.X509CRLEntry;
import java.util.InputMismatchException;


public class MainActivity extends AppCompatActivity {

    private EditText temp;
    private EditText res;
    private RadioButton toFahrenheit;
    private RadioButton toCelsius;


    public static double fah2Cel(double f) {
        return (f - 32) * 5 / 9;
    }

    public static double cel2Fah(double c) {
        return 32 + c * 9 / 5;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        res = (EditText) findViewById(R.id.etResult);
        temp = (EditText) findViewById(R.id.etNumber);
        toFahrenheit = (RadioButton) findViewById(R.id.radio_Fahrenheit);
        toCelsius = (RadioButton) findViewById(R.id.radio_Celsius);

    }

    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();

    }

    public void convert(View view) {
        try {
            double value = new Double(temp.getText().toString());
            if (toFahrenheit.isChecked()) {
                value = MainActivity.cel2Fah(value);
            } else {
                value = MainActivity.fah2Cel(value);
            }
            res.setText(new Double(value).toString());
        } catch (NumberFormatException e) {
            e.printStackTrace();
            Toast.makeText(this, "Please enter No.", Toast.LENGTH_SHORT).show();
            return;
        }
        Toast.makeText(MainActivity.this, "Converting", Toast.LENGTH_SHORT).show();
    }

    public void Clear(View view) throws IOException {
        Toast.makeText(MainActivity.this, "Clear", Toast.LENGTH_SHORT).show();
        res.getText().clear();
        temp.getText().clear();
    }
}