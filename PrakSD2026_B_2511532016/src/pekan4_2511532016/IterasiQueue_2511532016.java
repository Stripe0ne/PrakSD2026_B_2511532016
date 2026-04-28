package pekan4_2511532016;
import java.util.Queue;
import java.util.Iterator;
import java.util.LinkedList;
public class IterasiQueue_2511532016 {
	public static void main(String[] args) {
		Queue<String> q_2016 = new LinkedList<>();
		q_2016.add("Praktikum");
		q_2016.add("Struktur");
		q_2016.add("Data");
		q_2016.add("Dan");
		q_2016.add("Algoritma");
		Iterator<String> iterator = q_2016.iterator();
		while(iterator.hasNext()){
			System.out.print(iterator.next() + " "); 
		}
	}

}
