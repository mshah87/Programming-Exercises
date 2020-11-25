class Solution { //O(n) complexity, O(n) space
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(char c: s.toCharArray()){
            if(c == '(' || c == '{' || c == '[' ){
                stack.push(c);
            } else if (c == ')' && !stack.isEmpty() && stack.peek() == '('){
                stack.pop();
            } else if (c == '}' && !stack.isEmpty() && stack.peek() == '{'){
                stack.pop();
            } else if (c == ']' && !stack.isEmpty() && stack.peek() == '['){
                stack.pop();
            } else {
                return false; //if theres only one character
            }
        }
        return stack.isEmpty(); // in the end stack should be empty
    }
}