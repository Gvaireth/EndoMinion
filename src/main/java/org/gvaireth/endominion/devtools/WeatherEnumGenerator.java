package org.gvaireth.endominion.devtools;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import java.util.stream.Stream;

public class WeatherEnumGenerator {

	public static void generate() throws IOException {
		Stream<String> stream = Files.lines(Paths.get("D:\\data\\weatherdesc"));
		stream.forEach((line) -> {
			line = line.replace("\t", "");
			int firstspace = line.indexOf(' ');
			String num = line.substring(0, firstspace);
			String desc = line.substring(firstspace + 1);

			desc = desc.replaceAll("\\(", "").replaceAll("\\)", "").replaceAll("/", "").replaceAll("-", "");
			System.out.println(desc.toUpperCase().replaceAll(" ", "_") + "(" + num + ", \"" + desc + "\"),\n");

		});
		stream.close();
	}

}
