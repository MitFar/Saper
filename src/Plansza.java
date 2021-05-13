import java.util.Random;

public class Plansza {
    private int ilosc_min;
    private final int wys;
    private final int szer;
    private final int poziomtrudnosci;
    private int odkryte = 0;
    private final Pole[][] pola;

    public Plansza(int wys, int szer, int poziomtrudnosci){
        this.wys = wys;
        this.szer = szer;
        this.poziomtrudnosci = poziomtrudnosci;
        ilosc_min = 0;
        pola = new Pole[wys][szer];

        Random random = new Random();
        for (int kol=0; kol<wys; kol++){
            for (int wier=0; wier<szer; wier++){
                if (random.nextInt(10) < poziomtrudnosci){
                    pola[kol][wier] = new Mina();
                    ilosc_min++;
                }
                else {
                    pola[kol][wier] = new Pole();
                }
            }
        }
    }

    public void przelacz_flage(int kol, int wier){
        pola[kol][wier].przelacz_flage();
    }

    public void odkryj_pole(int kol, int wier){
        int res = pola[kol][wier].odkryj_pole();
        if (res == 0){
//            st
            System.out.println("todo");
//            game over
        }
        else {
            odkryte += res - 1;

            if(odkryte == ilosc_min){
                System.out.println("todo");
            }
        }
    }

    public int policz_miny(int kol, int wier){
        return 0;
    }

    public boolean stan_gry(){
        return true;
//        enum
    }


    @Override
    public String toString() {
        StringBuilder bobTheBuilder = new StringBuilder();
        for (int i=0; i<wys; i++){
            for (int j=0; j<szer; j++){
                bobTheBuilder.append(pola[i][j]);
            }
            bobTheBuilder.append('\n');
        }
        return bobTheBuilder.toString();
    }
}
