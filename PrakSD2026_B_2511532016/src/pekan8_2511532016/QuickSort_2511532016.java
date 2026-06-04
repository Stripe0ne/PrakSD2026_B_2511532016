package pekan8_2511532016;

public class QuickSort_2511532016 {
	static void Swap_2016(int[] arr_2016, int i_2016, int j_2016) {
		int temp_2016 = arr_2016[i_2016];
		arr_2016[i_2016] = arr_2016[j_2016];
		arr_2016[j_2016]= temp_2016;
	}
	static void MedianOfThree_2016(int[] arr_2016, int low_2016, int high_2016) {
		int mid_2016 = low_2016 + (high_2016-low_2016)/2;
		
		if(arr_2016[low_2016] > arr_2016[mid_2016]) {
			Swap_2016(arr_2016, high_2016, mid_2016);
		}
		if(arr_2016[low_2016] > arr_2016[high_2016]) {
			Swap_2016(arr_2016, high_2016, mid_2016);
		}
		if(arr_2016[mid_2016] > arr_2016[high_2016]) {
			Swap_2016(arr_2016, high_2016, mid_2016);
		}
		Swap_2016(arr_2016, high_2016, mid_2016);
	}
	
	static int Partition_2016(int[] arr_2016, int low_2016, int high_2016) {
		MedianOfThree_2016(arr_2016, low_2016, high_2016);
		
		int pivot_2016 = arr_2016[high_2016];
		int i_2016 = low_2016-1;
		
		for(int j_2016=low_2016; j_2016<=high_2016-1;j_2016++ ) {
			if(arr_2016[j_2016]<pivot_2016) {
				i_2016++;
				Swap_2016(arr_2016, i_2016, j_2016);
			}
		}
		Swap_2016(arr_2016, 1+i_2016, high_2016);
		return i_2016+1;
	}

	static void QuickSort_2016(int[]arr_2016,int low_2016, int high_2016) {
		if(low_2016<high_2016) {
			int pi_2016= Partition_2016(arr_2016,low_2016,high_2016);
			QuickSort_2016(arr_2016, low_2016, pi_2016-1);
			QuickSort_2016(arr_2016,pi_2016+1, high_2016);
		}
	}
	
	public static void printArray(int[] arr) {
		for(int i_2016:arr) System.out.print(i_2016 + " ");
		System.out.println();
	}
	
	public static void main(String[] args) {
		int[] arr_2016 = {10,7,8,9,1,5};
		System.out.print("Sebelum: ");
		int N_2016 = arr_2016.length;
		printArray(arr_2016);
		
		QuickSort_2016(arr_2016, 0, N_2016-1);
		
		System.out.print("Sesudah Quick Sort: ");
		printArray(arr_2016);
	}

}
