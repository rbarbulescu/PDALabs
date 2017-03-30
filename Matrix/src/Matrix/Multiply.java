package Matrix;

public class Multiply extends Thread{
	
	public int m1[][];
	public int m2[][];
	public int result[][];
	private int dim_matrice;
	int nrThreads;
	int countThread;
	
	public Multiply(int[][] m1,int[][] m2,int[][] result, int dim, int nrThreads, int countThread){
		this.m1 = m1;
		this.m2 = m2;
		dim_matrice = dim;
		this.result = result;
		this.nrThreads = nrThreads;
		this.countThread = countThread;
	}
	
	public void run(){
		int n = dim_matrice / nrThreads;
		for (int i = (n * countThread); i < (countThread + 1) * n; i++) { 
            for(int j = 0; j < dim_matrice; j++) { 
                for (int k = 0; k < dim_matrice; k++) { 
                    result[i][j] += m1[i][k] * m2[k][j];
                }
                System.out.println(result[i][j]+" Threadul ---> " + countThread);
            }
//            if(i == dim_matrice - 1){
//            	printResult(result);
//            }
        }
	}
	
//		public void printResult(int[][] matrix){
//			for(int i = 0; i < dim_matrice; i++){
//				for(int j = 0; j < dim_matrice; j++){
//					System.out.print(matrix[i][j]+" ");
//				}
//				System.out.println();
//			}
//		}
}
