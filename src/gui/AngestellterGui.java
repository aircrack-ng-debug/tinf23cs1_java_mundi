/**
 * 
 */
package gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import personen.Angestellter;
import personen.Person;

/**
 * Diese Klasse ist für die Darstellung der Angestellten
 * zuständig.
 * 
 * @author konrad
 */
public class AngestellterGui extends JInternalFrame {

	private Angestellter angestelltenFeld[];

	// Graphische Elemente der Oberfläche
	private JTable table;
	private DefaultTableModel model;
	private JPanel panel;
	private JScrollPane scrollPane;

	/**
	 * @param title
	 */
	public AngestellterGui(String title, Angestellter angestelltenFeld[]) {
		this(title, true, angestelltenFeld);
	}

	/**
	 * @param title
	 * @param resizable
	 */
	public AngestellterGui(String title, boolean resizable,
			Angestellter angestelltenFeld[]) {
		this(title, resizable, true, angestelltenFeld);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param title
	 * @param resizable
	 * @param closable
	 */
	public AngestellterGui(String title, boolean resizable, boolean closable,
			Angestellter angestelltenFeld[]) {
		this(title, resizable, closable, true, angestelltenFeld);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param title
	 * @param resizable
	 * @param closable
	 * @param maximizable
	 */
	public AngestellterGui(String title, boolean resizable, boolean closable, boolean maximizable,
			Angestellter angestelltenFeld[]) {
		this(title, resizable, closable, maximizable, true, angestelltenFeld);
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
	public AngestellterGui(String title, boolean resizable, boolean closable, boolean maximizable,
			boolean iconifiable,
			Angestellter angestelltenFeld[]) {
		super(title, resizable, closable, maximizable, iconifiable);
		
		this.angestelltenFeld = angestelltenFeld;
		
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
		erzeugeTabelle(angestelltenFeld, spaltenNamen);
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
			daten[zeile][spalte] = ((Person)datenQuelle[zeile]).getName();
			spalte++;
			daten[zeile][spalte] = ((Angestellter)datenQuelle[zeile]).getPersonalNr();
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
			angestelltenFeld[zeile].setName(name);
			angestelltenFeld[zeile].setPersonalNr(personalNr);
		}
	}
	
}
