package no.hvl.dat100;

import javax.swing.JOptionPane;
import java.text.MessageFormat;
import java.lang.Integer;

public class Fakultet {

	public static void main(String[] args) {
		
		/*
		 * Definerer variablene i og fakultet
		 */
		int i, fakultet = 1;
		
		/*
		 * Velger å bruke javax.swing.JOptionPane for å gi brukeren et dialogvindu
		 * fremfor å måtte skrive i konsollen.
		 * outputFakultet gjør om inputFakultet fra String til int ved å bruke Integer.parseInt.
		 */
		String inputFakultet = JOptionPane.showInputDialog("Skriv inn verdien som skal beregnes: ");
		int outputFakultet = Integer.parseInt(inputFakultet);
		
		/*
		 * Itererer gjennom outputFakultet, som er verdien brukeren ønsker å beregne fakultet for.
		 * Fakultet blir beregnet ved å lese inn heltallet fra brukeren (outputFakultet),
		 * og beregne verdien av n! der n! = 1 * 2 * 3 * ... * (n-1) * n.
		 * 
		 * @param	outputFakultet		verdien brukeren ønsker å beregne fakultet for
		 * @return						beregnet fakultet av verdien
		 */
		for (i = 1; i <= outputFakultet; i++) {
			fakultet = fakultet * i;
		}
		
		/*
		 * Skrivet ut resultatet i ett dialogvindu.
		 * Biblioteket java.text.MessageFormat brukes for å formatere output, 
		 * slik at vi kan bruke argumenter direkte i output.
		 */
		String printOutput = MessageFormat.format("Fakultet av {0} er {1}.", outputFakultet, fakultet);
		JOptionPane.showMessageDialog(null, printOutput);
	}
}
