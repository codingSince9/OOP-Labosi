package hr.fer.oop.lab4.second;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.BasicFileAttributes;

public class Visitor extends SimpleFileVisitor<Path> {

	protected double ukupnaVrijednost;
	protected int brojRacuna;

	public Visitor() {
		brojRacuna = 0;
		ukupnaVrijednost = 0;
	}

	public int getBrojRacuna() {
		return brojRacuna;
	}

	public double getVrijednost() {
		return ukupnaVrijednost;
	}

	@Override
	public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
		return FileVisitResult.CONTINUE;
	}

	@Override
	public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
		if (file.toString().endsWith("txt")) {
			brojRacuna++;
			BufferedReader br = new BufferedReader(new InputStreamReader(Files.newInputStream(file, StandardOpenOption.READ)));
			while (true) {
				String line = br.readLine();
				if (!line.startsWith("UKUPNO"))
					continue;
				else {
					String[] parts = line.split("\\s\\s+");
					ukupnaVrijednost += Double.parseDouble(parts[1]);
					break;
				}
			}
		}
		return FileVisitResult.CONTINUE;
	}

	@Override
	public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
		return FileVisitResult.CONTINUE;
	}

}
