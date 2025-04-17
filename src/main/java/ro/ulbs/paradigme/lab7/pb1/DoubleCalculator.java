package ro.ulbs.paradigme.lab7.pb1;

public class DoubleCalculator extends ACalculator {
	public DoubleCalculator(Double state) {
		this.state = state;
	}

	@Override
	public ACalculator init(Object state) {
		this.state = (Double) state;
		return this;
	}

	@Override
	public Double result() {
		return (Double)state;
	}

	@Override
	public Double clear() {
		state = 0.0;
		return (Double)state;
	}

	public DoubleCalculator add(Double state) {
		this.state = (double) this.state + (double) state;
		return this;
	}
	public DoubleCalculator subtract(Double state) {
		this.state = (double) this.state - (double) state;
		return this;
	}
	public DoubleCalculator multiply(Double state) {
		this.state = (double) this.state * (double) state;
		return this;
	}

	public DoubleCalculator divide(Double state) {
		if (state == 0.0) {
			throw new ArithmeticException("Division by zero for double");
		}
		this.state = (double) this.state / (double) state;
		return this;
	}
}
