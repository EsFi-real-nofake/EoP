package pleaseWork;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class canvas {
    //FUTURE ENHANCEMENT: Converting to ArrayList for dynamic arrays
    public static String[][] TeamRead = new String[10][5];
    public static String[][] JudgeRead = new String[5][2];
    public static String[][] AdminRead = new String[5][2];
    public static String[][] SpectRead = new String[5][2];
    public static Scanner input = new Scanner(System.in);
    //DATA  LOADERS:
    //FOR TEAMS
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
        System.out.println("Team Data loaded successfully!");
    } catch (FileNotFoundException ex) {
                System.out.println("Error: TeamData.txt not found!");
            ex.printStackTrace();
            } catch (IOException ex) {
                System.out.println("Error: TeamData.txt not found!");
            ex.printStackTrace();
            }
    }
    //FOR JUDGES
    public static void loadJudge() {
    try {
        BufferedReader read = new BufferedReader(new FileReader("JudgeData.txt"));
        String line;
        int i = 0;
        while ((line = read.readLine()) != null && i < JudgeRead.length) {
            String[] parts = line.split("\\|");
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
//FOR ADMINS
public static void loadAdmin() {
 try {
     BufferedReader readAdmin = new BufferedReader(new FileReader("AdminData.txt"));
     String line;
     int i = 0;
     while ((line = readAdmin.readLine()) != null && i < AdminRead.length) {
         String[] parts = line.split("\\|");
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
//FOR SPECTATORS
public static void loadSpect() {
    
        try {
            BufferedReader readSpect = new BufferedReader(new FileReader("SpectatorData.txt"));
            String line;
            int i = 0;
            while ((line = readSpect.readLine()) != null && i < SpectRead.length) {
                String[] parts = line.split("\\|");
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
//MAIN IS HERE MAIN IS HERE MAIN IS HERE MAIN IS HERE 
//MAIN IS HERE MAIN IS HERE MAIN IS HERE MAIN IS HERE  
    public static void main(String[] args) {
        loadTeams();
        loadAdmin();
        loadJudge();
        loadSpect();
        //at this point, all data has been safely receieved properly
            boolean sentinel;
            do{    
           sentinel = loginAndpermissions(); //HELD UP BY A SINGLE PEBBLE TYPE SHI PROGRAM
        }while(sentinel);
        System.out.println("Thank you for exploring this labyritnh of a program!");
    }

//REVAMPED LOGIN PAGE
public static boolean loginAndpermissions () {
    System.out.print("=====================================================\n");
    System.out.println("Welcome to The Festival Manager");
    System.out.println("1. Admin Login");
    System.out.println("2. Judge Login");
    System.out.println("3. Spectator Login");
    System.out.print("=====================================================\n");
    int loginChoice = input.nextInt();
    System.out.println(loginChoice);
      System.out.println("Enter credentials: ");
        String username = input.next();
        String password = input.next();
        //COULD'VE USED SWITCH HERE NGL
        //Error checking for username and password
    if(loginChoice == 1) {
        for(int i = 0; i < AdminRead.length; i++) {
            if(username.equals(AdminRead[i][0]) && password.equals(AdminRead[i][1])) {
                System.out.println("Access Granted!");
                adminPerms(true, username);   
                break;
            }  
    }}
    if(loginChoice == 2) {
        for(int i = 0; i < JudgeRead.length; i++) {
            if(username.equals(JudgeRead[i][0]) && password.equals(JudgeRead[i][1])) {
                System.out.println("Access Granted!");
                judgePerms(true, username);   
                break;
            }  
        }
    }
    if(loginChoice == 3) {
            for(int i = 0; i < SpectRead.length; i++) {
            if(username.equals(SpectRead[i][0]) && password.equals(SpectRead[i][1])) {
                System.out.println("Access Granted!");
                spectatorPerms(true, username);   
                break;
            }  
        }
    }
    System.out.print("Login again?(Y/N): ");
    String sentinel = input.next();
    if(sentinel.equals("N") || sentinel.equals("n")) {
        return false;
    }
    else {
        return true;
    }
}
//ADMIN PERMISSION / ABILITIES
public static void adminPerms(boolean access, String username) {
    int choice;
    String sentinel;
    System.out.println("Hello " + username + ", what do you want to do?");
    do{
    System.out.println("===============================\n1. Edit Teams\n2. Edit Judges\n3. Edit Spectators\n===============================");
    input.nextLine();
    choice = input.nextInt();
    //NGL COULD'VE USED SWITCH HERE TOO
    //BASICALLY, EVERY EDIT FUNCTION IS SEPARATED
    if(choice == 1) {
        editTeams();
    }
    else if(choice == 2) {
        editJudges();
    }
    else if(choice == 3) {
        editSpectators();
    }
    System.out.println("Want to continue as "+ username +"? (Y/N)");
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
            do{
            System.out.print("Adding: ");
            marks = input.nextInt();
            if(marks < 0 || marks > 5) {
                System.out.println("Marks must be between 0 and 5!");
            }
            }while(marks < 0 || marks > 5);
            TeamRead[i][markChoice] = String.valueOf(Integer.parseInt(TeamRead[i][markChoice]) + marks);
            System.out.println("Team mark: Creativity: " + TeamRead[i][2] + " | Marketability: " + TeamRead[i][3] + " | Customer Service: " + TeamRead[i][4]);
        }
        else {
            System.out.println("Team ID not found!");
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
         System.out.println("Hello " + username);
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
                       System.out.println("Team mark: Creativity: " + TeamRead[i][2] + " | Marketability: "  + TeamRead[i][3] + " | Customer Service: " + TeamRead[i][4]);
                       int average = (Integer.parseInt(TeamRead[i][2]) + Integer.parseInt(TeamRead[i][3]) + Integer.parseInt(TeamRead[i][4])) / 3;
                       System.out.println("Team average mark: " + average);
                   }
               } 
            break;
            } 
            case 2: {
                System.out.println("Enter Category to check(1: Creativity, 2: Marketability, 3: Customer Service, 4: EXIT): ");
                int Category = input.nextInt();
                 String teamID = " ", teamName = " ";
                for(int i = 0; i < TeamRead.length; i++) {
                    int max = 0;
                    if(Category == 4) {
                        break;
                    }
                    if(Category == 3) {
                        for(int j = 0; j < TeamRead.length; j++) {
                            if(Integer.parseInt(TeamRead[j][4]) > max) {
                                max = Integer.parseInt(TeamRead[j][4]);
                                teamID = TeamRead[j][0];
                                teamName = TeamRead[j][1];
                            } 
                        }
                            System.out.println("Team ID: " + teamID + " | Team Name: " + teamName + " is leading in Customer Service with " + max + " marks");
                        break;
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
                        break;
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
                        break;
                    }
                }
                break;
            }
            default: {
                System.out.println("Invalid choice!"); break;
            }
        }
        System.out.print("Continue?(Y/N): ");
            sentinel = input.next();
            if(sentinel.equals("N") || sentinel.equals("n")) 
                return;
            }while(true);
        }



public static void editTeams() {
    int choice = 0, markChoice = 0, index = 0;
    String skip = "skip";
    loadTeams();
    System.out.println("Whaddya wanna see?");
    while(choice != 1 && choice != 2) { //MENU right here
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
                    System.out.println("Team mark: Creativity: " + TeamRead[i][2] + " | Marketability: " + TeamRead[i][3] + " | Customer Service: " + TeamRead[i][4]);
                    System.out.print("Mark to change? Creativity(1), Marketability(2), Customer Service(3), EXIT(4):");
                    markChoice = input.nextInt();
                    if(markChoice == 4) break;
                    markChoice += 1;
                    System.out.print("Mark to change to: ");
                    String newMark = input.next();
                    TeamRead[i][markChoice] = newMark;
                    index = i;
                    break;
                }} break;
            }
        case 2 : {
            for(int i = 0; i < TeamRead.length; i++) {
                System.out.println(TeamRead[i][0]);
                if(teamID.equals(TeamRead[i][0])) {
                    System.out.println("Current team name: " + TeamRead[i][1]);
                   System.out.print("Name to change to: ");
                   input.nextLine();
                   String newName = input.nextLine();
                   TeamRead[i][1] = newName;
                   index = i;
                   break;
                }
            } break;
        }
    }
     if(TeamRead[index][0].equals(skip)|| TeamRead[index][1].equals(skip) || markChoice == 4) {
        System.out.println("Nothing updated");
        return;
    }
    updateTeams();
}



public static void editJudges() {
    int choice = 0, index = 0;
    String skip = "skip";
    loadJudge();
    System.out.println("Whaddya wanna see?");
    while(choice != 1 && choice != 2) {
    System.out.println("====================\n1. Judge name edit/view\n2. Judge password edit/view\n====================");
    choice = input.nextInt();
    if(choice != 1 && choice != 2) {
        System.out.println("Invalid choice!");
        }
    }
    System.out.println("List of judges: ");
    for(int i = 0; i < JudgeRead.length; i++) {
        System.out.println(JudgeRead[i][0]);
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
        default : {
            System.out.println("Idk how u did, but you broke through the hardcode. Congratulations, Stanley");
            break;
        }
    }
    if(JudgeRead[index][0].equals(skip) || JudgeRead[index][1].equals(skip) || judgeName.equals(skip)) {
        System.out.println("Nothing updated");
        return;
    }
    updateJudge();
}

public static void editSpectators() {
     int choice = 0, index = 0;
     String skip = "skip";
     loadSpect();
    System.out.println("Whaddya wanna see?");
    while(choice != 1 && choice != 2) {
    System.out.println("====================\n1. Spectator name edit/view\n2. Spectator password edit/view\n====================");
    choice = input.nextInt();
    if(choice != 1 && choice != 2) {
        System.out.println("Invalid choice!");
    }
    }
    System.out.println("List of spectators: ");
    for(int i = 0; i < SpectRead.length; i++) {
        System.out.println(SpectRead[i][0]);
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
    if(SpectRead[index][0].equals(skip) || SpectRead[index][1].equals(skip) || SpectName.equals(skip)) {
        System.out.println("Nothing updated");
        return;
    }
    updateSpectators();
}

//METHODS TO UPDATE TEXT FILE
//since writer wipes the entire thing, we just rewrite
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