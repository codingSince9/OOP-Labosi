package hr.fer.oop.lab4.first;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.BasicFileAttributes;

public class MyByteReader implements FileVisitor<Path> {
	private BufferedOutputStream output;

	public MyByteReader(OutputStream stream) {
		this.output = new BufferedOutputStream(stream);
	}

	@Override
	public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
		System.out.println("Sent directory to buffer: " + dir.toString());
		return FileVisitResult.CONTINUE;
	}

	@Override
	public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
		return FileVisitResult.CONTINUE;
	}

	@Override
	public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
//		System.out.println("reading file :" + file.toString());
		if (file.toString().endsWith(".txt")) {
			BufferedInputStream input = new BufferedInputStream(Files.newInputStream(file, StandardOpenOption.READ));
			byte[] buffer = new byte[1024];
			int length;
			while ((length = input.read(buffer)) > 0) {
				output.write(buffer, 0, length);
			}
			output.write("\r\n\r\n".getBytes());
			input.close();
		}
		return FileVisitResult.CONTINUE;
	}

	@Override
	public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
		return FileVisitResult.CONTINUE;
	}

}
