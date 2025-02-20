package algorithmicsS21;

public class QuicksortInsertionTimes {
	static int[] v;

	public static void main(String arg[]) {
		long t1, t2;
		String opcion = arg[0];
		int n=16000000;
		
		v = new int[n];

		if (opcion.compareTo("ordered") == 0)
			Vector.sorted(v);
		else if (opcion.compareTo("reverse") == 0)
			Vector.reverseSorted(v);
		else
			Vector.randomSorted(v);

		t1 = System.currentTimeMillis();
		
		int k=1000;
		QuicksortInsertion.quicksortInsertion(v,k);

		t2 = System.currentTimeMillis();

		System.out.println(n + "\t" + (t2 - t1));
		
	}
}
