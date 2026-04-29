import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RDCalculatorUI extends JFrame {
    private JTextField depositField;
    private JTextField rateField;
    private JTextField tenureField;
    private JTextArea resultArea;

    public RDCalculatorUI() {
        setTitle("Recurring Deposit Calculator");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(4, 2, 10, 10));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        inputPanel.add(new JLabel("Monthly Deposit (₹):"));
        depositField = new JTextField();
        inputPanel.add(depositField);

        inputPanel.add(new JLabel("Annual Interest Rate (%):"));
        rateField = new JTextField();
        inputPanel.add(rateField);

        inputPanel.add(new JLabel("Tenure (Months):"));
        tenureField = new JTextField();
        inputPanel.add(tenureField);

        JButton calculateButton = new JButton("Calculate");
        inputPanel.add(calculateButton);

        add(inputPanel, BorderLayout.NORTH);

        resultArea = new JTextArea();
        resultArea.setEditable(false);
        resultArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        JScrollPane scrollPane = new JScrollPane(resultArea);
        add(scrollPane, BorderLayout.CENTER);

        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculate();
            }
        });
    }

    private void calculate() {
        try {
            double deposit = Double.parseDouble(depositField.getText());
            double rate = Double.parseDouble(rateField.getText());
            int tenure = Integer.parseInt(tenureField.getText());

            RecurringDeposit rd = new RecurringDeposit(deposit, rate, tenure);
            resultArea.setText(rd.getSummary());
        } catch (NumberFormatException ex) {
            resultArea.setText("Invalid input. Please enter valid numbers.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new RDCalculatorUI().setVisible(true);
        });
    }
}