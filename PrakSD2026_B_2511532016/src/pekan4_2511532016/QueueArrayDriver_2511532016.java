package pekan4_2511532016;

public class QueueArrayDriver_2511532016 {
public static void main(String[] args) {
	QueueArray_2511532016 queue = new QueueArray_2511532016(1000);
	queue.enqueue_2016(10);
	queue.enqueue_2016(20); 
	queue.enqueue_2016(30); 
	queue.enqueue_2016(40);
	System.out.println("Item di depan " + queue.front_2016()); 
	System.out.println("Item paling belakang " + queue.rear_2016());
	System.out.println("Tampilan queue");
	queue.display_2016();
	System.out.println(queue.dequeue_2016() + " dihapus dari queue");
	System.out.println("Item di depan " + queue.front_2016()); 
	System.out.println("Item paling belakang " + queue.rear_2016());
	System.out.println("Tampilan queue setelah satu data dihapus");
	queue.display_2016();
}
}
