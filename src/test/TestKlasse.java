package test;
import personen.*;
import personen.studenten.DHStudent;
import personen.studenten.Student;
import gui.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class TestKlasse {

    static Student []  studentenFeld= {
            new Student("Emil"),
            new Student("Emil"),
            new Student("Armin"),
            new Student("Fritz"),
            new Student("Ernst"),
            new Student("Erna"),

    };
    static Lehrbeauftragter[] lehrbeauftragtenFeld = {
            new Lehrbeauftragter("Dr. Schlau"),
            new Lehrbeauftragter("Prof. Einfallsreich"),
            new Lehrbeauftragter("Dipl.-Ing. Pfiffikus"),
            new Lehrbeauftragter("OStR Lehrreich"),
    };
    static Angestellter[] angestelltenFeld = {
            new Angestellter("Meier", 101000),
            new Angestellter("Schulze", 101351),
            new Angestellter("Hartmann", 102605),
            new Angestellter("Grosskopf", 103731),
            new Angestellter("Haudegen", 104566),
    };

    static DHStudent[] dhStudentenFeld = {
            new DHStudent("Anton", "TINF22CS1"),
            new DHStudent("Michael", "TINF22CS1"),
            new DHStudent("Uwe", "TINF22CS1"),
            new DHStudent("Christian", "TINF22CS1"),
            new DHStudent("Christian", "TINF23CS1"),
            new DHStudent("Christiane", "TINF23CS1"),
            new DHStudent("Uwe", "TINF23CS1"),
            new DHStudent("Michaela", "TINF23CS1"),
    };
    static IMitarbeiter[] mitarbeiterenFeld = new IMitarbeiter[dhStudentenFeld.length + angestelltenFeld.length];

    public TestKlasse(){

         /*4.3 a) --> Es sind deshalb 19 Personen selbst wenn ich es als erste Anweisung einfügen würde, weil
        die Arrays in Testklasse Static sind. Damit werden die Objekte direkt zu Programmanfang initialisiert*/
        Person.druckeAnzahl();

        /*4.3 b) */
        Firma firma = new Firma("DH-Partnerfirma GmbH");
        firma.druckeName();

        /*4.3 c)*/
        int mitarbeiterzahl = angestelltenFeld.length + dhStudentenFeld.length;
        System.out.println(mitarbeiterzahl);

        /*4.3 d) */
        int index = 0;
        for(Angestellter angestellter : angestelltenFeld){
            mitarbeiterenFeld[index++] = angestellter;
        }
        for(DHStudent dhStudent: dhStudentenFeld){
            mitarbeiterenFeld[index++] = dhStudent;
        }

        /*4.3 e)*/
        for(IMitarbeiter mitarbeiter : mitarbeiterenFeld){
            mitarbeiter.arbeitenOhneMurren();
        }

        /*4.3 f)*/
        List<Lehrbeauftragter> lehrbeauftragterList = Arrays.asList(lehrbeauftragtenFeld);
        for(Lehrbeauftragter l : lehrbeauftragterList){
            System.out.println(l.toString());
        }

        /*4.3 g)*/
        Lehrbeauftragter l_einfallsreich = lehrbeauftragterList.get(1);
        ArrayList<IKlausurSchreiber> arrayList = new ArrayList<IKlausurSchreiber>();
        for(DHStudent dhStudent : dhStudentenFeld){
            System.out.println(dhStudent.getSemester() + "getsemester");
            if(dhStudent.getSemester() == 1 || dhStudent.getSemester() == 2){
                arrayList.add(dhStudent);
                System.out.println("Added");
            }
        }
        System.out.println(arrayList);

        /*4.3 h) */
        if(arrayList.toArray().length == 0){
            throw new Feldgroesse0Exception("Keine Prueflinge vorhanden! :-(");
        }

        System.out.println("Anzahl der Prüflinge: " + arrayList.toArray().length);

        /*4.3 i)*/
        IKlausurSchreiber prueflinge[] = new IKlausurSchreiber[arrayList.size()];
        prueflinge = arrayList.toArray(prueflinge);
        lehrbeauftragtenFeld[1].setPrueflinge(prueflinge);

        System.out.println("Lehrbeauftragter " + lehrbeauftragtenFeld[1].getName() + "laesst eine Klausur schreiben:");
        lehrbeauftragtenFeld[1].lasseKlausurSchreiben();

        /* der Lehrbeauftragte kann die Namen deshalb nicht einsehen, weil die namen protected sind. Wir können die Namen mithilfe
        eines getters bekommen, dieser wird nun aber nicht implementiert, da die Aufgabenstellung das nicht verlangt*/

        /*4.3 j)*/
        System.out.println("Ein Nachzuegler wird geclont und muss gleich die Klausur schreiben: ");
        Student nachzuegler = (Student)((Student) prueflinge[0]).clone();
        nachzuegler.klausurSchreiben();

        /*4.3 k)*/
        System.out.println("druckeObjekt() bei allen DH-Studenten testen:");
        for(DHStudent dhStudent : dhStudentenFeld){
            dhStudent.druckeObjekt();
        }

        /*4.3 m)*/
        Arrays.sort(dhStudentenFeld, (dhStudentenFeld[0]).new ComparatorKursName());

        /*4.3 n)*/
        System.out.println("Die sortierten DH-Studenten:");
        System.out.println(Arrays.asList(dhStudentenFeld));

        /*4.3 o)*/
        System.out.println("Die DH-Studenten nach dem Semester, dem Namen und dem Kurs sortieren ...");
        Arrays.sort(dhStudentenFeld, (dhStudentenFeld[0]).new ComparatorSemesterNameKurs());
        System.out.println("Die sortierten DH-Studenten:");
        System.out.println(Arrays.asList(dhStudentenFeld));

        /*4.3 p)*/
        System.out.println("Die Personenanzahl aus Sicht Person:");
        Person.druckeAnzahl();

        System.out.println("Die Personenanzahl aus Sicht der Klasse DH-Student:");
        DHStudent.druckeAnzahl();

        /*4.3 q)*/
        /*Zugriff ist in der gleichen Klasse, in Unterklassen (auch in anderen Paketen) und in anderen Klassen im gleichen Paket erlaubt.*/


        Gui g = new Gui(angestelltenFeld,mitarbeiterenFeld,lehrbeauftragtenFeld,prueflinge,studentenFeld,dhStudentenFeld);
    }

    public static void main(String[] args) {

        System.out.println(Thread.currentThread().getName());
        TestKlasse test = new TestKlasse();

        /*Aufgabe 5*/
        System.out.println("Alle Mitarbeiter essen in der Kantine:");
        for(IMitarbeiter m : mitarbeiterenFeld){
            m.inKantineEssen();
        }

        DHStudent paul = new DHStudent("alfred","Tinf");
        System.out.println(paul.toString());
        Person.druckeAnzahl();
        paul = new DHStudent("Gert","tinf");
        System.out.println(paul.toString());
        Person.druckeAnzahl();



        /*DHStudent dhstudent = new DHStudent("Alfred","Tinf23cs1");
        System.out.println(dhstudent.toString());*/

    }
}
