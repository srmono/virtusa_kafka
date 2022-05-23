package oops;

public class Demo {

	public static void main(String[] args) {
		
		//Create Student Object
		Student st1;
		st1 = new Student();
		
		st1.studentName = "Venkat";
		st1.studentId = 1;
		st1.studentCity = "Bangalore";
		
		//System.out.println(st1.studentCity);
		
//		st1.study();
//		st1.getStudentDetails();
		
		Student st2;
		st2 = new Student(2, "Raj", "Chennai");
		
//		st2.studentName = "Raj";
//		st2.studentId = 2;
//		st2.studentCity = "Chennai";
		
//		st2.study();
//		st2.getStudentDetails();
		
		Dog d1 = new Dog();
		d1.eating();
		d1.speak();
		System.out.println(d1.color);

	}

}










