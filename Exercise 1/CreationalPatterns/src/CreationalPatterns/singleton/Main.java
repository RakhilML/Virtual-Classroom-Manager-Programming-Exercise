package CreationalPatterns.singleton;

public class Main {
    public static void main(String[] args) {
        // Access the singleton instance
        PerformanceTracker tracker = PerformanceTracker.getInstance();

        // Update performance data
        tracker.completeCourse();
        tracker.addQuizScore(85);
        tracker.completeCourse();
        tracker.addQuizScore(90);

        // Display current performance
        tracker.displayPerformance();

        // Prove that the same instance is used
        PerformanceTracker anotherTracker = PerformanceTracker.getInstance();
        anotherTracker.displayPerformance();
    }
}
