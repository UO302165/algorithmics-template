package algorithmicsS6;

public class NullPathTimes {
	public static void main(String[] args) {
		long startTime;
		long endTime;
		for(int i = 10; i<20;i+=2){
			startTime = System.currentTimeMillis();
			for(int j=0; j<1;j++) {
				NullPath.run(i);
			}
			endTime=System.currentTimeMillis();
			System.out.println(String.format("The time for size %d is: %d", i,endTime-startTime));
		}
	}
}
