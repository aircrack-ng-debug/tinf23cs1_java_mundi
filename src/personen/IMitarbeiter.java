package personen;

public interface IMitarbeiter {

    public void arbeitenOhneMurren();

    default void inKantineEssen() {
        System.out.println("Ich esse seit 30 Jahren jeden Werktag in der Kantine!");
    }
}
