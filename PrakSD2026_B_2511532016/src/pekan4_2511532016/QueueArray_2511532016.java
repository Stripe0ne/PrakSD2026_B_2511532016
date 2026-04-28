package pekan4_2511532016;

public class QueueArray_2511532016 {
    int front_2016, rear_2016, size_2016;
    int capacity_2016;
    int array_2016[];

    public QueueArray_2511532016(int capacity) {
        this.capacity_2016 = capacity; // FIX 1: actually store the capacity
        front_2016 = this.size_2016 = 0;
        rear_2016 = capacity_2016 - 1;
        array_2016 = new int[this.capacity_2016];
    }

    boolean isFull_2016(QueueArray_2511532016 queue) {
        return (queue.size_2016 == queue.capacity_2016);
    }

    boolean isEmpty_2016(QueueArray_2511532016 queue) {
        return (queue.size_2016 == 0);
    }

    void enqueue_2016(int item_2016) {
        if (isFull_2016(this)) {
            return;
        }
        this.rear_2016 = (this.rear_2016 + 1) % this.capacity_2016;
        this.array_2016[this.rear_2016] = item_2016;
        this.size_2016 = this.size_2016 + 1;
        System.out.println(item_2016 + " enqueued to queue");
    }

    int dequeue_2016() {
        if (isEmpty_2016(this)) {
            return Integer.MIN_VALUE;
        }
        int item_2016 = this.array_2016[this.front_2016];
        this.front_2016 = (this.front_2016 + 1) % this.capacity_2016;
        this.size_2016 = this.size_2016 - 1;
        return item_2016;
    }

    int front_2016() {
        if (isEmpty_2016(this)) {
            return Integer.MIN_VALUE;
        }
        return this.array_2016[this.front_2016];
    }

    int rear_2016() {
        if (isEmpty_2016(this)) {
            return Integer.MIN_VALUE;
        }
        return this.array_2016[this.rear_2016];
    }

    void display_2016() {
        if (isEmpty_2016(this)) { 
            System.out.println("\n Antrian Kosong");
            return;
        }
        for (int i_2016 = front_2016; i_2016 <= rear_2016; i_2016++) { 
            System.out.printf(" %d <-- ", array_2016[i_2016]);
        }
        System.out.println();
    }
}