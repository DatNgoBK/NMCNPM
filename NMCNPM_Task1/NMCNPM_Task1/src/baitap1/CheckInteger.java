package baitap1;

import java.util.Scanner;

public class CheckInteger {

	int a;

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		CheckInteger b = new CheckInteger();
		b.input(s);

		b.checkPrimeOrCompisiteNumber();
		b.checkSquareNumber();
		b.checkPerfectNumber();

	}

	void input(Scanner s) {
		System.out.println("Nhap gia tri cua a :");
		a = s.nextInt();
	}

	void checkPrimeOrCompisiteNumber() {
		int dem = (int) (Math.sqrt(a) - 1);

		for (int i = 2; i <= (int) Math.sqrt(a); i++) {
			if (a % i == 0) {
				System.out.println("a la hop so");
				break;
			} else {
				dem--;
			}
		}

		if (dem == 0)
			System.out.println("a la so nguyen to");
	}

	void checkSquareNumber() {
		int x = (int) (Math.sqrt(a));

		if (a == x * x) {
			System.out.println("a la so chinh phuong");
		} else
			System.out.println("a khong la so chinh phuong");
	}

	void checkPerfectNumber() {
		int sum = 0;
		for (int i = 1; i <= (int) (a / 2); i++) {
			if (a % i == 0) {
				sum = sum + i;
			}
		}

		if (sum == a)
			System.out.println("a la so hoan hao");
		else
			System.out.println("a khong la so hoan hao");
	}

}
