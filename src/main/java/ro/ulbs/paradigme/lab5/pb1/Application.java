/*Adaugati textul de mai jos in fisierul in.txt, si apoi
a) parcurgeti fiecare linie si adaugati inca un new line (caracterul \n) pentru fiecare sfarsit de linie, apoi
afisati
b) parcurgeti fiecare linie si adaugati un newline (caracterul \n) pentru fiecare caracter punct ( .) si apoi
afisati
c) salvati in fisierul out.txt rezultatul modificarilor de la a) si b)
Textul este:
Lorem ipsum dolor sit amet, vim ne eripuit vulputate. Vide tantas dicunt ne ius, mel pertinacia intellegebat
ei. Sea vidisse aperiam et, eu altera audiam percipitur vis, decore verterem ea nec. Veri quando ad est. Ex
quidam blandit nec, eos et percipit indoctum.
Summo putant consetetur cu vel. Id eum adipisci philosophia, eos commodo principes an. Duis eripuit
laoreet qui ne, pri maiorum detracto definitiones et. Sea quis laudem dolorem eu.*/


package ro.ulbs.paradigme.lab5.pb1;

import java.io.*;
import java.util.*;
import java.nio.file.*;

public class Application {
	public static void main(String[] args) {
		String inputFileName = "in.txt";
		String outputFileName = "out.txt";
		try {
			List<String> lines = readSmallTextFile(inputFileName);
			List<String> modifiedLinesA = addNewlineAtEndOfEachLine(lines);
			List<String> modifiedLinesB = addNewlineAfterEachPeriod(lines);
			printLines(modifiedLinesA);
			printLines(modifiedLinesB);
			writeSmallTextFile(modifiedLinesA, outputFileName);
			writeSmallTextFile(modifiedLinesB, outputFileName, true);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	static List<String> readSmallTextFile(String fileName) throws IOException {
		Path path = Paths.get(fileName);
		return Files.readAllLines(path);
	}

	static void printLines(List<String> lines) {
		for (String line : lines) {
			System.out.println(line);
		}
	}

	static List<String> addNewlineAtEndOfEachLine(List<String> lines) {
		List<String> modifiedLines = new ArrayList<>();
		for (String line : lines) {
			modifiedLines.add(line + "\n");
		}
		return modifiedLines;
	}

	static List<String> addNewlineAfterEachPeriod(List<String> lines) {
	    List<String> modifiedLines = new ArrayList<>();
	    String allText = String.join(" ", lines);
	    String[] sentences = allText.split("\\.");
	    for (String sentence : sentences) {
	        if (!sentence.trim().isEmpty()) {
	            modifiedLines.add(sentence.trim() + ".");
	        }
	    }
	    return modifiedLines;
	}

	static void writeSmallTextFile(List<String> lines, String fileName) throws IOException {
		Path path = Paths.get(fileName);
		Files.write(path, lines);
	}

	static void writeSmallTextFile(List<String> lines, String fileName, boolean append) throws IOException {
		Path path = Paths.get(fileName);
		if (append) {
			Files.write(path, lines, StandardOpenOption.APPEND);
		} else {
			Files.write(path, lines);
		}
	}
}
