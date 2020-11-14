package hr.fer.oop.lab4.second;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class PrivremeniRacun extends SimpleFileVisitor<Path> {

	@Override
	public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
		return FileVisitResult.CONTINUE;
	}

	@Override
	public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {

		if (file.toString().endsWith("txt")) {
			String racun = file.getFileName().toString();
			String[] dijeloviRacuna = racun.split("_");
			String godina = dijeloviRacuna[2];
			String mjesec = dijeloviRacuna[3].substring(0, dijeloviRacuna[3].length() - 4);
			Path noviFajl = Paths.get("racuni/" + godina + "/" + mjesec + "/");

			if (!noviFajl.toFile().exists()) {
				noviFajl.toFile().mkdir();
			}
			file.toFile().renameTo(Paths.get(noviFajl.toString() + "/Racun_" + dijeloviRacuna[1] + ".txt").toFile());
		}
		return FileVisitResult.CONTINUE;
	}

	@Override
	public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
		return FileVisitResult.CONTINUE;
	}
}
