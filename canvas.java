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
   public static void loadTeams() {
    int i = 0;
    try (BufferedReader readTeam = new BufferedReader(new FileReader("TeamData.txt"))) {
        String line;
        while ((line = readTeam.readLine()) != null) {
            String[] parts = line.split("\\|");
            for(int j = 0; j < parts.length && j < 5; j++){
                TeamRead[i][j] = parts[j];
            }
            i++;
        }
        
    } catch (FileNotFoundException ex) {
                System.out.println("Error: TeamData.txt not found!");
            ex.printStackTrace();
            } catch (IOException ex) {
                System.out.println("Error: TeamData.txt not found!");
            ex.printStackTrace();
            }
    }
    public static void loadJudge() {
    try {
        BufferedReader read = new BufferedReader(new FileReader("JudgeData.txt"));
        String line;
        int i = 0;
        while ((line = read.readLine()) != null && i < JudgeRead.length) {
            String[] parts = line.split("\\|");
            System.out.println(line);
                 for (int j = 0; j < parts.length; j++) {
                JudgeRead[i][j] = parts[j];
            }
            i++;
        }
            System.out.println("Judge Data loaded successfully!");
        read.close();
    } catch (FileNotFoundException ex) {
        System.out.println("Error: JudgeData.txt not found!");
ex.printStackTrace();
    } catch (IOException ex) {
        System.out.println("Error: JudgeData.txt not found!");
ex.printStackTrace();
    }
}
public static void loadAdmin() {
 try {
     BufferedReader readAdmin = new BufferedReader(new FileReader("AdminData.txt"));
     String line;
     int i = 0;
     while ((line = readAdmin.readLine()) != null && i < AdminRead.length) {
         String[] parts = line.split("\\|");
         System.out.println(line);
         for (int j = 0; j < parts.length; j++) {
             AdminRead[i][j] = parts[j];
         }
         i++;
     }
         System.out.println("Admin Data loaded successfully!");
     readAdmin.close();
 } catch (FileNotFoundException ex) {
     System.out.println("Error: AdminData.txt not found!");
 ex.printStackTrace();
 } catch (IOException ex) {
     System.out.println("Error: AdminData.txt not found!");
  ex.printStackTrace();
 }
}
public static void loadSpect() {
    
        try {
            BufferedReader readSpect = new BufferedReader(new FileReader("SpectatorData.txt"));
            String line;
            int i = 0;
            while ((line = readSpect.readLine()) != null && i < SpectRead.length) {
                String[] parts = line.split("\\|");
                System.out.println(line);
                for (int j = 0; j < parts.length; j++) {
                    SpectRead[i][j] = parts[j];
                }
                i++;
            }
                System.out.println("Spectator Data loaded successfully!");
            readSpect.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Error: SpectatorData.txt not found!");
        ex.printStackTrace();
        } catch (IOException ex) {
            System.out.println("Error: SpectatorData.txt not found!");
        ex.printStackTrace();
        }
    }
	public static void main(String[] args) {
        //at this point, all data has been safely receieved properly
            loadTeams();
            loadAdmin();
            loadJudge();
            loadSpect();
            boolean sentinel = false;
            do{    
           sentinel = loginAndpermissions();
        }while(sentinel);
        System.out.println("Thank you for exploring this labyritnh of a program!");
    }

