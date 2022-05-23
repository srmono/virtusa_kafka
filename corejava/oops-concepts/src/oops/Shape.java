package oops;

public interface Shape {

	public static final int i = 36;
	
	public abstract void clacArea(int r);
	
}

class Circle implements Shape {
	@Override
	public void clacArea(int r) {
		// TODO Auto-generated method stub
		System.out.println("Area of circle" + (Math.PI * r * r));
	}
	
	public static void main(String[] args) {
		Shape circle = new Circle();
		circle.clacArea(30);
	}
}



