package personen.studenten;

import personen.IMitarbeiter;

import java.util.Comparator;

public class DHStudent extends Student implements IMitarbeiter {

    private String kurs;

    public DHStudent(String Name, String k){
        super(Name);
        kurs = k;
    }

    @Override
    public void arbeitenOhneMurren() {

        System.out.println("Ich bin der DH-Student " + this.name + " und gehe daher immer freudig meine Arbeit an!");
    }

    public void druckeKurs(){
        System.out.println(this.kurs);
        druckeObjekt(true);

    }

    public class ComparatorKursName implements Comparator<DHStudent> {
        @Override
        public int compare(DHStudent dhs1, DHStudent dhs2) {
            int courseComparison = dhs1.kurs.compareTo(dhs2.kurs);
            if (courseComparison != 0) {
                return courseComparison;
            } else {
                return dhs1.name.compareTo(dhs2.name);
            }
        }
    }

    public class ComparatorSemesterNameKurs implements Comparator<DHStudent> {
        @Override
        public int compare(DHStudent dhs1, DHStudent dhs2) {
            int semesterComparison = Integer.compare(dhs1.getSemester(), dhs2.getSemester());
            if (semesterComparison != 0) {
                return semesterComparison;
            } else {
                int nameComparison = dhs1.name.compareTo(dhs2.name);
                if (nameComparison != 0) {
                    return nameComparison;
                } else {
                    return dhs1.kurs.compareTo(dhs2.kurs);
                }
            }
        }
    }

    public static void druckeAnzahl(){
        System.out.printf("DHStudent.anzahl: " + DHStudent.anzahl + "\n");
    }

    /*
    @Override
    public String toString() {
        return this.kurs + ": " + this.name + " (" + this.semester + ".Sem.)";
    }*/

    @Override
    public void inKantineEssen(){
        System.out.println("Wie lecker doch das Essen bei meiner Ausbildungsfirma schmeckt!");
    }

    public String getKurs() {
        return kurs;
    }
    public void setKurs(String kurs) {
        this.kurs = kurs;
    }
}
