package matrixes;

import interfaces.IDemoMatrix;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.Scanner;

public class DemoMatrix implements IDemoMatrix {
    // размер двухмерной матрицы
    private int size;
    // одномерный массив для хранения двухмерной матрицы
    private double[] matrix;

    /**
     * Конструктор
     *
     * @param size - размер двухмерной матрицы
     */
    public DemoMatrix(int size) {
        this.size = size;
        matrix = new double[size * size];
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
                setCell(i, j, 0);
    }

    @Override
    public double getCell(int x, int y) {
        return matrix[x * size + y];
    }

    @Override
    public void setCell(int x, int y, double value) {
        if (-0.0000000001 < value && value < 0.0000000001) {
            value = 0.;
        }
        matrix[x * size + y] = value;
    }

    @Override
    public void outMatrix() {
        try (OutputStream fout = new ByteArrayOutputStream()) {
            writeToStream(fout);
            System.out.println("\nOutputStream:\n" + fout);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void writeToStream(OutputStream fout) throws IOException {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                fout.write(Double.toString(getCell(i, j)).replace('.', ',').getBytes());
                fout.write(' ');
            }
            fout.write('\n');
        }
    }

    @Override
    public void readFromStream(InputStream in) {
        Scanner scanner = new Scanner(in);
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (!scanner.hasNext()) {
                    throw new RuntimeException("Not enough information");
                }
                double value = scanner.nextDouble();
//                System.out.println("setCell(" + i + ", " + j + ", " + value + ")");
                setCell(i, j, value);
            }
        }
    }

    @Override
    public double sumAll() {
        double result = 0;
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
                result += getCell(i, j);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DemoMatrix that = (DemoMatrix) o;
        return size == that.size &&
                Arrays.equals(matrix, that.matrix);
    }
}
/*
http://proglang.su/java/io-and-files-and-directories#potoki
http://proglang.su/java/io-and-files-and-directories-datainputstream
*/