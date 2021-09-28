package service;

import java.util.ArrayList;

public class Validator {
    public StringBuilder validate (StringBuilder info) {
        int startIndex = 0;
        int pointCounter = 0;
        char buffer;
        boolean isValid = true;
        for (int index = 0; index < info.length(); index++) {
            buffer = info.charAt(index);
            if (buffer == ' ') {
                if (!isValid) {
                    info.delete(startIndex, index + 1);
                    index = startIndex - 1;
                    isValid = true;
                }
                startIndex = index + 1;
                pointCounter = 0;
            }
            if (buffer == '.') {
                pointCounter++;
            } else {
                isValid &= (buffer >= '0' && buffer <= '9') || buffer == ' ';
                isValid |= (buffer == '-' || buffer == '+') && (index - startIndex == 0);
                isValid &= pointCounter < 2;
            }
            if (index == info.length() - 1 && !isValid) {
                info.delete(startIndex, info.length());
            }
        }
        return info;
    }
}
