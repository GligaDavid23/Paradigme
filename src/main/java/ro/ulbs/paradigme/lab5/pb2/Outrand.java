package ro.ulbs.paradigme.lab5.pb2;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class Outrand {
	private static final int WORD_LENGTH = (int)(Math.random() * 15);
	private static final int WORDS_PER_LINE = 10;
	private static final int LINES = (int)(Math.random() * 10);
	private static final String OUTPUT_FILE = "outrand.txt";

	public void generateOutrand() {
		List<String> lines = new ArrayList<>();
		Random random = new Random();

		for (int i = 0; i < LINES; i++) {
			List<String> words = new ArrayList<>();
			for (int j = 0; j < WORDS_PER_LINE; j++) {
				words.add(generateRandomWord(random));
			}
			Collections.sort(words);
			lines.add(String.join(" ", words));
		}

		try {
			writeToFile(lines, OUTPUT_FILE);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private String generateRandomWord(Random random) {
		StringBuilder word = new StringBuilder(WORD_LENGTH);
		for (int i = 0; i < WORD_LENGTH; i++) {
			word.append((char) ('a' + random.nextInt(26)));
		}
		return word.toString();
	}

	private void writeToFile(List<String> lines, String fileName) throws IOException {
		Path path = Paths.get(fileName);
		Files.write(path, lines);
	}
}