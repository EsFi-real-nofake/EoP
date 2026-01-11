package pleaseWork;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
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
            loginAndpermissions();
        }
//now to revamp login page
public static void loginAndpermissions () {
    System.out.print("=====================================================");
    System.out.println("Welcome to The");
    System.out.println("1. Admin Login");
    System.out.println("2. Judge Login");
    System.out.println("3. Spectator Login");
    System.out.print("=====================================================");
    int loginChoice = input.nextInt();
    if(loginChoice == 1) {
        System.out.println("Enter credentials: ");
        String username = input.next();
        String password = input.next();
        for(int i = 0; i < AdminRead.length; i++) {
            if(username.equals(AdminRead[i][0]) && password.equals(AdminRead[i][1])) {
                System.out.println("Access Granted!");
                adminPerms(true, username);   
            }  
        }
    }
    else if(loginChoice == 2) {
        System.out.println("Enter credentials: ");
        String username = input.next();
        String password = input.next();
        for(int i = 0; i < JudgeRead.length; i++) {
            if(username.equals(JudgeRead[i][0]) && password.equals(JudgeRead[i][1])) {
                System.out.println("Access Granted!");
                judgePerms(true);   
            }  
        }
    }
}

public static void adminPerms(boolean access, String username) {
    int choice = 0;
    System.out.println("Hello" + username + ", what do you want to do?");
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
}

public static void judgePerms(boolean access, String username) {
    System.out.println("Hello" + username);

    }

    public static void spectatorPerms(boolean access, String username) {
    System.out.println("Hello" + username);
}

public static void editTeams() {
    int choice;
    System.out.println("Whaddya wanna see?");
    System.out.println("1. Team mark edit/view\n2. Team name edit/view");
    choice = input.nextInt();
    switch(choice) {
        case 1 : {}
        case 2 : {
            System.out.print("Enter team ID: ");
            String teamID = input.next();
            for(int i = 0; i < TeamRead.length; i++) {
                if(teamID.equals(TeamRead[i][0])) {
                    System.out.println("Team name: " + TeamRead[i][1]);
                    System.out.println("Team mark: Creativity" + TeamRead[i][2] + " | Marketability" + TeamRead[i][3] + " | Customer Service" + TeamRead[i][4]);
                }
            }
        }
    }
}
}
	
	

	
	
	
