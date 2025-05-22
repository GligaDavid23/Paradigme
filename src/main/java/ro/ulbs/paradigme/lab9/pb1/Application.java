/*9.3.1 Creati o lista de 10 numere intregi aleatoare in intervalul [5..25]
a) Calculati suma elementelor folosind java streams si afisati.
b) Calculati valoarea maxima si minima in lista. Afisati.
c) Parcurgeti lista si creati o alta lista prin pastrarea doar a elementelor in intervalul [10..20]. Afisati.
d) Folosind stream transformati (mapati) lista de intregi in alta lista care sa contina valori Double. Afisati.
e) Afisati daca in lista se gaseste valoarea 12.*/


package ro.ulbs.paradigme.lab9.pb1;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public class Application {
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < 10; i++) {
			list.add(5 + (int) (Math.random() * 21));
		}
		//a) Calculati suma elementelor folosind java streams si afisati.
		int sum = list.stream().mapToInt(Integer::intValue).sum();
		System.out.println("Suma elementelor: " + sum);
		//b) Calculati valoarea maxima si minima in lista. Afisati.
		int max = list.stream().mapToInt(Integer::intValue).max().getAsInt();
		System.out.println("Max elementelor: " + max);
		int min = list.stream().mapToInt(Integer::intValue).min().getAsInt();
		System.out.println("Min elementelor: " + min);
		//c) Parcurgeti lista si creati o alta lista prin pastrarea doar a elementelor in intervalul [10..20]. Afisati.
		List<Integer> filteredList = list.stream().filter((x) -> { return x>=10 && x<=20;}).collect(Collectors.toList());
		System.out.println("Lista filtrata: " + filteredList);
		//d) Folosind stream transformati (mapati) lista de intregi in alta lista care sa contina valori Double. Afisati.
		List<Double> doubleList = list.stream().map((x) -> { return x.doubleValue(); } ).collect(Collectors.toList());
		System.out.println("Lista de Double: " + doubleList);
		//e) Afisati daca in lista se gaseste valoarea 12.
		System.out.println("Lista contine 12:" + list.stream().map((x)->x==12).reduce(false, (a,b)->a||b));
	}
}