//now to revamp login page
public static boolean loginAndpermissions () {
    System.out.print("=====================================================\n");
    System.out.println("Welcome to The Festival Manager");
    System.out.println("1. Admin Login");
    System.out.println("2. Judge Login");
    System.out.println("3. Spectator Login");
    System.out.print("=====================================================\n");
    int loginChoice = input.nextInt();
     System.out.println("Enter credentials: ");
        String username = input.next();
        String password = input.next();
    if(loginChoice == 1) {
        for(int i = 0; i < AdminRead.length; i++) {
            if(username.equals(AdminRead[i][0]) && password.equals(AdminRead[i][1])) {
                System.out.println("Access Granted!");
                adminPerms(true, username);   
                break;
            }  
            else{
                System.out.println("Access Denied!");
                break;
        }
    }}
    else if(loginChoice == 2) {
        for(int i = 0; i < JudgeRead.length; i++) {
            if(username.equals(JudgeRead[i][0]) && password.equals(JudgeRead[i][1])) {
                System.out.println("Access Granted!");
                judgePerms(true, username);   
                break;
            }  
            else{
                System.out.println("Access Denied!");
                break;
        }
        }
    }
    else if(loginChoice == 3) {
            for(int i = 0; i < SpectRead.length; i++) {
            if(username.equals(SpectRead[i][0]) && password.equals(SpectRead[i][1])) {
                System.out.println("Access Granted!");
                spectatorPerms(true, username);   
                break;
            }  
            else{
                System.out.println("Access Denied!");
                break;
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
    System.out.println("Hello " + username + ", what do you want to do?");
    do{
    System.out.println("1. Edit Teams\n2. Edit Judges\n3. Edit Spectators");
    input.nextLine();
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
            input.nextLine();
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
    if(sentinel.equals("N") || sentinel.equals("n")) { 
        updateTeams();
        return; 
    }
}
}
    public static void spectatorPerms(boolean access, String username) {
        String sentinel;
        int choice;
        do{
         System.out.println("Hello" + username);
         System.out.println("=====================================\n1. See Teams\n2.See leading team in respective categories\n=====================================");
        input.nextLine();
         choice = input.nextInt();
        switch(choice) {
            case 1: {
                System.out.print("Enter Team ID: ");
                String teamID = input.next();
               for(int i = 0; i < TeamRead.length; i++) {
                   if(teamID.equals(TeamRead[i][0])) {
                       System.out.println("Team name: " + TeamRead[i][1]);
                       System.out.println("Team mark: Creativity" + TeamRead[i][2] + " | Marketability" + TeamRead[i][3] + " | Customer Service" + TeamRead[i][4]);
                       int average = (Integer.parseInt(TeamRead[i][2]) + Integer.parseInt(TeamRead[i][3]) + Integer.parseInt(TeamRead[i][4])) / 3;
                       System.out.println("Team average mark: " + average);
                   }
               } 
            break;
            } 
            case 2: {
                System.out.println("Enter Category to check: ");
                int Category = input.nextInt();
                 String teamID = " ", teamName = " ";
                for(int i = 0; i < TeamRead.length; i++) {
                    int max = 0;
                    if(Category == 3) {
                        for(int j = 0; j < TeamRead.length; j++) {
                            if(Integer.parseInt(TeamRead[j][4]) > max) {
                                max = Integer.parseInt(TeamRead[j][4]);
                                teamID = TeamRead[j][0];
                                teamName = TeamRead[j][1];
                            } 
                        }
                            System.out.println("Team ID: " + teamID + " | Team Name: " + teamName + " is leading in Customer Service with " + max + " marks");
                    }
                    if(Category == 2) {
                         for(int j = 0; j < TeamRead.length; j++) {
                            if(Integer.parseInt(TeamRead[j][3]) > max) {
                                max = Integer.parseInt(TeamRead[j][3]);
                                teamID = TeamRead[j][0];
                                teamName = TeamRead[j][1];
                            } 
                        }
                        System.out.println("Team ID: " + teamID + " | Team Name: " + teamName + " is leading in Marketability with " + max + " marks");
                    }
                    if(Category == 1) {
                         for(int j = 0; j < TeamRead.length; j++) {
                            if(Integer.parseInt(TeamRead[j][2]) > max) {
                                max = Integer.parseInt(TeamRead[j][2]);
                                teamID = TeamRead[j][0];
                                teamName = TeamRead[j][1];
                            } 
                        }
                        System.out.println("Team ID: " + teamID + " | Team Name: " + teamName + " is leading in Creativity with " + max + " marks");
                    }
                }
                break;
            }
            default: {
                
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
    int index = 0;
    System.out.println("Whaddya wanna see?");
    while(choice != 1 && choice != 2) {
    System.out.println("================\n1. Team mark edit/view\n2. Team name edit/view\n==================");
    choice = input.nextInt();
    if(choice != 1 && choice != 2) {
        System.out.println(choice);
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
                    index = i;
                    break;
                }}
            }
        case 2 : {
            for(int i = 0; i < TeamRead.length; i++) {
                System.out.println(TeamRead[i][0]);
                if(teamID.equals(TeamRead[i][0])) {
                    System.out.println("Current team name: " + TeamRead[i][1]);
                   System.out.print("Name to change to: ");
                   String newName = input.next();
                   TeamRead[i][1] = newName;
                   index = i;
                   break;
                }
            }
        }
    }
     if(TeamRead[index][0] == null || TeamRead[index][1] == null || TeamRead[index][2] == null || TeamRead[index][3] == null || TeamRead[index][4] == null) {
        System.out.println("Nothing updated");
        return;
    }
    updateTeams();
}



public static void editJudges() {
    int choice = 0;
    System.out.println("Whaddya wanna see?");
    while(choice != 1 && choice != 2) {
    System.out.println("====================\n1. Judge name edit/view\n2. Judge password edit/view\n====================");
    choice = input.nextInt();
    if(choice != 1 && choice != 2) {
        System.out.println("Invalid choice!");
        }
    }
    System.out.println("Enter judge username: ");
     String judgeName = input.next();
     int index = 0;
    switch(choice) {
        case 1 : {
                    for(int i = 0; i < JudgeRead.length; i++) {
                        if(judgeName.equals(JudgeRead[i][0])) {
                            System.out.println("Current name: " + JudgeRead[i][0]);
                            System.out.print("Name to change to: ");
                            String newName = input.next();
                            JudgeRead[i][0] = newName;
                            index = i;
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
                index = i;
                break;
                }
            }
            break;
        }
    }
    if(JudgeRead[index][0] == null || JudgeRead[index][1] == null) {
        System.out.println("Nothing updated");
        return;
    }
    updateJudge();
}

public static void editSpectators() {
     int choice = 0;
     int index = 0;
    System.out.println("Whaddya wanna see?");
    while(choice != 1 && choice != 2) {
    System.out.println("====================\n1. Spectator name edit/view\n2. Spectator password edit/view\n====================");
    choice = input.nextInt();
    if(choice != 1 && choice != 2) {
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
                            index = i;
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
                index = i;
                break;
                }
            }
            break;
        }
    }
    if(SpectRead[index][0] == null || SpectRead[index][1] == null) {
        System.out.println("Nothing updated");
        return;
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