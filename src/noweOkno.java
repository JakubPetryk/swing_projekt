import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class noweOkno {

        JFrame frame = new JFrame("Twoj wybor");
        JLabel label = new JLabel("Wybierz samochód z tabeli");

        noweOkno() {

            label.setBounds(0,0,100,50);
            label.setFont(new Font(null,Font.PLAIN,15));

            frame.add(label);

            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(600, 400);
            frame.setLayout(null);
            frame.setVisible(true);

        }
}



