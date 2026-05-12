package pekan6_2511532016;

public class HapusDLL_2511532016 {
	
	public static NodeDLL_2511532016 delHead_2016(NodeDLL_2511532016 head_2016) {
		if(head_2016 == null) return null;
		head_2016 = head_2016.next_2016;
		if(head_2016 != null) head_2016.prev_2016 = null;
		return head_2016;
	}
	
	public static NodeDLL_2511532016 delLast(NodeDLL_2511532016 head_2016) {
		if(head_2016 == null || head_2016.next_2016== null) return null;
		NodeDLL_2511532016 curr_2016 = head_2016;
		while(curr_2016.next_2016 != null) {
			curr_2016 = curr_2016.next_2016;
		}
		if(curr_2016.prev_2016 != null ) {
			curr_2016.prev_2016.next_2016 = null;
		}
		return head_2016;
	}
	
	public static NodeDLL_2511532016 delPos_2016(NodeDLL_2511532016 head_2016, int pos_2016) {
		if(head_2016 == null) return head_2016;
		NodeDLL_2511532016 curr_2016 = head_2016;
		
		for(int i_2016=1; curr_2016 != null && i_2016 < pos_2016; ++i_2016) {
			curr_2016 = curr_2016.next_2016;
		}
		if(curr_2016 == null) return head_2016;
		if(curr_2016.prev_2016 != null) curr_2016.prev_2016.next_2016 = curr_2016.next_2016;
		if(curr_2016.next_2016 != null) curr_2016.next_2016.prev_2016 = curr_2016.prev_2016;
		if(head_2016 == curr_2016) head_2016 = curr_2016.next_2016;
		return head_2016;
	}
	
	public static void printList_2016(NodeDLL_2511532016 head_2016){
		NodeDLL_2511532016 curr_2016 = head_2016;
		while (curr_2016 != null) {
			System.out.print(curr_2016.data_2016 + " ");
			curr_2016 = curr_2016.next_2016;
		}
		System.out.println();
		}
	
	public static void main(String[] args) {
		NodeDLL_2511532016 head_2016 = new NodeDLL_2511532016(1);
		head_2016.next_2016 = new NodeDLL_2511532016(2);
		head_2016.next_2016.prev_2016 = head_2016;
		
		head_2016.next_2016.next_2016 = new NodeDLL_2511532016(3);
		head_2016.next_2016.next_2016.prev_2016 = head_2016.next_2016;
		
		head_2016.next_2016.next_2016.next_2016 = new NodeDLL_2511532016(4);
		head_2016.next_2016.next_2016.next_2016.prev_2016 = head_2016.next_2016.next_2016;
		
		head_2016.next_2016.next_2016.next_2016.next_2016  = new NodeDLL_2511532016(5);
		head_2016.next_2016.next_2016.next_2016.next_2016.prev_2016  = head_2016.next_2016.next_2016.next_2016;
		
		System.out.print("DLL awal: ");
		printList_2016(head_2016);
		
		System.out.print("DLL setelah head dihapus: ");
		head_2016 = delHead_2016(head_2016);
		printList_2016(head_2016);
		
		System.out.print("DLL setelah node terakhir dihapus: ");
		head_2016 = delLast(head_2016);
		printList_2016(head_2016);
		
		System.out.print("Menghapus node ke 2: ");
		head_2016 = delPos_2016(head_2016, 2);
		
		printList_2016(head_2016);
	}
	
}
