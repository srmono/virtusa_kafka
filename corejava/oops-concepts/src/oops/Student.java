package oops;

public class Student {
	
	//Data: data members: instance variable
	int studentId;
	String studentName;
	String studentCity;
	
	//Constructor
	public Student() {
		//this(99);
		this(1, "raj", "mumbai");
		System.out.println("*********Creating Object***********");
	}
	
	public Student(int st) {
		System.out.println("*********parameterized constructor***********");
	}
	
	public Student(float st) {
		System.out.println("*********parameterized constructor***********");
	}
	
	public Student(int studentId, String studentName, String studentCity) {
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentCity = studentCity;
	}
	
	public Student(String n, int i,  String c) {
		studentId = i;
		studentName = n;
		studentCity = c;
	}
	
	//Behaviour: member methods : methods : functions
	public void study(){
		System.out.println(studentName + " is studying");
		//System.out.println(this.studentName + " is studying");
	}
	
	public void getStudentDetails() {
		System.out.println("Student name is " + studentName);
		System.out.println("Student id is " + studentId);
		System.out.println("Student city is " + studentCity);
	}
}
