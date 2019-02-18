package davidpedrosa.github.com.kanaboard.helper;

import davidpedrosa.github.com.kanaboard.helper.KanaKeyGroup;

public class KatakanaKeyGroup extends KanaKeyGroup
{
   
    private static final char [][] keys = new char [][]{
            {  'ア', 'カ', 'サ', 'タ', 'ナ', 'ハ', 'マ', 'ラ', 'ワ', '°', '〜', '<'},
            {  'イ', 'キ', 'シ', 'チ', 'ニ', 'ヒ', 'ミ', 'リ', 'ヲ', '̏', 'ー', 'ッ'},
            {  'ウ', 'ク', 'ス', 'ツ', 'ヌ', 'フ', 'ム', 'ル', 'ヤ', 'ャ', '/', 'ン'},
            {  'エ', 'ケ', 'セ', 'テ', 'ネ', 'ヘ', 'メ', 'レ', 'ユ', 'ョ', '(', '⏎'},
            {  'オ', 'コ', 'ソ', 'ト', 'ノ', 'ホ', 'モ', 'ロ', 'ヨ', 'ュ', ')','あ'}
    };
   
    //, , , 'バ', 'パ', 'ビ', 'ピ', 'ブ', 'プ', 'ベ', 'ペ', 'ボ', 'ポ'
    private static final char [][] voicedKeys = new char [][]{
            {  'ガ', 'ザ', 'ダ', 'バ' },
            {  'ギ', 'ジ', 'ヂ', 'ビ' },
            {  'グ', 'ズ', 'ヅ', 'ブ' },
            {  'ゲ', 'ゼ', 'デ', 'ベ' },
            {  'ゴ', 'ゾ', 'ド', 'ボ' }
    };
    
    private static final char [][] semiVoicedKeys = new char [][]{
            {'パ'},{'ピ'}, {'プ'}, {'ペ'}, {'ポ'}
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
