public class BinarySearch{
	public static void main(String [] args){
		int arr[] = {5,30,15,20,25,40};
		int value = 25;
		int first = 0;
		int last = arr.length-1;

		int mid = (first + last)/2;
		while (first <= last){
			if (arr[mid]<value){
				first = mid +1;
			}
			else if (arr[mid] == value){
				System.out.println("The element is found in index: "+mid);
				break;
			}
			else{
				last = mid - 1;
			}
			mid = (first + last)/2;
		}
		if(first>last){
			System.out.println("The element is not found");
		}
	}
}