package com.shane.euler;

import java.util.ArrayList;
import java.util.List;

public class LargestPrimeFactors {

		public static List<Long> getPrimeFactors(long n){
			List<Long> factors = new ArrayList();
			int i=2;
			while (n>1){
				while(n%i==0){
				factors.add((long)i);
				n/=i;
				}
				i++;
				if(i*i>n){
					if(n>1){
						factors.add(n);
						
					}
					break;
				}
			}
			
			
			
			return factors;
		}
}
