public class DiagonalMatrix {
    public static void main(String[] args) {
        // - Create (dynamically) a two dimensional array
        //   with the following matrix. Use a loop!
        //
        //   1 0 0 0
        //   0 1 0 0
        //   0 0 1 0
        //   0 0 0 1
        //
        // - Print this two dimensional array to the output

        int[][] twoDimensional = {{1, 0, 0, 0}, {0, 1, 0, 0}, {0, 0, 1, 0}, {0, 0, 0, 1}};

        for (int i = 0; i < twoDimensional.length; i++) {
            for (int j = 0; j < twoDimensional[i].length; j++) {
                System.out.print(twoDimensional[i][j] + " ");
            }
            System.out.println();

        }
    }
}
