import javax.swing.*;
import java.awt.*;

class saper {
    public static void main(String[] args) {
//        Random random = new Random();
//        for (int i=0; i<10; i++){
//            System.out.println(random.nextInt(2));
//        }
//        Plansza test = new Plansza(15, 10, 2);

        JFrame frame = new JFrame("Saper");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container kontener = frame.getContentPane();

        Interfejs interfejs = new Interfejs();
        kontener.add(interfejs);

        frame.pack();
//        frame.resize();
        frame.setResizable(false);
        frame.setVisible(true);
//        Scanner sc = new Scanner();
//        while (true){
//
//        }
//        for (int i=0; i<10; i++){
//            for (int j=0; j<5; j++){
//                test.odkryj_pole(i, j);
//            }
//        }
//        test.odkryj_pole(3, 2);
//        test.odkryj_pole(3, 3);
//        test.odkryj_pole(4, 1);
//        test.odkryj_pole(5, 0);

//        setResizable(false);
//        System.out.println(test);
    }
}
