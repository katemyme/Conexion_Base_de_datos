import dao.CarreraDao;
import modelos.Carrera;
import javax.swing.JOptionPane;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        CarreraDao dao = new CarreraDao();

        while (true) {
            String opcion = JOptionPane.showInputDialog(null,
                    "=== MENÚ CARRERAS ===\n" +
                            "1. Guardar carrera\n" +
                            "2. Listar carreras\n" +
                            "3. Eliminar carrera\n" +
                            "4. Actualizar carrera\n" +
                            "5. Salir\n\n" +
                            "Seleccioná una opción:");

            if (opcion == null || opcion.equals("5")) break;

            switch (opcion.trim()) {
                case "1" -> {
                    String nombre = JOptionPane.showInputDialog("Nombre de la carrera:");
                    String precioStr = JOptionPane.showInputDialog("Precio de la carrera:");
                    double precio = Double.parseDouble(precioStr);
                    Carrera c = new Carrera(null, nombre, precio);
                    dao.guardar(c);
                    JOptionPane.showMessageDialog(null, "Carrera guardada exitosamente");
                }
                case "2" -> {
                    List<Carrera> carreras = dao.listar();
                    if (carreras.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "No hay carreras registradas");
                    } else {
                        StringBuilder sb = new StringBuilder("=== CARRERAS ===\n");
                        for (Carrera c : carreras) {
                            sb.append("ID: ").append(c.getId())
                                    .append(" | Nombre: ").append(c.getNombre())
                                    .append(" | Precio: $").append(c.getPrecio())
                                    .append("\n");
                        }
                        JOptionPane.showMessageDialog(null, sb.toString());
                    }
                }
                case "3" -> {
                    String idStr = JOptionPane.showInputDialog("ID de la carrera a eliminar:");
                    Long id = Long.parseLong(idStr);
                    dao.eliminar(id);
                    JOptionPane.showMessageDialog(null, "Carrera eliminada");
                }
                case "4" -> {
                    String idStr = JOptionPane.showInputDialog("ID de la carrera a actualizar:");
                    Long id = Long.parseLong(idStr);
                    String nombre = JOptionPane.showInputDialog("Nuevo nombre:");
                    String precioStr = JOptionPane.showInputDialog("Nuevo precio:");
                    double precio = Double.parseDouble(precioStr);
                    Carrera c = new Carrera(id, nombre, precio);
                    dao.Actualizar(c);
                    JOptionPane.showMessageDialog(null, "Carrera actualizada");
                }
                default -> JOptionPane.showMessageDialog(null, "Opción inválida");
            }
        }

        JOptionPane.showMessageDialog(null, "¡Hasta luego!");
    }
}