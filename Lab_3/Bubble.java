public class Bubble{
	public static void bubblesort(int[] arr){
		int n = arr.length;

		for (int i = 0; i < arr.length; i++) {

			for (int j = 0; j < arr.length-1; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}

		}
	}
	public static void main(String[] args) {
		int[] arr1 = {3,13,5,2,17,4,8};
		System.out.println("Array before sorting: ");

		for (int i = 0; i < arr1.length; i++) {
			System.out.print(arr1[i] + " ");
		}

		System.out.println();

		System.out.println("Array after sorting: ");

		bubblesort(arr1);
		for (int i:arr1) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
}