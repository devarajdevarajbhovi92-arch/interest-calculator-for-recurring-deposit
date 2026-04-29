public class RecurringDeposit {
    private double monthlyDeposit;
    private double annualInterestRate; // in percent
    private int tenureMonths;

    public RecurringDeposit(double monthlyDeposit, double annualInterestRate, int tenureMonths) {
        this.monthlyDeposit = monthlyDeposit;
        this.annualInterestRate = annualInterestRate;
        this.tenureMonths = tenureMonths;
    }

    public double getMonthlyDeposit() {
        return monthlyDeposit;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public int getTenureMonths() {
        return tenureMonths;
    }

    public double calculateMaturityAmount() {
        double monthlyRate = annualInterestRate / 100 / 12;
        double maturity = monthlyDeposit * ((Math.pow(1 + monthlyRate, tenureMonths) - 1) / monthlyRate);
        return maturity;
    }

    public double calculateTotalDeposits() {
        return monthlyDeposit * tenureMonths;
    }

    public double calculateTotalInterest() {
        return calculateMaturityAmount() - calculateTotalDeposits();
    }

    public String getSummary() {
        return String.format(
            "Recurring Deposit Summary:\n" +
            "Monthly Deposit: %.2f\n" +
            "Annual Interest Rate: %.2f%%\n" +
            "Tenure: %d months\n" +
            "Total Deposits: %.2f\n" +
            "Total Interest Earned: %.2f\n" +
            "Maturity Amount: %.2f",
            monthlyDeposit, annualInterestRate, tenureMonths,
            calculateTotalDeposits(), calculateTotalInterest(), calculateMaturityAmount()
        );
    }
}