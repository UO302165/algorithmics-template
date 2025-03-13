package algorithmicsS3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import util.FileUtil;

public class Calendar<T> {

	private static final int THRESHOLD=1;
	private int numParticipants;
	private List<Object> players;
	private Object[][] calendar;
	private int daysOfGame;
	
	public Calendar(String fileName) {
		players = new ArrayList<Object>();
		loadFile(fileName);
		calendar = new Object[numParticipants][numParticipants];
		daysOfGame = numParticipants-1;
	}
	
	public Calendar(int numPlayers) {
		players = new ArrayList<Object>();
		numParticipants=numPlayers;
		loadPlayersWithoutFile();
		calendar = new Object[numParticipants][numParticipants];
		daysOfGame = numParticipants-1;
	}
	
	private void loadPlayersWithoutFile() {
		for(int i = 0; i<numParticipants;i++) {
			players.add(i);
		}
		
	}

	public void loadFile(String fileName) {
		numParticipants= FileUtil.loadFile(fileName,players);	
	}
	

	public void computeCalendar(int start, int end){
		if(end-start <= THRESHOLD){
			computeBaseCase(start,end);
		}else{
			int midpoint = (start+end)/2;
			computeCalendar(start, midpoint);
			computeCalendar(midpoint+1,end);
		}
	}

	public Object[][] getCalendar(){
		return calendar;
	}
	
	public List<Object> getPlayers(){
		return players;
	}
	
	private void computeBaseCase(int start, int end) {
		for(int i = 0; i<calendar.length-1;i+=2) {
			if(i==start) {
				calendar[i][start] = players.get(0);
				calendar[i+1][end] = players.get(0);
				calendar[i+1][start] = players.get(1);
				calendar[i][end] = players.get(1);
				
			}
			else if((i+start)<numParticipants) {
				calendar[i][start]= players.get(start+i);
				calendar[i+1][end] = players.get(start+i);
				calendar[i+1][start] = players.get(end+i);
				calendar[i][end] = players.get(end+i);
			}else {
				calendar[i][start]= players.get(Math.abs(start-i));
				calendar[i+1][start+1] = players.get(Math.abs(start-i));
				calendar[i+1][start] = players.get(Math.abs(start-i)+1);
				calendar[i][start+1] = players.get(Math.abs(start-i)+1);
			}
		}
	}
	
	public int getNumParticipants() {
		return numParticipants;
	}
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("PLAYER\t");
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

	
}
