package pekan3_2511532016;

public class stackArrayDriver_2511532016 {

	public static void main(String[] args) {
		stackArray_2511532016 s = new stackArray_2511532016();
		s.push_2511532016(10);
		s.push_2511532016(20);
		s.push_2511532016(30);
		System.out.println(s.pop_2511532016() + " dikeluarkan dari stack");
		System.out.println("Elemen teratas adalah :" + s.peek_2511532016());
		System.out.println("Elemen pada stack :");
		s.print_2511532016();
		
	}

}
