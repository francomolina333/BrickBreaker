package molina_p1;

import java.util.Scanner;

public class encrypt {

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
		
		System.out.println("" + thouPlace + hunPlace + tensPlace + onesPlace);
		
		onesPlace += 7;
		onesPlace %= 10;
		
		tensPlace += 7;
		tensPlace %= 10;
		
		hunPlace += 7;
		hunPlace %= 10;
		
		thouPlace += 7;
		thouPlace %= 10;
		
		System.out.println("" + tensPlace + onesPlace + thouPlace + hunPlace);
		
	}

}
