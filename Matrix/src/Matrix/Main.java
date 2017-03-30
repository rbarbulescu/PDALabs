package Matrix;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nrThreads = 4;
		int dim = 4;
		int[][] result = new int[dim][dim];
				
		Matrix matrix = new Matrix(dim);
		int[][] m1 = matrix.createMatrix();
		int[][] m2 = matrix.createMatrix();
        
        matrix.printMatrix(m1);
        matrix.printMatrix(m2);
        
        Thread[] threads = new Thread[nrThreads];
        for (int i = 0; i < nrThreads; i++) {
        	threads[i] = new Thread(new Multiply(m1,m2,result,dim,nrThreads, i));
        	threads[i].start();
        }
        for(int i = 0; i < nrThreads; i++){
        	try {
				threads[i].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
	}
}
