import java.util.Scanner;

public class CircleArea {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the radius: ");
        double radius = scanner.nextDouble();

        double area = radius * radius * 3.14159;

        System.out.println("Radius = " + radius + ", Area = " + area);

        scanner.close();
    }
}