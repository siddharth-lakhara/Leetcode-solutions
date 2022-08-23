package _12;

import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeMap;

public class IntToRoman {

    final TreeMap<Integer, String> conversionMap = new TreeMap<>() {{
        put(1, "I");
        put(4, "IV");
        put(5, "V");
        put(9, "IX");
        put(10, "X");
        put(40, "XL");
        put(50, "L");
        put(90, "XC");
        put(100, "C");
        put(400, "CD");
        put(500, "D");
        put(900, "CM");
        put(1000, "M");
    }};

    public String intToRoman(int num) {
        ArrayList<String> answerArr = new ArrayList<>();

        int multiplier = 1;
        while (num != 0) {
            int currNum = (num % 10) * multiplier;
            num /= 10;
            multiplier *= 10;

            ArrayList<String> currString = new ArrayList<>();
            while (currNum != 0) {
                int key = currNum;
                if (!conversionMap.containsKey(key)) {
                    key = conversionMap.lowerKey(currNum);
                }
                currString.add(conversionMap.get(key));
                currNum -= key;
            }
            answerArr.add(String.join("", currString));
        }

        Collections.reverse(answerArr);
        return String.join("", answerArr);
    }

    public void driver() {
        int num = 1994;
        String answer = intToRoman(num);
        System.out.println(answer);
    }

}
