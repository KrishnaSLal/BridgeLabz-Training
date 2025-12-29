class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        
        int i = s.length() - 1;
        int length = 0;

        // Skip trailing spaces
        while (i >= 0 && s.charAt(i) == ' ') {
            i--;
        }

        // Count last word characters
        while (i >= 0 && s.charAt(i) != ' ') {
            length++;
            i--;
        }
        return length;
    }
}