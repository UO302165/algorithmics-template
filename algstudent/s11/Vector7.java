package algorithmicsS1;

public class Vector7 {
	static int[]v;
	
	public static void main(String arg []) {
		int repetitions = Integer.parseInt(arg[0]);
		long t1,t2;
		int sum = 0;
		
		for (int n=10000; n<=Integer.MAX_VALUE; n*=2){ //n is increased *5   
			  v = new int[n];
			  Vector1.fillIn(v);
			  
			  t1 = System.currentTimeMillis();
			  //We have to repeat the whole process to be measured
			  for (int repetition=1; repetition<=repetitions; repetition++){    	
			     Vector1.matches2(v,v);
			  }
			  t2 = System.currentTimeMillis();
			  System.out.printf("SIZE=%d TIME=%d milliseconds SUM=%d NTIMES=%d\n", n, t2-t1, sum, repetitions);	
		}//for 
		
	}//main
}
