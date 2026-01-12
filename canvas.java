package pleaseWork;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class canvas {
    public static String[][] TeamRead = new String[10][5];
    public static String[][] JudgeRead = new String[5][2];
    public static String[][] AdminRead = new String[5][2];
    public static String[][] SpectRead = new String[5][2];
    public static Scanner input = new Scanner(System.in);
	public static void main(String[] args) {
        int i = 0;
        try {
            BufferedReader read = new BufferedReader(new FileReader("JudgeData.txt"));
            String line;
            
            while ((line = read.readLine()) != null && i < JudgeRead.length) {
                System.out.println(line);
                String[] parts = line.split("\\|");
                
                     for (int j = 0; j < parts.length; j++) {
                    JudgeRead[i][j] = parts[j];
                }
                System.out.println(JudgeRead[i][0] + " " + JudgeRead[i][1]);
            }
                System.out.println("Judge Data loaded successfully!");
            read.close();
        } catch (FileNotFoundException ex) {
            System.getLogger(test.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        } catch (IOException ex) {
            System.getLogger(test.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }

       
        try {
            BufferedReader readAdmin = new BufferedReader(new FileReader("AdminData.txt"));
            String line;
            
            while ((line = readAdmin.readLine()) != null && i < AdminRead.length) {
                System.out.println(line);
                String[] parts = line.split("\\|");
                for (int j = 0; j < parts.length; j++) {
                    AdminRead[i][j] = parts[j];
                }
                System.out.println(AdminRead[i][0] + " " + AdminRead[i][1]);
            }
                System.out.println("Admin Data loaded successfully!");
            readAdmin.close();
        } catch (FileNotFoundException ex) {
            System.getLogger(test.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        } catch (IOException ex) {
            System.getLogger(test.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        try {
            BufferedReader readSpect = new BufferedReader(new FileReader("SpectatorData.txt"));
            String line;
            
            while ((line = readSpect.readLine()) != null && i < SpectRead.length) {
                System.out.println(line);
                String[] parts = line.split("\\|");
          
                for (int j = 0; j < parts.length; j++) {
                    SpectRead[i][j] = parts[j];
                }
                System.out.println(SpectRead[i][0] + " " + SpectRead[i][1]);
            }
                System.out.println("Spectator Data loaded successfully!");
            readSpect.close();
        } catch (FileNotFoundException ex) {
            System.getLogger(test.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        } catch (IOException ex) {
            System.getLogger(test.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        try {
            BufferedReader readTeam = new BufferedReader(new FileReader("TeamData.txt"));
            String line;
            
            while ((line = readTeam.readLine()) != null && i < TeamRead.length) {
                System.out.println(line);
                String[] parts = line.split("\\|");
                    for(int j = 0; j < parts.length; j++){
                   TeamRead[i][j] = parts[j];
                    }
                    System.out.println(TeamRead[i][0] + " " + TeamRead[i][1]);
                }
                System.out.println("Team Data loaded successfully!");
                readTeam.close();
            } catch (FileNotFoundException ex) {
                System.getLogger(test.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            } catch (IOException ex) {
                System.getLogger(test.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            }
            //at this point, all data has been safely receieved properly
            boolean sentinel = false;
            do{    
           sentinel = loginAndpermissions();
        }while(sentinel);
    }

//now to revamp login page
public static boolean loginAndpermissions () {
    System.out.print("=====================================================");
    System.out.println("Welcome to The");
    System.out.println("1. Admin Login");
    System.out.println("2. Judge Login");
    System.out.println("3. Spectator Login");
    System.out.print("=====================================================");
    int loginChoice = input.nextInt();
     System.out.println("Enter credentials: ");
        String username = input.next();
        String password = input.next();
    if(loginChoice == 1) {
        for(int i = 0; i < AdminRead.length; i++) {
            if(username.equals(AdminRead[i][0]) && password.equals(AdminRead[i][1])) {
                System.out.println("Access Granted!");
                adminPerms(true, username);   
            }  
        }
    }
    else if(loginChoice == 2) {
        for(int i = 0; i < JudgeRead.length; i++) {
            if(username.equals(JudgeRead[i][0]) && password.equals(JudgeRead[i][1])) {
                System.out.println("Access Granted!");
                judgePerms(true, username);   
            }  
        }
    }
    else if(loginChoice == 3) {
            for(int i = 0; i < SpectRead.length; i++) {
            if(username.equals(SpectRead[i][0]) && password.equals(SpectRead[i][1])) {
                System.out.println("Access Granted!");
                spectatorPerms(true, username);   
            }  
        }
    }
    System.out.print("Continue?(Y/N): ");
    String sentinel = input.next();
    if(sentinel.equals("N") || sentinel.equals("n")) {
        return false;
    }
    else {
        return true;
    }
}

public static void adminPerms(boolean access, String username) {
    int choice;
    String sentinel;
    System.out.println("Hello" + username + ", what do you want to do?");
    do{
    System.out.println("1. Edit Teams\n2. Edit Judges\n3. Edit Spectators");
    choice = input.nextInt();
    if(choice == 1) {
        editTeams();
    }
    else if(choice == 2) {
        editJudges();
    }
    else if(choice == 3) {
        editSpectators();
    }
    System.out.println("Want to continue? (Y/N)");
    sentinel = input.next();
    if(sentinel.equals("N") || sentinel.equals("n")) {
        return;
    }
}while(true);
}

public static void judgePerms(boolean access, String username) {
    int marks = 0;
    while(true){
    System.out.println("Hello" + username + ", enter Team ID to give marks to: ");
    String teamID = input.next();
    for(int i = 0; i < TeamRead.length; i++) {
        if(teamID.equals(TeamRead[i][0])) {
            System.out.println("Team name: " + TeamRead[i][1]);
            System.out.print("Marks to add to: Creativity(1), Marketability(2), Customer Service(3): ");
            int markChoice = input.nextInt();
            markChoice += 1;
            System.out.print("Adding: ");
            do{
            marks = input.nextInt();
            if(marks < 0 || marks > 5) {
                System.out.println("Marks must be between 0 and 5!");
            }
            }while(marks < 0 || marks > 5);
            TeamRead[i][markChoice] = String.valueOf(Integer.parseInt(TeamRead[i][markChoice]) + marks);
            System.out.println("Team mark: Creativity" + TeamRead[i][2] + " | Marketability" + TeamRead[i][3] + " | Customer Service" + TeamRead[i][4]);
        }
    }
    System.out.print("Continue?(Y/N): ");
    String sentinel = input.next();
    if(sentinel.equals("N") || sentinel.equals("n")) 
        return; 
}
}
    public static void spectatorPerms(boolean access, String username) {
        String sentinel;
        int choice;
        do{
         System.out.println("Hello" + username);
         System.out.println("=====================================\n1. See Teams\n2. See Judges\n3. See leading team in respective categories\n=====================================");
        choice = input.nextInt();
         String teamID = input.next();
        for(int i = 0; i < TeamRead.length; i++) {
            if(teamID.equals(TeamRead[i][0])) {
                System.out.println("Team name: " + TeamRead[i][1]);
                System.out.println("Team mark: Creativity" + TeamRead[i][2] + " | Marketability" + TeamRead[i][3] + " | Customer Service" + TeamRead[i][4]);
                int average = (Integer.parseInt(TeamRead[i][2]) + Integer.parseInt(TeamRead[i][3]) + Integer.parseInt(TeamRead[i][4])) / 3;
                System.out.println("Team average mark: " + average);
            }
        } 
        System.out.print("Continue?(Y/N): ");
        sentinel = input.next();
        if(sentinel.equals("N") || sentinel.equals("n")) 
            return;
        }while(true);
}

public static void editTeams() {
    int choice = 0;
    System.out.println("Whaddya wanna see?");
    while(choice != 1 || choice != 2) {
    System.out.println("================\n1. Team mark edit/view\n2. Team name edit/view\n==================");
    choice = input.nextInt();
    if(choice != 1 || choice != 2) {
        System.out.println("Invalid choice!");
    }
    }
    System.out.print("Enter team ID: ");
            String teamID = input.next();
    switch(choice) {
        case 1 : {for(int i = 0; i < TeamRead.length; i++) {
                if(teamID.equals(TeamRead[i][0])) {
                    System.out.println("Team name: " + TeamRead[i][1]);
                    System.out.println("Team mark: Creativity" + TeamRead[i][2] + " | Marketability" + TeamRead[i][3] + " | Customer Service" + TeamRead[i][4]);
                    System.out.print("Mark to change? Creativity(1), Marketability(2), Customer Service(3):");
                    int markChoice = input.nextInt();
                    markChoice += 1;
                    System.out.print("Mark to change to: ");
                    String newMark = input.next();
                    TeamRead[i][markChoice] = newMark;
                    break;
                }}
            }
        case 2 : {
            for(int i = 0; i < TeamRead.length; i++) {
                if(teamID.equals(TeamRead[i][0])) {
                    System.out.println("Current team name: " + TeamRead[i][1]);
                   System.out.print("Name to change to: ");
                   String newName = input.next();
                   TeamRead[i][1] = newName;
                   break;
                }
            }
        }
    }
    updateTeams();
}



public static void editJudges() {
    int choice = 0;
    System.out.println("Whaddya wanna see?");
    while(choice != 1 || choice != 2) {
    System.out.println("====================\n1. Judge name edit/view\n2. Judge password edit/view\n====================");
    choice = input.nextInt();
    if(choice != 1 || choice != 2) {
        System.out.println("Invalid choice!");
        }
    }
    System.out.println("Enter judge username: ");
     String judgeName = input.next();
    switch(choice) {
        case 1 : {
                    for(int i = 0; i < JudgeRead.length; i++) {
                        if(judgeName.equals(JudgeRead[i][0])) {
                            System.out.println("Current name: " + JudgeRead[i][0]);
                            System.out.print("Name to change to: ");
                            String newName = input.next();
                            JudgeRead[i][0] = newName;
                            break;
                        }
                    }

                break;
            }
        case 2 : {
            
            for(int i = 0; i < JudgeRead.length; i++) {
                if(judgeName.equals(JudgeRead[i][0])){
                System.out.println("Current password: " + JudgeRead[i][1]);
                System.out.print("Password to change to: ");
                String newPassword = input.next();
                JudgeRead[i][1] = newPassword;
                break;
                }
            }
            break;
        }
    }
    updateJudge();
}

public static void editSpectators() {
     int choice = 0;
    System.out.println("Whaddya wanna see?");
    while(choice != 1 || choice != 2) {
    System.out.println("====================\n1. Spectator name edit/view\n2. Spectator password edit/view\n====================");
    choice = input.nextInt();
    if(choice != 1 || choice != 2) {
        System.out.println("Invalid choice!");
    }
    }
    System.out.println("Enter spectator username: ");
     String SpectName = input.next();
    switch(choice) {
        case 1 : {
                    for(int i = 0; i < SpectRead.length; i++) {
                        if(SpectName.equals(SpectRead[i][0])) {
                            System.out.println("Current name: " + SpectRead[i][0]);
                            System.out.print("Name to change to: ");
                            String newName = input.next();
                            SpectRead[i][0] = newName;
                            break;
                        }
                    }

                break;
            }
        case 2 : {
            
            for(int i = 0; i < SpectRead.length; i++) {
                if(SpectName.equals(SpectRead[i][0])){
                System.out.println("Current password: " + SpectRead[i][1]);
                System.out.print("Password to change to: ");
                String newPassword = input.next();
                SpectRead[i][1] = newPassword;
                break;
                }
            }
            break;
        }
    }
    updateSpectators();
}

//METHODS TO UPDATE TEXT FILE
public static void updateJudge() {
try (BufferedWriter writer = new BufferedWriter(new FileWriter("JudgeData.txt"))) {
    for (int i = 0; i < JudgeRead.length; i++) {
        if (JudgeRead[i][0] != null) {
            writer.write(JudgeRead[i][0] + "|" + JudgeRead[i][1]);
            writer.newLine();
        }
    }
    
} catch (IOException e) {
    e.printStackTrace();
    }       System.out.println("Judge file updated!");
}

public static void updateSpectators() {
try (BufferedWriter writer = new BufferedWriter(new FileWriter("SpectatorData.txt"))) {
    for (int i = 0; i < SpectRead.length; i++) {
        if (SpectRead[i][0] != null) {
            writer.write(SpectRead[i][0] + "|" + SpectRead[i][1]);
            writer.newLine();
        }
    }
     

} catch (IOException e) {
    e.printStackTrace();
    }       System.out.println("Spectator file updated!");
}

public static void updateTeams() {
try (BufferedWriter writer = new BufferedWriter(new FileWriter("TeamData.txt"))) {
    for (int i = 0; i < TeamRead.length; i++) {
        if (TeamRead[i][0] != null) {
            writer.write(TeamRead[i][0] + "|" + TeamRead[i][1] + "|" + TeamRead[i][2] + "|" + TeamRead[i][3] + "|" + TeamRead[i][4]);
            writer.newLine();
        }
    }
     
} catch (IOException e) {
    e.printStackTrace();
    }       System.out.println("Team file updated!");
}
}
	
	

	
	
	
