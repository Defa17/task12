package task.bhh.gui;

import task.util.*;
import task.utils.*;
import task.bhh.logic.*;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;

public class FrameMain extends JFrame {

    private JTextField textFieldA;
    private JButton buttonLoadInputFromFile;
    private JButton buttonCalc;
    private JTextField textFieldB;
    private JButton buttonSaveInputInfoFile;
    private JPanel panelMain;
    private JFileChooser fileChooserOpen;
    private JFileChooser fileChooserSave;
    private JMenuBar menuBarMain;
    private JMenu menuLookAndFeel;

    public FrameMain() {
        this.setTitle("Правильная последовательность из скобок");
        this.setContentPane(panelMain);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();

        fileChooserOpen = new JFileChooser();
        fileChooserSave = new JFileChooser();
        fileChooserOpen.setCurrentDirectory(new File("."));
        fileChooserSave.setCurrentDirectory(new File("."));
        FileFilter filter = new FileNameExtensionFilter("Text files", "txt");
        fileChooserOpen.addChoosableFileFilter(filter);
        fileChooserSave.addChoosableFileFilter(filter);

        fileChooserSave.setAcceptAllFileFilterUsed(false);
        fileChooserSave.setDialogType(JFileChooser.SAVE_DIALOG);
        fileChooserSave.setApproveButtonText("Save");

        menuBarMain = new JMenuBar();
        setJMenuBar(menuBarMain);

        menuLookAndFeel = new JMenu();
        menuLookAndFeel.setText("Вид");
        menuBarMain.add(menuLookAndFeel);
        SwingUtils.initLookAndFeelMenu(menuLookAndFeel);


        buttonCalc.addActionListener(e -> {
            try {
                String str = textFieldA.getText();
                Main m = new Main();
                String answer = ConvertAnswer.getAnswer(str);
                textFieldB.setText(String.format("%s", answer));
            } catch (Exception err) {
                JOptionPane.showMessageDialog(null, "Некорректные данные", "Ошибка", JOptionPane.ERROR_MESSAGE);
            }
        });

        buttonLoadInputFromFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    if (fileChooserOpen.showOpenDialog(panelMain) == JFileChooser.APPROVE_OPTION) {
                        String str = LoadFromFile.loadFromFile(fileChooserOpen.getSelectedFile().getPath());
                        String answer = ConvertAnswer.getAnswer(str);
                        textFieldA.setText(String.format("%s", str));
                        textFieldB.setText(String.format("%s", answer));

                    }
                } catch (Exception e) {
                    SwingUtils.showErrorMessageBox(e);
                }
            }
        });


        buttonSaveInputInfoFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    if (fileChooserSave.showSaveDialog(panelMain) == JFileChooser.APPROVE_OPTION) {
                        String str = textFieldA.getText();
                        String answer= ConvertAnswer.getAnswer(str);
                        String file = fileChooserSave.getSelectedFile().getPath();
                        if (!file.toLowerCase().endsWith(".txt")) {
                            file += ".txt";
                        }
                        SaveToFile.saveToFile(file, answer);
                    }
                } catch (Exception e) {
                    SwingUtils.showErrorMessageBox(e);
                }
            }
        });

        textFieldA.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                try {
                    String str = textFieldA.getText();
                    String answer = ConvertAnswer.getAnswer(str);
                    textFieldB.setText(String.format("%s", answer));
                } catch (Exception err) {
                    JOptionPane.showMessageDialog(null, "Некорректные данные", "Ошибка", JOptionPane.ERROR_MESSAGE);
                }
            }
        });


    }
}
