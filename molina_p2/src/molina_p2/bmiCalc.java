package molina_p2;

import java.util.Scanner;

public class bmiCalc {

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		
		System.out.println("Please type M for metric system or A for American");
		
		String system = scnr.next();
		
		if ((system.equals("a")) || (system.equals("A"))) {
			
			System.out.println("Enter your weight in pounds.");
			int pounds = scnr.nextInt();
			
			System.out.println("Enter your height in inches.");
			int inches = scnr.nextInt();
			
			double bmi = 703 * pounds / (Math.pow(inches, 2));
			
			System.out.println("BMI: " + bmi);
		}
		
		if ((system.equals("m")) || (system.equals("M"))) {
			
			System.out.println("Enter your weight in kilograms.");
			double kilo = scnr.nextDouble();
			
			System.out.println("Enter your height in meters.");
			double meters = scnr.nextDouble();
			
			double bmi2 = kilo / (Math.pow(meters, 2));
			
			System.out.println("BMI: " + bmi2);
		}
		
		System.out.println("");
		System.out.println("BMI categories:");
		System.out.println("Underweight = < 18.5");
		System.out.println("Normal weight = 18.5 - 24.9");
		System.out.println("Overweight = 25 - 29.9");
		System.out.println("Obesity = > 30");
		
	}

}
