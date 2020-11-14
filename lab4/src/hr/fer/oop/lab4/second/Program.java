package hr.fer.oop.lab4.second;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Program {

	private static MySecondByteReader byteReader = new MySecondByteReader();
	private static final String RACUNI = "racuni/";
	private static final String OUTPUT_UTF8 = "cjenik.utf8.txt";
	private static final String OUTPUT_ISO = "cjenik.88592.txt";

	public static void main(String[] args) {

		Path input = Paths.get(RACUNI);

		try (Writer bw1 = new BufferedWriter(
				new OutputStreamWriter(new BufferedOutputStream(new FileOutputStream(OUTPUT_UTF8)), "UTF-8"));
				Writer bw2 = new BufferedWriter(new OutputStreamWriter(
						new BufferedOutputStream(new FileOutputStream(OUTPUT_ISO)), "ISO-8859-2"))) {

			Files.walkFileTree(input, byteReader);

			// bw.write(String.format("%-100s%s%n%n", "IME ARTIKLA", "CIJENA S PDV-om"));
			for (Artikl artikl : byteReader.articles) {
				bw1.write(artikl.toString());
				bw1.write("\r\n");
				bw2.write(artikl.toString());
				bw2.write("\r\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
