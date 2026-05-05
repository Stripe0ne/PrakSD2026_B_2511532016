package pekan5_2511532016;


public class HapusSLL_2511532016 {
	public static NodeSLL_2511532016 deleteHead_2016(NodeSLL_2511532016 head_2016) {
		if(head_2016 == null) {
			return null;
		}
		head_2016 = head_2016.next_2016;
		return head_2016;
	}
	

	
	public static NodeSLL_2511532016 removeLastNode_2016(NodeSLL_2511532016 head_2016) { 
		if(head_2016 == null) return null;
		if(head_2016.next_2016 == null) return null;
		
		NodeSLL_2511532016 secondLast_2016 = head_2016;
		while(secondLast_2016.next_2016.next_2016 != null) {
			secondLast_2016 = secondLast_2016.next_2016;
		}
		secondLast_2016.next_2016 = null;
		return null;
	}
	public static NodeSLL_2511532016 deleteNode(NodeSLL_2511532016 head_2016, int position_2016) {
		NodeSLL_2511532016 temp_2016 = head_2016;
		NodeSLL_2511532016 prev_2016 = null;
		
		//Null linked list
		if(temp_2016 == null) return head_2016;
		
		//Head dihapus
		if(position_2016 == 1) {
			head_2016 = temp_2016.next_2016;
			return head_2016;
		}
		
		for(int i_2016 = 1; temp_2016 != null && i_2016 < position_2016; i_2016++) {
			prev_2016 = temp_2016;
			temp_2016 = temp_2016.next_2016;}
			
			if(temp_2016 != null) prev_2016.next_2016 = temp_2016.next_2016;
			else System.out.println("Data tidak valid");
			return head_2016;
		
	}
	public static void printList_2016(NodeSLL_2511532016 head) {
		NodeSLL_2511532016 curr_2016 = head;
		while(curr_2016.next_2016 != null) {
			System.out.print(curr_2016.data_2016+"-->");
			curr_2016 = curr_2016.next_2016;
		}
		if(curr_2016.next_2016 == null) {
			System.out.print(curr_2016.data_2016);
			System.out.println();
		}
	}
	public static void main(String[] args) {
		NodeSLL_2511532016 head_2016 = new NodeSLL_2511532016(1);
		head_2016.next_2016 = new NodeSLL_2511532016(2);
		head_2016.next_2016.next_2016 = new NodeSLL_2511532016(3);
		head_2016.next_2016.next_2016.next_2016 = new NodeSLL_2511532016(4);
		head_2016.next_2016.next_2016.next_2016.next_2016 = new NodeSLL_2511532016(5);
		head_2016.next_2016.next_2016.next_2016.next_2016.next_2016 = new NodeSLL_2511532016(6);
		
		System.out.println("List awal: ");
		printList_2016(head_2016);
		
		head_2016 = deleteHead_2016(head_2016);
		System.out.println("List setelah head dihapus: ");
		printList_2016(head_2016);
		
		int position_2016 = 2;
		head_2016 = deleteNode(head_2016, position_2016);
		System.out.println("List setelah node 2 dihapus: ");
		printList_2016(head_2016);
	}

}
