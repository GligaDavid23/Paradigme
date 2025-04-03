package ro.ulbs.paradigme.lab6.pb1;

public class Application {
	public static void main(String[] args) {
		IntCalculator calculator = new IntCalculator(10);
		int result = calculator.add(5).subtract(3).multiply(2).result();
		System.out.println("a) " + result);
	}
}
