public class LcdModel {

    /*
     * LED representation for each number, according to
     * 7 segment display :
     *
     *  -0-
     * |   |
     * 2   1
     * |   |
     *  -3-
     * |   |
     * 5   4
     * |   |
     *  -6-
     *
     */


    private char digitMatrix [][] = {
            /*0    1    2    3    4    5    6 */
            {'-', '|', '|', ' ', '|', '|', '-'}, //0
            {' ', '|', ' ', ' ', '|', ' ', ' '}, //1
            {'-', '|', ' ', '-', ' ', '|', '-'}, //2
            {'-', '|', ' ', '-', '|', ' ', '-'}, //3
            {' ', '|', '|', '-', '|', ' ', ' '}, //4
            {'-', ' ', '|', '-', '|', ' ', '-'}, //5
            {'-', ' ', '|', '-', '|', '|', '-'}, //6
            {'-', '|', ' ', ' ', '|', ' ', ' '},//7
            {'-', '|', '|', '-', '|', '|', '-'},//8
            {'-', '|', '|', '-', '|', ' ', '-'},//9
    };

    // iterators


    public void printNumber(String digitString) {

        //

        String numberString ;
        int size;

        String[] sizeAndNum = digitString.split(",");
        try {
            size = Integer.parseInt(sizeAndNum[0]);
            numberString = sizeAndNum[1];
            if ((size > 0 && size <= 10 && !numberString.equals(" ")) ) {
                parseNumber(size, numberString);
            } else if (!numberString.equals("0")) {
                System.out.println("Invalid Size: please choose a number from 1 to 10");
            }

        }catch (Exception e) {
            System.out.println(e);
            System.out.println("Invalid Entry");
        }

    }

    private void parseNumber(int size, String numberString){



        //iterators

        int row, num, col;

        int n = numberString.length();

        int digit;

        for (row = 0 ; row< (2*size)+3; row++) {
            for (num = 0 ; num < n; num++) {

                digit =  Character.getNumericValue(numberString.charAt(num));


                //Top, middle , low

                if ((row % (size + 1)) == 0) {

                    System.out.print(" ");

                    for (col = 0; col < size ; col++) {

                        int display = (row /(size + 1)) * 3;


                        System.out.print(digitMatrix[digit][display]);

                    }

                    System.out.print(" ");
                }

                // Between Top Middle

                if (row > 0 && row < (size+1)) {
                    System.out.print(digitMatrix[digit][2]);

                    for (col = 0; col < size ; col++) {
                        System.out.print(" ");
                    }

                    System.out.print(digitMatrix[digit][1]);

                }

                // Between Middle Bottom

                if (row > (size + 1) && row < (2*size + 2)) {
                    System.out.print(digitMatrix[digit][5]);
                    for (col = 0; col < size ; col++ ) {
                        System.out.print(" ");
                    }
                    System.out.print(digitMatrix[digit][4]);
                }

                if (num != n - 1) {
                    System.out.print(" ");
                }
            }

            System.out.print("\n");
        }

        System.out.print("\n");

    }

    public void printInstructions(){
        System.out.println("-Type whole number in format %,%  \n first number is size of print and should be from 1 to 10 \n second number is the one to be printed" +
                " \n to finish program type 0,0 \n to repeat instructions type 0");
    }



}

