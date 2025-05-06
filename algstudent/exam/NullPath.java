package algorithmicsS6;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class NullPath{
	
	private static final int MAXVALUE = 74;
	private static final int MINVALUE = -75;
	private static List<Integer> alreadyVisited;
	private static boolean haveSolution;
	public static void run(int sizeOfM) {
		alreadyVisited = new ArrayList<Integer>();
		int size = sizeOfM;
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
		haveSolution=false;
		getNullPath(weights,origin,target,1,sol,0);
		
		
		
		
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
	
	static void getNullPath(int [][] w, int origin, int target, int level, int[] sol, int previousWeight) {
		if(isSolution(level, sol, w)) {
			printPath(sol,w);
		}
		else{
			for(int i = 1; i<w.length-1;i++) {
				if(haveSolution) {
					break;
				}
				if(!alreadyVisited.contains(i)) {
					if((previousWeight%2==0 && w[sol[level-1]][i]%2!=0)||(previousWeight%2!=0 && w[sol[level-1]][i]%2==0)) {
						sol[level]=i;
						alreadyVisited.add(i);
						int prevNode,nextNode;
						if(level==0) {
							prevNode=origin;
						}else {
							prevNode=sol[level-1];
						}
						nextNode=sol[level];
						getNullPath(w, origin, target, level+1, sol, w[prevNode][nextNode]);
						sol[level]=-1;
						alreadyVisited.remove((Object)i);
					}
					
				}
			}
		}
	}
	
	private static void printPath(int[] sol, int[][]w) {
		int path=0;
		System.out.print("[");
		for(int i=0; i<sol.length;i++) {
			if(i>0) {
				System.out.print("("+w[sol[i-1]][sol[i]]+")");
				path+=w[sol[i-1]][sol[i]];
			}
			System.out.print(sol[i]+" ");
		}
		System.out.print("]");
		System.out.println(path);
	}
	private static boolean isSolution(int n, int[] sol, int[][]w) {
		
		if(n==w.length-1) {
			
			int prevWeight= w[sol[n-2]][sol[n-1]];
			int lastWeight= w[sol[n-1]][sol[n]];
			if(prevWeight%2!=lastWeight%2) {
				int path = 0;
				
				for(int i = 0; i<sol.length-1;i++) {
					path+=w[sol[i]][sol[i+1]];
				}
				if(path>MINVALUE && path<MAXVALUE) {
					haveSolution=true;
				}
				
			}
			
		}
		return haveSolution;
		
	}
}
	

