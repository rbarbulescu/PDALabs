package prod_cons;

public class Producator extends Thread{
	private Productie temp;
	
	public Producator(Productie produs){
		temp = produs;
	}
	
	public void run(){
		for(int i = 0; i < 10; i++){
			temp.prod(i);
			try{
				sleep(500);
			}
			catch(Exception e){
				System.out.println("exceptie de productie");
			}
		}
	}


}
