import net.salesianos.element.Motorbike;

import javax.swing.*;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        ArrayList<Motorbike> motorbikes = new ArrayList<>();
        motorbikes.add(new Motorbike("Honda CBR1000RR-R Fireblade", 25500f, 5, 217));
        motorbikes.add(new Motorbike("Yamaha R1 Race", 20699f, 4, 200));
        motorbikes.add(new Motorbike("Kawasaki Ninja ZX-10RR", 32799f, 6, 200));
        motorbikes.add(new Motorbike("Suzuki Hayabusa 1300", 22579f, 2, 190));
        motorbikes.add(new Motorbike("Ducati Panigale V4", 28990f, 3, 216));
        motorbikes.add(new Motorbike("BMW S1000RR", 23850f, 1, 210));

        String[] options = {"Crear", "Modificar", "Mostrar", "Eliminar", "Salir"};

        while (true) {
            try {
                int choice = JOptionPane.showOptionDialog(null, "Selecciona una opción", "Gestión de Motos",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

                if (choice == 0) { // Crear
                    String brand = JOptionPane.showInputDialog("Marca:");
                    if (brand == null || brand.trim().isEmpty())
                        throw new IllegalArgumentException("Marca inválida");

                    float price = Float.parseFloat(JOptionPane.showInputDialog("Precio:"));
                    int ranking = Integer.parseInt(JOptionPane.showInputDialog("Ranking:"));
                    int cv = Integer.parseInt(JOptionPane.showInputDialog("CV (caballos de vapor):"));

                    motorbikes.add(new Motorbike(brand, price, ranking, cv));
                    JOptionPane.showMessageDialog(null, "Moto añadida.");

                } else if (choice == 1) { // Modificar
                    if (motorbikes.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "No hay motos para modificar.");
                        continue;
                    }

                    StringBuilder list = new StringBuilder();
                    for (int i = 0; i < motorbikes.size(); i++) {
                        list.append(i).append(": ").append(motorbikes.get(i).getBrand()).append("\n");
                    }
                    int index = Integer.parseInt(JOptionPane.showInputDialog("Elige el número de la moto a modificar:\n" + list));
                    Motorbike m = motorbikes.get(index);

                    String newBrand = JOptionPane.showInputDialog("Nueva marca:", m.getBrand());
                    if (newBrand == null || newBrand.trim().isEmpty())
                        throw new IllegalArgumentException("Marca inválida");

                    float newPrice = Float.parseFloat(JOptionPane.showInputDialog("Nuevo precio:", m.getPrice()));
                    int newRanking = Integer.parseInt(JOptionPane.showInputDialog("Nuevo ranking:", m.getRanking()));
                    int newCv = Integer.parseInt(JOptionPane.showInputDialog("Nuevos CV:", m.getCv()));

                    m.setBrand(newBrand);
                    m.setPrice(newPrice);
                    m.setRanking(newRanking);
                    m.setCv(newCv);

                    JOptionPane.showMessageDialog(null, "Moto modificada.");

                } else if (choice == 2) { // Mostrar
                    if (motorbikes.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "No hay motos registradas.");
                        continue;
                    }

                    StringBuilder output = new StringBuilder();
                    for (Motorbike m : motorbikes) {
                        output.append(m.toString()).append("\n\n");
                    }
                    JOptionPane.showMessageDialog(null, output.toString());

                } else if (choice == 3) { // Eliminar
                    if (motorbikes.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "No hay motos para eliminar.");
                        continue;
                    }

                    StringBuilder list = new StringBuilder();
                    for (int i = 0; i < motorbikes.size(); i++) {
                        list.append(i).append(": ").append(motorbikes.get(i).getBrand()).append("\n");
                    }
                    int index = Integer.parseInt(JOptionPane.showInputDialog("Elige el número de la moto a eliminar:\n" + list));
                    motorbikes.remove(index);
                    JOptionPane.showMessageDialog(null, "Moto eliminada.");

                } else if (choice == 4 || choice == JOptionPane.CLOSED_OPTION) { // Salir
                    JOptionPane.showMessageDialog(null, "Programa finalizado.");
                    break;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error: Ingrese un número válido.");
            } catch (IndexOutOfBoundsException e) {
                JOptionPane.showMessageDialog(null, "Error: Índice fuera de rango.");
            } catch (IllegalArgumentException e) {
                JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            }
        }
    }
}
