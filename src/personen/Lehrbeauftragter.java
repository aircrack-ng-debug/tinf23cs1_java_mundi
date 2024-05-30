package personen;

public class Lehrbeauftragter {

    private String name;
    private IKlausurSchreiber[] prueflinge;

    public Lehrbeauftragter(String Name){
        this.name = Name; // übernehme Name aus Konstruktor in Instanzvariable
    }


    public void lasseKlausurSchreiben(){

        for(IKlausurSchreiber p : prueflinge){
            p.klausurSchreiben();
        }

    }

    // getter und setter für Lehrbeauftragten
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //getter und setter für Klausurschreiber
    public IKlausurSchreiber[] getPrueflinge() {
        return prueflinge;
    }

    public void setPrueflinge(IKlausurSchreiber[] prueflinge) {
        this.prueflinge = prueflinge;
    }

    @Override
    public String toString() {
        return name;
    }

}
