package javafundamentals;

import java.util.Scanner;

public class FirstJavaClass {

	public static void main(String[] args) {
		
		//System.out.println("I Love Java");
		
		//Variable
		// int, float, chat, String, long, double
//		int num = 18;
//		float avgMarks = 19.345f;
//		char grade = 'A';
//		String name = "Venkat";
//		boolean isValid = true;
//		
//		long bigNUmber = 798797970970l;
//		
//		System.out.println(bigNUmber);
		
		// Operators 
		//  +, -, /, *, %, ++, --
		
//		int firstNumber = 1234;
//		int secondNumber = 234;
//		
//		//casting data type
//		double myVal = 34.34;
//		int myInt = (int)myVal;
//		
//		double res = (double)firstNumber % (double)secondNumber;
		
//		int a = 12;
//		//a += 1;
//		
//		System.out.println(++a);
		
		//Taking user input
		
//		Scanner sc = new Scanner(System.in);
//		System.out.println("Enter your Name: ");
//		String name =  sc.nextLine();
//		
//		System.out.println( name );

		//Conditional Statements
		
//		int age = 19;
//		
//		if( age > 18 ) {
//			System.out.println("You can vote");
//		} else {
//			System.out.println("Yout can't vote" );
//		}
		
//		boolean isEqual = 18 == 18;
//		
//		System.out.println(isEqual );
		
		//char grade = 'D';
		
//		if( grade == 'A') {
//			System.out.println(" Your grade is very good");
//		} else if(grade == 'B') {
//			System.out.println(" Your grade is  good");
//		} else if(grade == 'D') {
//			System.out.println(" Your grade is  improving");
//		} else {
//			System.out.println("grade is  not found");
//		}
		
		// Switch Case
		
//		char grade = 'A';
//		
//		switch(grade) {
//		case 'A': 
//			System.out.println(" Your grade is very good");
//			break;
//		case 'B': 
//			System.out.println(" Your grade is  good");
//			break;
//		case 'C': 
//			System.out.println(" Your grade is ok");
//			break;
//		default: 
//			System.out.println(" grade not found");
//		}
		
		// &&, ||
		
		// loops 
		
		// for, while, do-while
		
//		for(int i = 0; i < 10; i++) {
//			System.out.println("Venkat " + i );
//		}
		
//		int a  = 23;
//		while( a <= 100) {
//			System.out.println(a);
//			a++;
////			if( a < 100) {
////				break;
////			}
//		}
		
//		int a = 23;
//		
//		do {
//			System.out.println(a);
//			a++;
//		} while(a > 100);
		
		//Array 
		// 23, 45, 67, 99, 67
		
//		int marks[] = new int[5];
//		
//		marks[0] = 23;
//		marks[1] = 63;
//		marks[2] = 72;
//		marks[3] = 89;
//		marks[4] = 92;
		
		//System.out.println(marks[3]);
		
//		int marks[] = { 23, 45, 67, 89, 34, 67, 78 };
//		
//		for( int i = 0; i < marks.length; i++) {
//			System.out.println(marks[i]);
//		}
		
		//int a[][] = new int[2][3];
		
//		int a[][] = {
//				{1, 2},
//				{3, 4}
//		};
//		
//		System.out.println(a[0][1]);
		
		//call Methods
		//System.out.println(average(3, 6));
		
		//exception handling
		int a[] = new int[3];
		
		try {
			System.out.println(a[4]);
		} catch (ArrayIndexOutOfBoundsException e) {
			// TODO: handle exception
			System.out.println(" Error in array");
			System.out.println(e.getLocalizedMessage());
		};
		
		System.out.println(" here is someting ");
		
	}

	//Methods 
	static int average(int firstNumber, int secondNUmber){
		int sum = firstNumber + secondNUmber;
		return sum / 2;
	}
	
}

















