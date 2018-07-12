package dopDZ;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class EditWindow extends JFrame {
    JTextField jTextFieldSurname, jTextFieldName, jTextFieldPatronymic;
    JButton jbtn;


    public EditWindow(HashMap<String, String> dataFIO){
        setTitle("Show Data");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setBounds(300, 300, 400, 400);

        addPanels();
        buttonPress(jbtn, dataFIO);
        setVisible(true);
        this.setResizable(false);
    }
    private void closeEditFrame(HashMap<String, String> dataFIO){
        dataFIO.put("name", jTextFieldName.getText());
        dataFIO.put("surname", jTextFieldSurname.getText());
        dataFIO.put("patr", jTextFieldPatronymic.getText());
        this.dispose();
    }

    private void addPanels(){
        JPanel bottomPanel = new JPanel();
        JPanel centerPanel = new JPanel();
        bottomPanel.setBackground(Color.BLUE);

        setLayout(new BorderLayout());

        this.add(centerPanel, BorderLayout.CENTER);
        this.add(bottomPanel, BorderLayout.SOUTH);
        addBottonButton(bottomPanel, "Ok");
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
    }

    private void buttonPress(JButton jButton, HashMap<String, String> dataFIO){
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                closeEditFrame(dataFIO);
            }
        });
    }
}
