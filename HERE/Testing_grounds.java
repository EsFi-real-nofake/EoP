package HERE;
import java.util.Scanner;
public class Testing_grounds {
	public static void main(String[] arg) {
		Scanner input = new Scanner(System.in);
		
 }
	
	 static double avgCalc( int[] cars) {
		double average;
		int total = 0;
		for(int i = 0; i < cars.length; i++) {
			total += cars[i];
		}
		average = (double) total / cars.length;
		return average;
	}
}