package ro.ulbs.paradigme.lab7.pb1;

public class NewIntCalculator extends ACalculator {
	public NewIntCalculator(Integer state) {
		this.state = state;
	}

	@Override
	public ACalculator init(Object state) {
		this.state = (Integer) state;
		return this;
	}

	@Override
	public Integer result() {
		return (Integer) state;
	}

	@Override
	public Integer clear() {
		state = 0;
		return (Integer) state;
	}

	public NewIntCalculator add(Integer state) {
		this.state = (int) this.state + (int) state;
		return this;
	}
	public NewIntCalculator subtract(Integer state) {
		this.state = (int) this.state - (int) state;
		return this;
	}
	public NewIntCalculator multiply(Integer state) {
		this.state = (int) this.state * (int) state;
		return this;
	}

	public NewIntCalculator divide(Integer state) {
		if (state == 0) {
			throw new ArithmeticException("Division by zero for int");
		}
		this.state = (int) this.state / (int) state;
		return this;
	}
}