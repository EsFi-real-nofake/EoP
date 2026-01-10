package HERE;
import java.util.Scanner;
import org.json.*;
import java.nio.file.*;
import java.io.*;
public class canvas {
	public static Scanner input = new Scanner(System.in);
	@SuppressWarnings("resource")
	public static String clearBuffer = new Scanner(System.in).nextLine();
	public static String[] selecteduser = new String[2];
	public static void main(String[] arg) {
		//variable declaration//
		int loginChoice;
		boolean loginStatus = true;
		//main menu for login
		System.out.println("Choose who to login as: \n 1. ADMIN\n2.JUDGE\n3.SPECTATOR");
		while(loginStatus) 
		{
		loginChoice = input.nextInt();
		loginStatus = Methods.login(loginChoice);
			switch (loginChoice)
			{
				case 1 : {
				Methods.adminPerms(loginStatus);
				break;
				}
				case 2 : {
				Methods.judgePerms(loginStatus);
				}
				case 3 : {
				Methods.spectatorPerms(loginStatus);
				}
			}
		}
		
	}
	

	
	
	
}
