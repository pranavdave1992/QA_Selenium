package Selenium;

public class Test1 {
	
	static Test1 t1 = new Test1(); 							// Created as we are calling ScanMe static method

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello World!");
		printMe();
		System.out.println("I am not in Print me");
		t1.scanMe(); // Static method - Called by object name
		System.out.println("Static method Sum:- " + t1.sum());
		
		System.out.println("Calling overloading Sum method:- " + t1.sum(9,9));
		
		Test2 t2 = new Test2(5);
		//Test2 t2 = new Test2();							// To call another constructor and create an object
		Test2.testing1();  									// Calling other class's static method. No need of any object
		t2.testing2();
		
		Test3 t3 = new Test3();								// When creating the object inside static, no need to specify static 
		Test3.testing3();
		t3.testing4();
	}

	public static void printMe() {
		System.out.println("I am in Print me!");
	}
	
	public void scanMe() {
		// This is non-static function!
		System.out.println("I am in Scan me!");
	}
	
	public int sum() {
		int z = 4 + 9;
		return z;
	}
	
	public int sum(int a, int b) {
		int total = a + b;
		return total;
	}
}
