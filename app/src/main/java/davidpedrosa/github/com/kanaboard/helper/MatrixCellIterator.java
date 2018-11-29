package davidpedrosa.github.com.kanaboard.helper;

import java.util.Iterator;

public class MatrixCellIterator implements Iterator<Character> {

    private char [][] matrix;
    private int i;
    private int k;
    public MatrixCellIterator(char [][] matrix) {
        this.matrix = matrix;
        this.i = 0;
        this.k = 0;
    }
    @Override
    public boolean hasNext() {
        return i < matrix.length -1 || ( i == matrix.length -1 && k < matrix[i].length);
    }

    @Override
    public Character next() {
        Character result = matrix[i][k];


        if (k == matrix[i].length -1 ) {
            k = 0;
            i++;
        } else {
            k++;
        }

        return (result == ' ')? next(): result;
    }
}
