package interfaces;

public interface IMatrix {

    // poluchit' element s zadannymi indeksami
    double getCell(int x, int y);

    // izmenit' element s zadannymi indeksami
    void setCell(int x, int y, double value);

    // vychislit' opredelitel' matricy (metodom Gaussa)
    double getDeterminant();

    // vyvodit matricu
    void outMatrix();

    // compare classes
    boolean equals(Object o);

    // hash-code - unikal'noe znachenie any object
    int hashCode();
}
