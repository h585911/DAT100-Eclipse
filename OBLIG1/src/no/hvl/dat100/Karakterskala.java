package no.hvl.dat100;

import javax.swing.JOptionPane;
import java.text.MessageFormat;
import java.util.Arrays;

public class Karakterskala {

	public static void main(String[] args) {
		
		/*
		 * Definerer ulike tabeller vi trenger
		 * @var		karakterskala	String		Alle gyldige karakterer
		 * @var		poengLow		int			Minste poengsum for karakter
		 * @var		poengHigh		int			Høyeste poengsum for karakter
		 * @var		arrayKarakterer	Object		Alle karakterene med poengsum som brukeren skriver inn
		 */
		String[] karakterSkala = {"F", "E", "D", "C", "B", "A"};
		int[] poengLow = {0, 40, 50, 60, 80, 90};
		int[] poengHigh = {39, 49, 59, 79, 89, 100};
		Object[] arrayKarakterer = new Object[10];

		/*
		 * Iterer gjennom alle karakterer brukeren skal skrive inn, i dette tilfellet en.
		 * Start med første iterasjon og inkrementer med en etter hver gyldig verdi fra brukeren.
		 * 
		 * @param	antallKarakterer	antall karakterer brukeren skal skrive inn
		 * @return						utskrift av karakter og poengsum.
		 */
		for (int antallKarakterer = 0; antallKarakterer < 10; antallKarakterer++) {
			String inputKarakter = JOptionPane.showInputDialog("Skriv inn poeng for studentnr " + (antallKarakterer + 1) + ": ");
			
			/*
			 * Dersom brukeren trykker på 'Cancel'-knappen i showInputDialog,
			 * settes verdien for inputKarakter til null.
			 * Dette er for å forhindre at vi får feilmeldingen java.lang.NullPointerException,
			 * som sier at vi ikke har noen verdi for 'inputKarakter'.
			 */
			if (inputKarakter == null) {
				System.out.println("inputKarakter.JOptionPane.showInputDialog.CANCEL_BUTTON");
				break;
			}
			
			/*
			 * Dersom brukeren ikke skriver noen verdi i 'inputKarakter',
			 * skriver vi ut en feilmelding og vi går tilbake en iterasjon.
			 * Grunnen til at vi går tilbake en iterasjon er slik at vi kommer tilbake til
			 * den iterasjonen vi var på når vi skrev inn den ugyldige verdien.
			 * Dersom vi ikke gjør dette, fortsetter løkken til neste iterasjon,
			 * selv om verdien vi skriv inn var ugyldig.
			 */
			if (inputKarakter.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Input kan ikke være tom.");
				antallKarakterer--;
			} else {
				int outputKarakter = Integer.parseInt(inputKarakter);
				String karakter = null;
				int poengMin = 0;
				int poengMax = 0;
				boolean isValid = false;
				
				for (int i = 0; i < karakterSkala.length; i++) {
					if (outputKarakter >= poengLow[i] && outputKarakter <= poengHigh[i]) {
						karakter = karakterSkala[i];
						poengMin = poengLow[i];
						poengMax = poengHigh[i];
						isValid = true;
						break;
					}
				}
				
				if (!isValid) {
					String printOutputError = MessageFormat.format("{0} er ikke en gyldig verdi.", outputKarakter);
					JOptionPane.showMessageDialog(null, printOutputError);
					antallKarakterer--;
				} else {
					String printOutput = MessageFormat.format("Studentnummer {0} har {1} poeng\nKarakter: {2}\nPoenggrense for karakter {2} (min/max): {3} / {4}", (antallKarakterer + 1), outputKarakter, karakter, poengMin, poengMax);
					JOptionPane.showMessageDialog(null, printOutput);
					
					arrayKarakterer[antallKarakterer] = "Student: " + (antallKarakterer + 1) + ", Karakter: " + karakter;
				}
			}
		}
		
		System.out.println(Arrays.toString(arrayKarakterer));

	}

}
