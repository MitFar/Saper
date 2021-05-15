import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Interfejs extends JPanel {
    private final Plansza plansza;
    private final Image[] img;
    private final JPanel menu;
    int iconSize = 20;
    int defaultWys = 20;
    int defaultSzer = 20;

    public Interfejs() {
        plansza = new Plansza();
//        wys = plansza.getWys();
//        szer = plansza.getSzer();
        menu = new JPanel();

        img = new Image[13];
        for (int i = 0; i <= 12; i++) {
            img[i] = new ImageIcon("/home/bronko/projects/saper/src/resources/" + i + ".png").getImage().getScaledInstance(iconSize, iconSize, Image.SCALE_SMOOTH);
        }

//        System.out.println(iconSize*szer + " " + iconSize*wys);
        setPreferredSize(new Dimension(iconSize * defaultSzer, iconSize * defaultWys));
        addMouseListener(new MinesAdapter());
    }

    @Override
    public void paintComponent(Graphics g) {
        System.out.println(plansza.stan_gry().toString());
        if (plansza.stan_gry().equals(StanGry.TRWA)){
            setPreferredSize(new Dimension(iconSize*plansza.getWys(), iconSize*plansza.getWys()));
        }
        else {
            setPreferredSize(new Dimension(iconSize*defaultSzer, iconSize*defaultWys));
        }
        switch (plansza.stan_gry()) {
            case MENU -> {
                System.out.println("menu");
                for (int i = 0; i < 12; i++) {
                    System.out.println(i);
                    g.drawImage(img[i], i * iconSize, 0, this);
                }
            }
            case TRWA -> {
                for (int i = 0; i < plansza.getWys(); i++) {
                    for (int j = 0; j < plansza.getSzer(); j++) {
                        System.out.println(plansza.info_pola(i, j));
                        g.drawImage(img[plansza.info_pola(i, j)], j * iconSize, i * iconSize, this);
                    }
                }
            }
            case WYGRANA -> {
                System.out.println("wygrana");
            }
            case PRZEGRANA -> {
                System.out.println("przegrana");
            }
        }
    }


    private class MinesAdapter extends MouseAdapter {

        @Override
        public void mousePressed(MouseEvent e) {
            int x = e.getX();
            int y = e.getY();
            switch (plansza.stan_gry()) {
                case MENU -> {
//                    System.out.println("menu");
                    plansza.ustaw_poziom_trudnosc(PoziomTrudnosci.EASY);
                }
                case TRWA -> {
                    int cCol = y / iconSize;
                    int cRow = x / iconSize;
                    plansza.odkryj_pole(cCol, cRow);
                }
                case WYGRANA, PRZEGRANA -> {
                    plansza.reset_stan_gry();
                }
            }


//            if (e.getButton() == MouseEvent.BUTTON3){

            repaint();
//            }
//            boolean doRepaint = false;
        }
    }
}