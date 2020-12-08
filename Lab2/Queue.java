public class Queue{
	int[] arr;
	int front;
	int len;
	int rear;
	int first;

	public Queue(int e){
		front = -1;
		len = 0;
		rear = -1;
		first = -1;
		arr =new int[e];
	}
	//
	public void enqueue(int e){
		if(isEmpty()){
			arr[0] = e;
			front = 0;
			rear = 0;
			first = arr[0];
		}
		else{
			arr[rear + 1] = e;
			rear = rear + 1;
		}
		len = len +1;
	}
	//
	public int dequeue(){
		if(isEmpty()){
			return 0;
		}
		else{
			front = front + 1;
		}
		len = len - 1;
		return arr[front - 1];
	}
	//
	public int first(){
		if(len == 0){
			return 0;
		}
		else{
			return arr[front];
		}
	}
	//
	public int len(){
		return len;
	}
	//
	public boolean isEmpty(){
		if (len == 0){
			return true;
		}
		return false;
	}

} 