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
				/*
				 * Dersom verdien fra brukeren er korrekt, gjør vi om verdien fra en String til int.
				 * Definerer også noen ekstra variabler som brukes lokalt i for-løkken.
				 * Den boolske variabelen 'isValid' brukes for å sjekke om poengsummen brukeren
				 * skriver inn er gyldig.
				 * Dvs. isValid settes til true DERSOM og KUN DERSOM poengsummen er ett heltall mellom 0 og 100.
				 */
				int outputKarakter = Integer.parseInt(inputKarakter);
				String karakter = null;
				int poengMin = 0;
				int poengMax = 0;
				boolean isValid = false;
				
				/*
				 * En ny for-løkke defineres for å iterere gjennom alle elementene i 
				 * variabelen 'karakterSkala'. 
				 * 
				 * @param	karakterSkala		alle karakterene i tabellen
				 * @return						karakterutsrkift med poengsum.
				 * 
				 * Dersom verdien fra brukeren finnes i noen av variablene 'poengLow' og 'poengHigh',
				 * settes karakteren tilsvarende poengsum, poengMin settes lik minimum poenggrense,
				 * og poengMax settes lik maksimum poenggrense.
				 * den boolske variabelen isValid settes også til true.
				 */
				for (int i = 0; i < karakterSkala.length; i++) {
					if (outputKarakter >= poengLow[i] && outputKarakter <= poengHigh[i]) {
						karakter = karakterSkala[i];
						poengMin = poengLow[i];
						poengMax = poengHigh[i];
						isValid = true;
						break;
					}
				}
				
				/*
				 * Dersom den boolske variabelen isValid er false, skriver vi ut en feilmelding.
				 * Velger å bruke java.text.MessageFormat for å formattere output.
				 * Dette gjør vi slik at vi kan bruke argumenter (eks. {0} for outputKarakter) i utskriften.
				 * Dette gjøres for å kunne bruke argumenter (eks. {0} for outputKarakter) i utskriften, 
				 * i stedet for å bruke println(outputkarakter + " er ikke en gyldig verdi.").
				 * Dersom isValid er false, går vi tilbake en iterasjon.
				 */
				if (!isValid) {
					String printOutputError = MessageFormat.format("{0} er ikke en gyldig verdi.", outputKarakter);
					JOptionPane.showMessageDialog(null, printOutputError);
					antallKarakterer--;
				} else {
					/*
					 * Dersom isValid er true, skriver vi ut studentnummer, poeng, karakter samt minimum og maksimum poeng.
					 * Til slutt legger vi til alle karakterer med studentnr i tabellen arrayKarakterer.
					 */
					String printOutput = MessageFormat.format("Studentnummer {0} har {1} poeng\nKarakter: {2}\nPoenggrense for karakter {2} (min/max): {3} / {4}", (antallKarakterer + 1), outputKarakter, karakter, poengMin, poengMax);
					JOptionPane.showMessageDialog(null, printOutput);
					
					arrayKarakterer[antallKarakterer] = "Student: " + (antallKarakterer + 1) + ", Karakter: " + karakter;
				}
			}
		}
		
		/*
		 * Skriver ut arrayKarakterer i konsollvinduet.
		 */
		System.out.println(Arrays.toString(arrayKarakterer));

	}

}
