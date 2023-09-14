package no.hvl.dat100;

import java.text.MessageFormat;

import javax.swing.JOptionPane;

public class Trinnskatt {
	
	public static void main(String[] args) {
		
		/*
		 * Definerer en boolsk variabel som brukes for å validere input fra brukeren.
		 */
		boolean isValid = false;
		
		/*
		 * While-løkke som kjører så lenge den boolske variabelen 'isValid' er false
		 */
		while (!isValid) {
			
			/*
			 * Dialogvindu slik at brukeren kan skrive inn bruttolønn.
			 * Velger å begnytte JOptionPane i stedet for konsollvinduet.
			 */
			String userInput = JOptionPane.showInputDialog("Skriv inn bruttolønn: ");

			/*
			 * Dersom brukeren trykker på 'Cancel'-knappen i showInputDialog,
			 * settes verdien for userInput til null.
			 * Dette er for å forhindre at vi får feilmeldingen java.lang.NullPointerException,
			 * som sier at vi ikke har noen verdi for 'userInput'.
			 */
			if (userInput == null) {
				System.out.println("inputKarakter.JOptionPane.showInputDialog.CANCEL_BUTTON");
				break;
			} else if (userInput.isEmpty()) {
				/*
				 * Dersom brukeren ikke skriver noe i dialogvinduet, skriver vi ut en feilmelding,
				 * og setter 'isValid' til false, slik at dialogvinduet for bruttolønn kommer på nytt.
				 */
				JOptionPane.showMessageDialog(null, "Input kan ikke være tom.");
				isValid = false;
			} else {
				/*
				 * Dersom verdien brukeren skriver inn er gyldig, gjøres userInput om fra Streng til Double.
				 * Kaller metoden 'beregnTrinnskatt' med parameteret 'userInputToDouble' som er bruttolønnen.
				 */
				double userInputToDouble = Double.parseDouble(userInput);
				
				/*
				 * Sjekker om 'userInputToDouble' er en negativ verdi.
				 * Dersom den er det, settes 'isValid' til false, og det skrives ut en feilmelding i dialogboks.
				 */
				if (userInputToDouble < 0) {
					String printOutputError = MessageFormat.format("{0} er ikke en gyldig verdi.", userInputToDouble);
					JOptionPane.showMessageDialog(null, printOutputError);
					isValid = false;
				} else {
					/*
					 * Derom 'userInputToDouble' er gyldig, går vi videre i programmet.
					 */
					double parseTrinnskatt = beregnTrinnskatt(userInputToDouble);
					
					/*
					 * Etter metoden er kjørt, og trinnskatten er beregnet skriver vi ut resultatet i ett nytt dialogvindu.
					 * 
					 * Biblioteket java.text.MessageFormat brukes for å formatere output, 
					 * slik at vi kan bruke argumenter direkte i output.
					 * 
					 * Siden vi arbeider med Double datatyper, velger jeg å formatere antall desimaler på resultatet.
					 * Derfor benyttes String.format("%.2f", userInputToDouble) og String.format("%.2f", parseTrinnskatt)
					 * som gjør om både input fra bruker, og resultatet, til to desimaler.
					 * 
					 * Den boolske variabelen 'isValid' settes lik true, og while-løkken stopper.
					 */
					String printOutput = MessageFormat.format("Trinnskatt for bruttoinntekt på {0}kr er: {1}kr.", String.format("%.2f", userInputToDouble), String.format("%.2f", parseTrinnskatt));
					JOptionPane.showMessageDialog(null, printOutput);
					
					isValid = true;
				}
			}
		}
	}
	
