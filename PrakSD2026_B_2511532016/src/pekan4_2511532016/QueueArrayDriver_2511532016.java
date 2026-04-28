package pekan4_2511532016;

public class QueueArrayDriver_2511532016 {
public static void main(String[] args) {
	QueueArray_2511532016 queue_2016 = new QueueArray_2511532016(1000);
	queue_2016.enqueue_2016(10);
	queue_2016.enqueue_2016(20); 
	queue_2016.enqueue_2016(30); 
	queue_2016.enqueue_2016(40);
	System.out.println("Item di depan " + queue_2016.front_2016()); 
	System.out.println("Item paling belakang " + queue_2016.rear_2016());
	System.out.println("Tampilan queue");
	queue_2016.display_2016();
	System.out.println(queue_2016.dequeue_2016() + " dihapus dari queue");
	System.out.println("Item di depan " + queue_2016.front_2016()); 
	System.out.println("Item paling belakang " + queue_2016.rear_2016());
	System.out.println("Tampilan queue setelah satu data dihapus");
	queue_2016.display_2016();
}
}
