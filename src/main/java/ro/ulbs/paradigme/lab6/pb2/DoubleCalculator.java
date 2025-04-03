package ro.ulbs.paradigme.lab6.pb2;

public class DoubleCalculator extends ACalculator{
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
}
