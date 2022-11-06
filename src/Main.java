import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!!!");

        Scanner sc = new Scanner(System.in);

       // capsulePgm(sc);
        costBenefitAnalysis(sc);


        sc.close();

    }

    public static void costBenefitAnalysis(Scanner sc) {

        List<Double> infOut = new ArrayList<Double>();
        infOut.add(10000.00);
        infOut.add(27000.00);
        infOut.add(19000.00);
        Project prj1 = new Project("Mars", 35000.00, 3, 12.00, infOut);
        System.out.println("total income:" + String.format("%.2f",prj1.getTotIncome()));
        System.out.println("Future Benefit:" + String.format("%.2f",prj1.getPvFutureBenefit()));
        System.out.println("Future Cost:"+ String.format("%.2f",prj1.getUpfrontCost()));
        System.out.println("Net Present Value:"+ String.format("%.2f",prj1.getNetPresentValue()));
    }

    public static void capsulePgm(Scanner sc) {
        int radius;
        double length;
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
    }
}
