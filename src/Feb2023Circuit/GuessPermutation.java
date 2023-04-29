package Feb2023Circuit;

import java.util.Scanner;

public class GuessPermutation {
	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		int T = sc.nextInt();

		for (int i = 0; i < T; i++) {
			int N = sc.nextInt();
			
			int arrPermutationArr [] =  new int [N+1];
			 
			int minVal = 0;
		
			for (int j = 1; j < N+1; j++) {			
				arrPermutationArr [j] = arrPermutationArr [j-1] + sc.nextInt();
				if (arrPermutationArr [j] <minVal) {
					minVal = arrPermutationArr [j];
				}
							
			}
			if (N==1) {
				if (arrPermutationArr [1] ==1 || arrPermutationArr [1] ==-1) {
					System.out.println(1);
				}
				else {
					System.out.println(-1);
				}
				continue;
			}
 
			
			boolean resultFound = true;
			int [] containsValue = new int [N+2];
			for (int j = 0; j < N+1; j++) {	
				arrPermutationArr[j] = arrPermutationArr[j] - minVal + 1;
				int val = arrPermutationArr[j];
				if (val >0 && val <N+2) {
					containsValue [val]=1;
				}			
			}
			for (int j = 1; j <= N+1; j++) {	 
				if (containsValue [j]!=1) {
					resultFound =false;
					break;
				}
			}
			if (resultFound) {
				for (int j = 0; j < N+1; j++) {	 
					System.out.print(  arrPermutationArr[j] + " ");
				}
			}
			else {
				System.out.print(-1);
			}
			System.out.println();
		}
	}

}


 
