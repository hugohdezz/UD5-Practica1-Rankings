import java.util.ArrayList;

import net.salesianos.element.Motorbike;

public class App {
    public static void main(String[] args) {
        ArrayList<Motorbike> motorbikes = new ArrayList<>();
        motorbikes.add(new Motorbike("Honda CBR1000RR-R Fireblade", 25500, 5, 217));
        motorbikes.add(new Motorbike("Yamaha R1 Race", 20699,4 , 200));
        motorbikes.add(new Motorbike("Kawasaki Ninja ZX-10RR", 32799, 6, 200));
        motorbikes.add(new Motorbike("Suzuki Hayabusa 1300", 22579, 2 , 190));
        motorbikes.add(new Motorbike("Ducati", 28990,3, 216));
        motorbikes.add(new Motorbike("BMW S1000RR", 23850, 1, 210));
    }
}