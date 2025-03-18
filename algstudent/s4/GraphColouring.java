package algorithmicsS4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GraphColouring {

	private static String[] colorArray = {"red", "blue", "green", "yellow", "orange", "purple", "cyan", "magenta", "lime"};
	private static List<Long> isolatedNodes;
	
	public static Map<String, String> greedy(Map<String, List<String>> graph) {
		Map<String,String> solution = new HashMap<String,String>();
		List<Long> isolatedNodesList = new ArrayList<Long>();
		for(Long i = (long)0; i<graph.size();i++) {
			if(graph.get(i+"").size()==1) {
				isolatedNodesList.add(i);
			}
		}
		isolatedNodes = isolatedNodesList;
		simpleGreedyState(graph,solution,0);
		for(String i:graph.keySet()) {
			if(!solution.containsKey(i)) {
				simpleGreedyState(graph,solution,Integer.parseInt(i));
			}
		}
		return solution;
	}


	private static void simpleGreedyState(Map<String, List<String>> graph, Map<String, String> solution, long index) {
		List<String> notPosibleColors = new ArrayList<String>();
		List<String> neighbours = graph.get(index+"");
		Object nextCandidate=-1;
		boolean nextCandidateFound = false;
		
		for(int i = 0; i<neighbours.size();i++) {
			Object key = neighbours.get(i);
			if(solution.containsKey(key.toString())){
				notPosibleColors.add(solution.get(key.toString()));
			}else if(!nextCandidateFound && !isolatedNodes.contains(key)) {
				nextCandidate = key;
				nextCandidateFound = true;
			}
		}
		String color="";
		for(int i=0;i<colorArray.length;i++) {
			if(!notPosibleColors.contains(colorArray[i])) {
				color = colorArray[i];
				break;
			}
		}
		
		solution.put(index+"", color);
		if(nextCandidateFound) {
			simpleGreedyState(graph,solution,(Long)(nextCandidate));
		}
		
		
	}

}
