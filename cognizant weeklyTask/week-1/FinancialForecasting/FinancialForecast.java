public class FinancialForecast {

    // Recursive method to calculate future value
    public static double futureValue(double presentValue, double growthRate, int years) {

        if (years == 0)
            return presentValue;

        return futureValue(presentValue * (1 + growthRate), growthRate, years - 1);
    }

    public static void main(String[] args) {

        double presentValue = 10000;
        double growthRate = 0.10; // 10%
        int years = 5;

        double result = futureValue(presentValue, growthRate, years);

        System.out.println("Present Value : Rs. " + presentValue);
        System.out.println("Growth Rate   : " + (growthRate * 100) + "%");
        System.out.println("Years         : " + years);
        System.out.println("Future Value  : Rs. " + String.format("%.2f", result));

        System.out.println("\nAnalysis:");
        System.out.println("Time Complexity : O(n)");
        System.out.println("Space Complexity: O(n) (Recursion Stack)");
        System.out.println("Optimization: Use Iteration or Dynamic Programming to avoid recursion overhead.");
    }
}
