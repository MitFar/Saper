import javax.swing.*;
import java.awt.*;

class saper {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Saper");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container kontener = frame.getContentPane();

        Interfejs interfejs = new Interfejs(PoziomTrudnosci.MEDIUM);
        kontener.add(interfejs);

        frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);
        System.out.println(interfejs.plansza);
    }
}
