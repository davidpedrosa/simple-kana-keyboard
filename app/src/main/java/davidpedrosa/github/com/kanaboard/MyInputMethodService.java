package davidpedrosa.github.com.kanaboard;

import android.inputmethodservice.InputMethodService;
import android.inputmethodservice.Keyboard;
import android.inputmethodservice.KeyboardView;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputConnection;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Stream;

import davidpedrosa.github.com.kanaboard.helper.HiraganaKeyGroup;
import davidpedrosa.github.com.kanaboard.helper.KanaKeyGroup;
import davidpedrosa.github.com.kanaboard.helper.KanaKeyStatus;
import davidpedrosa.github.com.kanaboard.helper.KatakanaKeyGroup;

public class MyInputMethodService extends InputMethodService implements KeyboardView.OnKeyboardActionListener {

    private KeyboardView keyboardView;
    private Keyboard keyboard;

    private static final KanaKeyGroup hiraganaKeyGroup = new HiraganaKeyGroup();
    private static final KanaKeyGroup katakanaKeyGroup = new KatakanaKeyGroup();

    private static final KanaKeyStatus kanaStatus = KanaKeyStatus.NORMAL;

    private static final int FIRST_KATAKANA_CODE = (int) 'ア';
    private static final int FIRST_HIRAGANA_CODE = (int) 'あ';

    private boolean katakana = false;

    public MyInputMethodService() {
        super();
    }

    public KanaKeyGroup getKanaGroup() {
        return katakana ? katakanaKeyGroup : hiraganaKeyGroup;
    }
    @Override
    public View onCreateInputView() {
        keyboardView = (KeyboardView) getLayoutInflater().inflate(R.layout.keyboard_view, null);
        keyboard = new Keyboard(this, R.xml.keys_layout);
        keyboardView.setKeyboard(keyboard);
        keyboardView.setOnKeyboardActionListener(this);
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
                case Keyboard.KEYCODE_DELETE :
                    CharSequence selectedText = inputConnection.getSelectedText(0);

                    if (TextUtils.isEmpty(selectedText)) {
                        inputConnection.deleteSurroundingText(1, 0);
                    } else {
                        inputConnection.commitText("", 1);
                    }
                /*case Keyboard.KEYCODE_SHIFT:
                    katakana = ! katakana;
                    for (Keyboard.Key key: keyboard.getKeys()) {
                        key.label = "" + katakanaChars[0];
                    }

                    keyboardView.invalidateAllKeys();
                    break;*/
                case Keyboard.KEYCODE_DONE:
                    inputConnection.sendKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_ENTER));

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
        char [][] characters = getKanaGroup().getKeys();
        int i = 0;
        int k = 0;
        for (Keyboard.Key key: keyboard.getKeys()) {
            key.codes = new int [] {(int) characters[i][k]};
            key.label = "" + characters[i][k];
            k++;
            if (k % characters[0].length == 0) {
                k = 0;
                i++;
            }
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

