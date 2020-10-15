public class Merge {

 // stably merge a[lo .. mid] with a[mid+1 ..hi] using aux[lo .. hi]
  private static void merge(int[] a, int[] aux, int lo, int mid, int hi) {
  for (int k = lo; k<=hi; k++ ) {
    aux[k] = a[k];
   }
   
   int i = lo, j = mid+1;
    for (int k = lo; k <= hi; k++) {
        if      (i > mid)              a[k] = aux[j++];
        else if (j > hi)               a[k] = aux[i++];
        else if (less(aux[j], aux[i])) a[k] = aux[j++];
        else                           a[k] = aux[i++];
        }
    }

    // mergesort a[lo..hi] using auxiliary array aux[lo..hi]
    private static void sort(int[] a, int[] aux, int lo, int hi) {
        if (hi <= lo){
            return;
        }
        else
        {
            int mid = lo + (hi-lo) / 2;
            sort(a, aux, lo, mid);
            sort(a, aux, mid + 1, hi);
            merge(a, aux, lo, mid, hi);
        }
    }

   //  /**
   //   * Rearranges the array in ascending order, using the natural order.
   //   * @param a the array to be sorted
   //   */
     public static void sort(int[] a) {
        int[] aux = new int[a.length];
        int lo = 0;
        int hi = a.length - 1;
        sort(a,aux,lo,hi);    
    }


   // /***************************************************************************
   //  *  Helper sorting function.
   //  ***************************************************************************/
    
   //  // is v < w ?
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }
        
   // /***************************************************************************
   //  *  Check if array is sorted - useful for debugging.
   //  ***************************************************************************/
    // private static boolean isSorted(int[] a) {
      //  return isSorted(a, 0, a.length - 1);
        
     //}

   //  private static boolean isSorted(int[] a, int lo, int hi) {
        
   //  }

   // print array to standard output
    private static void show(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
        
    }

    /**
     * Reads in a sequence of strings from standard input; mergesorts them; 
     * and prints them to standard output in ascending order. 
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        int[] a = {4,7,1,3,9,0,5,2,8,6}; 
        System.out.println("Elements Before Sorting:");
         for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        } 
        Merge.sort(a);
        System.out.println("Elements After Sorting:");
        show(a);

    }
}