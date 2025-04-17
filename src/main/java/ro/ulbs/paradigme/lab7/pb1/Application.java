package ro.ulbs.paradigme.lab7.pb1;

public class Application {
	public static void main(String[] args) {
		NewIntCalculator calculator = new NewIntCalculator(10);
		int result = (Integer)calculator.add(5).subtract(3).multiply(2).result();
		System.out.println("5.4.2 a) " + result);

		DoubleCalculator fCalculator = new DoubleCalculator(10.0);
		double result2 =
				(Double)fCalculator.add(5.0).subtract(3.3).multiply(2.2).init(fCalculator.result()).result();
		System.out.println("5.4.2 b) " + result2);
	}
}