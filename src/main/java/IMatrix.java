public interface IMatrix {

    // poluchit' element s zadannymi indeksami
    double getCell(int x, int y);

    // izmenit' element s zadannymi indeksami
    void setCell(int x, int y, double value);

    // vychislit' opredelitel' matricy (metodom Gaussa)
    double determinant();

    // vyvodit matricu
    void outMatrix();
}
