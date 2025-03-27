/*
 5.3.2 Generati un fisier text outrand.txt, in care sa scrieti cuvinte de cate 4 caractere din intervalul [a..z]
alese aleator, cate 10 cuvinte pe linie, ordonate crescator, 5 linii.
 */

package ro.ulbs.paradigme.lab5.pb2;

import ro.ulbs.paradigme.lab5.pb2.Outrand;

public class Application {
	public static void main(String[] args) {
		Outrand outrand = new Outrand();
		outrand.generateOutrand();
	}

}
