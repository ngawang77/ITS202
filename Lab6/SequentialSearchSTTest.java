public class SequentialSearchSTTest{
    public static void main(String[] args) {
        SequentialSearchST<String, Integer> obj = new SequentialSearchST<String, Integer>();
        obj.put("a",5);
        obj.put("b",4);
        obj.put("c",2);
        obj.put("b",3);
        obj.delete("b");
        System.out.println(obj.keys());

        System.out.println(obj.isEmpty());
        System.out.println(obj.size());
    }
}
