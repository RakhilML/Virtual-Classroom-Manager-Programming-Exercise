package CreationalPatterns.singleton;

public class PerformanceTracker {

    // Volatile to ensure thread-safe access
    private static volatile PerformanceTracker instance = null;

    private int completedCourses;
    private int quizScores;

    // Private constructor to prevent instantiation
    private PerformanceTracker() {
        completedCourses = 0;
        quizScores = 0;
    }

    // Public method to provide access to the singleton instance
    public static PerformanceTracker getInstance() {
        if (instance == null) {
            synchronized (PerformanceTracker.class) {
                if (instance == null) {
                    instance = new PerformanceTracker();
                }
            }
        }
        return instance;
    }

    // Method to update completed courses
    public void completeCourse() {
        completedCourses++;
        System.out.println("Courses completed: " + completedCourses);
    }

    // Method to add quiz scores
    public void addQuizScore(int score) {
        quizScores += score;
        System.out.println("Current total quiz score: " + quizScores);
    }

    // Display current performance data
    public void displayPerformance() {
        System.out.println("Performance Data -> Completed Courses: " + completedCourses + ", Total Quiz Scores: " + quizScores);
    }
}
