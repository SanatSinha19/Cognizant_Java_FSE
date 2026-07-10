public class ForecastTest {

    public static void main(String[] args) {

        double presentValue = 10000.0;  
        double growthRate = 0.08;       
        int years = 10;                 

        double futureValue = FinancialForecast.calculateFutureValue(presentValue, growthRate, years);

        System.out.println("=== Financial Forecast (Recursive) ===");
        System.out.println("Present Value: $" + presentValue);
        System.out.println("Growth Rate: " + (growthRate * 100) + "%");
        System.out.println("Years: " + years);
        System.out.printf("Predicted Future Value: $%.2f%n", futureValue);

        System.out.println();

        double[] memo = new double[years + 1];
        double futureValueMemoized = FinancialForecast.calculateFutureValueMemoized(presentValue, growthRate, years, memo);

        System.out.println("=== Financial Forecast (Memoized Recursive) ===");
        System.out.printf("Predicted Future Value: $%.2f%n", futureValueMemoized);

        System.out.println();
        System.out.println("=== Year-by-Year Forecast ===");
        for (int y = 1; y <= 5; y++) {
            double val = FinancialForecast.calculateFutureValue(presentValue, growthRate, y);
            System.out.printf("Year %d: $%.2f%n", y, val);
        }
    }
}