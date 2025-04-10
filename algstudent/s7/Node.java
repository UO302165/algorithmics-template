package algorithmicsS7;

import java.util.ArrayList;
import java.util.UUID;

/**
 * To represents the different states of a problem in the graph
 * For each problem, we should extend this class with specific information
 * We also need to compare Nodes because it is the way to compare them in the priority queue
 * @author viceg
 */
public class Node implements Comparable<Node> {
    protected int depth; //Number of moves made so far (is equal to the number of nodes developed) on this branch
    protected int parentID; //Parent ID for node tracking
    protected int ID; //ID for the node
    protected int heuristicValue; //Value of the calculated heuristic

    /**
     * Constructor for Node objects
     */
	public Node(int ID, int parentId, int depth) { //Values by default
    	this.depth = depth; 
    	parentID = parentId; //It does not have parent unless we say another thing
    	this.ID =ID;
    	calculateHeuristicValue();
    	
	}
	
	/**
	 * Getter for depth
	 * @return The depth variable
	 */
    public int getDepth() {return depth;}
	  
    /**
     * Getter for heuristicValue
     * @return The heuristicValue variable
     */
	public int getHeuristicValue() { return heuristicValue; }
	
	/**
	 * Compares whether two nodes are equal using the ToString method
	 * @param n Another node to be compared with
	 * @return True if there are equal. False otherwise
	 */
    public boolean equals(Node n) {
		return (n.toString().equals(toString()));
	}
    
    /**
     * Getter for parentID
     * @return The parentID variable
     */
    public int getParentID() {
    	return parentID;
    }
    
    /**
     * Gets the ID of the node
     * @return ID of the node
     */
    public int getID() {
    	return ID;
    }
    
    /**
     * We can have extra information about the problem to prune all the nodes
     * above a specific heuristicValue. By default we know nothing, so we 
     * do not prune anything
     * @return Value of the initial prune limit 
     */
	public int initialValuePruneLimit() {
		return Integer.MAX_VALUE; //Implementation by default
	}
    
	@Override
	public int compareTo(Node node) { //BRANCHING METHOD
		int totalValue = heuristicValue;
		int totalValueToBeCompared = node.getHeuristicValue();
		
		if (totalValue > totalValueToBeCompared) return 1; //this has less priority (is bigger)
		else if (totalValue == totalValueToBeCompared) return 0; //The same priority
		else return -1; //this has more priority (is smaller)
	}
    
	public void calculateHeuristicValue() {
		if(parentID!=null) {
			
		}
	}
	public ArrayList<Node> expand(int[][] weights){
		ArrayList<Node> children = new ArrayList<Node>();
		for(int i=0;i<weights.length;i++) {
			if(i!=ID) {
				children.add(new Node(i,ID, depth+1));
			}
		}
		return children;
	}
	public boolean isSolution(Node targetNode,int size) {
		return (depth==size && ID==targetNode.ID);
	}
}
