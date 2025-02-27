package jocAnagrame;

import java.util.Random;
import java.util.Scanner;

public class JocAnagrame {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();

		String[] listaCuvinte = { "magie", "vrajitor", "vraja", "potiune", "alchimie", "vrajitorie", "bagheta",
				"dragon", "cazan", "matura" };

		int scorJucator = 0;
		boolean seJoaca = true;

		System.out.println("Bun venit in Anagramele Vrajitorului");
		System.out.println("Dezleaga cuvintele magice pentru a primi puncte!");

		while (seJoaca) {
			String cuvant = listaCuvinte[random.nextInt(listaCuvinte.length)];
			String cuvantAmestecat = amestecaCuvantul(cuvant, random);
			System.out.println("Anagrama este:" + cuvantAmestecat);

			boolean cuvantGhicit = false;
			int nrIncercari = 3;

			while (nrIncercari > 0 && !cuvantGhicit) {
				System.out.print("Raspunsul tau: ");
				String raspunsJucator = scanner.nextLine();

				if (raspunsJucator.equalsIgnoreCase(cuvant)) {
					System.out.println("Raspuns corect!");
					scorJucator++;
					cuvantGhicit = true;
				} else {
					nrIncercari--;
					System.out.println("Gresit! Incercari ramase: " + nrIncercari);
				}
			}
			if (!cuvantGhicit) {
				System.out.println("Cuvantul corect era: " + cuvant);
			}
			System.out.println("Scorul tau este " + scorJucator);
			System.out.println("Doresti sa mai joci? (da/nu): ");
			String raspuns = scanner.nextLine();
			seJoaca = raspuns.equalsIgnoreCase("da");
		}
		System.out.println("Multumesc pentru joc. Scorul tau final este: " + scorJucator);
		scanner.close();
	}

	public static String amestecaCuvantul(String cuvant, Random random) {
		char[] litere = cuvant.toCharArray();
		for (int i = 0; i < litere.length; i++) {
			int j = random.nextInt(litere.length);
			char temp = litere[i];
			litere[i] = litere[j];
			litere[j] = temp;
		}
		return new String(litere);
	}

}
