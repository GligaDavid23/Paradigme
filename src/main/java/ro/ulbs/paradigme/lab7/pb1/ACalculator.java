package ro.ulbs.paradigme.lab7.pb1;

public abstract class ACalculator {
	public Object state;
	public Object result() {
		return  state;
	}
	public Object clear() {
		state =  0;
		return  state;
	}
	public abstract ACalculator init(Object state);
}
