package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindDistinctSubset {

	public static void main(String[] args) {
		List<String> inputSet = new ArrayList<>(Arrays.asList("x","y","z","a"));
		String [][] edgeSet = new String[100][2];
		int counter = 0;
		
		List<String> subsets = new ArrayList<>();
		
		subsets.add("{}");
		
		for(int i=0; i < inputSet.size();i++){
			subsets.add("{"+inputSet.get(i)+"}");
		}
		
		for(int i =0; i<inputSet.size(); i++)
		{
			for(int j=i+1; j < inputSet.size(); j++){
				edgeSet[counter][0] = inputSet.get(i);
				edgeSet[counter][1] = inputSet.get(j);
				subsets.add("{"+edgeSet[counter][0]+","+edgeSet[counter++][1]+"}");
			}
		}
		
		for(int i=0; i < counter; i++){
			for(int j=0; j < counter; j++){
				if(edgeSet[i][1] == edgeSet[j][0])
				{
					edgeSet[counter][0] = edgeSet[i][0] + "," + edgeSet[i][1];
					edgeSet[counter][1] = edgeSet[j][1];
					subsets.add("{"+edgeSet[counter][0]+","+edgeSet[counter++][1]+"}");
				}
			}
		}

		for(int i=0; i< subsets.size() ; i++){
			System.out.println(subsets.get(i));
		}
	}
	
	

}
