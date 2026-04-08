package pekan3_2511532016;
import java.util.Scanner;
import java.util.Stack;

public class StackPostFix_2511532016 {
	public static int postfixEvaluate_2511532016(String expression) {
		Stack<Integer> s_2511532016 = new Stack<Integer>();
		Scanner input_2511532016 = new Scanner(expression);
		while(input_2511532016.hasNext()) {
			if(input_2511532016.hasNextInt()) {
				if(!s_2511532016.isEmpty()) {
					System.out.println(s_2511532016);
				}
				s_2511532016.push(input_2511532016.nextInt());
				
			}
			
			else {
				if(!s_2511532016.isEmpty()) {
					System.out.println(s_2511532016);
				}
				String operator = input_2511532016.next();
				int operand2 = s_2511532016.pop();
				int operand1 = s_2511532016.pop();
				
				if(operator.equals("+")) {
					s_2511532016.push(operand1 + operand2);
				}
				else if(operator.equals("-")) {
					s_2511532016.push(operand1-operand2);
				}
				else if(operator.equals("*")) {
					s_2511532016.push(operand1 * operand2);
				}
				else {
					s_2511532016.push(operand1/operand2);
				}
		}
	
	}
	input_2511532016.close();
	return s_2511532016.pop();
}
	public static void main(String[] args) {
		System.out.println("hasil postfix= "+postfixEvaluate_2511532016("5 2 4 * + 7 -"));
	}

}




