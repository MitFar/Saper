public enum PoziomTrudnosci {
    EASY (9, 9, 5),
    MEDIUM (15, 15, 20),
    HARD (20, 20, 30);

    private final int wys;
    private final int szer;
    private final int percentage;

    PoziomTrudnosci(int wysokosc, int szerokosc, int procenty) {
        wys = wysokosc;
        szer = szerokosc;
        percentage = procenty;
    }
    public int getWys(){
        return wys;
    }
    public int getSzer(){
        return szer;
    }
    public int procenty(){
        return percentage;
    }
}
