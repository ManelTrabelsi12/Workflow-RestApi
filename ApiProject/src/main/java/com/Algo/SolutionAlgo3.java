package com.Algo;


public class SolutionAlgo3 {
	public static int Solution(int[] A){
		int size = A.length;
		int[] s = new int[size];
		int i =0;
		int sum = 0;
		while(i<size){
			s[i] =-1;
			if(i+1<size){
				s[i+1]=1;
			}	
				i= i+2;				
		}
		int l=0;
		while (l<size){
			sum=sum+(A[l]*s[l]);
			l++;
		}			
		return (Math.abs(sum));
	}
	
	public static void main(String[] args){
		int[] A = new int[] { 1, 5, 2,-2 };
		System.out.println(Solution(A));
	}
	

}
