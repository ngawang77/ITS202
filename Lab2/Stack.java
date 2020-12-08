public class Stack{
	int[] arr;
	int top;
	int size;
//constructor
	public Stack(int e){
		size = 0;
		top = -1;
		arr = new int[e];
	}
	//
	public int size(){
		return size;
	}
	//
	public boolean isEmpty(){
		if (size == 0){
			return true;
		}
		return false;
	}
	//
	public int top(){
		if(isEmpty()){
			return 0;
		}
		return arr[top];
	}
	//
	public void push(int e){
		top = top+1;
		if(isEmpty()){
			arr[0] = e;
			top = arr[0];
			top = 0;
		}
		else
		{
			arr[top] = e;
			//System.out.println(e+"push"); 
		}
		size = size + 1;
	}
	//
	public int pop(){
		if(isEmpty()){
			return 0;
		}
		else{
			top = top-1;
			return arr[top+1];
		}
	}

	public static void main(String[] args){
		Stack s = new Stack(4);
		s.push(1);
	}
} 