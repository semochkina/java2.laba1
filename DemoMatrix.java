package matrixes;

import interfaces.IDemoMatrix;
import interfaces.IMatrix;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.Scanner;

public class DemoMatrix {
    // размер двухмерной матрицы
//    private int size;
    // одномерный массив для хранения двухмерной матрицы
//    private double[] matrix;

//    /**
//     * Конструктор
//     *
//     * @param size - размер двухмерной матрицы
//     */
//    public DemoMatrix(int size) {
//        this.size = size;
//        matrix = new double[size * size];
//        for (int i = 0; i < size; i++)
//            for (int j = 0; j < size; j++)
//                setCell(i, j, 0);
//    }

//    @Override
//    public double getCell(int x, int y) {
//        return matrix[x * size + y];
//    }
//
//    @Override
//    public void setCell(int x, int y, double value) {
//        if (-0.0000000001 < value && value < 0.0000000001) {
//            value = 0.;
//        }
//        matrix[x * size + y] = value;
//    }
//
//    @Override
//    public void outMatrix() {
//        try (OutputStream fout = new ByteArrayOutputStream()) {
//            writeToStream(fout);
//            System.out.println("\nOutputStream:\n" + fout);
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }
//    }

    public static void writeToStream(IMatrix matrix, OutputStream fout) throws IOException {
        for (int i = 0; i < matrix.getSize(); i++) {
            for (int j = 0; j < matrix.getSize(); j++) {
                fout.write(Double.toString(matrix.getCell(i, j)).replace('.', ',').getBytes());
                fout.write(' ');
            }
            fout.write('\n');
        }
    }


    public void readFromStream(IMatrix matrix, InputStream fin) {
        Scanner scanner = new Scanner(fin);
        for (int i = 0; i < matrix.getSize(); i++) {
            for (int j = 0; j < matrix.getSize(); j++) {
                if (!scanner.hasNext()) {
                    throw new RuntimeException("Not enough information");
                }
                double value = scanner.nextDouble();
//                System.out.println("setCell(" + i + ", " + j + ", " + value + ")");
                matrix.setCell(i, j, value);
            }
        }
    }

    public double sumAll(IMatrix matrix) {
        double result = 0;
        for (int i = 0; i < matrix.getSize(); i++)
            for (int j = 0; j < matrix.getSize(); j++)
                result += matrix.getCell(i, j);
        return result;
    }

}