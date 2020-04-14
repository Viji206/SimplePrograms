package LeetCode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class TwoSum {

	private static Map<Integer, Integer> indexValue = new HashMap<>();
	
	public static void main(String[] args) {
		//findIndices(new int[]{2,7,11,15} , 9);

		int[] output= findIndicesOptimised(new int[]{3,2,95,4,-3} , 92);
		
		System.out.println(output[0] + " "+ output[1]);
	}

	private static int[] findIndices(int []nums, int target){
		
		int[] output = new int[2];
		
		for(int i =0; i < nums.length; i++){
			for(int j = i+1; j < nums.length; j++){
				 
				int sum = nums[i] + nums[j];
				
				if(sum == target ){
					
					output[0] = i;
					output[1] = j;
					break;
				}
			}
		}
		
		return output;
	}
	
	
	private static int[] findIndicesOptimised(int []nums, int target){
		
		int[] output = new int[2];
		
		for(int i = 0; i < nums.length; i++){
			indexValue.put(nums[i]	, i);
		}
		
		Iterator ite = indexValue.entrySet().iterator();
		while(ite.hasNext()){
			Map.Entry set = (Map.Entry)ite.next();
			
			System.out.println("Key :" + set.getKey());
			System.out.println("Vaue :" + set.getValue());
		}
		
		for(int i = 0; i < nums.length; i++){
			
			Integer index = getIndexIfNumberPresent((target - nums[i]), i);
			
			if(index != null){
				output[0] = i;
				output[1] = index;
				
				break;
			}			
			
		}
		
		return output;
		
	}
	
	private static Integer getIndexIfNumberPresent(int number, int index){
		
		if(indexValue.containsKey(number) && indexValue.get(number) != index){
			return indexValue.get(number);
		}
			
		return null;
	}
}
