package javafundamentals;

public class Printer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		IntegerPrinter printer = new IntegerPrinter(18);
//		
//		printer.print();
//		
//		DoublePrinter dPrinter = new DoublePrinter(35.68);
//		
//		dPrinter.print();
		
		GenericPrinter<Integer> printer = new GenericPrinter<Integer>(23);
		printer.print();
	}

}
