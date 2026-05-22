import dao.CarreraDao;
import modelos.Carrera;

public class Main {
    public static void main(String[] args) {

        CarreraDao dao = new CarreraDao();

        // Guardar una carrera
        Carrera c = new Carrera(null, "Ingenieria de Sistemas", 250);
        dao.guardar(c);

        // Listar todas
        for (Carrera carrera : dao.listar()) {
            System.out.println(carrera);
        }
    }
}