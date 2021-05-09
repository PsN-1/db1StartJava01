package passwordMeter;

public class Complexity {
    int score;
    String complexity;

    public Complexity(int score){
        this.score = score;
        calculatePasswordComplexity();
    }

    public String calculatePasswordComplexity() {

        if (score < 20) {
            complexity = "Very Weak";
        } else if (score < 40) {
            complexity = "Weak";
        } else if (score < 60) {
            complexity = "Good";
        } else if (score < 80) {
            complexity = "Strong";
        } else {
            complexity = "Very Strong";
        }

        return complexity;
    }
}
