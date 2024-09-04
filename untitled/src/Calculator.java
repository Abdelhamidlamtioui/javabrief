public class Calculator {
    public static int calculateTotalConsumption(CarbonTracker tracker, String userId) {
        CarbonTracker carbonTracker = new CarbonTracker();
        int total = 0;
        for (Consumption consumption : carbonTracker.getConsumptions(userId).values()) {
            total += consumption.getAmount();
        }
        return total;
    }
}
