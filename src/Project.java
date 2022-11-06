import java.util.ArrayList;
import java.util.List;

public class Project {
    private String name;
    private double upfrontCost; // same as Present value of future cost
    private int duration;
    private double rate;
    private List<Double> inflowOutflow;
    private List<Double> pvFactor;
    private List<Double> amount;
    private double totIncome;  // to of inflow amount
    private double pvFutureBenefit; // tot of amount
    private double netPresentValue; // amount - upfrontCost

    Project(String name, double upfrontCost, int duration, double rate, List<Double> inflowOutflow) {
        this.name = name;
        this.upfrontCost = upfrontCost;
        this.duration = duration;
        this.rate = rate;
        this.inflowOutflow = new ArrayList<Double>(inflowOutflow);
        this.pvFactor = new ArrayList<Double>(calculatePvFactor());
        this.amount = new ArrayList<Double>(calculateAmount());
    }

    public List<Double> getPvFactor() {
        return pvFactor;
    }

    private List<Double> calculatePvFactor() {
        List<Double> pvFactor = new ArrayList<Double>();
        double pvf;

        for(int i = 0; i < duration; i++) {
            pvf = (double) 1/Math.pow((1 + (double) rate / 100),(i+1));
            System.out.println("Pvf:" + pvf);
            pvFactor.add(pvf);
        }
        return pvFactor;
    }

    private List<Double> calculateAmount() {
        // (int duration, List<Double> pvFactor, List<Double> inflowOutflow)
        List<Double> amount = new ArrayList<Double>();
        double amt;

        for(int i=0; i<duration; i++) {
            amt = pvFactor.get(i) * inflowOutflow.get(i);
            System.out.println("Amount:"+amt);
            amount.add(amt);
        }
        return amount;
    }

    private double sum(List<Double> values) {
        double tot=0.0;
        for(int i = 0; i < duration; i++) {
            tot+=values.get(i);
        }
        return tot;
    }

    private double calculateNetPresent() {
        return netPresentValue - upfrontCost;
    }

    private void calculateValues() {
        for (int i = 0; i < duration; i++) {

        }
    }

}
