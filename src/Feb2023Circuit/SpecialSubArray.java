package Feb2023Circuit;

import java.util.Iterator;
import java.util.Scanner;

public class SpecialSubArray {

	
	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner (System.in);
		int T = sc.nextInt();
		
		for (int i = 0; i < T; i++) {
			int N = sc.nextInt();
			
			int [] prefixSum = new int [N+1];
			int [] prefixXorSum = new int [N+1];
			
			prefixSum [0]=0;
			prefixXorSum [0]=0;
			int count =0;
			for (int j = 1; j <=N; j++) {				
				int val = sc.nextInt();
				prefixSum[j]=prefixSum[j-1] + val;
				prefixXorSum[j]=prefixXorSum[j-1] ^ val;
			}
			
			for (int j = 0; j <N; j++) {
				 for (int k = j+1; k <= N; k++) {
					
					 int sumValue =  prefixSum[k] -prefixSum[j];
					 int xorValue =  prefixXorSum[k] ^ prefixXorSum[j];
					 if (sumValue==xorValue)  {
						 count++;
					 }
				}
				
			}
			System.out.println(count);
			
		}
		
		
	}
}
