package task.bhh.gui;

import java.util.Locale;

public class MainGUI {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ROOT);

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                new FrameMain().setVisible(true);
            }
        });
    }
}
