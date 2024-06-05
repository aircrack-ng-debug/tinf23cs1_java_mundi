package personen;

public abstract class Person {

    protected String name;
    protected static int anzahl;
    private int verzoegerung = 500;
    private static final Object monitor = new Object();

    private enum synchronisationsArtTyp { KLASSENMETHODE, MONITOR };
    private static synchronisationsArtTyp synchronisationsArt = synchronisationsArtTyp.MONITOR;

    public Person(String Name){
        name = Name;
        if(synchronisationsArt == synchronisationsArtTyp.MONITOR){
            synchronized (monitor) {
                anzahl++;
            }
        }else{
            anzahlInkrementieren();
        }

    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public static void druckeAnzahl(){
        System.out.printf("Personen.anzahl: " + Person.anzahl + "\n");
    }

    public abstract void druckeObjekt();

    /**
     *  wir haben finalize implementiert damit sichergestellt wird dass das Objekt auch nicht verwendet wird.
     */
    @Override
    public void finalize(){
        if(synchronisationsArt == synchronisationsArtTyp.MONITOR){
            synchronized (monitor) {
                anzahl--;
            }
        }else{
            anzahlDekrementieren();
        }
    }


    public synchronized void anzahlInkrementieren(){

            int anzahl = Person.anzahl;
            try {
                Thread.sleep(verzoegerung);
                anzahl++;
                Thread.sleep(verzoegerung);
            } catch (InterruptedException e) {
            }
            Person.anzahl = anzahl;

    }
    public synchronized void anzahlDekrementieren(){

            int anzahl = Person.anzahl;
            try {
                Thread.sleep(verzoegerung);
                anzahl++;
                Thread.sleep(verzoegerung);
            } catch (InterruptedException e) {
            }
            Person.anzahl = anzahl;

    }



}
