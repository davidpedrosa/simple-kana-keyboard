package davidpedrosa.github.com.kanaboard.helper;

public class HiraganaKeyGroup extends KanaKeyGroup
{
    private static final char [][] keys = new char [][]{
            {  'あ', 'か', 'さ', 'た', 'な', 'は', 'ま', 'ら', 'わ', '〜', '°', '<'},
            {  'い', 'き', 'し', 'ち', 'に', 'ひ', 'み', 'り', 'を', '̏', 'ー', 'っ'},
            {  'う', 'く', 'す', 'つ', 'ぬ', 'ふ', 'む', 'る', 'や',  'ゃ', 'ん', ' '},
            {  'え', 'け', 'せ', 'て', 'ね', 'へ', 'め', 'れ', 'ゆ',  'ょ', '⏎',  ' '},
            {  'お', 'こ', 'そ', 'と', 'の', 'ほ', 'も', 'ろ', 'よ',  'ゅ', 'ア', ' '}
    };
    
    private static final char [][] voicedKeys = new char [][]{
            {  'が', 'ざ', 'だ', 'ば'},
            {  'ぎ', 'じ', 'ぢ', 'び'},
            {  'ぐ', 'ず', 'づ', 'ぶ'},
            {  'げ', 'ぜ', 'で', 'べ'},
            {  'ご', 'ぞ', 'ど', 'ぼ'},
    };
    
    private static final char [][] semiVoicedKeys = new char [][]{
            {'ぱ'}, {'ぴ'}, {'ぷ'}, {'ぺ'}, {'ぽ'}
    };
    
    
    @Override
    public char[][] getNormalKeys()
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
