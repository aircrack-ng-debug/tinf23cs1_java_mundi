package personen.studenten;
import personen.IKlausurSchreiber;
import personen.Person;

import java.util.Random;

public class Student extends Person implements IKlausurSchreiber, Cloneable{

    public int semester;
    private double bafoegSchulden;
    private Random random;


    public Student(String Name){
        super(Name);
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        random = new Random(System.currentTimeMillis());
        if (this instanceof DHStudent){

            semester = random.nextInt(6)+1;

        }else{
            semester = random.nextInt(12) + 1; // random nextint von 12 Ziffern 0-11 sprich + 1 = 1 - 12
        }


        if (this instanceof DHStudent){
            bafoegSchulden = 0;
        }else{
            bafoegSchulden = semester * 3000;
        }
    }

    public void setBafoegSchulden(double a){
        this.bafoegSchulden =a;
    }

    @Override
    public Object clone() {
        try {
            Student cloned = (Student) super.clone();
            Person.anzahl++; // Erhöhe den Zähler für die Anzahl der Personen
            return cloned;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    public int getSemester(){
        return semester;
    }
    public void setSemester(int semester){
        this.semester = semester;
    }

    public void druckeSemester(){
        System.out.println("Semesterzahl " + this.semester);
    }

    public void druckeObjekt(boolean kurz){
        if(!kurz){druckeObjekt();
        }else{
            System.out.println("Der Student heißt " + this.name + " (" + this.semester + ".Sem.)");
        }
    }

    @Override
    public void druckeObjekt() {
        System.out.println("Der Student heißt " + this.name + ", ist im " +
                this.semester + ". Sem. und hat " + this.bafoegSchulden + "EUR Schulden wegen Bafoeg");
    }

    @Override
    public void klausurSchreiben() {
        String dh = (this instanceof DHStudent) ? "DH-" : "";
        System.out.println("Ich bin ein " + dh + "Student namens " + this.name + " und schreibe " + "meine Klausuren perfekt!");
    }

    public double getBafoegSchulden() {
        return bafoegSchulden;
    }
}
