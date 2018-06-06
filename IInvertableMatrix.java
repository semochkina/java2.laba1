package interfaces;

public interface IInvertableMatrix extends IMatrix {

    // poluchit' element s zadannymi indeksami
//    double getCell(int x, int y);

    // izmenit' element s zadannymi indeksami
//    void setCell(int x, int y, double value);

    // vychislit' obratnuyu matricu, vozvrashaet FALSE esli matrica vyrojdena
    boolean calculateMatrixInverse();

    // vyvodit matricu
//    void outMatrix();

//    double getCellNew(int x, int y);
}