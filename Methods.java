package pleaseWork;
import pleaseWork.canvas;
import java.util.Scanner;
import org.json.*;
import java.nio.file.*;
import java.io.*;
public class Methods {
	static Scanner input = new Scanner(System.in);
	public static boolean login(int loginChoice) {
		try {
			readVal = new String(Files.readAllBytes(Paths.get("src/data.json")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		boolean verify = false;
		String username, password;
		int counter = 3;
		
		switch (loginChoice) {
		case 1 :{ //ADMIN AUTH
			while(counter > 0)
			System.out.println("Enter username: ");
			username = input.nextLine();
			input.nextLine();
			System.out.println("Enter password: ");
			password = input.nextLine();
			for(int i = 0; i < admins.length(); i++) {
				toRead = admins.getJSONObject(i);
				String readUsername = toRead.getString(username);
				String readPassword = toRead.getString(password);
 				if(username == readUsername && password == readPassword)
					verify = true;
			};
			 {
				System.out.println("uhoh stinky wrong credentials. Try again! you got " +counter+ " more times aight");
			}
			break;
		}
		case 2 : { //JUDGE AUTH
			System.out.println("Enter username: "); 
			username = input.nextLine();
			input.nextLine();
			System.out.println("Enter password: ");
			password = input.nextLine();
			for(int i = 0; i < judges.length(); i++) {
				JSONObject toRead = judges.getJSONObject(i);
				String readUsername = toRead.getString(username);
				String readPassword = toRead.getString(password);
 				if(username == readUsername && password == readPassword)
					verify = true;
			};
			break;
			}
		
		case 3 : { //SPECT. AUTH
		System.out.println("Enter username: ");
		username = input.nextLine();
		input.nextLine();
		System.out.println("Enter password: ");
		password = input.nextLine();
		for(int i = 0; i < judges.length(); i++) {
			JSONObject toRead = judges.getJSONObject(i);
			String readUsername = toRead.getString(username);
			String readPassword = toRead.getString(password);
				if(username == readUsername && password == readPassword)
				verify = true;
		};		
		break;
				}
		}
		
		return verify;
		}


public static void adminPerms(boolean access) {
	int status = 1, choice;
	if(!access) {
	System.out.println("Access Denied!");
		do {
			System.out.println("===MENU===\n1. Delete Teams\n 2. Edit User Info");
			choice = input.nextInt();
			if(choice == 1) {
				System.out.println("Which team do you want to delete?");
				
			}
			else if(choice == 2) {
				System.out.println("Who do you want to edit?Judges(1) or Spectators(2): ");
				
				
			}
		}while(status != 0);
	}
	else {
		System.out.println("Access Granted!");
		//make menu for specific permissions
		
	}
	
}
public static void judgePerms(boolean access) {
	int status = 1;
	if(!access) {
		System.out.println("Access Denied!");
		do {
			
		}while(status != 0);
	}
	else {
		System.out.println("Access Granted! What do you want to do, judge? ");
			System.out.println("1. Give marks to teams\n2. View average marks of teams");
			
	}
}

public static void spectatorPerms(boolean access) {
	int status = 1;
	if(!access) {
	System.out.println("Access Denied!");
	do {
		
	}while(status != 0);
	}
	else {
		System.out.println("Access Granted!");
			
	}
}
}
