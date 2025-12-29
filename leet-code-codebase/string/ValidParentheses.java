class ValidParentheses {
    public boolean isValid(String s) {
       java.util.Stack<Character> stack = new java.util.Stack<>();

        for (char ch : s.toCharArray()) {

            // Push opening brackets
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } 
            else {
                // Closing bracket with no opening
                if (stack.isEmpty()) return false;

                char top = stack.pop();

                // Check if matching
                if (ch == ')' && top != '(') return false;
                if (ch == '}' && top != '{') return false;
                if (ch == ']' && top != '[') return false;
            }
        }
        // If stack empty, all brackets matched
        return stack.isEmpty(); 
    }
}