public class SeparateChainingHashSTTest {
    public static void main(String[] args) { 
        SeparateChainingHashST<String, Integer> st = new SeparateChainingHashST<String, Integer>();
        st.put("Karma", 1);
        st.put("Lhaki", 7);
        st.put("Landrel", 2);
        st.put("Tshering", 4);
        System.out.println("Size: " +st.size());
        System.out.println(st.get("Landrel"));

        st.delete("Lhaki");
        System.out.println("Size: " +st.size());
        System.out.println(st.keys());
        System.out.println(st.get("Tshering"));
        
        assert(st.size() == 3);
        assert(st.isEmpty() == false);
        assert(st.contains("Lhaki") == true);

        System.out.println("All Test cases passed!");
    }

}