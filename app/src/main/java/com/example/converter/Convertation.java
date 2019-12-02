package com.example.converter;

import androidx.annotation.NonNull;
import androidx.annotation.StringRes;

import java.util.Arrays;
import java.util.List;

public enum Convertation {
    //LENGTH(R.string.LENGTH, Arrays.asList(Units.)),
    SQUARE(R.string.SQUARE, Arrays.asList(Units.SQ_CENTIMETRES, Units.SQ_METERS));
    //WEIGHT(R.string.WEIGHT);

    @StringRes
    public final int label;
    public final List<Units> units;

    Convertation(@StringRes int label, @NonNull List<Units> units) {
        this.label = label;
        this.units = units;
    }
}
