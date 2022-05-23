package javafundamentals;

public class DoublePrinter {
	Double dataToPrint;
	
	public DoublePrinter(Double dataToPrint) {
		this.dataToPrint = dataToPrint;
	}
	
	public void print() {
		System.out.println(dataToPrint);
	}
}
