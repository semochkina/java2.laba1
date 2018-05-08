import org.junit.Assert;
import org.junit.Test;

public class MatrixTest {

    @Test
    public void test() {

        IMatrix iMatrix = new Matrix(2);
        iMatrix.setCell(0, 0, 1);
        iMatrix.setCell(0, 1, 2);
        iMatrix.setCell(1, 0, 3);
        iMatrix.setCell(1, 1, 2);


        System.out.println("\nThe input matrix");
        iMatrix.outMatrix();

        double determinant = iMatrix.determinant();

        System.out.println("\ndeterminant this matrix = " + determinant);

        Assert.assertEquals(determinant, -4., 0.001);
    }
}
