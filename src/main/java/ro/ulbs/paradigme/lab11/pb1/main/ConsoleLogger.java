package ro.ulbs.paradigme.lab11.pb1.main;

import java.util.Observer;
import java.util.Observable;
// TODO make this class Observer, by implementing java.util.Observer interface
public class ConsoleLogger  implements Observer{

    // TODO upon each notification, print to console

	@Override
	public void update(Observable o, Object arg) {
		System.out.println("Notification received from subject: " + o);
		System.out.println("Data received: " + arg);
	}
}
