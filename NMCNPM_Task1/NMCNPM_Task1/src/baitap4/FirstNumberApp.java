package baitap4;
import java.util.Scanner;
public class FirstNumberApp {
public boolean primeNumber( int n) {
		
		int i;
		if (n<2) return false;
		else if (n==2) return true;
		else {
			for(i=2; i<n; i++) if (n%i==0) return false;
		}
		return true;
	}
	public boolean squareNumber(int n) {
		
		int i;
		for(i=0; i<(n/2); i++) {
			if (i*i==n) return true;
		}
		return false;
	}
	public boolean perfectNumner(int n) {
		
		int i=0, sum=0;
		for(i=1; i<=(n/2); i++) {
			if(n%i==0) sum=sum+i;
		}
		if (sum==n) return true;
		else return false;
		
	}
	 	

	public static void main(String[] args) {
		FirstNumberApp s = new FirstNumberApp();
		System.out.print("nhap so nguyen n: ");
		Scanner scan = new Scanner (System.in);
		int n = scan.nextInt();
		scan.close();
		if (s.primeNumber(n) == true) System.out.println(n + " la mot so nguyen to.");
		if (s.squareNumber(n) == true) System.out.println(n + " la mot so chinh phuong.");
		if (s.perfectNumner(n) == true) System.out.println(n + " la mot so hoan hao.");
		
	}
}
