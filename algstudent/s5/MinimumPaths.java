package algorithmicsS5;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//MINIMUM PATHS IN A GRAPH BY FLOYD-WARSHALL
//IT IS A SOLUTION BY DYNAMIC PROGRAMMING
//ITS TIME COMPLEXITY IS CUBIC O(n^3)
public class MinimumPaths{
	static String[] v; //node vector
	static int[][] weights; //weight matrix
	static int[][] costs; //Floyd's paths cost matrix
	static int[][] p; //predecessor matrix (steps) in Floyd paths

	public static void compute(int size) {
		int n = size; //nodes of example graph
		v = new String[n];
		for (int i = 0; i < n; i++)
			v[i] = "NODE" + i;

		weights = new int[n][n];
		costs = new int[n][n];
		p = new int[n][n];

		//fillInWeightsRandom(weights); //weights for the example
		
		
		fillInWeights(weights);
		//System.out.println("WEIGHT MATRIX IS:");
		//printMatrix(weights);

		floyd(weights, costs, p);

		//System.out.println("MINIMUM COST MATRIX IS:");
		//printMatrix(costs);

		//System.out.println("P MATRIX IS:");
		//printMatrix(p);

		System.out.println();
		System.out.println("MINIMUM PATHS IN THE EXAMPLE GRAPH (for every pair of different nodes):");
		System.out.println();
		for (int source = 0; source <= n-1; source++)
			for (int target = 0; target <= n-1; target++)
				if (source != target) {
					System.out.print("FROM " + v[source] + " TO " + v[target] + " = ");
					minimumPath(v, weights, costs, p, source, target);
					System.out.println();
					if (costs[source][target] < 10000000) {
						System.out.println("MINIMUM COST=" + costs[source][target]);
					}
					System.out.println("**************");
				}

	}

	/* ITERATIVE WITH CUBIC COMPLEXITY O(n^3) */
	static void floyd(int[][] weights, int[][] costs, int[][] p) {
		int n = weights.length;
		prepareForFloyd(weights, costs, p);
		//System.out.println("COMPLETE THIS METHOD");
		for(int pivot=0; pivot<n;pivot++) {
			for(int source = 0; source<n; source++) {
				for(int target = 0; target<n;target++) {
					int pathWithpivot = costs[source][pivot]+costs[pivot][target];
					if(costs[source][target]> pathWithpivot) {
						costs[source][target] = pathWithpivot;
						p[source][target]=pivot;
					}
				}
			}
		}
	}
	static void fillInWeights(int[][] w) {

        for (int i = 0; i < w.length; i++)

                        for (int j = 0; j < w.length; j++)

                                        w[i][j] = 10000000;

        w[0][1] = 19;

        w[2][1] = 91;

        w[2][3] = 14;

        w[3][0] = 27;

        w[3][1] = 67;

        w[3][3] = 71;

}
	private static void prepareForFloyd(int[][]weights, int[][] costs, int[][] p) {
		int n = weights.length;
		for(int i = 0; i<n;i++) {
			for(int j = 0; j<n; j++) {
				if(i!=j) {
					costs[i][j] = weights[i][j];
				}else {
					costs[i][j] = 0;
				}
				p[i][j]=-1;
			}
		}
	}

	static void minimumPath(String[] v, int[][] weights, int[][] costs, int[][] steps, int source, int target) {
		//System.out.println("COMPLETE THIS METHOD");
		System.out.print(v[source]+ "-->");
		path(v,steps,source,target);
		System.out.print(v[target]);
	}

	/* IT IS RECURSIVE and WORST CASE is O(n), IT IS O(n) if you write all nodes */
	static void path(String[] v, int[][] steps, int i, int j) {
		if(steps[i][j]!=-1) {
			path(v, steps, i, steps[i][j]);
			System.out.print(v[steps[i][j]] + "-->");
			path(v,steps, steps[i][j], j);
		}
	}

	static void fillInWeightsRandom(int [][]w) {
		int minWeight=10;
		int maxWeight=99;
		double probability = 0.5;
		Random rand = new Random();
		for(int i = 0; i<w.length;i++) {
			for(int j=0; j<w.length;j++) {
				if(i!=j && rand.nextDouble()>=probability) {
					w[i][j] = rand.nextInt(minWeight, maxWeight);
				}else {
					w[i][j]= 100000;
				}
			}
		}
	}
	/* print the cost matrix */
	static void printMatrix(int[][] a) {
		int n = a.length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++)
				System.out.print(String.format("%10s", a[i][j]));
			System.out.println();
		}
		System.out.println();
	}

}
