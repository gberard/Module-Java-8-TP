class TpJava04 {
	public static void main(String args[]){
		float montant = Float.parseFloat(args[0]);
		System.out.println("Montant : " + montant);
		float remise;
		if(montant<1000){
			remise = 0f;
		} else if(montant<2000){
			remise = 0.01f;
		} else if(montant<5000){
			remise = 0.03f;
		} else {
			remise = 0.05f;
		}
		System.out.println("Remise : " + (montant*remise) + " (" + (100*remise) + "%)" );
		
		int taille = Integer.parseInt(args[1]);
		String texte;
		switch(taille){
			case 1 : 
				texte = "petit";
				break;
			case 2 :
				texte = "moyen";
				break;
			default :
				texte = "grand";
		}
		System.out.println("Taille : " + texte);
	}
}
