package hr.fer.oop.lab4.first;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class MultipleFileProgram {

	private static FileVisitor<Path> byteReader;
	private static final String DIR = "racuni/";
	private static final String OUTPUT = "multiout.txt";

	public static void main(String[] args) {
		Path input = Paths.get(DIR);
		Path output = Paths.get(OUTPUT);
		
		try(OutputStream os = Files.newOutputStream(output, StandardOpenOption.CREATE)) {
			byteReader = new MyByteReader(os);
			Files.walkFileTree(input, byteReader);
			System.out.println("File created in: " + output.toAbsolutePath());
		}
		catch (IOException e) {
			System.err.println(e);
		}	
	}
}
