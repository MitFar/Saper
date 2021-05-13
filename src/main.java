
class saper {
    public static void main(String[] args) {
//        Random random = new Random();
//        for (int i=0; i<10; i++){
//            System.out.println(random.nextInt(2));
//        }
        Plansza test = new Plansza(10, 5, 2);

//        Scanner sc = new Scanner();
//        while (true){
//
//        }
        for (int i=0; i<10; i++){
            for (int j=0; j<5; j++){
                test.odkryj_pole(i, j);
            }
        }
//        test.odkryj_pole(3, 2);
//        test.odkryj_pole(3, 3);
//        test.odkryj_pole(4, 1);
//        test.odkryj_pole(5, 0);

        System.out.println(test);
    }
}
