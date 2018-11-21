package davidpedrosa.github.com.kanaboard.helper;

public abstract class KanaKeyGroup
{
    
    public abstract char [][] getKeys();
    public abstract char [][] getVoicedKeys();
    public abstract char [][] getSemiVoicedKeys();
    
    public char [][] getKeys(KanaKeyStatus status) {
        char [][] keys = getKeys();
        char [][] voicedKeys = getVoicedKeys();
        char [][] semiVoicedKeys = getSemiVoicedKeys();
        
        char [][] result = new char[keys.length][keys[0].length];
        for (int i=0; i< keys.length; i++) {
            System.arraycopy(keys[i], 0, result[i], 0,  keys[i].length);
        }
        if (status.equals(KanaKeyStatus.VOICED)) {
            for (int i = 1; i< 4; i++) {
                System.arraycopy(voicedKeys[i - 1], 0, result[i], 0,  voicedKeys[0].length);
            }
        } else if (status.equals(KanaKeyStatus.SEMI_VOICED)) {
            System.arraycopy(semiVoicedKeys[0], 0, result[5], 0,  semiVoicedKeys[0].length);
        }
    
        return result;
    }
    
}
