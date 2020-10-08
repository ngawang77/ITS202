public class Selection{
	public static void SelectionSort(int[] arr){
		for(int i = 0; i <= arr.length - 1; i++){
			int smallest = i;

			for(int j = i + 1; j < arr.length; j++){
				if (arr[j] <arr[smallest]){
					smallest = j;
				}
			}
			int min = arr[smallest];
			arr[smallest] = arr[i];
			arr[i] = min;
		}
	}
	public static void main(String[] args){
		int [] arr = {5,6,8,2,3,1,7,4};
		int a = arr.length;

		System.out.println("Array before sorting: ");
		for (int i = 0; i < arr.length; i++){
			System.out.println(arr[i]);
		}
		SelectionSort(arr);
		System.out.println("Array after sorting: ");
		for (int i:arr) {
			System.out.print(i+ " ");
		}
	}
}