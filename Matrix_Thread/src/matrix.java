import java.util.Random;
import java.util.Scanner;


public class matrix {
	static int n = 4;
	//Creating the matrix
	static int[][] mat = new int[n][n];
	static int[][] mat2 = new int[n][n];
	static int[][] result = new int[n][n];
	public static Scanner input;
	public static void main(String [] args){

		//Creating the object of random class
		Random rand = new Random();
		input = new Scanner(System.in);
		System.out.print("Dati n:");
		int nr_thread = input.nextInt();

		//Filling first matrix with random values
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[i].length; j++) {
				mat[i][j]=rand.nextInt(10);
			}
		}

		//Filling second matrix with random values
		for (int i = 0; i < mat2.length; i++) {
			for (int j = 0; j < mat2[i].length; j++) {
				mat2[i][j]=rand.nextInt(10);
			}
		}

		try{
			//Object of multiply Class
			Multiply multiply = new Multiply(n,n,nr_thread);

			//Threads
			for(int u=0; u< nr_thread;u++){
				MatrixMultiplier thread = new MatrixMultiplier(multiply);
				Thread th = new Thread(thread);
				th.start();
				th.join();
			}
			//Implementing threads

		}catch (Exception e) {
			e.printStackTrace();
		}

		//Printing the result
		System.out.println("\n\nResult:");
		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result[i].length; j++) {
				System.out.print(result[i][j]+" ");
			}
			System.out.println();
		}
	}//End main

}//End Class

	//Multiply Class
	class Multiply extends matrix {

		private int i;
		private int j;
		private int chance;
		private int nr_thread;

		public Multiply(int i, int j,int nr_thread){
			this.i=i;
			this.j=j;
			this.nr_thread=nr_thread;
			chance=0;
		}

		//Matrix Multiplication Function
		public synchronized void multiplyMatrix(){

			int sum=0;
			int a=0;
			int b=0;
			for(a=0;a<i;a++){
				sum=0;
				if(a>=nr_thread){
					for(a=nr_thread;a<i;a++){
						for(b=nr_thread;b<j;b++){
							sum=sum+mat[chance][b]*mat2[b][a];
						}
						result[chance][a]=sum;
					}
				}
				else{
					for(b=0;b<j;b++){
						sum=sum+mat[chance][b]*mat2[b][a];
					}
					result[chance][a]=sum;
				}
			}

			if(chance>=i)
				return;
			chance++;
		}
}//End multiply class

//Thread Class
class MatrixMultiplier implements Runnable {
	private final Multiply mul;

	public MatrixMultiplier(Multiply mul){
		this.mul=mul;
	}

	@Override
	public void run() {
		mul.multiplyMatrix();
	}
}