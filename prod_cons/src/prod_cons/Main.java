package prod_cons;

public class Main {
	public static void main(String[] args){
		Productie produs = new Productie();
		Consumator consumator = new Consumator(produs);
		Producator producator = new Producator(produs);
				
		producator.start();
		consumator.start();		
	}

}
