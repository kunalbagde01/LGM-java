import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Calculator implements ActionListener {
    private JFrame frame;
    private JTextField textField;
    private JButton[] numberButtons;
    private JButton[] functionButtons;
    private JButton addButton, subButton, mulButton, divButton;
    private JButton decButton, equButton, clrButton, delButton, negButton;
    private JButton sinButton, cosButton, tanButton, logButton, lnButton;
    private JPanel panel;
    
    private double num1 = 0, num2 = 0, result = 0;
    private char operator;

    public Calculator() {
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLayout(null);

        textField = new JTextField();
        textField.setBounds(30, 25, 400, 50);
        textField.setEditable(false);
        frame.add(textField);

        numberButtons = new JButton[10];
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
        }

        decButton = new JButton(".");
        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        equButton = new JButton("=");
        clrButton = new JButton("Clear");
        delButton = new JButton("Delete");
        sinButton = new JButton("sin");
        cosButton = new JButton("cos");
        tanButton = new JButton("tan");
        logButton = new JButton("log");
        lnButton = new JButton("ln");


        functionButtons = new JButton[] { addButton, subButton, mulButton, divButton, decButton, equButton, clrButton, delButton };

        for (JButton button : functionButtons) {
            button.addActionListener(this);
        }

        sinButton.addActionListener(this);
        cosButton.addActionListener(this);
        tanButton.addActionListener(this);
        logButton.addActionListener(this);
        lnButton.addActionListener(this);

        sinButton.setFont(new Font("Arial", Font.PLAIN, 18));
        cosButton.setFont(new Font("Arial", Font.PLAIN, 18));
        tanButton.setFont(new Font("Arial", Font.PLAIN, 18));
        logButton.setFont(new Font("Arial", Font.PLAIN, 18));
        lnButton.setFont(new Font("Arial", Font.PLAIN, 18));



        panel = new JPanel();
        panel.setBounds(30, 100, 400, 300);
        panel.setLayout(new GridLayout(6, 4, 10, 10));

        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);
        panel.add(decButton);
        panel.add(numberButtons[0]);
        panel.add(equButton);
        panel.add(divButton);
        panel.add(sinButton);
        panel.add(cosButton);
        panel.add(tanButton);
        panel.add(logButton);
        panel.add(lnButton);
        panel.add(clrButton);
        panel.add(delButton);

        frame.add(panel);

        clrButton.setBounds(50, 420, 100, 30);
        delButton.setBounds(180, 420, 100, 30);

       // frame.add(clrButton);
       // frame.add(delButton);

        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]) {
                textField.setText(textField.getText() + String.valueOf(i));
            }
        }
        if (e.getSource() == decButton) {
            textField.setText(textField.getText() + ".");
        }
        if (e.getSource() == addButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText("");
        }
        if (e.getSource() == subButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText("");
        }
        if (e.getSource() == mulButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '*';
            textField.setText("");
        }
        if (e.getSource() == divButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");
        }
        if (e.getSource() == equButton) {
            num2 = Double.parseDouble(textField.getText());

            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    result = num1 / num2;
                    break;
            }

            textField.setText(String.valueOf(result));
            num1 = result;
        }
        if (e.getSource() == clrButton) {
            textField.setText("");
        }
        if (e.getSource() == delButton) {
            String str = textField.getText();
            textField.setText("");
            for (int i = 0; i < str.length() - 1; i++) {
                textField.setText(textField.getText() + str.charAt(i));
            }
        }
        if (e.getSource() == sinButton) {
            num1 = Double.parseDouble(textField.getText());
            result = Math.sin(num1);
            textField.setText(String.valueOf(result));
        }
        if (e.getSource() == cosButton) {
            num1 = Double.parseDouble(textField.getText());
            result = Math.cos(num1);
            textField.setText(String.valueOf(result));
        }
        if (e.getSource() == tanButton) {
            num1 = Double.parseDouble(textField.getText());
            result = Math.tan(num1);
            textField.setText(String.valueOf(result));
        }
        if (e.getSource() == logButton) {
            num1 = Double.parseDouble(textField.getText());
            result = Math.log10(num1);
            textField.setText(String.valueOf(result));
        }
        if (e.getSource() == lnButton) {
            num1 = Double.parseDouble(textField.getText());
            result = Math.log(num1);
            textField.setText(String.valueOf(result));
        }
    }

    public static void main(String[] args) {
        new Calculator();
    }
}

