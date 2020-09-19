package com.Algo;


public class SolutionAlgo2 {
	 public static int[] solution(int[] a, int[] b) {
	        int[] result = new int[a.length];
	        int max_a = getMax(a);
	        int max_b = getMax(b);
	        int[] tab = createTab(max_a, max_b);	        

	        for (int i = 0; i<a.length; i++) {
	            result[i] = tab[a[i]] % (int) Math.pow(2, b[i]);
	        }
	        return result;
	    }

	    private static int getMax(int[] tab) {
	        int max = tab[0];
	        for (int i = 0; i<tab.length; i++) {
	            if (tab[i] > max) {
	                max = tab[i];
	            }
	        }
	        return max;
	    }

	    public static int[] createTab(int max_a, int max_b) {
	        int[] tab = new int[max_a+1];
	        int prev  = 1;
	        int current = 1;
	        tab[0] = 1;
	        tab[1] = 1;
	        int i = 3;

	        while (i <= max_a+1){
	            int temp = current;
	            current = (prev + current)  % (int) Math.pow(2, max_b);
	            prev = temp;
	            tab[i-1] = current;
	            i++;
	        }
	        return tab;
	    }
	    
	    public static void main(String[] args){
	    	int[] A = new int[] { 4, 4, 5,5, 1 };
	    	int[] B = new int[] { 3, 2,4,3,1};
			for (int i:solution(A,B))
				System.out.println(i); 
	    }     
		
	}
