import dao.CarreraDao;
import modelos.Carrera;

public class Main {
    public static void main(String[] args) {
        Carrera is = new Carrera(null, "Ingenieria de sistemas ", 250);

        CarreraDao registro = new CarreraDao();
        registro.guardar(is);
        for (Carrera c : registro.listar()){
            System.out.println(c);
        }
    }
}
