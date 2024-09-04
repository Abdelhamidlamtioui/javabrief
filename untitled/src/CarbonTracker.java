import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CarbonTracker {
    private HashMap<String, Consumption> userConsumptions;

    public CarbonTracker() {
        userConsumptions = new HashMap<>();
    }

    public void addConsumptionRecord(String userId, int amount, LocalDate startdate, LocalDate enddate) {
        Consumption newConsumption = new Consumption(amount, startdate, enddate);
        userConsumptions.put(userId, newConsumption);
    }

    // Method to retrieve consumptions for a specific user
    public Map<String,Consumption> getConsumptions(String userId) {
        return userConsumptions;
    }

    // Calculate averages
    public double calculateDailyAverage(String userId, LocalDate start, LocalDate end) {
        Map<String,Consumption> consumptions = getConsumptions(userId);
        long days = ChronoUnit.DAYS.between(start, end);
        double total = consumptions.values().stream()
                .filter(c -> !c.getStartdate().isBefore(start) && !c.getEnddate().isAfter(end))
                .mapToDouble(Consumption::getAmount)
                .sum();
        return days > 0 ? total / days : 0;
    }

    public double calculateWeeklyAverage(String userId, LocalDate start, LocalDate end) {
        double dailyAverage = calculateDailyAverage(userId, start, end);
        return dailyAverage * 7;
    }

    public double calculateMonthlyAverage(String userId, LocalDate start, LocalDate end) {
        double dailyAverage = calculateDailyAverage(userId, start, end);
        return dailyAverage * 30;
    }
}
