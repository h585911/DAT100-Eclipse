package no.hvl.dat100;

import javax.swing.JOptionPane;

public class Trinnskatt {
	
public static void main(String[] args) {
		
		String userInput = JOptionPane.showInputDialog("Skriv inn bruttolønn: ");
		double userInputToDouble = Double.parseDouble(userInput);
		
		double parseTrinnskatt = beregnTrinnskatt(userInputToDouble);

		JOptionPane.showMessageDialog(null, "Trinnskatt for bruttoinntekt på " + userInputToDouble + "kr er: " + parseTrinnskatt + "kr");
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
