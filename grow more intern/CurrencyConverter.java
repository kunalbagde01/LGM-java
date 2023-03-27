import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.*;

public class CurrencyConverter extends JFrame implements ActionListener {
    
    private static final long serialVersionUID = 1L;
    private JPanel panel;
    private JLabel amountLabel, fromLabel, toLabel, resultLabel;
    private JTextField amountField, resultField;
    private JComboBox<String> fromCurrencyBox, toCurrencyBox;
    private JButton convertButton;
    private double[] exchangeRates = {1.0, 0.012, 0.011, 0.017, 1.59};

    public CurrencyConverter() {   
        super("Currency Converter");
        
        panel = new JPanel(new FlowLayout());
        panel.setLayout(null);
        amountLabel = new JLabel("Amount:");
        

        fromLabel = new JLabel("From:");
        

        toLabel = new JLabel("To:");
       

        resultLabel = new JLabel("Result:");
        

        amountField = new JTextField(10);
        

        resultField = new JTextField(10);
        
        resultField.setEditable(false);

        convertButton = new JButton("Convert");
       

        convertButton.addActionListener(this);
        fromCurrencyBox = new JComboBox<String>(new String[] {"Rs", "USD", "EUR", "CAD", "YEN"});
        toCurrencyBox = new JComboBox<String>(new String[] {"Rs", "USD", "EUR", "CAD", "YEN"});

        panel.setBounds(50, 10, 280, 150);
        amountLabel.setBounds(50, 10, 80, 30);
        amountField.setBounds(250, 10, 160, 30);
        fromLabel.setBounds(50, 60, 80, 30);
        fromCurrencyBox.setBounds(250, 60, 160, 30);
        toLabel.setBounds(50, 110, 80, 30);
        toCurrencyBox.setBounds(250, 110, 160, 30);
        resultLabel.setBounds(50, 160, 80, 30);
        resultField.setBounds(250, 160, 160, 30);
        convertButton.setBounds(250, 210, 160, 30);

        Font font = new Font("Arial", Font.BOLD, 20); 

        amountLabel.setFont(font);
        fromLabel.setFont(font);
        toLabel.setFont(font);
        resultLabel.setFont(font);
        amountField.setFont(font);
        resultField.setFont(font);
        fromCurrencyBox.setFont(font);
        toCurrencyBox.setFont(font);
        convertButton.setFont(font);


        panel.add(amountLabel);
        panel.add(amountField);
        panel.add(fromLabel);
        panel.add(fromCurrencyBox);
        panel.add(toLabel);
        panel.add(toCurrencyBox);
        panel.add(resultLabel);
        panel.add(resultField);
        panel.add(convertButton);
        add(panel);
        setSize(500, 500);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == convertButton) {
            String fromCurrency = (String) fromCurrencyBox.getSelectedItem();
            String toCurrency = (String) toCurrencyBox.getSelectedItem();
            double amount = Double.parseDouble(amountField.getText());
            int fromIndex = getIndex(fromCurrency);
            int toIndex = getIndex(toCurrency);
            double result = amount / exchangeRates[fromIndex] * exchangeRates[toIndex];
            DecimalFormat df = new DecimalFormat("#.##");
            resultField.setText(df.format(result));
        }
    }

    private int getIndex(String currency) {
        switch (currency) {
            case "Rs":
                return 0;
            case "USD":
                return 1;
            case "EUR":
                return 2;
            case "CAD":
                return 3;
            case "YEN":
                return 4;
            default:
                return -1;
        }
    }

    public static void main(String[] args) {
        new CurrencyConverter();
    }
}
