
public class DemoDebug {
	
	public static int addition(int a, int b) {
		int c = a+b;
		return c;
	}

	public static void main(String[] args) {
		int i = 10;
		int j = 20;
		int k = 0;
		
		k = addition(i,j);
		//int x = 30;
		int y = 0;
		
		y = k+j;
		y = y+20;
		System.out.println("y = "+y);
		
		


	}

}
