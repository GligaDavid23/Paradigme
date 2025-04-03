package ro.ulbs.paradigme.lab6.pb2;

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
