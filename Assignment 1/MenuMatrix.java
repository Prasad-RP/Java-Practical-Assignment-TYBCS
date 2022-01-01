/*Set B)
c)
Write a menu driven program to perform the following operations on
multidimensional array ie matrix :
i. Addition
ii. Multiplication
iii. Transpose of any matrix.
iv. Exit
*/

import java.util.Scanner;
public class MenuMatrix {
// to calculate Addition of matrix
	public void addition() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter size of row nd column: ");
		int r = sc.nextInt();
		int c = sc.nextInt();

		int [][] m1 = new int[r][c];
		int [][] m2 = new int[r][c];
		System.out.println("Enter values of matrix m1");
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				System.out.printf("Enter element at index %d and %d :", i, j);
				m1[i][j] = sc.nextInt();
			}
		}
		System.out.println("Enter values of matrix m2");
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c ; j++) {
				System.out.printf("Enter element at index %d and %d :", i, j);
				m2[i][j] = sc.nextInt();
			}
		}

		System.out.println("Matrix m1");
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				System.out.print(m1[i][j] + " ");
			}
			System.out.print("\n");
		}
		System.out.println("Matrix m2");
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				System.out.print(m2[i][j] + " ");
			}
			System.out.print("\n");
		}
		System.out.println("Sum of M1 and M2");
		int [][] sum = new int[r][c];
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				sum[i][j] =  m1[i][j] + m2[i][j];
			}

		}
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				System.out.print(sum[i][j] + " ");
			}
			System.out.print("\n");
		}

	}
// Transpose of Matrix
	public void transpose() {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter size of row nd column: ");
		int r = sc.nextInt();
		int c = sc.nextInt();

		int [][] m1 = new int[r][c];
		System.out.println("Enter values of matrix m1");
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				System.out.printf("Enter element at index %d and %d :", i, j);
				m1[i][j] = sc.nextInt();
			}
		}
		System.out.println("Entered Matrix ...");
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				System.out.print(m1[i][j] + " ");
			}
			System.out.print("\n");
		}
		System.out.println("Transpose Matrix..");
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				System.out.print(m1[j][i] + " ");
			}
			System.out.print("\n");
		}
	}

// to multiplicate matrices

	public void multiplication() {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter size of row nd column: ");
		int r = sc.nextInt();
		int c = sc.nextInt();

		int [][] m1 = new int[r][c];
		int [][] m2 = new int[r][c];
		System.out.println("Enter values of matrix m1");
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				System.out.printf("Enter element at index %d and %d :", i, j);
				m1[i][j] = sc.nextInt();
			}
		}
		System.out.println("Enter values of matrix m2");
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c ; j++) {
				System.out.printf("Enter element at index %d and %d :", i, j);
				m2[i][j] = sc.nextInt();
			}
		}

		System.out.println("Matrix m1");
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				System.out.print(m1[i][j] + " ");
			}
			System.out.print("\n");
		}
		System.out.println("Matrix m2");
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				System.out.print(m2[i][j] + " ");
			}
			System.out.print("\n");
		}
		System.out.println("Multiplication of M1 and M2");
		int [][] mul = new int[r][c];
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				for (int k = 0; k < c; k++) {
					mul[i][j] = mul[i][j] + m1[i][k] * m2[k][j];
				}
			}
		}
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				System.out.print(mul[i][j] + " ");
			}
			System.out.print("\n");
		}
	}
	public static void main(String[] args) {
		MenuMatrix m = new MenuMatrix();
			Scanner sc = new Scanner(System.in);
		System.out.println("\n1.Addition of Matrix. \n2.Multiplication of Matrix. \n3.Transpose of Matrix. \n4.Exit");
		System.out.println("Enter Your Choice : ");
		int choice = sc.nextInt();

		switch (choice) {
        case 1:
        m.addition();
        break;
        case 2:
         m.multiplication();
          break;
        case 3: 
        m.transpose(); 
        break;
        case 4: break;
		}
	}
}