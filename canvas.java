package pleaseWork;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
public class canvas {
	static class User {
    String username;
    String password;
    
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
    
    @Override
    public String toString() {
        return "User{username='" + username + "', password='" + password + "'}";
    }
}

static class Team {
    String teamId;
    String teamName;
    int[] marks;
    
    public Team(String teamId, String teamName, int[] marks) {
        this.teamId = teamId;
        this.teamName = teamName;
        this.marks = marks;
    }
    
    @Override
    public String toString() {
        return "Team{teamId='" + teamId + "', teamName='" + teamName + 
               "', marks=" + Arrays.toString(marks) + "}";
    }
}
        static ArrayList<User> admins = new ArrayList<>();
        static ArrayList<User> judges = new ArrayList<>();
        static ArrayList<User> spectators = new ArrayList<>();
        static ArrayList<Team> teams = new ArrayList<>();
		public static void main(String[] arg) {
        
        try {
            BufferedReader reader = new BufferedReader(new FileReader("data.txt"));
            String line;
            String currentSection = null;
            
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                
                // Check which section we're in
                if (line.equals("ADMINS")) {
                    currentSection = "ADMINS";
                    reader.readLine(); // Skip the header line
                } else if (line.equals("JUDGES")) {
                    currentSection = "JUDGES";
                    reader.readLine(); // Skip the header line
                } else if (line.equals("SPECTATORS")) {
                    currentSection = "SPECTATORS";
                    reader.readLine(); // Skip the header line
                } else if (line.equals("TEAMS")) {
                    currentSection = "TEAMS";
                    reader.readLine(); // Skip the header line
                } else if (!line.isEmpty()) {
                    // Parse the data line
                    String[] parts = line.split("\\|");
                    
                    if (currentSection != null) {
                        switch (currentSection) {
                            case "ADMINS":
                                admins.add(new User(parts[0], parts[1]));
                                break;
                            case "JUDGES":
                                judges.add(new User(parts[0], parts[1]));
                                break;
                            case "SPECTATORS":
                                spectators.add(new User(parts[0], parts[1]));
                                break;
                            case "TEAMS":
                                int[] marks = {
                                    Integer.parseInt(parts[2]),
                                    Integer.parseInt(parts[3]),
                                    Integer.parseInt(parts[4])
                                };
                                teams.add(new Team(parts[0], parts[1], marks));
                                break;
                        }
                    }
                }
            }
            reader.close();
            
            // Print results to verify
            System.out.println("Admins: " + admins);
            System.out.println("Judges: " + judges);
            System.out.println("Spectators: " + spectators);
            System.out.println("Teams: " + teams);
            
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
	}
	

	
	
	
