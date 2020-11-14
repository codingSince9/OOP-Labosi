package hr.fer.oop.lab4.second;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.TreeSet;

public class MySecondByteReader implements FileVisitor<Path> {

	public TreeSet<Artikl> articles;

	public MySecondByteReader() {
		articles = new TreeSet<>();
	}

	@Override
	public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
		return FileVisitResult.CONTINUE;
	}

	@Override
	public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
		System.out.println("reading file :" + file.toString());
		if (file.toString().endsWith("txt")) {
			Artikl article;
			BufferedReader br = new BufferedReader(
					new InputStreamReader(Files.newInputStream(file, StandardOpenOption.READ)));
			while (true) {
				String line = br.readLine();
				line.trim();
				if (line.startsWith("UKUPNO")) {
					break;
				} else if (!line.isEmpty() && !line.startsWith("Proizvod") && !line.startsWith("Račun br")
						&& !line.startsWith("Kupac:") && !line.startsWith("---") && !line.endsWith("---")) {
					// String[] nazivCijena = line.split("\\s\\s+");
					article = new Artikl(line.substring(0, 78), Double.parseDouble(line.substring(79, 90)));
					this.articles.add(article);
				}
			}
		}
		return FileVisitResult.CONTINUE;
	}

	@Override
	public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
		return FileVisitResult.CONTINUE;
	}

	@Override
	public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
		return FileVisitResult.CONTINUE;
	}

	public TreeSet<Artikl> getArticles() {
		return articles;
	}

}
