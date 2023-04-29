package circuitJan2023;

import java.util.Iterator;
import java.util.Scanner;

public class SmallestArray {

	public static void main(String[] args) {


		Scanner sc = new Scanner (System.in);

		int N = sc.nextInt();
		long  K = sc.nextLong();
		long [] A = new long [N];
		long [] L = new long [N];
		long [] R = new long [N];

		for (int i = 0; i < N; i++) {
			A[i] = sc.nextLong();
		}
		for (int i = 0; i < N; i++) {
			L[i] = sc.nextLong();
		}
		for (int i = 0; i < N; i++) {
			R[i] = sc.nextLong();
		}
		long absSum=0;
		// First start with minimum ie L[i]
		for (int i = 0; i < N; i++) {
			long abs = Math.abs( A[i] - L[i]);
			absSum +=abs;
		}
		boolean resultFound = false;
		if (absSum>K) { // If sum is more than K then our task will be to reduce 
			// the abs values in reverse order to keep output array lexicographically smallest

			for (int i = N-1; i >=0; i--) {

				if (A[i] <=L[i]) { // No reduction possible
					continue;	
				} 
				long currentAbsGap = A[i] - L[i];
				if  ( (A[i] >L[i]) &&  (A[i] <=R[i])  ) { // If in between
					if ((absSum - currentAbsGap ) <=K) { // Gap can reduced to minimum zero
						resultFound =true;
						long gapReductionNeeded = (absSum - K);
						L[i] = L[i] +  gapReductionNeeded;
						break;
					}
					else {
						L[i] = A[i];
						absSum-=currentAbsGap; // Gap will become zero, so sum 
						//will reduce by current gap
						continue;
					}
				}
				else {  // if A[i] is bigger than R[i]

					long minGap = A[i] - R[i];
					long reductionPossible =  currentAbsGap - minGap;

					if ((absSum - reductionPossible ) <=K) {

						resultFound =true;
						long gapReductionNeeded =  (absSum - K);
						L[i] = L[i] + gapReductionNeeded  ;
						break;

					}
					else {						
						absSum-=R[i]-L[i]; //   sum 
						//will reduce by current gap betwenn left and right
						L[i] = R[i];
						continue;
					}			
				}
			}

		}
		else if (absSum<K)  {  // We need to increase the gap by adjusting from the 
			for (int i = N-1; i >=0; i--) {	
				if (A[i] >R[i]) { // No increase  possible
					continue;	
				} 
				long currentAbsGap = A[i] - L[i];
				if  ( (A[i] >=L[i]) &&  (A[i] <=R[i])  ) { // If in between  
                                                           // Then check if gap with Right side (R[i] ) is larger.
					                                       // If larger then use that gap
					long rightSideGap = R[i] - A[i]; 
					
					if (rightSideGap<=currentAbsGap) {
						continue;	// Already Gap is maximum at left limit
					}
					long gapIncreasePossible = rightSideGap - currentAbsGap;
					
					if  ((absSum + gapIncreasePossible ) >=K) {
						resultFound =true;
						long  gapIncreaseNeeded =   (  K - absSum);
						L[i] = A[i] + currentAbsGap + gapIncreaseNeeded  ;
						break;
					}
					else {
						absSum = absSum + gapIncreasePossible;
						L[i] = R[i];
						continue;
					}
 
				}
				else {  // If A[i]  less than lower limit B[i
					
					long gapIncreasePossible = R[i] - L[i];
					if  ((absSum + gapIncreasePossible ) >=K) {
						resultFound =true;
						long  gapIncreaseNeeded =  (  K - absSum);
						L[i] = L[i] + gapIncreaseNeeded  ;
						break;
					}
					else {
						absSum = absSum + gapIncreasePossible;
						L[i]=R[i];
						continue;
					}
				}
			}
		}
		else {
			resultFound =true;  // No adjustment required
		}
		if (resultFound) {
			for (long i: L) {
				System.out.print(i + " ");
			}
		}
		else {
			System.out.println(-1);
		}


	}
}
