package pekan6_2511532016;

public class InsertDLL_2511532016 {
	
	static NodeDLL_2511532016 insertBegin_2016(NodeDLL_2511532016 head_2016, int data_2016) {
		NodeDLL_2511532016 new_node_2016 = new NodeDLL_2511532016(data_2016);
		new_node_2016.next_2016 = head_2016;
		if(head_2016 != null) {
			head_2016.prev_2016 = new_node_2016;
		}
		return new_node_2016;
	}
	
	public static NodeDLL_2511532016 insertEnd_2016(NodeDLL_2511532016 head_2016, int newData_2016) {
		NodeDLL_2511532016 newNode_2016 = new NodeDLL_2511532016(newData_2016);
		if(head_2016 == null) head_2016 = newNode_2016;
		else {
			NodeDLL_2511532016 curr_2016 = head_2016;
			while(curr_2016.next_2016 != null) {
				curr_2016 = curr_2016.next_2016;
			}
			curr_2016.next_2016 = newNode_2016;
			newNode_2016.prev_2016 = curr_2016;
		}
		return head_2016;
	}
	
	public static NodeDLL_2511532016 insertAtPosition_2016(NodeDLL_2511532016 head_2016, int pos, int new_data) {
		NodeDLL_2511532016 new_node_2016 = new NodeDLL_2511532016(new_data);
		if(pos ==1){
			new_node_2016.next_2016 = head_2016;
			if(head_2016 != null) {
			head_2016.prev_2016 = new_node_2016;
			}
		head_2016= new_node_2016;
		return head_2016;
		}
		
		NodeDLL_2511532016 curr_2016 = head_2016;
		for(int i_2016=1; i_2016<pos - 1 && curr_2016 != null; ++i_2016) {
			curr_2016= curr_2016.next_2016;
		}
		if(curr_2016 == null) {
			System.out.println("Posisi tidak ada");
			return head_2016;
		}
		new_node_2016.prev_2016 = curr_2016;
		new_node_2016.next_2016 = curr_2016.next_2016;
		curr_2016.next_2016 = new_node_2016;
		if(new_node_2016.next_2016 != null) {
			new_node_2016.next_2016.prev_2016 = new_node_2016;
		}
		return head_2016;
	}
	
	
	public static void printList_2016(NodeDLL_2511532016 head_2016){
	NodeDLL_2511532016 curr_2016 = head_2016;
	while (curr_2016 != null) {
		System.out.print(curr_2016.data_2016 + " <-> ");
		curr_2016 = curr_2016.next_2016;
	}
	System.out.println();
	}
	
	
	public static void main(String[] args) {
		NodeDLL_2511532016 head_2016 = new NodeDLL_2511532016(2);
		head_2016.next_2016 = new NodeDLL_2511532016(3);
		head_2016.next_2016.prev_2016 = head_2016;
		head_2016.next_2016.next_2016 = new NodeDLL_2511532016(5);
		head_2016.next_2016.next_2016.prev_2016 = head_2016.next_2016;
		
		System.out.print("DLL awal: ");
		printList_2016(head_2016);
		head_2016 = insertBegin_2016(head_2016, 1);
		System.out.print("Simpul 6 ditambah di akhir: ");
		int data_2016 = 6;
		head_2016 = insertEnd_2016(head_2016, data_2016);
		printList_2016(head_2016);
		
		System.out.print("Tambah node pada posisi 4: ");
		int data2_2016 = 4;
		int pos_2016 =4;
		
		head_2016= insertAtPosition_2016(head_2016, pos_2016, data2_2016);
		printList_2016(head_2016);
	}
}
