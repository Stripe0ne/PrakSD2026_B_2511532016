package pekan5_2511532016;


public class TambahSLL_2511532016 {
	public static NodeSLL_2511532016 insertAtFront_2016(NodeSLL_2511532016 head_2016, int value_2016) {
		NodeSLL_2511532016 new_node_2016 = new NodeSLL_2511532016(value_2016);
		new_node_2016.next_2016 = head_2016;
		return new_node_2016;
	}
	//Fungsi menambahkan node di akhir SLL
	public static NodeSLL_2511532016 insertAtEnd_2016(NodeSLL_2511532016 head_2016, int value_2016) {
			//Buat sebuah node dengan sebuah nilai
		NodeSLL_2511532016 newNode_2016 = new NodeSLL_2511532016(value_2016);
		//Jika list kosong maka node jadi head
		if(head_2016 == null){
			return newNode_2016;
		}
		//Simpan head ke variabel sementara
		NodeSLL_2511532016 last_2016 = head_2016;
		//Telusuri ke node akhir
		while(last_2016.next_2016 != null){
			last_2016 = last_2016.next_2016;
		}
		//Ubah pointer
		last_2016.next_2016 = newNode_2016;
		return head_2016;
	}
	static NodeSLL_2511532016 GetNode_2016(int data_2016){
		return new NodeSLL_2511532016(data_2016);
	}
	
	static NodeSLL_2511532016 insertPos_2016(NodeSLL_2511532016 headNode_2016, int position_2016, int value_2016) {
		NodeSLL_2511532016 head_2016 = headNode_2016;
		if(position_2016 < 1) System.out.println("Invalid Position");
		if(position_2016 == 1) {
			NodeSLL_2511532016 new_node_2016 = new NodeSLL_2511532016(value_2016);
			new_node_2016.next_2016 = head_2016;
			return new_node_2016;
		}
		else {
			while(position_2016-- != 0) {
				if(position_2016 == 1) {
					NodeSLL_2511532016 newNode_2016 = GetNode_2016(value_2016);
					newNode_2016.next_2016 = headNode_2016.next_2016;
					headNode_2016.next_2016 = newNode_2016;
					break;
				}
				headNode_2016 = headNode_2016.next_2016;
			}
			if(position_2016 != 1) System.out.println("Posisi di luar jangkauan");
			return head_2016;
		}
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
		//Buat linked list 
		NodeSLL_2511532016 head_2016 = new NodeSLL_2511532016(2);
		head_2016.next_2016 = new NodeSLL_2511532016(3);
		head_2016.next_2016.next_2016 = new NodeSLL_2511532016(5);
		head_2016.next_2016.next_2016.next_2016 = new NodeSLL_2511532016(6);
		
		System.out.print("Senarai berantai awal: ");
		printList_2016(head_2016);
		
		System.out.print("Tambah 1 simpul di depan: ");
		int data_2016 =1;
		head_2016 = insertAtFront_2016(head_2016, data_2016);
		printList_2016(head_2016);
		
		System.out.print("Tambah 1 simpul di belakang: ");
		int data2_2016 = 7;
		head_2016 = insertAtEnd_2016(head_2016, data2_2016);
		printList_2016(head_2016);
		
		System.out.print("Tambah 1 simpul ke data 4: ");
		int data3_2016= 4;
		int pos_2016 = 4;
		head_2016 = insertPos_2016(head_2016, pos_2016, data3_2016);
		
		printList_2016(head_2016);
	}
}
