package multithreading;

public class ThreadSum extends Thread {
	private int point;
	long sum=0;
	private int x;
	
	ThreadSum(int point,int x){
		this.point=point;
		this.x=x;
	}
	@Override
	public void run() {
		for (long i = (point-1)*1000000; i < (point*1000000); i++) { 
			boolean a=String.valueOf(i).contains(String.valueOf(x));
			if (a) {
				sum=sum+i;
			}
			}
	}
	
   
		
	
}
