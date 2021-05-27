public class Pole {
    protected boolean ma_flage = false;
    protected boolean jest_odkryte = false;

    public int odkryj_pole() {
        if (jest_odkryte){
            return 1;
        }
        jest_odkryte = true;
        return 2;
    }

    public void przelacz_flage() {
        if (!jest_odkryte) {
            ma_flage = !ma_flage;
        }
    }

    public boolean Ma_flage() {
        return ma_flage;
    }

    public boolean Jest_odkryte() {
        return jest_odkryte;
    }

    public boolean Ma_mine() {
        return false;
    }

    @Override
    public String toString() {
        if (ma_flage) {
            return "[F]";
        }

//        else if(jest_odkryte){
            return "[_]";
//        }
//        return "[ ]";
    }
}
