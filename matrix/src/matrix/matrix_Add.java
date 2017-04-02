package matrix;

import java.util.Random;

public class matrix_Add {
	
	public static int nrThreads = 4;
	public static int dim = 10;
		public static void main(String[] args){
		
		
		Random rand = new Random();
		
		int[][] mat1 = new int[dim][dim];
		int[][]	mat2 = new int[dim][dim];
		int[][] result = new int[dim][dim];
		
		for(int i=0; i<dim; i++){
			for(int j=0; j<dim; j++){
				mat1[i][j] = rand.nextInt(10);
			}
		}
		for(int i=0; i<dim; i++){
			for(int j=0; j<dim; j++){
				mat2[i][j] = rand.nextInt(10);
			}
		}
		
		print(mat1);
		System.out.println("------------------------------");
		print(mat2);
		System.out.println("------------------------------");
		
		Thread[] th = new Thread[nrThreads];
		for(int i=0; i<nrThreads; i++){
			th[i] = new Thread(new Add(mat1, mat2, result, dim, nrThreads, i));
			th[i].start();
		}
		
		for(int i=0; i<nrThreads; i++){
			try{
				th[i].join();
			}catch(Exception e){
				e.printStackTrace();
			}
		}		
		print(result);
	}
		
		
	public static void print(int[][] result){
		for(int i=0; i<dim; i++){
			for(int j=0; j<dim; j++){
				System.out.print(result[i][j]+" ");
			}
			System.out.println();
		}
			
	}
	
}




