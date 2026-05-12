package pekan6_2511532016;

public class Penelusuran_2511532016 {
	static void forwardTraversal_2016(NodeDLL_2511532016 head) {
		NodeDLL_2511532016 curr = head;
		while(curr != null){
			System.out.print(curr.data_2016 + " <-> ");
			curr = curr.next_2016;
		}
		System.out.println();
	}
	
	static void backwardTraversal_2016(NodeDLL_2511532016 tail_2016) {
		NodeDLL_2511532016 curr_2016 = tail_2016;
		while(curr_2016 != null){
			System.out.print(curr_2016.data_2016 + " <-> ");
			curr_2016 = curr_2016.prev_2016;
		}
		System.out.println();
	}
	
	
	public static void main(String[] args) {
		NodeDLL_2511532016 head_2016 = new NodeDLL_2511532016(1);
		NodeDLL_2511532016 second_2016 = new NodeDLL_2511532016(2);
		NodeDLL_2511532016 third_2016 = new NodeDLL_2511532016(3);
		
		head_2016.next_2016 = second_2016;
		second_2016.prev_2016 = head_2016;
		second_2016.next_2016 = third_2016;
		third_2016.prev_2016 = second_2016;
		
		System.out.println("Penelusuran maju: "); forwardTraversal_2016(head_2016);
		System.out.println("Penelusuran mundur: "); backwardTraversal_2016(third_2016);

	}

}
