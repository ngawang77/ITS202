public class QueueTest{//to test the method in Queue
	public static void main(String[] args) {
		Queue s = new Queue(4);
        s.enqueue(10);
		s.enqueue(22);
		s.enqueue(30);
		s.enqueue(42);

		System.out.println(s.isEmpty());
        System.out.println(s.len());
		System.out.println(s.first());
		System.out.println(s.dequeue());
		System.out.println(s.first());
		System.out.println(s.len());

		System.out.println("All test cases passed");
	}
} 