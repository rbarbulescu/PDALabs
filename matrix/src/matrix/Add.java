package matrix;


public class Add extends Thread{
	
	public int mat1[][];
	public int mat2[][];
	public int result[][];
	public int dim_matrix;
	public int nrThreads;
	
	
	public Add(int[][] m1, int[][] m2, int[][] result, int dim, int nrThreads){
		this.mat1 = m1;
		this.mat2 = m2;
		this.result = result;
		this.dim_matrix =  dim;
		this.nrThreads = nrThreads;
	}
	
	
	public void run(){
		//int n = dim_matrix/nrThreads;
		//int m = dim_matrix % nrThreads;
		//int lastThread = 1*n;
		//int var = 1;
		
		//for(int i=n; i<lastThread; i++){
			for(int j=0; j<dim_matrix; j++){
				for(int k=0; k<dim_matrix;k++){
					result[j][k] = mat1[j][k] + mat2[j][k];
				}
			}
			
			/*if(i == dim_matrix - m - 1 && var == 1){
				lastThread += m;
				var = 0;
			}
			if(i == dim_matrix - 1){
				//printResult(result);
			}*/
		//}		
	}
	
	
	
}