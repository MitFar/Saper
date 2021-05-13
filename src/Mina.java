public class Mina extends Pole{

    @Override
    public int odkryj_pole(){
        jest_odkryte = true;
        return 0;
    }

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
