package com.example.converter;

import androidx.annotation.StringRes;

public enum Units {
    SQ_KILOMETRES(R.string.SQ_KILOMETRE, 1000000.0, 0.000001),
    SQ_METRES(R.string.SQ_METRE, 1.0, 1.0),
    SQ_CENTIMETRES(R.string.SQ_CENTIMETRE, 0.0001, 10000.0),
    SQ_HECTARE(R.string.SQ_HECTARE, 10000.0, 0.0001),
    KILOMETRE(R.string.kilometre, 1000.0, 0.001),
    MILE(R.string.mile, 1609.344, 0.00062137119223733397),
    METRE(R.string.metre, 1.0, 1.0),
    CENTIMETRE(R.string.centimetre, 0.01, 100.0),
    MILLIMETRE(R.string.millimetre, 0.001, 1000.0),
    MICROMETRE(R.string.micrometre, 0.000001, 1000000.0);

    @StringRes
    public int label;
    public double conversionToBase;
    public double conversionFromBase;

    Units(@StringRes int label, double conversionToBase, double conversionFromBase) {
        this.label = label;
        this.conversionToBase = conversionToBase;
        this.conversionFromBase = conversionFromBase;
    }
}
