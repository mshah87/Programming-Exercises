class Solution {
    public int evalRPN(String[] tokens) { // O(n) time and O(n) space
        Stack<Integer> stack = new Stack<>();
        for(String token: tokens){
            if(isOperator(token)){
                stack.push(compute(token, stack.pop(), stack.pop()));
            } else {
                stack.push(Integer.valueOf(token));
            }
        }
        return stack.pop();
    }
    
    public boolean isOperator(String token){
        if(token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")){
            return true;
        } 
        return false;
    }
    
    public int compute(String operator, int num2, int num1){
        int result = 0;
        switch(operator) {
            case "+": result = num1 + num2; 
                break;
            case "-": result = num1-num2;
                break;
            case "*": result = num1*num2;
                break;
            case "/": result = num1/num2;
                break;
        }
        return result;
    }
}
