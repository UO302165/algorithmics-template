package algorithmicsS0;

import java.util.ArrayList;
import java.util.List;

public class JavaA1 {

	private static boolean primoA1(int n) {
		boolean p = true;
		for(int i=2;i<n;i++) {
			if(n%i==0) {
				p = false;
			}
		}
		return p;
	}
	
	private static List<Integer> listadoPrimos(int n){
		List<Integer>primes = new ArrayList<Integer>();
		for (int i=2;i<=n;i++) {
			if(primoA1(i)) {
				primes.add(i);
			}
		}
		return primes;
	}
	
	public static void main(String[] args) {
		int n=10000;
		for(int i = 0; i<=7;i++) {
			long t1 = System.currentTimeMillis();
			List<Integer>primes= listadoPrimos(n);
			long t2 = System.currentTimeMillis();
			
			System.out.println("n= " + n + "***" + "time= "
			+ (t2-t1) + " milliseconds");
			n*=2;
		}

	} 
}
