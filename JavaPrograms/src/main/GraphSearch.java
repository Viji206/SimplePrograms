package main;


public class GraphSearch {

	static int [][]nodes = {{1,0},{2,0},{3,0},{4,0},{5,0},{6,0},{7,0},{8,0},{13,0},{14,0}};
	static int [][]graphEdges = { {1,7}, {1,2}, {1,8} ,{2,3},{2,6}, {3,4},{3,8},{4,5},{5,6},{5,8},{6,7},{6,13}};
	static int stack[] = new int[100];
	static int stackIndex = 0;
	
	static int queue[] = new int[100];
	static int front = 0;
	static int rear = 0;
	
	public static void main(String[] args) {
	
		//System.out.println("--------------DFS--------------------");
		//deptFirstSearch(6);
		
		
		//System.out.println("--------------BFS--------------------");
		//breathFirstSearch(6);
		finPathUsingDFS(6, 3);
		
	}

	private static void deptFirstSearch(int node){
		stack[stackIndex] = node;
		markNodeAsVisited(node);
		
		for(int i=0; i < graphEdges.length; i++){
			if(graphEdges[i][0] == node && !isNodeVisited(graphEdges[i][1])){
				stack[++stackIndex] = graphEdges[i][1];
				markNodeAsVisited(graphEdges[i][1]);
				deptFirstSearch(stack[stackIndex]);
				return;
			}else if(graphEdges[i][1] == node && !isNodeVisited(graphEdges[i][0])){
				stack[++stackIndex] = graphEdges[i][0];
				markNodeAsVisited(graphEdges[i][0]);
				deptFirstSearch(stack[stackIndex]);
				return;
			}
		}
		
		popFromStack();
		
	}
	
	private static void markNodeAsVisited(int node){		
		for(int i=0; i< nodes.length; i++){
			if(nodes[i][0] == node){
				nodes[i][1] = 1;
			}
		}
	}
	
	private static boolean isNodeVisited(int node){
		for(int i=0; i < nodes.length; i++){
			if(nodes[i][0] == node){
				return nodes[i][1] == 1 ? true : false;
			}
		}
		return false;
	}
	
	private static void popFromStack(){
		
		System.out.println(stack[stackIndex--]);
		if(stackIndex < 0)
			return;
		else
			deptFirstSearch(stack[stackIndex]);
	}

	private static void breathFirstSearch(int node){
		queue[front] = node;
		markNodeAsVisited(node);
		
		for(int i=0; i < graphEdges.length; i++){
			
			if(graphEdges[i][0] == node && !isNodeVisited(graphEdges[i][1])){
				
				queue[++rear] = graphEdges[i][1] ;
				markNodeAsVisited(graphEdges[i][1]);
				
			}else if(graphEdges[i][1] == node && !isNodeVisited(graphEdges[i][0])){
			
				queue[++rear] = graphEdges[i][0] ;
				markNodeAsVisited(graphEdges[i][0]);
			}
		}
		
		popFromQueue();
	}
	
	private static void popFromQueue(){
		
		
		System.out.println(queue[front++]);
		
		if(front > rear){
			return;
		}else{
			breathFirstSearch(queue[front]);
		}
	}
	
	
	private static void finPathUsingDFS(int startNode, int endNode){
		stack[stackIndex] = startNode;
		markNodeAsVisited(startNode);

		for(int i = 0; i < graphEdges.length; i++){
			if(startNode == graphEdges[i][0] && !isNodeVisited(graphEdges[i][1])){				
				
				stack[++stackIndex] = graphEdges[i][1];
				finPathUsingDFS(stack[stackIndex], endNode);
				return;
			}else if(startNode == graphEdges[i][1] && !isNodeVisited(graphEdges[i][0])){				
				
				stack[++stackIndex] = graphEdges[i][0];
				finPathUsingDFS(stack[stackIndex], endNode);
				return;
			}
		}
		
		popFromStackToGetPath(endNode);
	}
	
	
	private static void popFromStackToGetPath(int endNode){
		
		if(stackIndex < 0){
			return;
		}else if(stack[stackIndex] == endNode){
			while(stackIndex >= 0){
				System.out.println(stack[stackIndex--]);
			}
		}else{
			finPathUsingDFS(stack[--stackIndex], endNode);
		}
	}
}
