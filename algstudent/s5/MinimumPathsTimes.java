package algorithmicsS5;

public class MinimumPathsTimes {
	public static void main(String[] args) {
		double startTime;
		double endTime;
		for(int i = 200; i<10000000;i*=2) {
			 startTime=System.currentTimeMillis();
			 MinimumPaths.compute(i);
			 endTime=System.currentTimeMillis();
			 
			 System.out.println("THE TIME COMPUTING FLOYD FOR " + i+ " NODES IS: " + (endTime-startTime));
		}
	}

}
