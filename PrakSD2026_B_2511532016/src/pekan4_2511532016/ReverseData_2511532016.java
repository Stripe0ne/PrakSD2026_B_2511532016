package pekan4_2511532016;
import java.util.Queue;
import java.util.Stack;
import java.util.LinkedList;

public class ReverseData_2511532016 {
	public static void main(String[] args) {
		Queue<Integer> q_2016 = new LinkedList<Integer>();
		q_2016.add(1);
		q_2016.add(2);
		q_2016.add(3);
		System.out.println("Sebelum reverse " + q_2016);
		
		Stack<Integer> s_2016 = new Stack<Integer>();
		while(!q_2016.isEmpty() ) {
			s_2016.push(q_2016.remove());
		}
		while(!s_2016.isEmpty()) {
			q_2016.add(s_2016.pop());
			
		}
		System.out.println("Sesudah reverse= " + q_2016);
	}
}
