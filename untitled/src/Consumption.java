import java.time.LocalDate;

public class Consumption {
    private int amount;
    private LocalDate startdate;
    private LocalDate enddate;

    public Consumption(int amount, LocalDate startdate, LocalDate enddate) {
        this.amount = amount;
        this.startdate = startdate;
        this.enddate = enddate;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public LocalDate getStartdate() {
        return startdate;
    }

    public void setStartdate(LocalDate startdate) {
        this.startdate = startdate;
    }

    public LocalDate getEnddate() {
        return enddate;
    }

    public void setEnddate(LocalDate enddate) {
        this.enddate = enddate;
    }

    public String display() {
        return "Consumption{" +
                "amount=" + amount +
                ", start date=" + startdate +
                ", end date=" + enddate +
                '}';
    }
}
