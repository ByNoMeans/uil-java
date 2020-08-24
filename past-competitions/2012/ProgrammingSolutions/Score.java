package _UTCS_2012;

import java.io.*;
import java.util.*;

public class Score {
    public static void main(String[] args) throws IOException{

        Scanner s = new Scanner(new File("UTCS_12\\judges\\score.dat"));
        int numSets = s.nextInt();
        s.nextLine();
        for(int i = 1; i <= numSets; i++) {
            HashMap<String, Team> results = new HashMap<String, Team>();
            System.out.println(i);
            String data = s.nextLine();
            s.nextLine();
            String[] raw = data.trim().split("\\s+");
            assert raw.length % 3 == 0;
            final int LIMIT = raw.length / 3;
            for(int j = 0; j < LIMIT; j++) {
                String t = raw[j * 3];
                int q = Integer.parseInt(raw[j * 3 + 1]);
                assert 1 <= q && 1 <= 12;
                q -= 1;
                String r = raw[j * 3 + 2];
                assert r.equals("C") || r.equals("I") : r;
                if(!results.containsKey(t)) {
                    results.put(t, new Team(t));
                }
                Team temp = results.get(t);
                if(!temp.questions[q].solved) {
                    if(r.equals("C")) {
                        temp.questions[q].score += 60;
                        temp.questions[q].solved = true;
                    }
                    else
                        temp.questions[q].score -= 5;
                }
            }
            ArrayList<Team> finalResult = new ArrayList<Team>(results.values());
            Collections.sort(finalResult);
            for(Team t : finalResult)
                System.out.println(t);
        }
        s.close();
    }
    
    private static class Team implements Comparable<Team> {
        private Question[] questions;
        private String name;
        
        private Team(String n) {
            name = n;
            questions = new Question[12];
            for(int i = 0; i < questions.length; i++)
                questions[i] = new Question();
        }
        
        public int totalScore() {
            int r = 0;
            for(Question q : questions)
                if(q.solved)
                    r += q.score;
            return r;
        }
        
        public int compareTo(Team other) {
            int result = other.totalScore() - this.totalScore();
            if(result == 0)
                result = this.name.compareTo(other.name);
            return result;
        }
        
        public String toString() {
            return name + " " + totalScore();
        }
    }
    
    private static class Question {
        private boolean solved;
        private int score;
    }
}
