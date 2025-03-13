package algorithmicsS4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GraphColouring {

	private static String[] colorArray = {"red", "blue", "green", "yellow", "orange", "purple", "cyan", "magenta", "lime"};
	
	
	public static Map<String, String> greedy(Map<String, List<String>> graph) {
		Map<String,String> solution = new HashMap<String,String>();
		simpleGreedyState(graph,solution,0);
		return solution;
	}


	private static void simpleGreedyState(Map<String, List<String>> graph, Map<String, String> solution, int index) {
		List<String> notPosibleColors = new ArrayList<String>();
		List<String> neighbours = graph.get(index+"");
		int nextCandidate=-1;
		boolean nextCandidateFound = false;
		for(int i = 0; i<neighbours.size();i++) {
			if(solution.containsKey(neighbours.get(i))) {
				notPosibleColors.add(solution.get(i+""));
			}else if(!nextCandidateFound) {
				nextCandidate = i;
				nextCandidateFound = true;
			}
		}
		String color="";
		for(int i=0;i<colorArray.length;i++) {
			if(!notPosibleColors.contains(colorArray[i])) {
				color = colorArray[i];
			}
		}
		
		solution.put(index+"", color);
		if(nextCandidateFound) {
			simpleGreedyState(graph,solution,nextCandidate);
		}
		
		
	}

}
