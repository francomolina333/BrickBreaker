package molina_p1;

import java.util.Scanner;

public class decrypt {

	public static void main(String[] args) {
		int onesPlace;
		int tensPlace;
		int hunPlace;
		int thouPlace;
		Scanner scnr = new Scanner(System.in);
		
		System.out.println("Enter a 4-digit code.");
		int code = scnr.nextInt();
		
		onesPlace = code % 10;
		tensPlace = (code / 10) % 10;
		hunPlace = (code / 100) % 10;
		thouPlace = (code / 1000) % 10;
		
		
		if (onesPlace < 8) {
			onesPlace += 10;
		}	
		
		onesPlace %= 7;
		
		if (tensPlace < 8) {
			tensPlace += 10;
		}	
		tensPlace %= 7;
		
		if (hunPlace < 8) {
			hunPlace += 10;
		}	
		hunPlace %= 7;
		
		if (thouPlace < 8) {
			thouPlace += 10;
		}	
		thouPlace %= 7;
		
		System.out.println("" + tensPlace + onesPlace + thouPlace + hunPlace);
		
		
		

	}

}
