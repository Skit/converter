package com.example.converter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.List;
import androidx.arch.core.util.Function;

public class Main2Activity extends AppCompatActivity {

    private static String TAG = "item";

    private Units fromUnit;
    private Units toUnit;

    private Convertation convertation;
    private TextInputLayout fromLayout;
    private TextInputLayout toLayout;

    private EditText fromText;
    private EditText toText;

    public static Intent getStartIntent(@NonNull Context context, @NonNull Convertation conversion) {
        final Intent intent = new Intent(context, Main2Activity.class);
        intent.putExtra(TAG, (Parcelable) conversion);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        convertation = getIntent().getParcelableExtra(TAG);
        setContentView(R.layout.activity_main2);
        fromLayout = findViewById(R.id.from_input_layout);
        fromText = fromLayout.getEditText();
        toLayout = findViewById(R.id.to_input_layout);
        toText = toLayout.getEditText();

        final String defaultText = String.valueOf(getResources().getInteger(R.integer.defaultVal));
        final String defaultLabel = getString(convertation.units.get(0).label);
        fromLayout.setHint(defaultLabel);
        toLayout.setHint(defaultLabel);
        fromText.setText(defaultText);
        toText.setText(defaultText);

        Spinner fromSpinner = findViewById(R.id.from_spinner);
        Spinner toSpinner = findViewById(R.id.to_spinner);
        final List<String> unitLabels = transform(convertation.units, u -> getString(u.label));
        fromSpinner.setAdapter(new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, unitLabels));
        toSpinner.setAdapter(new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, unitLabels));

        fromSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                fromUnit = convertation.units.get(position);
                fromLayout.setHint(getString(fromUnit.label));
                convert();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        toSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                toUnit = convertation.units.get(position);
                toLayout.setHint(getString(toUnit.label));
                convert();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        fromText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                convert();
            }
        });
    }

    private static <T, K> List<K> transform(List<T> list, Function<T, K> function) {
        final ArrayList<K> result = new ArrayList<>();
        for (T t : list) {
            result.add(function.apply(t));
        }
        return result;
    }


    private void convert() {
        if (fromUnit != null && toUnit != null) {
            final Editable eFromText = fromText.getText();
            if (eFromText != null && eFromText.length() != 0) {
                try {
                    final Double fromValue = Double.valueOf(eFromText.toString());
                    toText.setText(String.valueOf(fromValue * fromUnit.conversionToBase * toUnit.conversionFromBase));
                } catch (NumberFormatException ex) {
                    //HUI
                }
            }
        }
    }
}
