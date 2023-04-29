package circuitDec2022;

import java.util.Iterator;
import java.util.Scanner;

public class OddSum {


	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);

		int T = sc.nextInt();

		for (int i = 0; i < T; i++) {

			int N= sc.nextInt();
			int Q= sc.nextInt();

			;

			long prefixOddSum [] = new long  [N+1];

			prefixOddSum [0] =0;

			for (int j = 1; j <= N; j++) {
				int val  = 	sc.nextInt();

				if (val%2==0) {
					prefixOddSum[j] = prefixOddSum[j-1];
				}
				else {
					prefixOddSum[j] = prefixOddSum[j-1] +1;
				}
			}
			for (int j = 0; j < Q; j++) {
				int L= sc.nextInt();
				int R = sc.nextInt();

				long numberOdd = prefixOddSum[R] -  prefixOddSum[L-1];
				long numberEven =  R -L +1 - numberOdd;

				if (numberOdd==0) {
					System.out.print(0 + " ");
					continue;
				}
				//All threee odd numberOdd C 3 
				long fisrtTerm =0;
				if (numberOdd>=3) {
					fisrtTerm = (numberOdd*(numberOdd-1)*(numberOdd-2))/6;
				}

				//Only one odd
				// Odd Selection numberOdd
				// Even selection even c 2
				long secondTerm =0;

				if (numberEven>=2) {
					secondTerm = ( numberOdd * numberEven * (numberEven -1) )/2;
				}
				System.out.print((fisrtTerm+secondTerm) + " ");

			}
			System.out.println ();





		} // End of Test Case
	}
}
