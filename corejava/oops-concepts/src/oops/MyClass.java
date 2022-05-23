package oops;

abstract public class MyClass {
	
	//complete method
	public void cal() {
		System.out.println("Calculating results");
	}
	
	//abstract method
	abstract public void launchProduct();
	
}

//abstract class can not be instantiated
//
//class Start{
//	public static void main(String[] args) {
//		MyClass myclass = new MyClass();
//	}
//}