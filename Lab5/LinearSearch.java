public class LinearSearch{
	public static void main(String[] args){
		int arr[] = {3,4,2,6,5,9,0,8};
		int value = 6;
		int len = arr.length;

		for (int i=0; i<len; i++){
			if(arr[i]==value)
			System.out.println("The element is found in index: "+i);
		}
	}
}