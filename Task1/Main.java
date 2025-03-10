import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        NumberGuess coldAndHot = new NumberGuess();
        coldAndHot.guessTheNumber();
        }
    }

class NumberGuess {
    Scanner scan = new Scanner(System.in);
    Random random = new Random();
    boolean equality = true;
    int guessedNumber = random.nextInt(101);

    void validationNumber(int userNumber){
        if(userNumber == 0) {
            printNumber();
        } else if(userNumber < 0 || userNumber > 100) {
            System.out.println("Введене число Не в діапазоні від 1 до 100. Спробуйте ще раз: ");
            userNumber = scan.nextInt();
        }
        compareNumbers(userNumber);
    }

    void compareNumbers(int userNumber) {
        if(userNumber < guessedNumber) {
            System.out.println("Загадане число більше. Спробуйте ще раз: ");
        } else if (userNumber > guessedNumber){
            System.out.println("Загадане число менше. Спробуйте ще раз: ");
        } else {
        equality = false;
        System.out.println("Ви вгадали число, загадане число: " + guessedNumber);
        }
    }

    public void guessTheNumber() {
        System.out.print("Введіть число від 1 до 100: ");
        while (equality) {
            int userNumber = scan.nextInt();
            validationNumber(userNumber);
        }
    }

    void printNumber(){
        System.out.println("Загадане число: " + guessedNumber);
    }
}
