class TpJava07 {
	public static void main(String args[]){
		int nb = Integer.parseInt(args[0]);
		int i = 0;
		int affiche = 0;
		while(affiche<nb){
			if(isPremier(i)){
				System.out.println(i);
				affiche++;
			}
			i++;
		}
	}
	
	private static boolean isPremier(int n){
		if((n==0) || (n==1)){
			return false;
		}
		if((n==2)||(n==3)){
			return true;
		}
		for(int i=2;i<=Math.sqrt(n);i++){
			if((n%i)==0){
				return false;
			}
		}
		return true;
	}
	
}
