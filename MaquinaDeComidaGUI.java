// -*- coding: utf-8 -*-




import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MaquinaDeComidaGUI implements ActionListener {

    private JFrame frame;
    private JPanel panel;
    private JLabel label;
    private JButton button1, button2, button3, button4, button5;
    private JTextArea textArea;
    private double saldo;
    private double precoDoItem;
    private boolean itemSelecionado;

    public MaquinaDeComidaGUI() {

        frame = new JFrame("Máquina de Comida");
        frame.setSize(900, 500);

        panel = new JPanel(new GridLayout(6, 1));

        label = new JLabel("Selecione o item desejado:");
        panel.add(label);

        button1 = new JButton("Salgadinho - 100$");
        button1.addActionListener(this);
        panel.add(button1);

        button2 = new JButton("Chocolate - 200$");
        button2.addActionListener(this);
        panel.add(button2);

        button3 = new JButton("Refrigerante - 300$");
        button3.addActionListener(this);
        panel.add(button3);
        
        button4 = new JButton("Batata Frita - 350$");
        button4.addActionListener(this);
        panel.add(button4);

        button5 = new JButton("Biscoito - 100$");
        button5.addActionListener(this);
        panel.add(button5);

        textArea = new JTextArea(10, 25);
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        panel.add(scrollPane);

        frame.add(panel);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == button1) {
            precoDoItem = 100;
            itemSelecionado = true;
        } else if (e.getSource() == button2) {
            precoDoItem = 200;
            itemSelecionado = true;
        } else if (e.getSource() == button3) {
            precoDoItem = 300;
            itemSelecionado = true;
        } else if (e.getSource() == button4) {
            precoDoItem = 350;
            itemSelecionado = true;
        } else if (e.getSource() == button5) {
            precoDoItem = 100;
            itemSelecionado = true;
        }

        if (itemSelecionado) {
            textArea.append("Você selecionou: " + e.getActionCommand() + "\n");

            while (saldo < precoDoItem) {
                String input = JOptionPane.showInputDialog(frame, "Insira dinheiro:");
                double valorInserido = Double.parseDouble(input);
                saldo += valorInserido;
            }

            double troco = saldo - precoDoItem;
            if (troco > 0) {
                textArea.append("Seu troco é:" + troco + "\n");
            }

            textArea.append("Obrigado pela compra!\n");
            saldo = 0;
            itemSelecionado = false;
        }
    }

    public static void main(String[] args) {
        new MaquinaDeComidaGUI();
    }
}