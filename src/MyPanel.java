import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class MyPanel extends JPanel implements ActionListener {

    JTextField FieldImie, FieldNazwisko, FieldDni, FieldCena;
    JTable TableSamochody, TableWypozyczone;
    JFrame frame = new JFrame("Wypozyczalnia samochdow");
    JButton mybutton, bOddaj, bWypozycz;
    JLabel LabelImie, LabelNazwisko, LabelDni, LabelCena, LabelSamochody, LabelWypozyczone, LabelKlient;
    JPanel panel;



    public MyPanel() {


/*
        frame.add(mybutton);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200, 600);
        frame.setLayout(null);
        frame.setVisible(true);
*/
        // TextFields Imie, Nazwisko, Ilosc Dni , Cena

        setLayout(null);

        // wybor menagera tutaj zaden
// SEKCJA SAMOCHODY Dostepne do wypozyczenia:

        LabelSamochody = new JLabel("Samochody dostepne");
        LabelSamochody.setBounds(100, 50, 200, 20);
        add(LabelSamochody);

        // SEKCJA SAMOCHODY WYPOZYCZONE

        LabelWypozyczone = new JLabel("Wypozyczone samochody");
        LabelWypozyczone.setBounds(900, 50, 200, 20);
        add(LabelWypozyczone);

        //SEKCJA DO WPISYWANIA KLIENTA I WYPOZYCZENIA

        LabelKlient = new JLabel("Klient");
        LabelKlient.setBounds(500, 50, 200, 20);
        add(LabelKlient);

        LabelImie = new JLabel("Imie");
        LabelImie.setBounds(600, 150, 100, 20);
        //  add(LabelImie);

        int xField = 400;
        FieldImie = new JTextField("Imie");
        FieldImie.setBounds(xField, 150, 200, 20);
        add(FieldImie);

        FieldNazwisko = new JTextField("Nazwisko");
        FieldNazwisko.setBounds(xField, 200, 200, 20);
        add(FieldNazwisko);

        FieldDni = new JTextField("Ilość Dni");
        FieldDni.setBounds(xField, 250, 200, 20);
        add(FieldDni);

        FieldCena = new JTextField("Cena");
        FieldCena.setBounds(xField, 300, 200, 20);
        add(FieldCena);

        bWypozycz = new JButton("Wypozycz Auto");
        bWypozycz.setBounds(400, 400, 150, 30);
        add(bWypozycz);

// SEKCJA ODDAJ AUTO
        bOddaj = new JButton("Oddaj Auto");
        bOddaj.setBounds(800, 400, 150, 30);
        add(bOddaj);

        mybutton = new JButton("Wybierz samochód");
        mybutton.setBounds(200, 400, 150, 40);
        add(mybutton);
        mybutton.setFocusable(false);
        mybutton.addActionListener(this);


        //button.setText("Kliknij");
        //dispose() wyjscie po kliknieciu
        bWypozycz.addActionListener(this);

        TableSamochody = new JTable();

        TableWypozyczone = new JTable();

        panel = new JPanel();


        panel.setLayout(new BorderLayout());

        JScrollPane pane = new JScrollPane(TableSamochody);

        panel.add(pane, BorderLayout.CENTER);

        TableSamochody.setBounds(20, 100, 300, 250);
        add(TableSamochody);

        TableWypozyczone.setBounds(800,100,300, 250 );
        add(TableWypozyczone);


        odswiezSamochody();
    }
   /*     List<Klijent> klienci = DBConnection.pobierzKlientow();

        DefaultTableModel model = new DefaultTableModel();
        Object[] columnsName = new Object[2];
        columnsName[0] = "Imie";
        columnsName[1] = "Nazwisko";

        model.setColumnIdentifiers(columnsName);

        Object[] rowData = new Object[2];

        for (int i = 0; i < klienci.size(); i++) {

            rowData[0] = klienci.get(i).getImie();
            rowData[1] = klienci.get(i).getNazwisko();

            model.addRow(rowData);

        }


        List<Samochody> samochodyDane = DBConnection.pobierzSamochody();

        DefaultTableModel model1 = new DefaultTableModel();
        Object[] columnsName1 = new Object[1];
        columnsName1[0] = "Nazwa";

        model1.setColumnIdentifiers(columnsName1);

        Object[] rowData1 = new Object[1];

        rowData1[1] = samochodyDane.get(1);
        model.addRow(rowData1);

        tKlijent = new JTable();
        tKlijent.setModel(model);
        frame.setLayout(new BorderLayout());
        JScrollPane pane = new JScrollPane(tKlijent);
        frame.add(pane, BorderLayout.CENTER);
        tKlijent.setBounds(400, 50, 300, 150);
        frame.add(tKlijent);

        tSamochody = new JTable();
        tSamochody.setModel(model1);
        frame.setLayout(new BorderLayout());
        JScrollPane pane1 = new JScrollPane(tSamochody);
        frame.add(pane1, BorderLayout.CENTER);
        tSamochody.setBounds(100,250, 300,150 );
        frame.add(tSamochody);
*/


    public void odswiezSamochody() {
        System.out.println("odswiezSamochody - Start");
        DefaultTableModel model = new DefaultTableModel();
        Object[] columnsName = new Object[2];
        columnsName[0] = "ID";
        columnsName[1] = "Nazwa";

        model.setColumnIdentifiers(columnsName);

        Object[] rowData = new Object[2];

        List<Samochody> samochody = DBConnection.pobierzSamochody();
        System.out.println("odswiezSamochody - Ilość pobranych samochodów: " + samochody.size());
        for (int i = 0; i < samochody.size(); i++) {
            Samochody samochod = samochody.get(i);
            rowData[0] = samochod.getId_samochody();
            rowData[1] = samochod.getNazwa();

            model.addRow(rowData);
        }

        TableSamochody.setModel(model);
        System.out.println("odswiezSamochody - Koniec");
    }


    @Override
    public Dimension getPreferredSize() {
        return new Dimension(1200, 600);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == mybutton) {

            noweOkno noweokno = new noweOkno();
        }
        else if (e.getSource() == bWypozycz) {
            wypozyczSamochod();
        }

    }

    public void wypozyczSamochod() {
        String imie = FieldImie.getText();
        String nazwisko = FieldNazwisko.getText();
        DBConnection.DodajKlienta(imie, nazwisko);
    }


}

