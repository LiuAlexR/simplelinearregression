package com.projects.linearregression;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * The homepage panel.
 */
public class Homepage extends JPanel {
    /**
     * The application handler parent.
     */
    ApplicationHandler parent;
    /**
     * The screen size.
     */
    Dimension screenSize;

    /**
     * The constructor of the home page.
     * @param parent The application handler parent.
     * @param screenSize The screen size.
     */
    public Homepage(ApplicationHandler parent, Dimension screenSize){
        this.parent = parent;
        this.screenSize = screenSize;
        setLayout(null);
        drawMainScene();
        setSize(screenSize);
    }

    /**
     * Listener class for handling button events.
     */
    class ButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() instanceof JButton){
                String btnSrcTxt = e.getActionCommand();
                if(btnSrcTxt.equals("Draw")){
                    parent.changeState0To1();
                    repaint();
                }
            }
        }
    }

    /**
     * The button that displays Draw that when clicked draws the function.
     */
    private JButton buttonDraw = new JButton("Draw");
    /**
     * The title of the homepage.
     */
    private JLabel title = new JLabel("Linear Regression Plotter", SwingConstants.CENTER);
    /**
     * The listener of the button.
     */
    ButtonListener listener = new ButtonListener();

    /**
     * Draws the main scene.
     */
    public void drawMainScene(){
        removeAll();
        double width = screenSize.getWidth();
        double height = screenSize.getHeight();
        buttonDraw.setBounds((int) width *5 / 12, (int) height * 5 / 9, (int) width / 6,  (int) height / 9);
        buttonDraw.addActionListener(listener);

        title.setBounds(0, 0, (int) width, (int)  height/3);
        title.setFont(new Font("Serif", Font.PLAIN, 50));
        add(buttonDraw);
        add(title);
    }
}
