package matrixes;

import interfaces.IMatrix;

import java.util.Scanner;

/**
 *  Vychislit' opredelitel' matricy metodom Gaussa
 *
 *  dlya etogo privedem matricu k verhney treugol'noy matricy
 *  proizvedenie chisel na glavnoy diagonali budet ravno opredelitelyu
 */
public class Main {

    public static void main(String[] args) throws Exception {

        // razmernost' matricy
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the dimension of the matrix: ");
        int n = in.nextInt();

        IMatrix iMatrix = new Matrix(n);

        System.out.println("\nSet matrix:");
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {
                System.out.println("matrix[" + (i+1) + "][" + (j+1) + "]= ");
                double ddd = in.nextDouble();
                iMatrix.setCell(i, j, ddd);
            }

        System.out.println("\nThe input matrix");
        iMatrix.outMatrix();

        double determinant = iMatrix.getDeterminant();

        System.out.println("\ngetDeterminant this matrix = " + determinant);

        System.exit(0);
    }
}
