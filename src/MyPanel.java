 import com.toedter.calendar.JCalendar;
 import com.toedter.calendar.JDateChooser;
 import com.toedter.calendar.JDateChooserCellEditor;

 import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;


public class MyPanel extends JPanel implements ActionListener {

    JTextField FieldImie, FieldNazwisko, FieldDni, FieldCena;
    JTable TableSamochody, TableWypozyczenia;
    JButton mybutton, bOddaj, bWypozycz, usunPozycje;
    JLabel LabelImie, LabelNazwisko, LabelDni, LabelCena, LabelSamochody, LabelWypozyczone, LabelKlient;
    JList DlugoscWypoz;
    JDateChooser data;

    public MyPanel() {

        setLayout(null);
        setBackground(new Color(0x9471));

        // wybor menagera tutaj zaden
// SEKCJA SAMOCHODY Dostepne do wypozyczenia:

        LabelSamochody = new JLabel("Samochody dostepne");
        LabelSamochody.setBounds(50, 50, 200, 20);
        add(LabelSamochody);

        // SEKCJA SAMOCHODY WYPOZYCZONE

        LabelWypozyczone = new JLabel("Wypozyczone samochody");
        LabelWypozyczone.setBounds(650, 50, 200, 20);
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

       // FieldDni = new JTextField("Ilość Dni");
       // FieldDni.setBounds(xField, 250, 200, 20);
       // add(FieldDni);

        DlugoscWypoz = new JList<String>( new String[]
                {" do 24h","od 24h do 72h","od 72h do 168", "powyżej tygodnia" });
        DlugoscWypoz.setBounds(xField,250,100,75 );
        add(DlugoscWypoz);

        FieldCena = new JTextField("Cena");
        FieldCena.setBounds(xField, 350, 200, 20);
        add(FieldCena);

        bWypozycz = new JButton("Wypozycz Auto");
        bWypozycz.setBounds(400, 400, 150, 30);
        add(bWypozycz);
        bWypozycz.addActionListener(this);

       /* data = new JDateChooser();
        data.setBounds(750,400,200,50 );
        add(data);
*/
        usunPozycje = new JButton("usuń pozycję");
        usunPozycje.setBounds(750, 400, 200, 50 );





//  odswierz tabele wypozyczenia
        bOddaj = new JButton("Odswiez tabele");
        bOddaj.setBounds(450, 450, 150, 30);
        add(bOddaj);
        bOddaj.addActionListener(this);


        mybutton = new JButton("Wybierz samochód");
        mybutton.setBounds(200, 400, 150, 40);
        add(mybutton);
        mybutton.setFocusable(false);
        mybutton.addActionListener(this);


        TableSamochody = new JTable();
        TableWypozyczenia = new JTable();

       /* JPanel panel = new JPanel();
        panel.setBackground(Color.black);
        panel.setLayout(new BorderLayout());

        JScrollPane pane = new JScrollPane(TableSamochody);
        panel.add(pane, BorderLayout.CENTER);
*/
        TableSamochody.setBounds(20, 100, 300, 250);
        add(TableSamochody);

        TableWypozyczenia.setBounds(650, 100, 500, 250);
        add(TableWypozyczenia);

        odswiezSamochody();
        odswiezWypozyczenia();
    }


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
        } else if (e.getSource() == bWypozycz) {
            wypozyczSamochod();
        }

    }

    public void wypozyczSamochod() {
        String imie = FieldImie.getText();
        String nazwisko = FieldNazwisko.getText();
        String dlugosc_wypozyczenia = DlugoscWypoz.getSelectedValue().toString();
        Double cena = Double.parseDouble(FieldCena.getText());
        long idnowy = DBConnection.DodajKlienta(imie, nazwisko);
        int wybranyWierszSamochod = TableSamochody.getSelectedRow();
        String wybranyIdSamochoduString = TableSamochody.getModel().getValueAt(wybranyWierszSamochod, 0).toString();
        int wybranyIdSamochoduInt = Integer.parseInt(wybranyIdSamochoduString);

        System.out.println("dlugosc_wypozyczenia " + dlugosc_wypozyczenia);
        System.out.println("cena" + cena);
        System.out.println("idnowy" + idnowy);
        System.out.println("wybranyIdSamochoduInt" + wybranyIdSamochoduInt);

        DBConnection.DodajWypozyczenie((int) idnowy, wybranyIdSamochoduInt, dlugosc_wypozyczenia, cena);
        odswiezWypozyczenia();
    }


    public void  odswiezWypozyczenia() {
        System.out.println("odswieWypozyczenia - Start");
        DefaultTableModel model = new DefaultTableModel();
        Object[] columnsName = new Object[5];
        columnsName[0] = "imie";
        columnsName[1] = "nazwisko";
        columnsName[2] = "nazwa";
        columnsName[3] = "dlugosc_wypozyczenia";
        columnsName[4] = "cena";

        model.setColumnIdentifiers(columnsName);

        Object[] rowData = new Object[5];

        List<Wypozyczenia> wypozyczenia = DBConnection.pobierzWypozyczenia();
        System.out.println("odswiezWypozyczenia - Ilość pobranych wypozyczeń: " + wypozyczenia.size());
        for (int i = 0; i < wypozyczenia.size(); i++) {
            Wypozyczenia wypozyczenie = wypozyczenia.get(i);
            rowData[0] = wypozyczenie.getImie();
            rowData[1] = wypozyczenie.getNazwisko();
            rowData[2] = wypozyczenie.getNazwa();
            rowData[3] = wypozyczenie.getDlugosc_wypozyczenia();
            rowData[4] = wypozyczenie.getCena();

            model.addRow(rowData);

        }

        TableWypozyczenia.setModel(model);
        System.out.println("odswiezWypozyczenia - Koniec");
    }

}



