import com.ipiecoles.java.java220.Manager;
import com.ipiecoles.java.java220.Technicien;

import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world !");

        HashSet<Technicien> techniciens = new HashSet<>();
        Manager manager = new Manager();
        Technicien technicien1 = new Technicien(null, null, null, null, 0.0, 1);
        Technicien technicien2 = new Technicien(null, null, null, null, 0.0, 2);
        techniciens.add(technicien1);
        techniciens.add(technicien2);
        System.out.println(techniciens.size());
        manager.setEquipe(techniciens);
        System.out.println(manager.getEquipe().size());

    }
}
