public class KeyIndex {
	void Sort(int a[], int R, int N, int count[], int aux[]){
		// Compute frequency counts.
		for (int i = 0; i < N; i++)
			count [a[i]+1]++;

		// Transform counts to indices.
		for (int r = 0; r < R; r++)
			count[r+1] += count[r];

		// Distribute the records.
		for (int i = 0; i < N; i++)
			aux[count[a[i]]++] = a[i];

		// Copy back.
		for (int i = 0; i < N; i++)
			a[i] = aux[i];

	}
    public static void main(String[] args) {
    	KeyIndex obj = new KeyIndex();
    	int a[]={0,3,5,2,1,8,9,3};
    	int R = 256;
    	int N = a.length;
        int count[]=new int[R+1];
        int[] aux = new int[N];

        System.out.println("Before Sorting: ");
		for (int i = 0; i<N ;i++ ) {
			System.out.print(" "+a[i]);	
		}
		System.out.println("");

        obj.Sort(a,R,N,count,aux);
        
       	System.out.println("After Sorting: ");
		for (int i = 0; i<N ;i++ ) {
			System.out.print(" "+a[i]);	
		}
		System.out.println("");

    }
}