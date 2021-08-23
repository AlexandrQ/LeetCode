package main.easy;

public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        /*String[] words = s.split(" ");
        return words[words.length - 1].length();*/

        int length = 0;
        char[] chars = s.toCharArray();
        boolean isNotSpace = false;
        for(int i = chars.length - 1; i >= 0; i--) {
            if(chars[i] == ' ') {
                if(isNotSpace) {
                    break;
                }
                continue;
            }
            length++;
            isNotSpace = true;
        }
        return length;
    }
}
