import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter first number:");
        double n1 = sc.nextDouble();

        System.out.println("Enter second number:");
        double n2 = sc.nextDouble();

        System.out.println("Choose operation (+, -, *, /):");
        char op = sc.next().charAt(0);

        double r = 0;

        switch(op) {
            case '+': r = n1 + n2; break;
            case '-': r = n1 - n2; break;
            case '*': r= n1 * n2; break;
            case '/':
                if(n2 != 0)
                    r = n1 / n2;
                else
                    System.out.println("Cannot divide by zero!");
                break;
            default: System.out.println("Invalid operation");
        }

        System.out.println("Result: " + r);
    }
}
