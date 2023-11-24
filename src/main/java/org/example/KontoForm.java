package org.example;

import javax.swing.*;

public class KontoForm {
    private PaymentForm paymentForm;
    private JPanel kontoFormPanel;
    private JLabel kontoField;
    private JLabel balanceField;
    private JList transactionList;

    private JFrame jFrame = new JFrame();

    public KontoForm(Konto dettaKonto) {
        jFrame.setSize(400, 400);
        jFrame.setLocationRelativeTo(null);
        jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jFrame.setTitle("Payment Window");
        jFrame.setContentPane(kontoFormPanel);
        jFrame.setVisible(true);

        kontoField.setText(dettaKonto.getKontonummer());
        balanceField.setText(dettaKonto.getBalance() + "");
    }

    public void setPaymentForm(PaymentForm paymentForm) {
        this.paymentForm = paymentForm;
    }
}
