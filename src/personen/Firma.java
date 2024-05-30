package personen;

public class Firma {

    private String name;

    public Firma(String name){
        this.name = name;

    }

    public void druckeName(){

        System.out.println("Der Firmenname lautet: " + this.name);
    }



}
