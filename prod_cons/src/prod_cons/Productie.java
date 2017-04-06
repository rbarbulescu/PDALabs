package prod_cons;

public class Productie {
	private boolean valabil = false;
	private int container = 0;
	
	public synchronized void prod(int produs){
		if(valabil == true){
			try{
				wait(5000); //blocheaza firul solicitant daca avem deja creat un obiect
			}
			catch(Exception ex){
				System.out.println("Eroare la productie");
			}
		}
		valabil = true;//pentru ca consumatorul sa poata consuma
		container = produs;
		System.out.println(container+" produse valabile");
		notifyAll();//deblocheaza toate firele, in cazul de fata ofera o sansa consumatorului
	}
	public synchronized int cons(){
		if(valabil == false){
			try{
				wait(5000);//blocheaza firul solicitant daca nu avem creat un obiect
			}
			catch(Exception ex){
				System.out.println("Eroare de consum");
			}
		}
		valabil = false;//pentru ca producatorul sa poata produce 
		System.out.println(container+" produse consumate");
		notifyAll();
		return container;
	}
}