import java.util.*;

public class main {
    public static void main(String[] args) {
        
        // Binomial probabilities for 0, 1, 2, 3 and more defects
        double defects0 = binomial(0);
        double defects1 = binomial(1);
        double defects2 = binomial(2);
        double defects3OrMore = 1 - (defects0 + defects1 + defects2);

        // Output individual probabilities
        System.out.printf("Probability of 0 defects: " + defects0 + "\n");
        System.out.printf("Probability of 1 defect: " + defects1 + "\n");
        System.out.printf("Probability of 2 defects: " + defects2 + "\n");
        System.out.printf("Probability of 3 or more defects: " + defects3OrMore + "\n");

        // Summary
        System.out.println("\nSummary:");
        System.out.printf("There is a probability of " + defects0 + " to have no defects in a batch of 100 circuit boards.\n");
        System.out.printf("There is a probability of " + defects1 + " to have 1 defect in a batch of 100 circuit boards.\n");
        System.out.printf("There is a probability of " + defects2 + " to have 2 defects in a batch of 100 circuit boards.\n");
        System.out.printf("There is a probability of " + defects3OrMore + " to have 3 or more defects in a batch of 100 circuit boards.\n");
    }

    // Calculate binomial probability
    private static double binomial(int k) {
        long expectedNumberWithDefects = 1;
        int totalCircuitBoards = 100;
        double defectProbability  = 0.01;

        for (int i = 1; i <= k; i++) {
            expectedNumberWithDefects = expectedNumberWithDefects  * (totalCircuitBoards - i + 1) / i;
        }
        return expectedNumberWithDefects  * Math.pow(defectProbability, k) * Math.pow(1 - defectProbability, totalCircuitBoards - k);
    }
}
