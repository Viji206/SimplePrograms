package main;

public class ReverseStringUsingRecursion {
	
	 static String input;
	 public static void reverseStringUsingIndex(int index)
	 {
		 if(index == 0){
			 return;
		 }else{
			 System.out.print(input.charAt(--index));
			 reverseStringUsingIndex(index);
		 }
	 }
	 
	public static void reverseString(String input)
	{
		if(input.length() == 0){
			System.out.print(input);
		}else
		{
			System.out.print(input.charAt(input.length()-1));
			reverseString(input.substring(0,input.length()-1));
		}
	}
	public static void main(String args[]){		
		input = "Viji";
		reverseStringUsingIndex(input.length());
		System.out.println();
		reverseString(input);
	}

}
