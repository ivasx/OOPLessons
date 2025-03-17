import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Fraction first = new Fraction(5,0);
        Fraction second = new Fraction(1, 3);
        first.print();
    }
}

class Fraction {
    Scanner scan = new Scanner(System.in);
    int numerator;
    int denominator;

    Fraction(int numerator, int denominator){
        if (denominator == 0){
            System.out.println("Знаменник не може дорівнювати 0. Введіть нове значення.");
            this.denominator = scan.nextInt();
        } else {
            this.numerator = numerator;
        }
        this.denominator = denominator;
    }

    void print(){
        System.out.println("Дріб: ");
        System.out.println(numerator);
        System.out.println("———");
        System.out.println(denominator);
    }
    void addition(Fraction application){
        numerator = numerator + application.numerator;
        denominator = denominator + application.denominator;
    }
    void subtraction(){}
    void multiplication(){}
    void division(){}
    void reductionFraction(){}
}
