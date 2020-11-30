import java.util.*;
public class ArrayList
{
	double arrSize_1by4 = 0.25;
	double arrSize_3by4 = 0.75;
	int arr = 4;
	static int x;
	int remove;
	int top = 0;
	static double length;
	static int Array[];
	public ArrayList()
	{
		Array = new int[arr];
	}
	//which takes a generic variable as a parameter and adds the element to the dynamic array. 
	public void add(int ele)
	{
		Array[top] = ele;
		top++;
	}
	//this function does not take a parameter.When called pop deletes the last element in the dynamic array.
	public void pop()
	{
		top--;
		remove = Array[top];
		Array[top] = 0;
		int count = 0;
		for(int i = 0; i < Array[i]; i++) {
			count++;
		}
		x = count;
		length = (double)x/arr;
		System.out.println("Remove Element " +remove);
	}
    //this function takes one integer parameter. When called resize changes the size of the array to the value of the parameter sent.
	public void resize()
	{
		if(length == arrSize_1by4 ) {
			int newArray[] = new int[(arr/2)*2];
			for(int i = 0; i < Array.length; i++) {
				newArray[i] = Array[i];
			}
			Array = newArray;
			arr = arr/2;
			for(int n : newArray) {
				System.out.print(n + " ");
				}	
		}
		else if(length == arrSize_3by4) {
			int newArray[] = new int[arr*2];
			for(int i = 0; i < Array.length; i++) {
				newArray[i] = Array[i];
			}
			arr = arr * 2;
			Array = newArray;
			for(int j : newArray) {
			System.out.print(j + " ");
			}
			System.out.println();
		}
		else {
			System.out.println("ArrayIndexOutOfBoundRange");
		}
	}
	//Does not take ay parameter and returns the number of elements present in the dynamic array.
	public int size()
	{
		return arr;
	}
	//Does not take any parameter and returns the string representation of the dynamic array.
	public String toString()
	{
		String s = Arrays.toString(Array);
		return s;
	}
	public static void main(String[] args) {
		ArrayList obj1 = new ArrayList();
		obj1.add(5);
		obj1.add(8);
		obj1.add(4);
		//obj1.add(5);
		obj1.add(3);
		//obj1.add(7);
		obj1.pop();
		//obj1.pop();
		obj1.resize();
		System.out.println("toString " +obj1.toString());
		System.out.println("The number of elements in the newArray is " +x);
		System.out.println("The Size of new Array is " +obj1.size());
	}
} 
