package Matrix;

import java.util.Random;

public class Matrix {

	public int matrix[][];
	public int dim_matrice;
	private Random rand = new Random();
 
	public Matrix(int dim){
		this.dim_matrice = dim;
	}

	public int[][] createMatrix(){
		matrix = new int[dim_matrice][dim_matrice];
		for(int i = 0; i < dim_matrice; i++){
			for(int j = 0; j < dim_matrice; j++){
				matrix[i][j] = rand.nextInt(4);
			}
		}
		return matrix;
	}

	public void printMatrix(int[][] matrix){
		for(int i = 0; i < dim_matrice; i++){
			for(int j = 0; j < dim_matrice; j++){
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("------------------------------");
	}
}
