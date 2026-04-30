package pekan4_2511532016;

public class Queue_2511532016 {
    int front_2016, rear_2016, size_2016, max_2016;
    String array_2016[];

    public Queue_2511532016(int max_2016) {
        this.max_2016 = max_2016; 
        front_2016 = this.size_2016 = 0;
        rear_2016 = max_2016 - 1;
        array_2016 = new String[this.max_2016];
    }
    void enqueue_2016(String anu_2016) {
        if (isFull_2016(this)) {
            return;
        }
        this.rear_2016 = (this.rear_2016 + 1) % this.max_2016;
        this.array_2016[this.rear_2016] = anu_2016;
        this.size_2016 = this.size_2016 + 1;
        System.out.println(anu_2016 + " berhasil masuk ke antrian");
    }
    void dequeue_2016() {
        if (isEmpty_2016(this)) {
        	return;
        }
        String item_2016 = this.array_2016[this.front_2016];
        this.front_2016 = (this.front_2016 + 1) % this.max_2016;
        this.size_2016 = this.size_2016 - 1;
        System.out.println(item_2016 + " telah dilayani");

    }
    void display_2016() {
        if (isEmpty_2016(this)) {
            return;
        }
        System.out.println("Isi antrian:");
        for (int i_2016 = 0; i_2016 < this.size_2016; i_2016++) {
            System.out.println((i_2016 + 1) + ". " + array_2016[(front_2016 + i_2016) % max_2016]);
        }
    }
    
    boolean isEmpty_2016(Queue_2511532016 queue_2016) {
        if(queue_2016.size_2016 == 0){
            System.out.println("Antrian Kosong!");
            return true;
        }
        return false;
        
    }
    boolean isFull_2016(Queue_2511532016 queue) {
        if(queue.size_2016 == queue.max_2016){  
            System.out.println("Antrian Sudah Penuh!");
            return true;
        }
        return false;
    }
    void Reverse_2016() {
        if (isEmpty_2016(this)) {
            return;
        }
        String[] temp_2016 = new String[this.size_2016];
        for (int i_2016 = 0; i_2016 < this.size_2016; i_2016++) {
            temp_2016[i_2016] = this.array_2016[(front_2016 + i_2016) % this.max_2016];
        }
        for (int i_2016 = 0; i_2016 < this.size_2016; i_2016++) {
            this.array_2016[i_2016] = temp_2016[this.size_2016 - 1 - i_2016];
        }

        this.front_2016 = 0;
        this.rear_2016 = this.size_2016 - 1;
        this.display_2016();
       
        System.out.println();
    }
}

