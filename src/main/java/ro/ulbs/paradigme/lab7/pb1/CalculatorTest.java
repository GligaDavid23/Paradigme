package ro.ulbs.paradigme.lab7.pb1;

import org.junit.jupiter.api.*;
public class CalculatorTest {
	@Test
	public void testInitialization() {
		NewIntCalculator calculatorInt = new NewIntCalculator(5);
		Assertions.assertEquals(5, calculatorInt.result());
		DoubleCalculator calculatorDouble = new DoubleCalculator(5.0);
		Assertions.assertEquals(5.0, calculatorDouble.result());
		System.out.println("Initialization tests passed.");
	}

	@Test
	public void testAddIntPositive() {
		NewIntCalculator calculator1 = new NewIntCalculator(10);
		Assertions.assertEquals(20, calculator1.add(10).result());
	}

	@Test
	public void testAddIntNegative() {
		NewIntCalculator calculator1 = new NewIntCalculator(10);
		Assertions.assertEquals(0, calculator1.add(-10).result());
	}

	@Test
	public void testAddDoublePositive() {
		DoubleCalculator calculator2 = new DoubleCalculator(10.5);
		Assertions.assertEquals(20.5, calculator2.add(10.0).result());
	}

	@Test
	public void testAddDoubleNegative() {
		DoubleCalculator calculator3 = new DoubleCalculator(10.5);
		Assertions.assertEquals(0.5, calculator3.add(-10.0).result());
	}

	@Test
	public void testSubtractIntPositive() {
		NewIntCalculator calculator4 = new NewIntCalculator(10);
		Assertions.assertEquals(5, calculator4.subtract(5).result());
	}

	@Test
	public void testSubtractIntNegative() {
		NewIntCalculator calculator5 = new NewIntCalculator(10);
		Assertions.assertEquals(15, calculator5.subtract(-5).result());
	}

	@Test
	public void testSubtractDoublePositive() {
		DoubleCalculator calculator6 = new DoubleCalculator(10.5);
		Assertions.assertEquals(5.5, calculator6.subtract(5.0).result());
	}

	@Test
	public void testSubtractDoubleNegative() {
		DoubleCalculator calculator7 = new DoubleCalculator(10.5);
		Assertions.assertEquals(15.5, calculator7.subtract(-5.0).result());
	}

	@Test
	public void testMultiplyIntPositive() {
		NewIntCalculator calculator8 = new NewIntCalculator(10);
		Assertions.assertEquals(100, calculator8.multiply(10).result());
	}

	@Test
	public void testMultiplyIntNegative() {
		NewIntCalculator calculator9 = new NewIntCalculator(10);
		Assertions.assertEquals(-100, calculator9.multiply(-10).result());
	}

	@Test
	public void testMultiplyDoublePositive() {
		DoubleCalculator calculator10 = new DoubleCalculator(10.5);
		Assertions.assertEquals(105.0, calculator10.multiply(10.0).result());
	}

	@Test
	public void testMultiplyDoubleNegative() {
		DoubleCalculator calculator11 = new DoubleCalculator(10.5);
		Assertions.assertEquals(-105.0, calculator11.multiply(-10.0).result());
	}

	@Test
	public void testMultiplyIntBy0() {
		NewIntCalculator calculator12 = new NewIntCalculator(10);
		Assertions.assertEquals(0, calculator12.multiply(0).result());
	}

	@Test
	public void testMultiplyDoubleBy0() {
		DoubleCalculator calculator13 = new DoubleCalculator(10.5);
		Assertions.assertEquals(0.0, calculator13.multiply(0.0).result());
	}

	@Test
	public void testDivideIntPositives() {
		NewIntCalculator calculator14 = new NewIntCalculator(10);
		Assertions.assertEquals(2, calculator14.divide(5).result());
	}

	@Test
	public void testDivideIntNegatives() {
		NewIntCalculator calculator15 = new NewIntCalculator(10);
		Assertions.assertEquals(-2, calculator15.divide(-5).result());
	}

	@Test
	public void testDivideDoublePositives() {
		DoubleCalculator calculator16 = new DoubleCalculator(10.5);
		Assertions.assertEquals(2.1, calculator16.divide(5.0).result());
	}

	@Test
	public void testDivideDoubleNegatives() {
		DoubleCalculator calculator17 = new DoubleCalculator(10.5);
		Assertions.assertEquals(-2.1, calculator17.divide(-5.0).result());
	}

	@Test
	public void testDivideIntBy0() {
		NewIntCalculator calculator18 = new NewIntCalculator(10);
		ArithmeticException e1 = Assertions.assertThrows(
				ArithmeticException.class,
				() -> calculator18.divide(0)
		);
		Assertions.assertEquals("Division by zero for int", e1.getMessage());
	}

	@Test
	public void testDivideDoubleBy0() {
		DoubleCalculator calculator19 = new DoubleCalculator(10.5);
		ArithmeticException e2 = Assertions.assertThrows(
				ArithmeticException.class,
				() -> calculator19.divide(0.0)
		);
		Assertions.assertEquals("Division by zero for double", e2.getMessage());
	}
}
