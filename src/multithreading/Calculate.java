package multithreading;

import java.util.Scanner;

public class Calculate {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		int x=sc.nextInt();
		long result=0;
		for(int i=1;i<=1000;i++) {
			ThreadSum ts=new ThreadSum(i,x);
			ts.start();
			try{
				ts.join();
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
			result=result+ts.sum;
			
		}
		System.out.println(result);	
	}

}
