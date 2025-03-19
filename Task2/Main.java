import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Fraction first = new Fraction(1,10);
        Fraction second = new Fraction(1, 3);
        first.addition(second);
    }
}

class Fraction {
    Scanner scan = new Scanner(System.in);
    int numerator;
    int denominator;

    Fraction(int numerator, int denominator) {
        if (denominator == 0) {
            System.out.println("Знаменник не може дорівнювати 0. Введіть нове значення: ");
            this.denominator = scan.nextInt();
            this.numerator = numerator;
        } else {
            this.numerator = numerator;
            this.denominator = denominator;
        }
    }

    void printFraction() {
        int lenNumerator = String.valueOf(numerator).length();
        int lenDenominator = String.valueOf(denominator).length();
        int maxLen;
        if (lenNumerator > lenDenominator) {
            maxLen = lenNumerator;
        } else {
            maxLen = lenDenominator;
        }
        System.out.println(numerator);
        for (int i = 0; i < maxLen; i++) {
            System.out.print("—");
        }
        System.out.println();
        System.out.println(denominator);
    }

    void addition(Fraction application) {
        numerator = numerator + application.numerator;
        denominator = denominator + application.denominator;
        printFraction();
    }

    void subtraction(Fraction application) {
        numerator = numerator * application.denominator - application.numerator * denominator;
        denominator = denominator * application.denominator;
        printFraction();
    }

    void multiplication(Fraction application) {
        numerator *= application.numerator;
        denominator *= application.denominator;
        printFraction();
    }

    void division(Fraction application) {
        if (application.numerator == 0) {
            System.out.println("Ділити на нулб не мож");
            return;
        }
        numerator *= application.denominator;
        denominator *= application.numerator;
        printFraction();
    }

    void reductionFraction() {
        int a = Math.abs(numerator);
        int b = Math.abs(denominator);
        // нсд
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        int nsd = a;
        numerator /= nsd;
        denominator /= nsd;
        if (denominator < 0) {
            numerator = -numerator;
            denominator = -denominator;
        }
        printFraction();
    }
}
