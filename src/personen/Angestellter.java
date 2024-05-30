package personen;

public class Angestellter extends Person implements IMitarbeiter{

    private int personalNr;

    public Angestellter(String name,int personalNr) {
        super(name);
        this.personalNr = personalNr;


    }


    public Angestellter(String Name) {
        super(Name);
    }

    @Override
    public void druckeObjekt() {
        System.out.println("Der Angestellte heißt: " + name + " hat die Personalnummer: " + personalNr + " und ist einer von " + Person.anzahl);
    }

    @Override
    public void arbeitenOhneMurren() {

        System.out.println("Ich bin Angestellter " + this.name + " und arbeite ohne Murren und Knurren");
    }

    public int getPersonalNr() {
        return personalNr;
    }
    public void setPersonalNr(int personalNr) {
        this.personalNr = personalNr;
    }
}
