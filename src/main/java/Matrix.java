public class Matrix implements IMatrix {

    // Размерность матрицы
    int size;

    // Матрица
    double[][] matrix;

    public Matrix(int size) {
        this.size = size;
        matrix = new double[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = 0;
            }
        }
    }

    public double getCell(int x, int y) {
        return matrix[x][y];
    }

    public void setCell(int x, int y, double value) {
        matrix[x][y] = value;
    }

    private void perestavlyaemStroki(int numRow1, int numRow2){
        for (int i = 0; i < size; i++){
            double mem = matrix[numRow1][i];
            matrix[numRow1][i] = matrix[numRow2][i];
            matrix[numRow2][i] = mem;
        }
    }

    public double determinant() {
        // opredelitel'
        double value = 1;
        // privodim k verhney treugol'noy matricy
        for (int i = 0; i < size - 1; i++) {
            if (getCell(i, i) == 0) {
                // nulevoy element na glavnoy diagonali
                // ishem druguyu stroku s ne nulevym znacheniem v dannom stolbce
                int n = 0;
                for (int j = i + 1; j < size; j++) {
                    if (getCell(j, i) != 0) {
                        n = j;
                        break;
                    }
                }
                if (n == 0) {
                    // net stolbca bez 0, na glavnoe diagonali budet 0, opredelitel' == 0
                    System.out.println("0 in row " + i + " in all colums, determinant == 0");
                    return 0;
                }
                // perestavlyaem stroki
                perestavlyaemStroki(i, n);

                // pri perestanovki strok menyaetsya znak
                value *= -1;
                System.out.println("\nChange rows  " + i + " -> " + n);
                outMatrix();
            }

            // Operaciya dobavleniya k odnoy iz strok matricy drugoy stroki, umnojennoy na nekotoroe chislo, ne menyaet opredelitel'
            // k ostal'nym strokam dobavlyaem tekushuyu s takim koefficientom, chtoby v dannoy kolonke byl 0
            for (int j = i + 1; j < size; j++) {
                if (getCell(j, i) == 0) {
                    System.out.println("\ndon't change row number " + j);
                } else {
                    double kf = getCell(j, i) / getCell(i, i) * -1;
                    setCell(j, i, 0);
                    for (int k = i+1; k < size; k++)
                        setCell(j, k, getCell(j, k) + getCell(i, k) * kf);
                    System.out.println("\nN row = " + j + ", kf == " + kf);
                    outMatrix();
                }
            }
            value *= getCell(i, i);
        }
        value *= getCell(size - 1, size - 1);
        return value;
    }

    public void outMatrix() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
