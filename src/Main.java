import java.util.Scanner;

public class Main {

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        //scanner.useDelimiter("\\n");

        String number = "";
        int size;
        LcdModel lcd = new LcdModel();



        lcd.printInstructions();

        while (!number.equals("0,0")){

            number = (String) scanner.next();

            if (number.equals("0")) {
                lcd.printInstructions();
                continue;
            }

            lcd.printNumber(number);

        }


    }

}
