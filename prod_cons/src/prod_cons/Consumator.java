package prod_cons;

public class Consumator extends Thread{
	private Productie temp;
	
	public Consumator(Productie produs){
		temp = produs;
	}
	
	public void run(){
		for(int i = 0; i<10; i++){
			temp.cons();
			try{
				sleep(500);
			}
			catch(Exception e){
				System.out.println("exceptie la consum");
			}
		}
	}
}
