import java.util.*;

public class Solution<Key extends Comparable<Key>, Value> {
    private Node root;        // root of BST
    public int size = 0;

    private class Node {
        private Key key;           // sorted by key
        private Value val;         // associated data
        private Node left, right;  // left and right subtrees
        //private int size;          // number of nodes in subtree

        public Node(Key key, Value val, int size) {
            this.key = key;
            this.val = val;
            //this.size = size;

        }
    }

    /**
     * Initializes an empty symbol table.
     */
    public Solution() {
        root = null;
    }

    /**
     * Returns true if this symbol table is empty.
     * @return {@code true} if this symbol table is empty; {@code false} otherwise
     */
    public boolean isEmpty() {
        if (size() == 0) {
            return true;  
        }
        return false;
       
    }

    /**
     * Returns the number of key-value pairs in this symbol table.
     * @return the number of key-value pairs in this symbol table
     */
    public int size() {
        return size;
    }

    // return number of key-value pairs in BST rooted at x
    //private int size(Node x) {  
       
    //}

    /**
     * Does this symbol table contain the given key?
     *
     * @param  key the key
     * @return {@code true} if this symbol table contains {@code key} and
     *         {@code false} otherwise
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    // public boolean contains(Key key) {

    //}

    /**
     * Returns the value associated with the given key.
     *
     * @param  key the key
     * @return the value associated with the given key if the key is in the symbol table
     *         and {@code null} if the key is not in the symbol table
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public Value get(Key key) {
        Node curNode = root;
        if (key == null) {
            throw new IllegalArgumentException("Key is Null");
        }
        while(curNode.key != key){
            int temp = key.compareTo(curNode.key);
            if(temp < 0){
                curNode = curNode.left;
            }
            else if(temp > 0){
                curNode = curNode.right;
            }
            if(curNode.key == key){
               return curNode.val;
             }
        }
        // if(curNode.key == key
        //     System.out.println(curNode.val);
        // }
        return curNode.val;    
    }
 
    /**
     * Inserts the specified key-value pair into the symbol table, overwriting the old 
     * value with the new value if the symbol table already contains the specified key.
     * Deletes the specified key (and its associated value) from this symbol table
     * if the specified value is {@code null}.
     *
     * @param  key the key
     * @param  val the value
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */

    public void put(Key key, Value val) {
        if(key == null){
            throw new IllegalArgumentException("Argument to get value() is null");
        }
        else{
            Node newNode = new Node(key,val, 1);
            if (root == null) {
                root = newNode;
            }
            else{
                Node curNode = root;
                Node parent;
                while(curNode != null){
                    parent = curNode;
                    int temp = key.compareTo(curNode.key);
                    if (temp < 0) {
                        curNode = curNode.left;
                        if(curNode == null){
                            parent.left = newNode;
                            size = size + 1;
                            return;
                        }      
                        else if (curNode.key == key) {
                            curNode.val = val;
                            return;
                        }
                    }
                    else if(temp > 0){
                        curNode = curNode.right;
                        if(curNode == null){
                            parent.right = newNode;
                            size = size +1;
                            return;
                        }
                        else if(curNode.key == key){
                            curNode.val = val;
                            return;
                        }
                    }
                }
            }
            size = size +1;
        }
    }


    /**
     * Returns the smallest key in the symbol table.
     *
     * @return the smallest key in the symbol table
     * @throws NoSuchElementException if the symbol table is empty
     */
    public Key min() {
        if(isEmpty()){
            throw new NoSuchElementException("Symbol Table is Empty"); 
        }  
        else{
            Node curNode = root;
            while(curNode.left != null){
                curNode = curNode.left;
            }
            return curNode.key;
        }
    } 



