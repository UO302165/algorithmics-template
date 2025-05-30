package algorithmicsS7;

import java.util.ArrayList;


import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;


/**
 * Main class to solve problems using the Branch and Bound technique
 * We need to extend it for any specific problem
 * @author viceg
 */
public class BranchAndBound {
	private static Logger log = LoggerFactory.getLogger(BranchAndBound.class);
	protected Heap ds; //Nodes to be explored (not used nodes)
	protected Node bestNode; //To save the final node of the best solution
	protected Node rootNode; //Initial node
	protected int pruneLimit; //To prune nodes above this value
	   
	/**
	 * Constructor for BrancAndBount objects
	 */
	public BranchAndBound() {
		ds = new Heap(); //We create an instance of the Heap class to save the nodes
	}
	      
	/**
	 * Manages all the process, from the beginning to the end
	 * @param rootNode Starting state of the problem
	 */
	public Heap branchAndBound(Node rootNode, int[][] weights, Node targetNode) { 
		
		ds.insert(rootNode); //First node to be explored
	
		pruneLimit = rootNode.initialValuePruneLimit();

		while (!ds.empty() && ds.estimateBest() < pruneLimit) {
			Node node = ds.extractBestNode();	
			if(node.depth==targetNode.depth) {
				
			}
			ArrayList<Node> children = node.expand(weights); 
			
			for (Node child : children)
				if (child.isSolution(targetNode, weights.length)) {
					int cost = child.getHeuristicValue();
					if (cost < pruneLimit) {
						pruneLimit = cost;
						bestNode = child;
					} 
				}
				else
					if (child.getHeuristicValue() < pruneLimit) {
						ds.insert(child);
					}
		} //while
		return ds;
	}
		
	/**
	 * Gets the root node
	 * @return The root node
	 */
    public Node getRootNode() {
    	return rootNode;
    }
    
	/**
	 * Gets the best node
	 * @return The best node
	 */
    public Node getBestNode() {
    	return bestNode;
    }

    /**
     * Prints the solution from the root node to the best node
     */
//    public void printSolutionTrace() {
//    	if (bestNode == null) {
//			log.debug("Original:");
//			log.debug(rootNode.toString());
//    		log.debug("THERE IS NO SOLUTION");
//    	} 
//    	else {
//    		//Extract the path of the used nodes from bestNode to the rootNode
//            ArrayList<Node> result = ds.extractUsedNodesFrom(bestNode);
//
//            for (int i = 0; i < result.size();  i++) {
//    			if (i == 0) 
//    				log.debug("Original:");
//    			else 
//    				log.debug("Step " + i + ":");
//				log.debug(result.get(result.size()-i-1).toString());
//    	    }
//            log.debug("\nSolution with " + bestNode.getDepth() + " step(s).");	
//    	}
//    }
}
