package _2259;

public class RemoveDigit {
    public String removeDigit(String number, char digit) {
        int removeIdx = -1;
        for (int idx = 0; idx < number.length()-1; idx++) {
            if (number.charAt(idx) == digit) {
                removeIdx = idx;
                if ((int) number.charAt(idx + 1) > (int) digit) {
                    break;
                }
            }
        }
        if (removeIdx >= 0) {
            return number.substring(0, removeIdx) + number.substring(removeIdx+1); 
        }
        return number.substring(0, number.length()-1);
    }
    
    public void driver() {
        String number = "73197";
        char digit = '7';
        String answer = removeDigit(number, digit);
        System.out.println(answer);
    }
}
