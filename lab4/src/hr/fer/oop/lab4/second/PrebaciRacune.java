package hr.fer.oop.lab4.second;

import java.io.IOException;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PrebaciRacune {

	public static void main(String[] args) {

		FileVisitor<Path> premjesti = new PrivremeniRacun();
		FileVisitor<Path> ukupno = new Visitor();
		Path privremeni = Paths.get("racuni-privremeno/");

		try {
			System.out.println("prije");
			Files.walkFileTree(privremeni, ukupno);
			System.out.println("Racuna ima: " + ((Visitor) ukupno).brojRacuna + " a vrijednost je:  " + ((Visitor) ukupno).ukupnaVrijednost);
			Files.walkFileTree(privremeni, premjesti);
			System.out.println("poslije");
			Files.walkFileTree(privremeni, ukupno);
			System.out.println("Racuna ima: " + ((Visitor) ukupno).brojRacuna + " a vrijednost je:  " + ((Visitor) ukupno).ukupnaVrijednost);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
