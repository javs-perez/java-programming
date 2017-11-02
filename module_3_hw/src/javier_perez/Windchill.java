import java.util.Scanner;

/* WINDCHILL EQUATION
 * wc = 35.74 + 0.6215(t) - 35.75(v^0.16) + 0.4275(t)(v^0.16)
 */

public class Windchill {
	public static void main(String[] args) {
		// setting variables
		Scanner input = new Scanner(System.in);
		double temp, windSpeed, windChill;
		
		// Prompt the user to enter temperature and windspeed
		System.out.print("Enter Farenheit temperature: ");
		temp = input.nextDouble();
		System.out.print("Enter wind speed in miles per hour: ");
		windSpeed = input.nextDouble();
		
		// calculate windchill if valid
		if (temp >= -58 && temp <= 41 && windSpeed >= 2) {
			windChill = 35.74 + (0.6125 * temp) - (35.75 * Math.pow(windSpeed, 0.16)) + (0.4275 * temp * Math.pow(windSpeed, 0.16));
			System.out.println("The windchill is " + windChill + ".");
		} else {
			// display messages indicating whether the temp and/or wind speed are invalid
			System.out.println("Either the temperature and/or the wind speed you entered are invalid, please check error messages below:");
			if (temp < -58 || temp > 41) 
				System.out.println("The temperature range needs to be between -58F and 41F.");
			
			if (windSpeed < 2)
				System.out.println("The windspeed needs to be greater than or equal to 2 miles per hour.");
		}
	}
}
