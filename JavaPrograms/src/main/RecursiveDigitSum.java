package main;

public class RecursiveDigitSum {

	
	public static void main(String[] args) {
		System.out.println(recursiveSum(1485148148));

	}

	
	public static long recursiveSum(long input){
		
		if(input / 10 == 0){
			return input;
		}
		else{
			
			long sum = 0;
			
			while(input != 0){
				sum += input%10;
				input = input / 10;				
			}	
			
			return recursiveSum(sum);
		}
	}
}
