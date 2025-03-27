package algorithmicsS6;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class NullPath{
	
	private static final int TOLERANCE = 99;
	
	public static void main(String[] args) {
		int size = Integer.parseInt(args[0]);
		int [][] weights = new int[size][size];
		int origin = 0;
		int target = size-1;
		int[] sol = new int[size];
		sol[origin]=origin;
		sol[target]=target;
		fillInWeightsRandom(weights);
		for(int i = 0; i<size;i++) {
			for(int j = 0; j<size;j++) {
				System.out.print(weights[i][j] + " ");
			}
			System.out.println();
		}
		getNullPath(weights,origin,target,1,sol);
		
		
		
		
	}
	static void fillInWeightsRandom(int [][]w) {
		int minWeight=10;
		int maxWeight=99;
		double probability = 0.5;
		Random rand = new Random();
		for(int i = 0; i<w.length;i++) {
			for(int j=0; j<w.length;j++) {
				if(rand.nextDouble()>=probability) {
					w[i][j] = rand.nextInt(minWeight, maxWeight);
				}else {
					w[i][j]= rand.nextInt(-maxWeight, -minWeight);
				}
			}
		}
	}
	
	static void getNullPath(int [][] w, int origin, int target, int level, int[] sol) {
		if(isSolution(level, sol, w)) {
			System.out.print("[");
			for(int i=0; i<sol.length;i++) {
				System.out.print(sol[i]+" ");
			}
			System.out.println("]");
			
		}
		else{
			boolean alreadyVisited = false;
			for(int i = 1; i<w.length-1;i++) {
				alreadyVisited = false;
				for(int j = 0; j<w.length;j++) {
					if(sol[j]==i) {
						alreadyVisited=true;
						break;
					}
				}
				if(!alreadyVisited) {
					sol[level]=i;
					getNullPath(w, origin, target, level+1, sol);
					sol[level]=-1;
				}
				
				
			}
		}
	}
	
	private static boolean isSolution(int n, int[] sol, int[][]w) {
		if(n==w.length-1) {
			int path = 0;
			
			for(int i = 0; i<sol.length-1;i++) {
				path += w[sol[i]][sol[i+1]];
			}
			return Math.abs(path)<=TOLERANCE;
		}
		return false;
		
	}
}
	

