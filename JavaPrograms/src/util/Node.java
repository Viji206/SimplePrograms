package util;

import java.util.List;

public class Node {

	private String name;
	private boolean isVisited;
	private List<String> connectedDetails;
	
	public Node(List<String> details){
		this.connectedDetails = details;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isVisited() {
		return isVisited;
	}
	public void setVisited(boolean isVisited) {
		this.isVisited = isVisited;
	}
	public List<String> getConnectedDetails() {
		return connectedDetails;
	}
	public void setConnectedDetails(List<String> connectedDetails) {
		this.connectedDetails = connectedDetails;
	}
}
