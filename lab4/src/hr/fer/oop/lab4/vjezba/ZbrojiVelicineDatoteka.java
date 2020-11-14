package hr.fer.oop.lab4.vjezba;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.util.LinkedHashSet;

public class ZbrojiVelicineDatoteka<T> extends SimpleFileVisitor<Path> {

	private static final String DIR = "racuni/2003/";

	@Override
	public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
		return super.visitFile(file, attrs);
	}

	public static void main(String[] args) throws IOException {

		File[] size;

		Path input = Paths.get(DIR);
		BasicFileAttributes atributes = Files.readAttributes(input, BasicFileAttributes.class);

		Files.walkFileTree(input, size);
	}
}
