package com.Algo;

public class SolutionAlgo1 {
	
	public  static int[] Solution(int N, int[] A) {
		
		int[] result =  new int[N];
		for(int i: A){
			if (i==N+1){
				max_counter(result);
			}
			if (i >= 1 && i <= N) {
				int j = i-1;
				result[j]=result[j]+1;
			}
		}
		return result;		
	}
	
	public static void max_counter(int[]result){
		int max = get_max_counter(result);
		for(int i=0;i< result.length;i++){
			result[i]= max;
		}
	}
	
	public static int get_max_counter(int[]result){
		int max=0;
		for(int i: result){
			if(i>max){
			max= i;				
			}
		}
		return max;
	}
	
	public static void main(String[] args){
		int[] A = new int[] { 3, 4, 4,6, 1,4,4 };
		int N= 5;
		for (int i:Solution( N, A))
			System.out.println(i); 
	}
}
