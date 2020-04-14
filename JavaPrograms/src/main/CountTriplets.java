package main;

public class CountTriplets {

	public static void main(String[] args) {
		
		int arr[] = {1,3,9,9,27,81};
		//{1 , 2, 2, 4};
		triplets(3, arr);
	}

	public static void triplets(int r, int arr[]){
		
		int counter = 0;
		for(int i=0; i < arr.length - 2; i++){
			
			for(int j=i+1; j < arr.length - 1; j++){
				for(int k=j+1; k < arr.length;k++){
					if((arr[i] * r) == arr[j] && (arr[j] *r) == arr[k]){
						counter++;
					}
				}
			}
		}
		
		System.out.println("Counter :"+counter);
	}
}
