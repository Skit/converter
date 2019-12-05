package com.example.converter;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.annotation.StringRes;

import java.util.Arrays;
import java.util.List;

public enum Convertation implements Parcelable {
    LENGTH(R.string.LENGTH, Arrays.asList(Units.MILE, Units.KILOMETRE, Units.METRE, Units.CENTIMETRE, Units.MILLIMETRE, Units.MICROMETRE)),
    SQUARE(R.string.SQUARE, Arrays.asList(Units.SQ_CENTIMETRES, Units.SQ_KILOMETRES, Units.SQ_METRES, Units.SQ_HECTARE));

    @StringRes
    public final int label;
    public List<Units> units;

    Convertation(@StringRes int l, @NonNull List<Units> u) {
        label = l;
        units = u;
    }

    Convertation(Parcel in) {
        label = in.readInt();
    }

    public static final Creator<Convertation> CREATOR = new Creator<Convertation>() {
        @Override
        public Convertation createFromParcel(Parcel in) {
            return Convertation.values()[in.readInt()];
        }

        @Override
        public Convertation[] newArray(int size) {
            return new Convertation[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(ordinal());
    }
}
