package oops;

public class MyChild extends MyClass {


	public void launchProduct() {
		// TODO Auto-generated method stub
		System.out.println("Launching product this week");
	}


}

class Start{
	public static void main(String[] args) {
		MyChild myChild = new MyChild();
		
		myChild.launchProduct();
		myChild.cal();
	}
}
