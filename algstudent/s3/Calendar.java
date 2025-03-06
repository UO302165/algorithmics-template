package petanque;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Calendar {

	private int numParticipants;
	private List<String> players;
	private String[][] calendar;
	private int daysOfGame;
	
	public Calendar(String fileName) {
		players = new ArrayList<String>();
		loadFile(fileName);
		calendar = new String[numParticipants][numParticipants];
		daysOfGame = numParticipants-1;
	}
	
	public void loadFile(String fileName) {
		numParticipants= FileUtil.loadFile(fileName,players);	
	}
	
	public void completeCalendar() {
		getCalendarByParts(numParticipants);
	}
	private void getCalendarByParts(int index) {
		if (index>=0) {
			calendar[index][index] = players.get(index);
			getCalendarByParts(index-1);
		}
	}
	
	public String[][] getCalendar(){
		return calendar;
	}
	
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("PLAYER/OPPONENT\t");
		for (int i = 1; i <=daysOfGame;i++) {
			sb.append("DAY" + i + "\t");
		}
		sb.append("\n");
		for (int i = 0; i<numParticipants;i++) {
			for(int j  = 0; j<numParticipants;j++) {
				sb.append(calendar[i][j] + "\t");
			}
			sb.append("\n");
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		Calendar calendar = new Calendar(args[0]);
		calendar.completeCalendar();
		calendar.toString();
	}
}
