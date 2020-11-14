package hr.fer.oop.lab4.third;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeSet;

public class NastavnikIvo {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Map<String, ArrayList<Integer>> ucenici = new LinkedHashMap<>();

		while (sc.hasNextLine()) {
			String line = sc.nextLine();
			ArrayList<Integer> list;
			if (line.equals("KRAJ")) {
				break;
			}
			int empty = line.indexOf(" ");
			String ime = line.substring(0, empty);
			int ocjena = Integer.parseInt(line.substring(empty + 1));

			list = ucenici.get(ime);
			if (list == null) {
				list = new ArrayList<>();
				list.add(ocjena);
				ucenici.put(ime, list);
			} else {
				list.add(ocjena);
			}
		}

		for (Entry<String, ArrayList<Integer>> a : ucenici.entrySet()) {
			System.out.println();
			TreeSet<Integer> ocjena = new TreeSet<>(a.getValue());
			System.out.println("Ucenik: " + a.getKey());
			int suma = 0;
			for (int i : a.getValue()) {
				suma += i;
			}
			int brojOcjena = a.getValue().size();
			System.out.println("Broj ocjena: " + brojOcjena);
			System.out.println("Ocjene: " + a.getValue().toString());
			System.out.println("Razlicite ocjene: " + ocjena.toString());
			System.out.println("Prosjecna ocjena: " + (float) suma / brojOcjena);

			double mean = suma / (double) brojOcjena;
			double std = 0;
			for (Integer i : a.getValue()) {
				std += Math.pow(mean - i, 2);
			}
			std /= brojOcjena;
			std = Math.sqrt(std);
			System.out.println("Standardna devijacija: " + std);

		}

		System.out.println();
		System.out.println(ucenici);
		sc.close();
	}
}