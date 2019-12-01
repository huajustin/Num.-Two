package GUI;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame implements ActionListener {

    public GUI(){
        super("Washroom nears me.");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(700, 500));
        ((JPanel) getContentPane()).setBorder(new EmptyBorder(13, 13, 13, 13));
        setLayout(new FlowLayout());
        button();


        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        setLayout(null);
    }

    public void button(){
        JButton btn = new JButton("Set Location");
        add(btn);
        btn.setLocation(350, 250);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
