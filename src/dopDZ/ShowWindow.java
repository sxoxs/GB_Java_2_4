package dopDZ;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.util.HashMap;

public class ShowWindow extends JFrame {
    JTextField jTextFieldSurname, jTextFieldName, jTextFieldPatronymic;
    JButton jbtn;


    public ShowWindow(HashMap<String, String> dataFIO){
        setTitle("Show Data");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(300, 300, 400, 400);

        addPanels(dataFIO);
        goButtonPress(jbtn, dataFIO);
        updateJText(dataFIO);

        setVisible(true);
        this.setResizable(false);
    }


    private void addPanels(HashMap<String, String> dataFIO){
        JPanel bottomPanel = new JPanel();
        JPanel centerPanel = new JPanel();
        bottomPanel.setBackground(Color.BLUE);

        setLayout(new BorderLayout());

        this.add(centerPanel, BorderLayout.CENTER);
        this.add(bottomPanel, BorderLayout.SOUTH);
        addBottonButton(bottomPanel, "Edit");
        addComponentInPanel(centerPanel);
    }

    private void addBottonButton(JPanel panel, String str) {
        jbtn = new JButton(str);

        panel.setLayout(new FlowLayout());
        panel.add(jbtn);

    }
    private void addComponentInPanel(JPanel panel) {

        JLabel jLabelSurname = new JLabel("Фамилия ");
        jTextFieldSurname = new JTextField("Фамилия");


        JLabel jLabelName = new JLabel("Имя");
        jTextFieldName = new JTextField("Имя");


        JLabel jLabelPatronymic = new JLabel("Отчество");
        jTextFieldPatronymic = new JTextField("Отчество");

        panel.setLayout(new GridLayout(6, 1));

        panel.add(jLabelSurname);
        panel.add(jTextFieldSurname);
        panel.add(jLabelName);
        panel.add(jTextFieldName);
        panel.add(jLabelPatronymic);
        panel.add(jTextFieldPatronymic);

        jTextFieldName.setEnabled(false);
        jTextFieldPatronymic.setEnabled(false);
        jTextFieldSurname.setEnabled(false);
    }
    private void goButtonPress(JButton jButton, HashMap<String, String> dataFIO){
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new EditWindow(dataFIO);
            }
        });
    }
    private void updateJText(HashMap<String, String> dataFIO){
        addWindowFocusListener(new WindowFocusListener() {
            @Override
            public void windowGainedFocus(WindowEvent e) {
                setEnabled(true);
                jTextFieldName.setText(dataFIO.get("name"));
                jTextFieldSurname.setText(dataFIO.get("surname"));
                jTextFieldPatronymic.setText(dataFIO.get("patr"));
            }

            @Override
            public void windowLostFocus(WindowEvent e) {
                setEnabled(false);
            }
        });

    }
}
