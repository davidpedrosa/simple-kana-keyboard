package davidpedrosa.github.com.kanaboard.helper;

import davidpedrosa.github.com.kanaboard.helper.KanaKeyGroup;

public class KatakanaKeyGroup extends KanaKeyGroup
{
   
    private static final char [][] keys = new char [][]{
            { 'ア', 'イ', 'ウ', 'エ', 'オ', ' '},
            { 'カ', 'キ', 'ク', 'ケ', 'コ', ' '},
            { 'サ', 'シ', 'ス', 'セ', 'ソ', ' '},
            { 'タ', 'チ', 'ツ', 'テ', 'ト', ' '},
            { 'ナ', 'ニ', 'ヌ', 'ネ', 'ノ', ' '},
            { 'ハ', 'ヒ', 'フ', 'ヘ', 'ホ', ' '},
            { 'マ', 'ミ', 'ム', 'メ', 'モ', ' '},
            { 'ラ', 'リ', 'ル', 'レ', 'ロ', ' '},
            { 'ワ', 'ヲ', 'ヤ', 'ユ', 'ヨ', ' '},
            { 'ン', 'ャ', 'ョ', 'ュ', '̏', 'あ'},
            { '<', 'ッ',  'ー', '〜', '°', ' '}
    };
   
    //, , , 'バ', 'パ', 'ビ', 'ピ', 'ブ', 'プ', 'ベ', 'ペ', 'ボ', 'ポ'
    private static final char [][] voicedKeys = new char [][]{
            {'ガ', 'ギ', 'グ', 'ゲ', 'ゴ', ' '},
            {'ザ', 'ジ', 'ズ', 'ゼ', 'ゾ', ' '},
            {'ダ', 'ヂ', 'ヅ', 'デ', 'ド', ' '},
            {'バ', 'ビ', 'ブ', 'ベ', 'ボ', ' '}
    };
    
    private static final char [][] semiVoicedKeys = new char [][]{
            {'パ','ピ', 'プ', 'ペ', 'ポ', ' '}
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