    /**
     * Returns the largest key in the symbol table less than or equal to {@code key}.
     *
     * @param  key the key
     * @return the largest key in the symbol table less than or equal to {@code key}
     * @throws NoSuchElementException if there is no such key
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public Key floor(Key key) {
       if(key == null)
            throw new IllegalArgumentException("Argument to floor() is null");
        if(isEmpty())
            throw new NoSuchElementException("Called floor() with empty symbol table");
        Node curNode = floor(root, key);
        if(curNode == null){
            return null;
        }
        else{
            return curNode.key;
        }
    }
    private Node floor(Node curNode, Key key){
        Node small = null;
        while(curNode != null){
            int temp = key.compareTo(curNode.key);
            if(temp == 0){
                return curNode;
            }
            if(temp > 0){
                small = curNode;
                curNode = curNode.right;
            }
            else{
                curNode = curNode.left;
            }
        }
        return small;
    }

    /**
     * Return the key in the symbol table whose rank is {@code k}.
     * This is the (k+1)st smallest key in the symbol table.
     *
     * @param  k the order statistic
     * @return the key in the symbol table of rank {@code k}
     * @throws IllegalArgumentException unless {@code k} is between 0 and
     *        <em>n</em>–1
     */
    public Key select(int k) {
        if((k < 0) || k >= size()){
            throw new IllegalArgumentException("Rank should be between 0 and its size");
        }
        return select(root, k+1).key;
    }

    // Return key of rank k. 
    private Node select(Node x, int k) {
        int nodeCount = 0;
        Stack<Node> stack = new Stack<Node>();
        Node curr = root;
        while(!stack.isEmpty() || curr != null)
        {
            if(curr != null)
            {
                stack.push(curr);
                curr = curr.left;
            }
            else
            {
                curr = stack.pop();
                nodeCount++;
                if(nodeCount == k)
                    break;
                curr = curr.right;
            }
        }
        return curr;
    } 



    /**
     * Returns all keys in the symbol table in the given range,
     * as an {@code Iterable}.
     *
     * @param  lo minimum endpoint
     * @param  hi maximum endpoint
     * @return all keys in the symbol table between {@code lo} 
     *         (inclusive) and {@code hi} (inclusive)
     * @throws IllegalArgumentException if either {@code lo} or {@code hi}
     *         is {@code null}
     */
   
        public Iterable<Key> keys(Key lo, Key hi) {
        if (lo == null) {
            throw new IllegalArgumentException("First argument to keys() is null");
        }
        if (hi == null) {
            throw new IllegalArgumentException("Second argument to keys() is null");
        }

        ArrayList<Key> arr = new ArrayList<Key>();
        keys(root, arr, lo, hi);
        return arr;
    }

    private void keys(Node curr,ArrayList<Key> arr, Key lo, Key hi) { 
        if (curr == null) {
            return;
        }
        while (curr != null){

            int temp = curr.key.compareTo(lo);
            int temp1 = curr.key.compareTo(hi);
            
            if (curr.left == null) {
                if (temp1 <= 0 && temp >= 0) {
                    arr.add(curr.key);
                }
                curr = curr.right;
            }
            else {
                Node node = curr.left;
                while (node.right != null && node.right != curr) {
                    node = node.right;
                }
                if (node.right == null) {
                    node.right = curr;
                    curr = curr.left;
                }
                else {
                    node.right = null;
                    if (temp1 <= 0 && temp>=0) arr.add(curr.key);{
                     curr = curr.right;
                    }
                }
            }
        }
    }
        

    /* Run the program by giving the approriate command obtained from
    input files through input.txt files. The output should be displayed
    exactly like the file output.txt shows it to be.*/
  
    public static void main(String[] args) { 
        Solution<String, Integer> obj = new Solution<String, Integer>();
        obj.put("ABDUL",1);
        System.out.println(obj.get("ABDUL"));
        obj.put("HRITHIK",2);
        obj.put("SAI",3);
        obj.put("SAMAL",6);
        System.out.println(obj.get("SAI")); 
        obj.put("TASHI",4);

        System.out.println(obj.size());
        System.out.println(obj.min());
        System.out.println(obj.floor("HRITHIK"));
        System.out.println(obj.floor("HAHA"));
        System.out.println(obj.select(2));
        System.out.println(obj.keys("ABDUL","TASHI"));
        obj.put("CHIMI",5);
        obj.put("SAMAL",6);
        System.out.println(obj.get("SAMAL"));
        obj.put("NIMA",7);
        System.out.println(obj.size());
        System.out.println(obj.get("CHIMI"));
        System.out.println(obj.floor("CHIMA"));
        obj.put("SONAM",8);  
        System.out.println(obj.keys("ABDUL", "TASHI"));
       
    }
}