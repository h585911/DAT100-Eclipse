package no.hvl.dat100;

public class Trinnskatt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(beregnTrinnskatt(100000));
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
	 * 	Første innslagspunkt (1): 	198 350kr 	@ 1,7 	% trinnskatt
	 * 	Andre innslagspunkt  (2): 	279 150kr 	@ 4,0 	% trinnskatt
	 *  Tredje innslagspunkt (3): 	642 950kr 	@ 13,5 	% trinnskatt
	 *  Fjerde innslagspunkt (4): 	926 800kr 	@ 16,5 	% trinnskatt
	 *  Femte innslagspunkt  (5): 	1 500 000kr @ 17,5 	% trinnskatt
	 *  
	 *  Hvordan beregnes den progressive trinnskatten (Eksempel)?:
	 *  Bruttoinntekt: 1 100 000kr
	 *  
	 *  (1): (279 149kr - 198 350kr) * 1,7 % 	= 1373,583kr ≈ 1374kr
	 *  (2): (642 949kr - 279 150kr) * 4,0 % 	= 14551,96kr ≈ 14552kr
	 *  (3): (926 799kr - 642 950kr) * 13,5 % 	= 38319,615kr ≈ 38320kr
	 *  (4): (1 100 000kr - 926 800kr) * 16,5 % = 28578kr
	 *  
	 *  Trinnskatt totalt = 1374kr + 14552kr + 38320kr + 28578kr = 82824kr
	 *  Dette utgir 7,53 % av lønnen.
	 *  (82824/1100000)*100 = 7,53 %
	 */
	public static int beregnTrinnskatt(int nettolonn) {
		
		return nettolonn;
	}

}
