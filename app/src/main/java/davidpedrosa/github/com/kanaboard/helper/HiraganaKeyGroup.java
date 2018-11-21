package davidpedrosa.github.com.kanaboard.helper;

public class HiraganaKeyGroup extends KanaKeyGroup
{
    private static final char [][] keys = new char [][]{
            { 'あ', 'い', 'う', 'え', 'お'},
            { 'か', 'き', 'く', 'け', 'こ'},
            { 'さ', 'し', 'す', 'せ', 'そ'},
            { 'た', 'ち', 'つ', 'て', 'と'},
            { 'な', 'に', 'ぬ', 'ね', 'の'},
            { 'は', 'ひ', 'ふ', 'へ', 'ほ'},
            { 'ま', 'み', 'む', 'め', 'も'},
            { 'ら', 'り', 'る', 'れ', 'ろ'},
            { 'わ', 'を', 'や', 'ゆ', 'よ'},
            { 'ん', 'ゃ','ょ', 'ゅ', 'っ'},
            { '°', '̏',  'ー', '〜', '<'}
    };
    
    private static final char [][] voicedKeys = new char [][]{
            {'が', 'ぎ', 'ぐ', 'げ', 'ご'},
            {'ざ', 'じ', 'ず', 'ぜ', 'ぞ'},
            {'だ', 'ぢ', 'づ', 'で', 'ど'},
            {'ば', 'び', 'ぶ', 'べ', 'ぼ'}
    };
    
    private static final char [][] semiVoicedKeys = new char [][]{
            {'ぱ', 'ぴ', 'ぷ', 'ぺ', 'ぽ'}
    };
    
    
    @Override
    public char[][] getKeys()
    {
        return keys;
    }
    
    @Override
    public char[][] getVoicedKeys()
    {
        return voicedKeys;
    }
    
    @Override
    public char[][] getSemiVoicedKeys()
    {
        return semiVoicedKeys;
    }
    
   
}
