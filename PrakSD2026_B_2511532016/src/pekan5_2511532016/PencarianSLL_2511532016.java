package pekan5_2511532016;

public class PencarianSLL_2511532016 {
	static boolean searchKey_2016(NodeSLL_2511532016 head_2016, int key_2016) {
		NodeSLL_2511532016 curr_2016 = head_2016;
		while(curr_2016 != null) {
			if(curr_2016.data_2016 == key_2016) 
				return true;
				curr_2016 = curr_2016.next_2016;}
		return false;
		}
	public static void traversal_2016(NodeSLL_2511532016 head_2016) {
		NodeSLL_2511532016 curr_2016 = head_2016;
		while(curr_2016 != null) {
			System.out.print(" " + curr_2016.data_2016);
			curr_2016 = curr_2016.next_2016;}
			System.out.println();
	}
	
	
	public static void main(String[] args) {
		NodeSLL_2511532016 head_2016 = new NodeSLL_2511532016(14);
		head_2016.next_2016 = new NodeSLL_2511532016(21);
		head_2016.next_2016.next_2016 = new NodeSLL_2511532016(13);
		head_2016.next_2016.next_2016.next_2016 = new NodeSLL_2511532016(30);
		head_2016.next_2016.next_2016.next_2016.next_2016 = new NodeSLL_2511532016(10);
		
		System.out.println("Penelusuran SLL : ");
		traversal_2016(head_2016);
		
		int key = 30;
		System.out.print("Cari data " + key + " = ");
		if(searchKey_2016(head_2016, key)) System.out.print("Ketemu");
		else System.out.print("Tidak ada");

	}

}