	/*
	 * Trinnskatt er en progressiv bruttoskatt på personinntekt.
	 * Det vil si at skattesatsen blir høyere når inntekten stiger,
	 * at skatten beregnes før eventuelle fradrag, og at skatten beregnes ut ifra lønn,
	 * pensjon og andre innteker som faller inn under personinntekt.
	 * 
	 * Trinnskatten deles inn i fem trinn (Satser for 2023):
	 * KILDE 1: https://www.skatteetaten.no/satser/trinnskatt/
	 * KILDE 2: https://www.finanssans.no/artikler/trinnskatt
	 * 
	 *  Første innslagspunkt (1):   198 350kr   @ 1,7   % trinnskatt
	 *  Andre innslagspunkt  (2):   279 150kr   @ 4,0   % trinnskatt
	 *  Tredje innslagspunkt (3):   642 950kr   @ 13,5  % trinnskatt
	 *  Fjerde innslagspunkt (4):   926 800kr   @ 16,5  % trinnskatt
	 *  Femte innslagspunkt  (5):   1 500 000kr @ 17,5  % trinnskatt
	 *  
	 *  Hvordan beregnes den progressive trinnskatten (Eksempel)?:
	 *  Bruttoinntekt: 1 100 000kr
	 *  
	 *  (1): (279 149kr - 198 350kr) * 1,7 %    = 1373,583kr ≈ 1374kr
	 *  (2): (642 949kr - 279 150kr) * 4,0 %    = 14551,96kr ≈ 14552kr
	 *  (3): (926 799kr - 642 950kr) * 13,5 %   = 38319,615kr ≈ 38320kr
	 *  (4): (1 100 000kr - 926 800kr) * 16,5 % = 28578kr
	 *  
	 *  Trinnskatt totalt = 1374kr + 14552kr + 38320kr + 28578kr = 82824kr
	 *  Dette utgir 7,53 % av bruttoinntekt.
	 *  (82824/1100000)*100 = 7,53 %
	 */
	
	/*
	 * En metode for beregning av trinnskatt av bruttoinntekt.
	 * Metoden beregnes som vist ovenfor.
	 * 
	 * @param       bruttoInntekt   Bruttoinntekt som brukeren spesifiserer i dialogboksen
	 * @return      trinnskatt      Returnerer beregnet trinnskatt
	 */
	public static double beregnTrinnskatt(double bruttoInntekt) {
		
		double beregnetTrinnskatt = 0.0;
		
		if(bruttoInntekt <= 198349) {
			beregnetTrinnskatt = 0.0; // Trinnskatt for innslagspunkt (0)
		} else if (bruttoInntekt >= 198350 && bruttoInntekt <= 279149) {
			beregnetTrinnskatt = (bruttoInntekt - 198350) * 0.017; // Trinnskatt for innslagspunkt (1)
		} else if (bruttoInntekt >= 279150 && bruttoInntekt <= 642949) {
			beregnetTrinnskatt = ((279149 - 198350) * 0.017) + ((bruttoInntekt - 279150) * 0.040); // Trinnskatt for innslagspunkt (2)
		} else if (bruttoInntekt >= 642950 && bruttoInntekt <= 926799) {
			beregnetTrinnskatt = ((279149 - 198350) * 0.017) + ((642949 - 279150) * 0.040) + ((bruttoInntekt - 642950) * 0.135); // Trinnskatt for innslagspunkt (3)
		} else if (bruttoInntekt >= 926800 && bruttoInntekt <= 1499999) {
			beregnetTrinnskatt = ((279149 - 198350) * 0.017) + ((642949 - 279150) * 0.040) + ((926799 - 642950) * 0.135) + ((bruttoInntekt - 926800) * 0.165); // Trinnskatt for innslagspunkt (4)
		} else if (bruttoInntekt >= 1500000) {
			beregnetTrinnskatt = ((279149 - 198350) * 0.017) + ((642949 - 279150) * 0.040) + ((926799 - 642950) * 0.135) + ((1499999 - 926800) * 0.165) + ((bruttoInntekt - 1500000) * 0.175); // Trinnskatt for innslagspunkt (5)
		}

		// Returnerer den beregnede trinnskatten.
		return beregnetTrinnskatt;
	}
}
