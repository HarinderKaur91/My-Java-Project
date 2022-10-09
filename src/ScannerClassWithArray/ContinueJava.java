package ScannerClassWithArray;

public class ContinueJava {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int rollNumber=1;rollNumber<=10;rollNumber++) {
			if(rollNumber==4) {
				continue;		//skips the current iteration
			}
			System.out.println(rollNumber);
		}
	}

}
