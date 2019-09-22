package test;

import java.util.Scanner;

public class poll {
	
			public static void main(String[] args) {
				int x;
				int counter;
				String quit = "a";
				String[] topics = new String[5];
				
				topics[0] = "Global warming";
				topics[1] = "John Wick";
				topics[2] = "Church\t";
				topics[3] = "Java language";
				topics[4] = "Rick and Morty";
				
				int[][] responses = new int[10][10];
				int temp;
				int i;
				double hSum;
				double lSum;
				
				double[] sum = new double[5];
				double[] avgRating = new double[5];
				
				Scanner scnr = new Scanner(System.in);
				
				for(x = 0; (x < 10) && !(quit.equals("q") || quit.equals("Q")) ; x++) {
				
					System.out.println("Rate the following topics from 1 to 10.");
					
					System.out.println(topics[0]);
					temp = scnr.nextInt();
					responses[0][temp-1] += 1;
					
					System.out.println(topics[1]);
					temp = scnr.nextInt();
					responses[1][temp-1] += 1;
					
					System.out.println(topics[2]);
					temp = scnr.nextInt();
					responses[2][temp-1] += 1;
					
					System.out.println(topics[3]);
					temp = scnr.nextInt();
					responses[3][temp-1] += 1;
					
					System.out.println(topics[4]);
					temp = scnr.nextInt();
					responses[4][temp-1] += 1;
					
					if (x < 9) {
						System.out.println("Press Q to quit and display results. Press any other key to submit another response.");
						
						quit = scnr.next();
					}
					
					if (x == 9 || (quit.equals("q") || quit.equals("Q"))) {
						System.out.println("Survey complete.");
						System.out.println("");
					}
				}
				
				
				for (counter = 0; counter < 5; counter++) {
					
					for (i = 0; i < 10; i++) {
						sum[counter] += responses[counter][i] * (i + 1);
					}
					
					avgRating[counter] = (double)sum[counter] / (double)x;
				}
				
				
				System.out.println("TOPICS\t\t1\t2\t3\t4\t5\t6\t7\t8\t9\t10\tAvg");
				System.out.println("");
				
				for (counter = 0; counter < 5; counter++) {
					System.out.print(topics[counter] + "\t");
					
					for (i = 0; i < 10; i++) {
						System.out.print(responses[counter][i] + "\t");
										
					}
					
					System.out.println(avgRating[counter]);
				}
				
				x = 0;
				
				hSum = sum[x];
				lSum = sum[x];
				
				for (i = 0; i < 4; i++) {
					if (sum[x] < sum[i + 1]) {
						x = i + 1;
					}
				}
				
				hSum = sum[x];
				
				System.out.println("");
				
				System.out.println("The highest point total is " + topics[x] + ": " + hSum);
				
				
				x = 0;
				for (i = 0; i < 4; i++) {
					if (sum[i] > sum[i + 1]) {
						x = i + 1;
					}
				}
				
				lSum = sum[x];
				
				System.out.println("The lowest point total is " + topics[x] + ": " + lSum);

	}

}
