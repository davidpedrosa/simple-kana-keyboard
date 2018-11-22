package davidpedrosa.github.com.kanaboard.helper;

public abstract class KanaKeyGroup
{
    
    public abstract char [][] getNormalKeys();
    public abstract char [][] getVoicedKeys();
    public abstract char [][] getSemiVoicedKeys();

    private static final int [] voicedRowIndexes = {1,2,3,5};
    public char [][] getKeys(KanaKeyStatus status) {
        char [][] keys = getNormalKeys();
        char [][] voicedKeys = getVoicedKeys();
        char [][] semiVoicedKeys = getSemiVoicedKeys();
        
        char [][] result = new char[keys.length][keys[0].length];
        for (int i=0; i< keys.length; i++) {
            System.arraycopy(keys[i], 0, result[i], 0,  keys[i].length);
        }
        if (status.equals(KanaKeyStatus.VOICED)) {
            int k = 0;
            for (int i: voicedRowIndexes) {
                System.arraycopy(voicedKeys[k], 0, result[i], 0,  voicedKeys[k].length);
                k++;
            }
        } else if (status.equals(KanaKeyStatus.SEMI_VOICED)) {
            System.arraycopy(semiVoicedKeys[0], 0, result[5], 0,  semiVoicedKeys[0].length);
        }
    
        return result;
    }
    
}
