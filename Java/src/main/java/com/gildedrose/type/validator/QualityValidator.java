package com.gildedrose.type.validator;

public class QualityValidator {

    private final int qualityCap;

    public QualityValidator(int qualityCap) {
        this.qualityCap = qualityCap;
    }

    public int validate(int quality) {
        if (quality > qualityCap) {
            return qualityCap;
        } else if (quality < 0) {
            return 0;
        } else {
            return quality;
        }
    }
}
