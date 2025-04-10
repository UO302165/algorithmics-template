package algorithmicsS7;

public class NullPathBBTimes {
	public static void main(String[] args) {
		long startTime;
		long endTime;
		for(int i = 4; i<100000000;i+=2){
			startTime = System.currentTimeMillis();
			for(int j=0; j<1;j++) {
				NullPathBB.run(i);
			}
			endTime=System.currentTimeMillis();
			System.out.println(String.format("The time for size %d is: %d", i,endTime-startTime));
		}
	}
}
