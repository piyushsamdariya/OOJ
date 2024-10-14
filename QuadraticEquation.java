import java.util.Scanner;

class QuadraticEquation {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
       
        System.out.print("Enter value of a: ");
        double a = scanner.nextDouble();
        
        System.out.print("Enter value of b: ");
        double b = scanner.nextDouble();
        
        System.out.print("Enter value of c: ");
        double c = scanner.nextDouble();
        
                double D = b * b - 4 * a * c;
          
        if (D > 0) {
            double root1 = (-b + Math.sqrt(D)) / (2 * a);
            double root2 = (-b - Math.sqrt(D)) / (2 * a);
            System.out.println("Roots are real and different:");
            System.out.println("Root 1:"+ root1);
            System.out.println("Root 2:"+ root2);

        } else if (D == 0) {
            double root = -b / (2 * a);
            System.out.println("Root is real and the same:");
            System.out.println("Root :"+ root);

        } else {
            double realPart = -b / (2 * a);
            double imaginaryPart = Math.sqrt(-D) / (2 * a);
            System.out.println("Roots are complex:");
            System.out.println("Root 1:"+realPart+ "+" +imaginaryPart);
            System.out.println("Root 2:"+realPart+ "-" +imaginaryPart);
        }

        scanner.close();
    }
}
