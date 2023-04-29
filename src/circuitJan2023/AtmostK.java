package circuitJan2023;

import java.util.Arrays;
import java.util.Scanner;

public class AtmostK {

	public static void main(String[] args) {

		 
		
		Scanner sc = new Scanner (System.in);

		int T = sc.nextInt();

		for (int i = 0; i <T; i++) {

			int N = sc.nextInt();
			int K = sc.nextInt();
			int [] charCount = new int [26]; // 26 values for all smaller-case char count
			String input = sc.next();
			for (int j = 0; j <N; j++) {
				int val = input.charAt(j);
				charCount [val-97]++;
			}
			int max = Arrays.stream(charCount ).max().getAsInt();
			int output =  max/K;
			if (max % K==0) {
				System.out.println(output);
			}
			else {
				System.out.println(output +1);
			}
			
		}

	}
}
