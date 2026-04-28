package pekan4_2511532016;
import java.util.LinkedList;
import java.util.Queue;

public class QueueLinkedList_2511532016 {

	public static void main(String[] args) {
		Queue<Integer> q_2016 = new LinkedList<>();
		for(int i = 0; i<6 ; i++) {
			q_2016.add(i);
		}
		System.out.println("Elemen Antrian "+ q_2016);
		int hapus_2016 = q_2016.remove();
		System.out.println("Hapus elemen = " + hapus_2016);
		System.out.println(q_2016);
		int depan_2016 = q_2016.peek();
		System.out.println("Kepala Antrian = " + depan_2016);
		
		int banyak_2016 = q_2016.size();
		System.out.println("Size Antrian = " + banyak_2016 );
	}

}
