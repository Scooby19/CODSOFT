import java.util.Scanner;

public class Task4 {
    static class InputThread extends Thread {
        private Scanner scanner;
        private String answer = "";
        private boolean answered = false;

        public InputThread(Scanner scanner) {
            this.scanner = scanner;
        }

        public void run() {
            try {
                if (scanner.hasNextLine()) {
                    answer = scanner.nextLine().trim().toUpperCase();
                    answered = true;
                }
            } catch (Exception e) {
                // Ignore input interruption
            }
        }

        public String getAnswer() {
            return answer;
        }

        public boolean isAnswered() {
            return answered;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] questions = {
            "1. Java was developed by:\nA. Bjarne Stroustrup\nB. James Gosling\nC. Dennis Ritchie\nD. Guido van Rossum",
            "2. JVM stands for:\nA. Java Virtual Machine\nB. Java Variable Model\nC. Java Verified Method\nD. None",
            "3. Which keyword is used to inherit a class in Java?\nA. extends\nB. inherit\nC. implements\nD. imports"
        };

        char[] answers = {'B', 'A', 'A'};
        int score = 0;
        final int TIME_LIMIT = 10;

        for (int i = 0; i < questions.length; i++) {
            System.out.println("\n" + questions[i]);
            System.out.println("You have " + TIME_LIMIT + " seconds to answer (A/B/C/D): ");

            InputThread inputThread = new InputThread(scanner);
            inputThread.start();

            try {
                inputThread.join(TIME_LIMIT * 1000);  // wait max 10 seconds
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (inputThread.isAnswered()) {
                String userAnswer = inputThread.getAnswer();
                if (userAnswer.length() == 1 && userAnswer.charAt(0) == answers[i]) {
                    System.out.println(" Correct!");
                    score++;
                } else {
                    System.out.println(" Wrong! Correct answer: " + answers[i]);
                }
            } else {
                System.out.println("⏱ Time's up! No answer given. Correct answer: " + answers[i]);
                inputThread.interrupt(); // interrupt the input thread
            }
        }

        System.out.println("\n🎯 Quiz Over! Your Score: " + score + "/" + questions.length);
        scanner.close();
    }
}

