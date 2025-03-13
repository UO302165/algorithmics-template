package algorithmicsS3;

public class CalendarTimes {
	public static void main(String[] args) {
		
		Calendar calendar;
		int numRepetitions=1;
		
		for(int i = 2; i<Integer.MAX_VALUE;i*=2) {
			calendar = new Calendar(i);
			long startTime = System.currentTimeMillis();
			for(int j = 0; j<numRepetitions; j++) {
				calendar.computeCalendar(0,calendar.getCalendar().length-1);
			}
			long endTime= System.currentTimeMillis();
			//System.out.print(calendar.toString());
			System.out.println(String.format("The time spent for a calendar of %d people is: %d", calendar.getNumParticipants(), endTime-startTime));
		}
		
	}
}
