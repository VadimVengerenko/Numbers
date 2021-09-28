package service;

import java.util.ArrayList;

public class Converter {
    public ArrayList<Double> convert(StringBuilder info) {
        ArrayList<Double> numbers = new ArrayList<>();
        char buffer;
        double multiplier = 1;
        double number = 0;
        boolean isInteger = true;
        for (int index = 0; index < info.length(); index++) {
            buffer = info.charAt(index);
            if (buffer >= '0' && buffer <= '9') {
                if (isInteger) {
                    number = number * 10 + buffer - '0';
                } else {
                    number += (buffer - '0') / 10.0;
                }
            } else if (buffer == '.') {
                isInteger = false;
            } else if (buffer == '-') {
                multiplier = -1;
            }
            if (buffer == ' ' || index == info.length() - 1) {
                numbers.add(multiplier * number);
                number = 0;
                multiplier = 1;
                isInteger = true;
            }
        }
        return numbers;
    }
}
