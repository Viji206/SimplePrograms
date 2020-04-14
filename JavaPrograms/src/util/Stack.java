package util;

import java.util.List;

public class Stack<T> {

	List<T> stackList;
	int index;
	
	public Stack(List<T> list){
		this.stackList = list;
		index = -1;
	}
	
	public void push(T element){
		stackList.add(++index,element);
	}
	
	public T peek(){
		if(index >= 0){
			return stackList.get(index);
		}else{
			return null;
		}
	}
	
	public T pop() throws Exception{
		if(index >= 0){
		return stackList.remove(index--);
		}
		
		throw new Exception("No element to remove");
	}
}
