public class Mina extends Pole{
//    private boolean jest_odkryte = false;

    @Override
    public int odkryj_pole(){
        jest_odkryte = true;
        return 0;
    }

//    @Override
//    public boolean Jest_odkryte() {
//        return jest_odkryte;
//    }

    @Override
    public boolean Ma_mine(){
        return true;
    }

    @Override
    public String toString() {
        if (ma_flage) {
            return "[F]";
        }
        else if(jest_odkryte){
            return "[M]";
        }
        return "[ ]";
    }

}
