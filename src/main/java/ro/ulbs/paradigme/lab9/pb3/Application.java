/*9.3.3 Avand lista "Acesta este un program scris cu java 8 si expresii lambda".
a) parcurgeti lista si numarati cuvintele ale caror lungime este mai mare sau egala de 5 caractere. Afisati
noua lista.
b) ordonati lista noua si apoi afisati
c) afisati un element care incepe cu litera 'p'*/

package ro.ulbs.paradigme.lab9.pb3;

import java.util.*;

public class Application {
	public static void main(String[] args) {
		String string = "Acesta este un program scris cu java 8 si expresii lambda";
		List<String> list = List.of(string.split(" "));
		//a) parcurgeti lista si numarati cuvintele ale caror lungime este mai mare sau egala de 5 caractere. Afisati noua lista.
		System.out.println("Lista initiala: " + list);
		List<String> filteredList = list.stream().filter(x -> x.length() >= 5).toList();
		System.out.println("Lista filtrata: " + filteredList + " cu lungime >= 5 sunt "  + list.stream().filter(x->x.length()>=5).count());
		//b) ordonati lista noua si apoi afisati
		List<String> filteredSortedList = filteredList.stream().sorted().toList();
		System.out.println("Lista filtrata si sortata: " + filteredSortedList);
		//c) afisati un element care incepe cu litera 'p'
		Optional<String> pWord = list.stream().filter(x->x.startsWith("p")).findFirst();
		if(pWord!=null)
			System.out.println("Primul cuvant ce incepe cu p este: " + pWord);
		else
			System.out.println("Nu exista vreun cuvant ce incepe cu p");
	}
}
