package baitap2;
import java.util.Scanner;

public class ComplexNumber {
	double real;
	double imaginairy;
	public ComplexNumber(){
		real = 0;
		imaginairy = 0;
	}
	
	public ComplexNumber(double real, double imaginairy) {
		this.real = real;
		this.imaginairy = imaginairy;
	}

	public double outputToReal(){
		return this.real;
	}
	
	public double outputToImaginairy(){
		return this.imaginairy;
	}
	
	public String printComplexNumber(){
		if(this.imaginairy > 0)
			return this.real+"+"+this.imaginairy+"i";
		else if(this.imaginairy < 0)
			return this.real+"-"+(-this.imaginairy)+"i";
		else return this.real+"";
	}
	
	public ComplexNumber plusComplexNumber(ComplexNumber num){
		ComplexNumber result = new ComplexNumber();
		result.real = this.real + num.real;
		result.imaginairy = this.imaginairy + num.imaginairy;
		return result;
	}
	
	public ComplexNumber minusComplexNumber(ComplexNumber num){
		ComplexNumber result = new ComplexNumber();
		result.real = this.real - num.real;
		result.imaginairy = this.imaginairy - num.imaginairy;
		return result;
	}
	
	public ComplexNumber timesComplexNumber(ComplexNumber num){
		ComplexNumber result = new ComplexNumber();
		result.real = this.real*num.real - this.imaginairy*num.imaginairy;
		result.imaginairy = this.real*num.imaginairy + this.imaginairy*num.real;
		return result;
	}
	
	public ComplexNumber dividesComlexNumber(ComplexNumber num){
		if(num.real != 0 || num.imaginairy!=0)
		{
			ComplexNumber result = new ComplexNumber();
			result.real = (this.real*num.real + this.imaginairy*num.imaginairy)/(Math.pow(num.real, 2) + Math.pow(num.imaginairy, 2));
			result.imaginairy = (num.real*this.imaginairy - this.real*num.imaginairy)/(Math.pow(num.real, 2) + Math.pow(num.imaginairy, 2));
			return result;
		}
		else{
			System.out.println("Khong the chia cho so phuc co gia tri 0!");
			return null;
		}
	}
	
	public ComplexNumber timesRealNumber(double num){
		ComplexNumber result = new ComplexNumber();
		result.real = this.real * num;
		result.imaginairy = this.imaginairy * num;
		return result;
	}
	
	public static void main(String []args){
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap so phuc thu nhat : ");
		System.out.print("Nhap phan thuc : ");
		Double temp1 = sc.nextDouble();
		System.out.print("Nhap phan ao : ");
		Double temp2 = sc.nextDouble();
		ComplexNumber a = new ComplexNumber(temp1, temp2);
		System.out.println("Nhap so phuc thu hai : ");
		System.out.print("Nhap phan thuc : ");
		temp1 = sc.nextDouble();
		System.out.print("Nhap phan ao : ");
		temp2 = sc.nextDouble();
		ComplexNumber b = new ComplexNumber(temp1 ,temp2);
		System.out.println("So phuc thu nhat la a = "+a.printComplexNumber());
		System.out.println("So phuc thu hai la b = "+b.printComplexNumber());
		System.out.println("Tong cua a + b = "+a.plusComplexNumber(b).printComplexNumber());
		System.out.println("Hieu cua a - b = "+a.minusComplexNumber(b).printComplexNumber());
		System.out.println("Tich cua a * b = "+a.timesComplexNumber(b).printComplexNumber());
		System.out.println("Thuong của a / b = "+a.dividesComlexNumber(b).printComplexNumber());
		System.out.print("Nhap so thuc c = ");
		Double temp3 = sc.nextDouble();
		System.out.println("Tich a * c = "+a.timesRealNumber(temp3).printComplexNumber());
		System.out.println("Tich b * c = "+b.timesRealNumber(temp3).printComplexNumber());
	}
}
