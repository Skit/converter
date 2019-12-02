package com.example.converter;

import androidx.annotation.StringRes;

public enum Units {
    SQ_KILOMETRES(R.string.kilometre, 1000.0, 0.001),
    SQ_METERS(R.string.metre, 1.0, 1.0),
    SQ_CENTIMETRES(R.string.centimetre, 0.01, 100.0),
    SQ_HECTARE(R.string.hectare, 10000.0, 0.0001);

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
