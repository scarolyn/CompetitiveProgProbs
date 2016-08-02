import java.util.*;
public class RPNCalculator{
    public static void main(String[] args) {
        String input = "3 10 8 * + 4 2 / 1 + *";
        int answer = (3 + 10 * 8 ) * (4 / 2 + 1);
        String input2 = "1*";
        String input3 = "3 2 ^";
        String input4 = "1 2 3";
        
        System.out.println(rpmCalc(input) == answer);
        System.out.println(rpmCalc(input3) == 9);
        try {
            System.out.println(rpmCalc(input2));
        } catch(IllegalArgumentException e) {
            System.out.println(true);
        } catch(Exception e) {
            System.out.println("Uncaught exception was thrown");
        }
    }
    
    public static int rpmCalc(String input) {
        Stack<Integer> digits = new Stack<>();
        String[] expression = input.split(" ");
        for (int i = 0; i < expression.length; i++) {
            try {
                digits.push(Integer.parseInt(expression[i]));
            } catch (NumberFormatException e) {
                if (digits.size() < 2) {
                    throw new IllegalArgumentException("Not enough digits to evaluate");
                }
                int second = digits.pop();
                int first = digits.pop();
                int evaluated = evaluateOperator(second, first, expression[i]);
                digits.push(evaluated);
            }
        }
        if (digits.size() != 1) {
            throw new IllegalArgumentException("Not enough operators found");
        }
        return digits.pop();
    }
    
    public static int evaluateOperator(int second, int first, String operator) {
        switch(operator){
            case "*":
                return first * second;
                
            case "/":
                return first / second;
                
            case "+":
                return first + second;
               
           case "-":
                return first - second;
                
           case "^":
                return (int)Math.pow(first, second);
                
           default :
                throw new IllegalArgumentException("Invalid operator");
        }
    }
}
