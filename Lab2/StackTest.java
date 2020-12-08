public class StackTest{//to test the method in stack
	public static void main(String[] args) {
		Stack s = new Stack(4);
        s.push(10);
		s.push(22);
		s.push(30);
		s.push(42);

		s.pop();
		System.out.println(s.isEmpty());
        System.out.println(s.pop());
		System.out.println(s.size());
		System.out.println(s.top());

		System.out.println("All test cases passed");
	}
} 