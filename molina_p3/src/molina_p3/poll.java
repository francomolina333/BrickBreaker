package molina_p3;

import java.util.Arrays;
import java.util.Scanner;

public class poll {

	public static void main(String[] args) {
		int x;
		int counter;
		String quit = "a";
		String[] topics = new String[5];
		
		topics[0] = "Global warming.";
		topics[1] = "John Wick";
		topics[2] = "Church.";
		topics[3] = "Java language";
		topics[4] = "Rick and Morty.";
		
		int[][] responses = new int[5][10];
		int temp;
		int i;
		
		Scanner scnr = new Scanner(System.in);
		
		for(x = 0; (x < 10) && !(quit.equals("q") || quit.equals("Q")) ; x++) {
		
			System.out.println("Rate the following topics from 1 to 10.");
			
			System.out.println(topics[0]);
			temp = scnr.nextInt();
			responses[0][temp--]++;
			
			System.out.println(topics[1]);
			temp = scnr.nextInt();
			responses[1][temp--]++;
			
			System.out.println(topics[2]);
			temp = scnr.nextInt();
			responses[2][temp--]++;
			
			System.out.println(topics[3]);
			temp = scnr.nextInt();
			responses[3][temp--]++;
			
			System.out.println(topics[4]);
			temp = scnr.nextInt();
			responses[4][temp--]++;
			
			if (x < 9) {
				System.out.println("Press Q to quit and display results. Press any other key to submit another response.");
				
				quit = scnr.next();
			}
			
			if (x = 9 || ) {
				System.out.println("Survey complete.");
			}
		}
		
		System.out.println("Topic\t1\t2\t3\t4\t5\t6\t7\t8\t9\t10");
		
		for (counter = 0; counter < 5; counter++) {
			System.out.print(topics[counter] + "\t");
			
			for (i = 0; i < 9; i++) {
				System.out.print(responses[counter][i] + "\t");
								
			}
			
			System.out.println(responses[counter][9]);
		}
		
	}
}
