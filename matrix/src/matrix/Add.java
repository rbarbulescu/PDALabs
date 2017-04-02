package matrix;


public class Add extends Thread{
	
	public int mat1[][];
	public int mat2[][];
	public int result[][];
	public int dim_matrix;
	public int nrThreads;
	public int countThread;
	
	public Add(int[][] m1, int[][] m2, int[][] result, int dim, int nrThreads, int countThread){
		this.mat1 = m1;
		this.mat2 = m2;
		this.result = result;
		this.dim_matrix =  dim;
		this.nrThreads = nrThreads;
		this.countThread = countThread;
		}
	
	
	public void run(){
		int n = dim_matrix/nrThreads;
		int lastThread = (countThread+1)*n;
		
		
		if(dim_matrix<nrThreads){
			for(int j=0; j<dim_matrix; j++){
				for(int k=0; k<dim_matrix;k++){
					result[j][k] = mat1[j][k] + mat2[j][k];
				}
			}
		}
		else{
			for(int i=n*countThread; i<lastThread; i++){
				for(int j=0; j<dim_matrix; j++){
					for(int k=0; k<dim_matrix;k++){
						result[j][k] = mat1[j][k] + mat2[j][k];
					}
				}	
			}
		}
	}
	
}