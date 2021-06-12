import java.util.Random;

public class Plansza {
    private int ilosc_min;
    private final int wys;
    private final int szer;
    private final Pole[][] pola;
    public int odkryte;
    private StanGry stangry = StanGry.TRWA;

    public Plansza(PoziomTrudnosci poziomtrudnosci) {
        wys = poziomtrudnosci.getWys();
        szer = poziomtrudnosci.getSzer();
        ilosc_min = 0;
        odkryte = 0;
        pola = new Pole[wys][szer];

        Random random = new Random();
        for (int kol = 0; kol < wys; kol++) {
            for (int wier = 0; wier < szer; wier++) {
                if (random.nextInt(100) < (poziomtrudnosci.procenty())) { // losuje od 0 do 99 < procenty, to mina
                    pola[kol][wier] = new Mina();
                    ilosc_min++;
                } else {
                    pola[kol][wier] = new Pole();
                }
            }
        }
    }

    public void przelacz_flage(int kol, int wier) {
        pola[kol][wier].przelacz_flage();
    }

    public void odkryj_pole(int kol, int wier) {
        int res = pola[kol][wier].odkryj_pole(); ////polimorfizm, w zależności od tego czy wartość z tablicy jest obiektem klasy pole, czy mina,
        if (res == 0) {                         //  wywołuje się metoda odkryj_pole, należąca do odpowiedniej klasy(pole lub mina)
            stangry = StanGry.PRZEGRANA;
        } else {
            odkryte += res - 1;

            if (wys * szer == odkryte + ilosc_min) {
                stangry = StanGry.WYGRANA;
            }

            if (policz_miny(kol, wier) == 0) {
                for (int i = -1; i < 2; i++) {
                    int offset_kol = kol + i;
                    for (int j = -1; j < 2; j++) {
                        int offset_wier = wier + j;
                        if (jest_w_zakresie(offset_kol, offset_wier) && (i != 0 || j != 0) && !pola[offset_kol][offset_wier].Jest_odkryte()) {
                            odkryj_pole(offset_kol, offset_wier);//odkrywa wszystkie kafelki dookola pola jesli to pole ma 0 min dookolo, pozniej rekurencyjnie
                        }
                    }
                }
            }
        }
    }

    private boolean jest_w_zakresie(int kol, int wier) {
        return kol >= 0 && kol < szer && wier >= 0 && wier < wys;
    }

    public int policz_miny(int kol, int wier) {
        int res = 0;
        for (int i = -1; i < 2; i++) { //przechodzi po 9 kafelkach wokol pola
            int offset_kol = kol + i;
            for (int j = -1; j < 2; j++) {
                int offset_wier = wier + j;
                if (jest_w_zakresie(offset_kol, offset_wier) && (i != 0 || j != 0) && pola[offset_kol][offset_wier].Ma_mine()) { //polimorfizm
                    res++;
                }
            }
        }
        return res;
    }

    public int info_pola(int kol, int wier) {
        if (pola[kol][wier].Jest_odkryte()) {
            return policz_miny(kol, wier);
        }
        if (pola[kol][wier].Ma_flage()) {
            return 11;
        }
        return 10;
    }

    public StanGry stan_gry() {
        return stangry;
    }

    int getWys() {
        return wys;
    }

    int getSzer() {
        return szer;
    }

    @Override
    public String toString() {
        StringBuilder bobTheBuilder = new StringBuilder();
        for (int i = 0; i < wys; i++) {
            for (int j = 0; j < szer; j++) {
                bobTheBuilder.append(pola[i][j]);
            }
            bobTheBuilder.append('\n');
        }
        return bobTheBuilder.toString();
    }
}
