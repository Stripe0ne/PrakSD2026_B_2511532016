package pekan1_2511532016;																		
public class JamDriver_2511532016 {
	public static void main(String[] args) {
		Jam_2511532016 a_2016 = new Jam_2511532016(23, 59, 50);
		Jam_2511532016 b_2016 = new Jam_2511532016(00, 00, 15);
		System.out.println("a               = " + a_2016);
		System.out.println("b               = " + b_2016);
		System.out.println("a+b             = " + a_2016.plus(b_2016));
		System.out.println("next 20s        = " + a_2016.nextNSecond(20));
		System.out.println("durasi(a,b)     = " + Jam_2511532016.durasiDetik(a_2016,b_2016));
		System.out.println("a.compareTo(b)  = " + a_2016.compareTo(b_2016));
	}}	
