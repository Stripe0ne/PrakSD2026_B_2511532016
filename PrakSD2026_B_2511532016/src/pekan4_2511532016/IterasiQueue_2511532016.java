package pekan4_2511532016;
import java.util.Queue;
import java.util.Iterator;
import java.util.LinkedList;
public class IterasiQueue_2511532016 {
	public static void main(String[] args) {
		Queue<String> q = new LinkedList<>();
		
		q.add("Praktikum");
		q.add("Struktur");
		q.add("Data");
		q.add("Dan");
		q.add("Algoritma");
		Iterator<String> iterator = q.iterator();

		while(iterator.hasNext()){
			System.out.print(iterator.next() + " "); 
		}
	}

}
