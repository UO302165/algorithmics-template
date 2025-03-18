package algorithmicsS4;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class GreedyTimes {
	public static void main(String[] args) {
		for(int i = 4; i<=8192;i*=2) {
			
			JSONParser parser = new JSONParser();
			try (FileReader reader = new FileReader("g"+i+".json")) {
				JSONObject jsonObject = (JSONObject) parser.parse(reader);
				@SuppressWarnings("unchecked")
				Map<String, List<String>> graph = (Map<String, List<String>>) (jsonObject.get("graph"));
				long startTime = System.currentTimeMillis();
				Map<String, String> solution=null;
				for(int j = 0; j<10000;j++) {
					solution = GraphColouring.greedy(graph);
				}
				long endTime = System.currentTimeMillis();
				try (FileWriter file = new FileWriter("solution.json")) {
					file.write(new JSONObject(solution).toJSONString());
				}

				if (solution != null) {
					//System.out.println("Solution found: " + solution);
					System.out.println("The time for "+i+" nodes is:" + (endTime-startTime));
				} else {
					System.out.println("Solution not found.");
				}
			} catch (IOException | ParseException e) {
				e.printStackTrace();
			}
		}
		
	}
}
