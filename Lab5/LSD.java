public class LSD
{
	public static void main(String[] args){
		String[] a = {"Yangzom", "Jamyang", "Ngawang", "Lhundup"};
		int N = a.length;
		int R = 256;
		int W = a.length;
		String[] aux = new String[N];

		for (int d = W-1; d >= 0; d--)
		{
			// Sort by key-indexed counting on dth char.
			int[] count = new int[R+1];
			// Compute frequency counts.
			for (int i = 0; i < N; i++){
				count[a[i].charAt(d) + 1]++;
			}
			

			// Transform counts to indices.
			for (int r = 0; r < R; r++){
				count[r+1] += count[r];
			}
			
		
			// Distribute.
			for (int i = 0; i < N; i++){
				aux[count[a[i].charAt(d)]++] = a[i];
			}

			// Copy back.
			for (int i = 0; i < N; i++){
				a[i] = aux[i];
			}
		}
		
		for (int i = 0; i < N; i++)
		{
			System.out.print(" "+a[i]);
		}
		System.out.println(" ");	
	}
}