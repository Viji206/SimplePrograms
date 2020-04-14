package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import util.Node;


public class FindPath {

	static List<Node> nodeDetails = new ArrayList<>();
	
	public static void main(String[] args) {
		
		
		
		nodeDetails.add(getNodeDetails("1","2,7,8"));
		nodeDetails.add(getNodeDetails("2","1,3,6"));
		nodeDetails.add(getNodeDetails("3","2,4,8"));
		nodeDetails.add(getNodeDetails("4","3,5"));
		nodeDetails.add(getNodeDetails("5","6,8"));
		nodeDetails.add(getNodeDetails("6","2,5,7,13"));
		nodeDetails.add(getNodeDetails("7","1,6"));
		nodeDetails.add(getNodeDetails("8","1,3,5"));
		nodeDetails.add(getNodeDetails("13","6"));
		nodeDetails.add(getNodeDetails("14",""));
		
		//depthFirstSearch("6");
		
		breadthFirstSearch();
	}

	
	public static Node getNodeDetails(String cityName, String connectedNodes){
		
		Node node = new Node(new ArrayList<>());		
		
		node.setName(cityName);
		node.setConnectedDetails(connectedNodes.length()> 0 ? Arrays.asList(connectedNodes.split(",")) : new ArrayList<String>());
		node.setVisited(false);
		
		return node;
	}
	
	private static void depthFirstSearch(String startNode){
		
		markNodeAsVisited(startNode);
		
		List<String> connectedNodes = nodeDetails.stream().filter(a -> a.getName().equals(startNode))
				.map(Node::getConnectedDetails).findAny().orElse(null);
		
		for(String node : connectedNodes){
			if(!isNodeVisited(node)){
				depthFirstSearch(node);
			}
		}		
		System.out.println(startNode);
	}
	
	private static void breadthFirstSearch(){
		
		for(Node node : nodeDetails){
			
			if(!node.getConnectedDetails().isEmpty()){
				printNode(node.getName());			
			}
			
			for(String connectedNode : node.getConnectedDetails()){
				printNode(connectedNode);
				
			}
		}
		
	}
	
	private static boolean isNodeVisited(String node){
		Optional<Node> findNode = nodeDetails.stream().filter(a -> a.getName().equals(node)).findFirst();
		if(findNode.isPresent()){
			return findNode.get().isVisited();
		}
		return false;		
	}
	
	private static void markNodeAsVisited(String node){
		
		nodeDetails.stream()
		.filter(a -> a.getName().equals(node))
		.forEach(b -> b.setVisited(true));
		
		/*for( Node entry : nodeDetails){
			
			if(entry.getName() == node){
				entry.setVisited(true);
				break;
			}
		}*/
	}
	
	private static void printNode(String node){
		
		if(!isNodeVisited(node)){
			markNodeAsVisited(node);
			System.out.println(node);
		}
	}
}
