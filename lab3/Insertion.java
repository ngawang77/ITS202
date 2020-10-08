public class Insertion{
	public static void InsertionSort(int arr[]){
        int a = arr.length;

        for (int i = 0; i < a - 1; ++i){
			int x = arr[i];

            for (int j = i +1; j>0 && Compare(j - 1, j, arr) ;j--){ 
                int temp = arr[j-1];
                arr[j-1] = arr[j];
                arr[j] = temp;
            }
        }
    }

    public static boolean Compare(int i, int j, int[] arr){
        if (arr[i] > arr[j]) {
            return true;  
        }
        return false;   
    }	
    	
    public static void main(String [] args){
		int [] arr = {2,6,7,9,3,1,5,4};
		Insertion obj = new Insertion();
	    System.out.println("Array before sorting: ");
		
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
		}
		System.out.println("");
		obj.InsertionSort(arr);

		System.out.println("Array after sorting: ");
		for(int i = 0; i < arr.length; i++){    
            System.out.print(arr[i]);    
        }   
	}
}