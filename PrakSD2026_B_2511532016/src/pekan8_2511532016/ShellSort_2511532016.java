package pekan8_2511532016;

public class ShellSort_2511532016 {
	
	public static void ShellSort_2016(int[] A_2016) {
		int n_2016 = A_2016.length;
		int gap_2016 = n_2016/2;
		while(gap_2016 > 0) {
			for(int i_2016=gap_2016 ; i_2016<n_2016; i_2016++) {
				int temp_2016 = A_2016[i_2016];
				int j_2016=i_2016;
				while(j_2016>=gap_2016 && A_2016[j_2016-gap_2016] > temp_2016) {
					A_2016[j_2016]= A_2016[j_2016-gap_2016];
					j_2016= j_2016-gap_2016;
				}
				A_2016[j_2016] = temp_2016;
			}
			gap_2016 = gap_2016/2;
		}
	}
	public static void printArray(int[] arr) {
		for(int i_2016:arr) System.out.print(i_2016 + " ");
		System.out.println();
	}
	
	public static void main(String[] args) {
		int[] data_2016 = {3,10,4,6,8,9,7,2,1,5};
		System.out.print("Sebelum: ");
		printArray(data_2016);
		
		ShellSort_2016(data_2016);
		
		System.out.print("Sesudah Shell Sort: ");
		printArray(data_2016);
	}

}
