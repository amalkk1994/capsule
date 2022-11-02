import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!!!");

        int radius;
        double length;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the value of N:");
        radius = Integer.parseInt(sc.nextLine());
        System.out.println("Enter the value of length:");
        length = Double.parseDouble(sc.nextLine());
        System.out.println("Radius:" + radius + ", Length:" + length);
        Capsule capsule = new Capsule();
        capsule.setLength(length);

        int curRadius = 6;
        System.out.format("%16s%16s%16s%16s\n", "Radius","Volume", "Surface Area", "Circumference");
        System.out.println("----------------------------------------------------------------");
        while(curRadius <= radius) {
            capsule.setRadius(curRadius);
            System.out.format("%16s%16s%16s%16s\n", capsule.getRadius(), capsule.volume(), capsule.surfaceArea(), capsule.circumference());
            curRadius +=6;
        }
        sc.close();

    }
}
