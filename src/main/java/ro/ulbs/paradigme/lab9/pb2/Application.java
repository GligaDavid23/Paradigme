/*9.3.2 Avand lista de numere 9, 10, 3, 4, 7, 3, 4. Construiti o lista noua in care sa introduceti patratele
valorilor din prima lista retinand doar elementele distincte.*/

package ro.ulbs.paradigme.lab9.pb2;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Application {
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		list.add(9);
		list.add(10);
		list.add(3);
		list.add(4);
		list.add(7);
		list.add(3);
		list.add(4);
		ArrayList<Integer> squaredDistinctList = new ArrayList<>();
		squaredDistinctList = list.stream().distinct().map(x->x*x).collect(Collectors.toCollection(ArrayList::new));
		System.out.println("Lista initiala: " + list);
		System.out.println("Lista modificata: " + squaredDistinctList);
	}
}
