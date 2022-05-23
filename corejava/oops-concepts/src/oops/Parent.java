package oops;

class A{}

class B extends A{}

public class Parent {

	protected A m1() {
		System.out.println("I am method one of parent");
		return new A();
	}
}

//public  > protect > default > private

class Child extends Parent{
	
	protected B m1() {
		System.out.println("I am a method from Child");
		return new B();
	}
}
