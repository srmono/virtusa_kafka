package javafundamentals;

public class GenericPrinter<T> {

	T dataToPrint;
	
	public GenericPrinter(T dataToPrint) {
		this.dataToPrint =  dataToPrint;
	}
	
	public void print() {
		System.out.println(dataToPrint);
	}
}
