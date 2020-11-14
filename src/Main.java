import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Main {


    public static void main(String[] args) {

        // POLACZENIE Z BAZA DANYCH
        DBConnection.DBConnect();

        // GUI
        JFrame window = new JFrame("Wypożyczalnia samochodów");
        window.add(new MyPanel());
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
        window.pack();

    }

}



