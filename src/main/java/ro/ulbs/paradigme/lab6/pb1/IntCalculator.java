package ro.ulbs.paradigme.lab6.pb1;

public class IntCalculator {
	int state;
	public IntCalculator(int state) {
		this.state = state;
	}
	public IntCalculator add(int a) {
		this.state = this.state + a;
		return this;
	}
	public IntCalculator subtract(int a) {
		this.state = this.state - a;
		return this;
	}
	public IntCalculator multiply(int a) {
		this.state = this.state * a;
		return this;
	}
	public int result() {
		return this.state;
	}
	public int clear() {
		this.state = 0;
		return state;
	}
}
