package com.projects.linearregression;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.KeyStroke;

/**
 * Tracks the status of the key
 */
class MyKeyListener implements KeyListener {

    /**
     * Array store of the key is pressed and false if its released
     * Index by character code
     */
    private boolean[] keyStatus = new boolean[525];

    /**
     * Invoked when the key is pressed or released
     * @param e the event to be processed
     */
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        var keyStroke = KeyStroke.getKeyStrokeForEvent(e).toString();
        char keyChar = keyStroke.charAt(keyStroke.length()-1);
        keyStatus[(int) keyChar] = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        var keyStroke = KeyStroke.getKeyStrokeForEvent(e).toString();
        char keyChar = keyStroke.charAt(keyStroke.length()-1);
        keyStatus[(int) keyChar] = false;
    }

    /**
     * Returns the ucrrent status array of keys
     * True if the key is pressed
     *
     * @return boolean array of key states
     */
    public boolean[] getKeyStatus(){
        return keyStatus;
    }
}