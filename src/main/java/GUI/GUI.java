package GUI;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class GUI extends JFrame implements ActionListener {

    private JLabel first_label;

    public GUI(){
        super("Washroom nears me.");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(700, 500));
        ((JPanel) getContentPane()).setBorder(new EmptyBorder(13, 13, 13, 13));
        setLayout(new FlowLayout());
        button();
        MapImage();


        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        setLayout(null);
    }

    private void button(){
        JButton btn = new JButton("Set Location");
        add(btn);
        btn.setLocation(350, 250);
    }

    private void MapImage(){
        ImageIcon creeper = new ImageIcon("washrooms.png");
        first_label = new JLabel("Creeper", creeper, SwingConstants.CENTER);
        add(first_label);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
