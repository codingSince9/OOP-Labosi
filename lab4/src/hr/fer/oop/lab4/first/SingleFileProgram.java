package hr.fer.oop.lab4.first;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SingleFileProgram {

	private static MyByteWriter byteWriter;
	private static final String INPUT = "racuni3/2003/1/Racun_0.txt";
	private static final String OUTPUT = "singleout.txt";

	public static void main(String[] args) {

		Path input = Paths.get(INPUT);
		Path output = Paths.get(OUTPUT);

		try (InputStream is = Files.newInputStream(input)) {
			byteWriter = new MyByteWriter(is, output);
			byteWriter.run();
			System.out.println("File created in: " + output.toAbsolutePath());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
