/**
 * 
 */
package gui;

import personen.Angestellter;
import personen.Lehrbeauftragter;
import personen.Person;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Diese Klasse ist für die Darstellung der Angestellten
 * zuständig.
 * 
 * @author konrad
 */
public class LehrbeauftragtenGui extends JInternalFrame {

	private Lehrbeauftragter lehrbeauftragterFeld[];

	// Graphische Elemente der Oberfläche
	private JTable table;
	private DefaultTableModel model;
	private JPanel panel;
	private JScrollPane scrollPane;

	/**
	 * @param title
	 */
	public LehrbeauftragtenGui(String title, Lehrbeauftragter lehrbeauftragterFeld[]) {
		this(title, true, lehrbeauftragterFeld);
	}

	/**
	 * @param title
	 * @param resizable
	 */
	public LehrbeauftragtenGui(String title, boolean resizable,
                               Lehrbeauftragter lehrbeauftragterFeld[]) {
		this(title, resizable, true, lehrbeauftragterFeld);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param title
	 * @param resizable
	 * @param closable
	 */
	public LehrbeauftragtenGui(String title, boolean resizable, boolean closable,
                               Lehrbeauftragter lehrbeauftragterFeld[]) {
		this(title, resizable, closable, true, lehrbeauftragterFeld);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param title
	 * @param resizable
	 * @param closable
	 * @param maximizable
	 */
	public LehrbeauftragtenGui(String title, boolean resizable, boolean closable, boolean maximizable,
                               Lehrbeauftragter lehrbeauftragterFeld[]) {
		this(title, resizable, closable, maximizable, true, lehrbeauftragterFeld);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Umfangreichster Konstruktor zum Erzeugen eines Fensters
	 * für Angestellte, das als JInternalFrame einem JDesktop
	 * hinzugefügt werden kann.
	 * @param title
	 * @param resizable
	 * @param closable
	 * @param maximizable
	 * @param iconifiable
	 */
	public LehrbeauftragtenGui(String title, boolean resizable, boolean closable, boolean maximizable,
                               boolean iconifiable,
                               Lehrbeauftragter lehrbeauftragterFeld[]) {
		super(title, resizable, closable, maximizable, iconifiable);
		
		this.lehrbeauftragterFeld = lehrbeauftragterFeld;
		
		this.model = new DefaultTableModel();
		this.table = new JTable(this.model);
		
		// Erstellen eines Panels für den Inhalt des internen Frames
        this.panel = new JPanel(new BorderLayout());
		
		this.scrollPane = new JScrollPane(this.table);
		panel.add(scrollPane, BorderLayout.CENTER);

		// Create a button to save changes
		JButton speichernButton = new JButton("Änderungen speichern");
		speichernButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				aenderungenSpeichern();
			}
		});		
		panel.add(speichernButton, BorderLayout.SOUTH);

		this.add(panel);

		// x, y, breite, hoehe
		this.setBounds(0, 0, 190, 200);
		this.setVisible(true);
		String spaltenNamen[] = { "Name", "Personalnummer" };
		erzeugeTabelle(lehrbeauftragterFeld, spaltenNamen);
	}

	/**
	 * Das Datenmodell der Tabelle mit Daten befüllen.
	 * @param datenQuelle 1D-Feld mit Angestellten-Objekten.
	 * @param spaltenNamen 1D-Feld mit den Namen bzw. 
	 * 		Überschriften der Spalten.
	 */
	private void erzeugeTabelle(Object datenQuelle[], String spaltenNamen[]) {
		// Erstellen der Daten für die Tabelle
		Object[][] daten = new Object[datenQuelle.length][spaltenNamen.length];
		for(int zeile = 0; zeile < datenQuelle.length; zeile++) {
			int spalte = 0;
			daten[zeile][spalte] = ((Lehrbeauftragter)datenQuelle[zeile]).getName();
			spalte++;
			//daten[zeile][spalte] = ((Lehrbeauftragter)datenQuelle[zeile]).getPersonalNr();
		}
		this.model.setRowCount(datenQuelle.length);
		this.model.setDataVector(daten, spaltenNamen);
		this.setVisible(true);
	}

	/**
	 * Die interaktiven Änderungen in der Tabelle
	 * im Feld der Angestellten speichern. 
	 */
	private void aenderungenSpeichern() {
		int zeilenN = this.model.getRowCount();
		int spaltenN = this.model.getColumnCount();
		String name; 
		int personalNr;
		for(int zeile = 0; zeile < zeilenN; zeile++) {
			name = (String)(this.model.getValueAt(zeile, 0));
			Object o = this.model.getValueAt(zeile, 1);
			personalNr = 0;
			// Greift, sobald einmal eine Zelle geändert worden ist
			if(o instanceof String) {
				String text = (String)o;
				personalNr = Integer.parseInt(text);
			}
			// Greift, solange eine Zelle noch nicht geändert worden ist
			if(o instanceof Integer) {
				personalNr = (Integer)(this.model.getValueAt(zeile, 1));
			}
			lehrbeauftragterFeld[zeile].setName(name);
		}
	}
	
}
