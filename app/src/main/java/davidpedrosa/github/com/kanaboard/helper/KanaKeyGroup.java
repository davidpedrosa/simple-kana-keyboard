package davidpedrosa.github.com.kanaboard.helper;

public abstract class KanaKeyGroup
{
    
    public abstract char [][] getNormalKeys();
    public abstract char [][] getVoicedKeys();
    public abstract char [][] getSemiVoicedKeys();

    private static final int [] voicedRowIndexes = {1,2,3,5};
    private static final int [] semiVoicedRowIndexes = {5};
    public char [][] getKeys(KanaKeyStatus status) {
        char [][] keys = getNormalKeys();
        char [][] voicedKeys = getVoicedKeys();
        char [][] semiVoicedKeys = getSemiVoicedKeys();
        
        char [][] result = new char[keys.length][keys[0].length];
        for (int i=0; i< keys.length; i++) {
            System.arraycopy(keys[i], 0, result[i], 0,  keys[i].length);
        }
        if (status.equals(KanaKeyStatus.VOICED)) {
            replaceMatrixPart(result, voicedKeys, voicedRowIndexes);
        } else if (status.equals(KanaKeyStatus.SEMI_VOICED)) {
            replaceMatrixPart(result, semiVoicedKeys, semiVoicedRowIndexes);
        }
    
        return result;
    }

    private void replaceMatrixPart(char [][] matrix, char [][] newChunk, int [] indexes) {
        for (int i = 0; i < matrix.length; i++) {
            int j = 0;
            for (int k : indexes) {
                matrix[i][k] = newChunk[i][j];
                j++;
            }

        }

    }
}
