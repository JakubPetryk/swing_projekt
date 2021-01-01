import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class Main {


    public static void main(String[] args) {

        // POLACZENIE Z BAZA DANYCH
        DBConnection.DBConnect();

        // GUI
        JFrame window = new JFrame("Wypożyczalnia samochodów");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(1200, 800);
        window.setVisible(true);
        window.add(new MyPanel());
        window.pack();




    }

}



