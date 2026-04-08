package pekan3_2511532016;

public class stackArray_2511532016 {
	static final int MAX = 1000;
	int top;
	int a[] = new int[MAX];
	
	boolean isEmpty_2511532016() {
		return (top < 0);
	}
	stackArray_2511532016(){
		top =-1;
	}
	boolean push_2511532016(int x) {
		if(top >= (MAX-1)) {
			System.out.println("Stack Overflow");
			return false;
		}
		else {
			a[++top] = x;
			System.out.println(x + " dimasukkan ke dalam stack");
			return true;
		}
	}
	int pop_2511532016() {
		if(top <0) {
			System.out.println("Stack Underflow");
			return 0;
		}
		else {
			int x = a[top--];
			return x;
		}
		
			}
	int peek_2511532016() {
		if(top <0) {
			System.out.println("Stack Underflow");
			return 0;
		}
		else {
			int x = a[top];
			return x;
		}
	}
	void print_2511532016() {
		for(int i = top; i>-1; i--) {
			System.out.println(" " + a[i]);
		}
	}
}
	