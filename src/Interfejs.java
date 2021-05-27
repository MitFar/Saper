import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Interfejs extends JPanel {
    public final Plansza plansza;
    private final Image[] img;

    int iconSize = 15;
    int Wys;
    int Szer;

    public Interfejs(PoziomTrudnosci poziomtrudnosci) {
        plansza = new Plansza(poziomtrudnosci);
        Wys = plansza.getWys();
        Szer = plansza.getSzer();

        img = new Image[13];
        for (int i = 0; i < 12; i++) {
            img[i] = new ImageIcon("./src/resources/" + i + ".png").getImage(); //.getScaledInstance(iconSize, iconSize, Image.SCALE_SMOOTH)
        }
        setPreferredSize(new Dimension(iconSize * Szer, iconSize * Wys));
        addMouseListener(new MinesAdapter());
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (plansza.stan_gry().equals(StanGry.TRWA)) {
            setPreferredSize(new Dimension(iconSize * plansza.getWys(), iconSize * plansza.getWys()));
        } else {
            setPreferredSize(new Dimension(iconSize * Szer, iconSize * Wys));
        }
        switch (plansza.stan_gry()) {
            case TRWA -> {
                for (int i = 0; i < plansza.getWys(); i++) {
                    for (int j = 0; j < plansza.getSzer(); j++) {
                        int nr = plansza.info_pola(i, j);
                        Image pole = img[nr];
                        g.drawImage(pole, j * iconSize, i * iconSize, this);
                    }
                }
            }
            case WYGRANA -> {
                g.setColor(Color.green);
                g.fillRect(0, 0, Szer * iconSize, Wys * iconSize);
                g.setColor(Color.black);
                Font font = new Font("Arial", Font.PLAIN, 30);
                g.setFont(font);
                g.drawString("Wygrana XDD", 100, 100);
            }
            case PRZEGRANA -> {
                g.setColor(Color.red);
                g.fillRect(0, 0, Szer * iconSize, Wys * iconSize);
                g.setColor(Color.black);
                Font font = new Font("Arial", Font.PLAIN, 30);
                g.setFont(font);
                g.drawString("Przegrana XDD", 100, 100);
            }
        }
    }


    private class MinesAdapter extends MouseAdapter {

        @Override
        public void mousePressed(MouseEvent e) {
            int x = e.getX();
            int y = e.getY();
            switch (plansza.stan_gry()) {
                case TRWA -> {
                    int cCol = y / iconSize;
                    int cRow = x / iconSize;
                    if (e.getButton() == MouseEvent.BUTTON1) {
                        plansza.odkryj_pole(cCol, cRow);
                    }
                    if (e.getButton() == MouseEvent.BUTTON3) {
                        plansza.przelacz_flage(cCol, cRow);
                    }

                }
                case WYGRANA, PRZEGRANA -> {
                }
            }
            repaint();
            System.out.println(plansza);
        }
    }
}