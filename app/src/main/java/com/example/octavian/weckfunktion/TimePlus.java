package com.example.octavian.weckfunktion;

/**
 * Created by octavian on 22.01.18.
 */

public class TimePlus {
    int diff;

    public TimePlus(int aDiff) {
        diff = aDiff;
    }

    public String toString() {
        if (diff > 60) {
            return "+" + String.valueOf(diff/60) + "h";
        } else {
            return "+" + String.valueOf(diff) + "min";
        }
    }
}
