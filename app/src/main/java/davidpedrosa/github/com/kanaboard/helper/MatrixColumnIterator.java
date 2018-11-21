package davidpedrosa.github.com.kanaboard.helper;

import java.util.Iterator;

public class MatrixColumnIterator implements Iterator<Character> {

    private char [][] matrix;
    private int i;
    private int k;
    public MatrixColumnIterator(char [][] matrix) {
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


        if (i == matrix.length -1 ) {
            i = 0;
            k++;
        } else {
            i++;
        }

        return (result == ' ')? next(): result;
    }
}
