// "static void main" must be defined in a public class.
import java.util.*;
public class Main {
    public static void main(String[] args) {
        String[] teams = {"a","b","c","d","e","f","g"};
        String[] fixtures = new String[42]; //stores the fixtures
       
        Queue<String> q = new LinkedList<>(); //queue to check no teams have consecutive matches
        for(int i=0; i<7; i++) 
            q.add(teams[i]);
        
        HashMap<String,Integer> matchCount = new HashMap<>(); //to keep match count of all teams 
        for(int i=0; i<7; i++)
            matchCount.put(teams[i],0);
        
        String team1="";
        String team2="";
        int j = 0;
        while(q.isEmpty() == false) {
            team1 = q.poll();
            team2 = q.poll();
            Match m = new Match(team1, team2);
            fixtures[j++] = m.toString();
            if(matchCount.get(team1) != 6) { //we do not add team back to queue if it has played all the 6 matches
                matchCount.put(team1,matchCount.get(team1)+1); 
                q.add(team1);
            }
            
             if(matchCount.get(team2) != 6) {
                matchCount.put(team2,matchCount.get(team2)+1); 
                q.add(team2);
            }
            
        }
        
        for(int i=0; i<fixtures.length; i++)
            System.out.println(fixtures[i]);
        
        
    }

  class Match {
    String team1, team2;
        public Match(String team1, String team2) {
            this.team1 = team1;
            this.team2 = team2;
        }
        public String toString() {
            return team1 + "" + team2;
        }
    }
}