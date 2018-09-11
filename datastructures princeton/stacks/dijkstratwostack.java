import java.util.Stack;

//Dijkstra's two-stack algorithm 
//operator: push onto operator stack 
//left parenthesis: ignore 
//right parenthesis: pop operator and two values: push the result of applying 
//that operator to those values onto the operand stack

public class DijkstraAlgorithm{
     public static void main(String[] args) {

        Stack<String> ops = new Stack<String>();       
        Stack<Double> vals = new Stack<Double>();

        //stdin is input, which is the arithmetic expression
        while(!StdIn.isEmpty()){
            String s = StdIn.readString();
            if(s.equals('(')){
                continue;
            } else if (s.equals("+")){
                 ops.push(s);
            } else if (s.equals("*")){
                ops.push(s);
            } else if (s.equals(")")){
                //get operator from ops stack and assign to op
                String op = ops.pop();
                if (op.equals("+")){
                    vals.push(vals.pop() + vals.pop());
                } else if (op.equals("*")){
                    vals.push(vals.pop() * vals.pop());
                }
            } else {
                vals.push(Double.parseDouble(s));
            }

            
        }

        StOut.println(vals.pop());
        
    }
}