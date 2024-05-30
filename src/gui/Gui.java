/**
 * 
 */
package gui;

import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import personen.Angestellter;
import personen.IKlausurSchreiber;
import personen.IMitarbeiter;
import personen.Lehrbeauftragter;
import personen.Person;
import personen.studenten.DHStudent;
import personen.studenten.Student;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.lang.RuntimeException;

/**
 * @author konrad
 *
 */

public class Gui extends JFrame {
	
	private IMitarbeiter mitarbeiterFeld[];
	private Lehrbeauftragter lehrbeauftragtenFeld[];
	private IKlausurSchreiber prueflinge[];
	private DHStudent dhStudentenFeld[];
	private Student studentenFeld[];
	
	private JDesktopPane desktop;
	private JMenuBar menuBar;
	
	private AngestellterGui angestellterGui;
	private StudentGui studentGui;
	private DHStudentGui dhStudentGui;
	private LehrbeauftragtenGui lehrbeauftragtenGui;
	
	/**
	 * Konstruktor.
	 * mitarbeiterFeld, lehrbeauftragtenFeld, prueflinge,
				dhStudentenFeld, studentenFeld
	 */
	public Gui(
			Angestellter angestelltenFeld[],
			IMitarbeiter mitarbeiterFeld[],
			Lehrbeauftragter lehrbeauftragtenFeld[],
			IKlausurSchreiber prueflinge[],
			Student studentenFeld[],
			DHStudent dhStudentenFeld[]) {
		// Konstruktor von JFrame mit Fenstertitel
		super("TINF23CS1");

		this.mitarbeiterFeld = mitarbeiterFeld;
		this.lehrbeauftragtenFeld = lehrbeauftragtenFeld;
		this.prueflinge = prueflinge;
		this.studentenFeld = studentenFeld;
		this.dhStudentenFeld = dhStudentenFeld;
		
		// Erstellen des Fensters
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(800, 600);

		// Erstellen der Menüleiste
		this.menuBar = new JMenuBar();

		// Erstellen des "Datei"-Menüs
		JMenu fileMenu = new JMenu("Datei");
		JMenuItem newMenuItem = new JMenuItem("Neu");
		JMenuItem openMenuItem = new JMenuItem("Öffnen");
		JMenuItem saveMenuItem = new JMenuItem("Speichern");
		JMenuItem exitMenuItem = new JMenuItem("Beenden");

		// Hinzufügen der Menüelemente zum "Datei"-Menü
		fileMenu.add(newMenuItem);
		fileMenu.add(openMenuItem);
		fileMenu.add(saveMenuItem);
		fileMenu.addSeparator();
		fileMenu.add(exitMenuItem);

		// Erstellen des "Bearbeiten"-Menüs
		JMenu editMenu = new JMenu("Bearbeiten");
		JMenuItem cutMenuItem = new JMenuItem("Ausschneiden");
		JMenuItem copyMenuItem = new JMenuItem("Kopieren");
		JMenuItem pasteMenuItem = new JMenuItem("Einfügen");

		// Hinzufügen der Menüelemente zum "Bearbeiten"-Menü
		editMenu.add(cutMenuItem);
		editMenu.add(copyMenuItem);
		editMenu.add(pasteMenuItem);
		
		// Erstellen des "Anzeigen"-Menüs
		JMenu anzeigeMenu = new JMenu("Anzeigen");
		JMenuItem angestelltenMenuItem = new JMenuItem("Angestellte");
		JMenuItem mitarbeiterMenuItem = new JMenuItem("Mitarbeiter");
		JMenuItem lehrbeauftragterMenuItem = new JMenuItem("Lehrbeauftragte");
		JMenuItem prueflingeMenuItem = new JMenuItem("Prüflinge");
		JMenuItem studentenMenuItem = new JMenuItem("Studenten");
		JMenuItem dhStudentenMenuItem = new JMenuItem("DH-Studenten");

		// Hinzufügen der Menüelemente zum "Anzeigen"-Menü
		anzeigeMenu.add(angestelltenMenuItem);
		anzeigeMenu.add(mitarbeiterMenuItem);
		anzeigeMenu.add(lehrbeauftragterMenuItem);
		anzeigeMenu.add(prueflingeMenuItem);
		anzeigeMenu.add(studentenMenuItem);
		anzeigeMenu.add(dhStudentenMenuItem);
		
		// Hinzufügen der Menüs zur Menüleiste
		menuBar.add(fileMenu);
		menuBar.add(editMenu);
		menuBar.add(anzeigeMenu);

		// Hinzufügen der Menüleiste zum JFrame
		this.setJMenuBar(menuBar);

        // Desktop-Fläche für die "JInternalFrame"-Fenster erstellen
        this.desktop = new JDesktopPane();
        setContentPane(desktop);
       
		// Hinzufügen der ActionListener zu den Menüelementen
		exitMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		newMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(Gui.this, "Neu ausgewählt");
			}
		});

		openMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(Gui.this, "Öffnen ausgewählt");
			}
		});

		saveMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(Gui.this, "Speichern ausgewählt");
			}
		});

		cutMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(Gui.this, "Ausschneiden ausgewählt");
			}
		});

		copyMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(Gui.this, "Kopieren ausgewählt");
			}
		});

		pasteMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(Gui.this, "Einfügen ausgewählt");
			}
		});

		angestelltenMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (angestellterGui != null)
					desktop.remove(angestellterGui);
		        String title = "Angestellte";
		        boolean resizable = true;
		        boolean closable = true;
		        boolean maximizable = true;
		        angestellterGui = new AngestellterGui(
		        		title, resizable, closable, maximizable, 
		        		angestelltenFeld);        
		        desktop.add(angestellterGui);
			}
		});

		studentenMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (studentGui != null)
					desktop.remove(studentGui);
		        String title = "Studenten (KEINE DH!)";
		        boolean resizable = true;
		        boolean closable = true;
		        boolean maximizable = true;
		        studentGui = new StudentGui(
		        		title, resizable, closable, maximizable, 
		        		studentenFeld);        
		        desktop.add(studentGui);
			}
		});

		dhStudentenMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (dhStudentGui != null)
					desktop.remove(dhStudentGui);
		        String title = "DHBW-Studenten";
		        boolean resizable = true;
		        boolean closable = true;
		        boolean maximizable = true;
		        dhStudentGui = new DHStudentGui(
		        		title, resizable, closable, maximizable, 
		        		dhStudentenFeld);        
		        desktop.add(dhStudentGui);
			}
		});

		lehrbeauftragterMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(lehrbeauftragtenGui != null)
					desktop.remove(lehrbeauftragtenGui);
				String title = "Lehrbeauftragte";
				boolean resizable = true;
				boolean closable = true;
				boolean maximizable = true;
				lehrbeauftragtenGui = new LehrbeauftragtenGui(
						title,resizable,closable,maximizable, lehrbeauftragtenFeld
				);
				desktop.add(lehrbeauftragtenGui);
			}
		});

		// Anzeigen des Fensters
		this.setVisible(true);
	}


}


