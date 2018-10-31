public class Factorio {
    public static void main(String[] args) {
        // - Create a function called `factorio`
        //   that returns it's input's factorial

        int number = 7;
        System.out.println(factorio(number));

    }

        public static int factorio(int number) {
            int factorial = 1;
            for(int i=2; i<=number; i++){
                factorial*=i;
            }
            return factorial;
        }
}
