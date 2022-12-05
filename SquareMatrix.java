import java.util.Scanner;

public class SquareMatrix {
	
	
	public static int[] findLargestBlock(int[][] m) {
		
		int[] temp = new int[3];
		
		int max = 0;
		for(int i = 0; i < m.length; i++) {
			for(int j = 0; j < m.length; j++) {
				
				if(m[i][j] != 1) {
					break;
				}
				
				int nextRow = i+1;
				int nextCol = j+1;
				boolean flag = true;
				
				while(nextRow < m.length && nextCol < m.length && flag) {
					
					for(int rowChecking = i; rowChecking <= nextRow; rowChecking++) {
						
						if(m[rowChecking][nextCol] == 0) {
							flag = false;
							break;
						}
						
					}
					
					for(int colChecking = j; colChecking <= nextCol; colChecking++) {
						
						if(m[nextRow][colChecking] == 0) {
							flag = false;
							break;
						}
						
					}
					
					if(flag) {
						
						int sizeOfSquare = nextRow - i + 1;
						
						if(sizeOfSquare > max) {
							max = sizeOfSquare;
							temp[0] = i;
							temp[1] = j;
							temp[2] = max;
						}
						
					}
					
					nextCol++;
					nextRow++;
					
				}//while
			}// for j
		}// for i
		
		return temp;
	}
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int size = 0;
		System.out.print("Enter the number of rows in the matrix: ");
		size = sc.nextInt();
		int[][] matrix = new int[size][size];
	
		System.out.println("Enter the matrix row by row:");
		int val;
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				val = sc.nextInt();
				matrix[i][j] = val;
						
			}	
		}
		
	
		
		int[] res = new int[3];
		res = findLargestBlock(matrix);
		
		 if (res != null) {
	            System.out.print("The maximum square submatrix is at (" + res[0] + "," + res[1] + ") with size " + res[2]);
	     }
		 else {
			 System.out.println("There isn't any square matrix in given matrix.");
		 }
		
		
		sc.close();
	}
}
