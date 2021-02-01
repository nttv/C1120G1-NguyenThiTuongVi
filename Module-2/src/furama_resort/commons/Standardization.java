package furama_resort.commons;

public class Standardization {
    public static String standardizeString(String str) {
        String newStr = str.toLowerCase();
        String[] arrTemp = newStr.split("");
        newStr = arrTemp[0].toUpperCase() + arrTemp[1];
        for (int i = 2; i < arrTemp.length; i++) {
            if (arrTemp[i - 1].equals(" ")) {
                newStr += arrTemp[i].toUpperCase();
            } else {
                newStr += arrTemp[i];
            }
        }
        return newStr;
    }
}
