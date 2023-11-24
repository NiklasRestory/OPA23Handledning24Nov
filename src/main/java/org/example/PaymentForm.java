package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PaymentForm {
    private JTextField frånKontoField;
    private JTextField tillKontoField;
    private JTextField hurMycketField;
    private JButton makeTransactionButton;
    private JPanel paymentPanel;
    private JLabel messageLabel;
    private JLabel fromLabel;
    private JLabel toLabel;
    private JTextField goToKontoText;
    private JButton goToButton;

    private JFrame jFrame;

    ArrayList<Konto> kontoList = new ArrayList<>();

    public PaymentForm() {
        kontoList.add(new Konto("33333", 4000));
        kontoList.add(new Konto("1234", 300));
        kontoList.add(new Konto("5678", 9000));
        kontoList.add(new Konto("112358", 1321));

        jFrame = new JFrame();
        jFrame.setSize(400, 400);
        jFrame.setLocationRelativeTo(null);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setTitle("Payment Window");
        jFrame.setContentPane(paymentPanel);
        jFrame.setVisible(true);

        makeTransactionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Konto from = getKontoByKontonummer(frånKontoField.getText());
                Konto to = getKontoByKontonummer(tillKontoField.getText());
                int amount = Integer.MIN_VALUE;
                try {
                    amount = Integer.parseInt(hurMycketField.getText());
                }
                catch (Exception ex) {
                }

                if (from != null && to != null && amount != Integer.MIN_VALUE) {
                    if (from.getBalance() >= amount) {
                        from.setBalance(from.getBalance() - amount);
                        to.setBalance(to.getBalance() + amount);
                        messageLabel.setText("Transaction successful.");
                        fromLabel.setText(from.getKontonummer() + " now has " + from.getBalance() + "kr.");
                        toLabel.setText(to.getKontonummer() + " now has " + to.getBalance() + "kr.");
                    }
                    else {
                        messageLabel.setText("Insufficient funds in " + from.getKontonummer());
                    }
                }
                else {
                    messageLabel.setText("Could not complete transaction. Inaccurate data.");
                }
            }
        });

        PaymentForm thisPaymentForm = this;

        goToButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Konto konto = getKontoByKontonummer(goToKontoText.getText());
                if (konto != null) {
                    KontoForm kontoForm = new KontoForm(konto);
                    kontoForm.setPaymentForm(thisPaymentForm);
                }
                else {
                    messageLabel.setText("There is no account with that number.");
                }
            }
        });
    }

    public Konto getKontoByKontonummer(String kontoNummer) {
        for (Konto konto: kontoList) {
            if (konto.getKontonummer().equals(kontoNummer)) {
                return konto;
            }
        }
        return null;
    }
}
