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
        this.pvFactor = new ArrayList<Double>();
        this.amount = new ArrayList<Double>();
        calculateValues();
    }

    public String getName() {
        return name;
    }

    public double getUpfrontCost() {
        return upfrontCost;
    }

    public int getDuration() {
        return duration;
    }

    public double getRate() {
        return rate;
    }

    public List<Double> getInflowOutflow() {
        return inflowOutflow;
    }

    public List<Double> getAmount() {
        return amount;
    }

    public double getTotIncome() {
        return totIncome;
    }

    public double getPvFutureBenefit() {
        return pvFutureBenefit;
    }

    public double getNetPresentValue() {
        return netPresentValue;
    }

    public List<Double> getPvFactor() {
        return pvFactor;
    }

    private double calculatePvFactor(double rate, double dur) {
            double pvf;
            pvf = (double) 1/Math.pow((1 + (double) rate / 100),(dur));
            return pvf;
    }

    private double calculateAmount(double pvf, double infOut) {
            double amt;
            amt = pvf * infOut;
      //      System.out.println("Amount:"+amt);
            return amt;
    }

    private double calculateNetPresent() {
        return netPresentValue - upfrontCost;
    }

    private void calculateValues() {
        double pvf;
        double tot=0.00;
        double pfb=0.00;
        double amt=0.00;
        System.out.format("%16s%16s%16s%16s\n", "Year","Cash Inflows/OutFlows", "PV Factor", "Amount");
        for (int i = 0; i < duration; i++) {
            pvf = calculatePvFactor(rate,i+1);
            this.pvFactor.add(pvf);
            amt = calculateAmount(pvf,inflowOutflow.get(i));
            this.amount.add(amt);
            tot+=inflowOutflow.get(i);
            pfb+=amt;
            System.out.format("%16s%16s%16s%16s\n", i+1,String.format("%.2f",inflowOutflow.get(i)), String.format("%.4f",pvf), String.format("%.2f",amt));
        }
        this.totIncome = tot;
        this.pvFutureBenefit = pfb;
        this.netPresentValue = this.pvFutureBenefit - this.upfrontCost;
    }

}
