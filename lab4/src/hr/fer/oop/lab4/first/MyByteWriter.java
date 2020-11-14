package hr.fer.oop.lab4.first;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class MyByteWriter {

	protected InputStream stream;
	protected Path path;

	public MyByteWriter(InputStream stream, Path path) {
		this.stream = stream;
		this.path = path;
	}

	public void run() throws IOException {
		BufferedInputStream in = new BufferedInputStream(stream);
		BufferedOutputStream out = new BufferedOutputStream(Files.newOutputStream(path, StandardOpenOption.CREATE));
		byte[] buffer = new byte[1024];
		int length;
		while ((length = in.read(buffer)) > 0) {
			out.write(buffer, 0, length);
		}
		in.close();
		out.close();
	}

}
