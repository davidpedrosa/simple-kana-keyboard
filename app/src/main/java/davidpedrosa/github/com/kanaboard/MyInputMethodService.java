package davidpedrosa.github.com.kanaboard;

import android.inputmethodservice.InputMethodService;
import android.inputmethodservice.Keyboard;
import android.inputmethodservice.KeyboardView;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputConnection;

import davidpedrosa.github.com.kanaboard.helper.HiraganaKeyGroup;
import davidpedrosa.github.com.kanaboard.helper.KanaKeyGroup;
import davidpedrosa.github.com.kanaboard.helper.KanaKeyStatus;
import davidpedrosa.github.com.kanaboard.helper.KatakanaKeyGroup;
import davidpedrosa.github.com.kanaboard.helper.MatrixColumnIterator;

public class MyInputMethodService extends InputMethodService implements KeyboardView.OnKeyboardActionListener {

    private KeyboardView keyboardView;
    private Keyboard keyboard;

    private static final KanaKeyGroup hiraganaKeyGroup = new HiraganaKeyGroup();
    private static final KanaKeyGroup katakanaKeyGroup = new KatakanaKeyGroup();

    private static KanaKeyStatus kanaStatus = KanaKeyStatus.NORMAL;

    private static final int FIRST_KATAKANA_CODE = (int) 'ア';
    private static final int FIRST_HIRAGANA_CODE = (int) 'あ';
    private static final int SWITCH_VOICED_CODE = (int) '̏';
    private static final int SWITCH_SEMI_VOICED = (int) '°';
    private static final int DELETE_CODE = (int) '<';

    private boolean katakana = false;

    public MyInputMethodService() {
        super();
    }

    public KanaKeyGroup getKanaGroup() {
        return katakana ? katakanaKeyGroup : hiraganaKeyGroup;
    }
    private boolean charIn(char c, char[][] matrix) {
        for (int i = 0; i< matrix.length; i++)
            for (int k = 0; k < matrix[i].length; k++)
                if (matrix[i][k] == c)
                    return true;
        return false;
    }
    @Override
    public View onCreateInputView() {
        keyboardView = (KeyboardView) getLayoutInflater().inflate(R.layout.keyboard_view, null);
        keyboard = new Keyboard(this, R.xml.keys_layout);
        keyboardView.setKeyboard(keyboard);
        keyboardView.setOnKeyboardActionListener(this);
        char [][] matrix = getKanaGroup().getKeys(kanaStatus);
        for (Keyboard.Key key: keyboard.getKeys()){
            if (! charIn(key.label.toString().charAt(0), matrix)) {
                System.out.println(key.toString());
            }
        }
        reloadKeyboard();


        return keyboardView;
    }

    @Override
    public void onPress(int i) {

    }

    @Override
    public void onRelease(int i) {

    }

    @Override
    public void onKey(int primaryCode, int[] keyCodes) {
        InputConnection inputConnection = getCurrentInputConnection();
        if (inputConnection != null) {
            switch(primaryCode) {
                case DELETE_CODE :
                    CharSequence selectedText = inputConnection.getTextBeforeCursor(1,0);


                    if (!TextUtils.isEmpty(selectedText)) {
                        inputConnection.deleteSurroundingText(1, 0);
                    }
                    break;
                case FIRST_HIRAGANA_CODE:
                    if (katakana) {
                        katakana = false;
                        reloadKeyboard();

                    } else {
                        onKeyGeneralCase(primaryCode, keyCodes, inputConnection);
                    }
                    break;
                case FIRST_KATAKANA_CODE:
                    if (! katakana) {
                        katakana = true;
                        reloadKeyboard();

                    } else {
                        onKeyGeneralCase(primaryCode, keyCodes, inputConnection);
                    }
                    break;
                case SWITCH_VOICED_CODE:
                    kanaStatus = (kanaStatus == KanaKeyStatus.VOICED) ? KanaKeyStatus.NORMAL: KanaKeyStatus.VOICED;
                    reloadKeyboard();
                    break;
                case SWITCH_SEMI_VOICED:
                    kanaStatus = (kanaStatus == KanaKeyStatus.SEMI_VOICED) ? KanaKeyStatus.NORMAL: KanaKeyStatus.SEMI_VOICED;
                    reloadKeyboard();
                    break;
                default :
                    onKeyGeneralCase(primaryCode, keyCodes, inputConnection);

            }
        }
    }

    private void onKeyGeneralCase(int primaryCode, int[] keyCodes, InputConnection inputConnection ) {
        char code = (char) primaryCode;
        inputConnection.commitText(String.valueOf(code), 1);
    }
    private void reloadKeyboard() {
        MatrixColumnIterator matrixColumnIterator = new MatrixColumnIterator(getKanaGroup().getKeys(kanaStatus));
        for (Keyboard.Key key: keyboard.getKeys()) {
            Character c = matrixColumnIterator.next();
            key.codes = new int [] {(int) c};
            key.label = "" + c;
        }
        keyboardView.invalidateAllKeys();
    }

    @Override
    public void onText(CharSequence charSequence) {

    }

    @Override
    public void swipeLeft() {

    }

    @Override
    public void swipeRight() {

    }

    @Override
    public void swipeDown() {

    }

    @Override
    public void swipeUp() {

    }
}

