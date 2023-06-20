package com.amrita.jpl.cys21076.p2;

abstract class QuizGame {
    public void startGame() {
        askQuestion();
    }
    abstract void askQuestion();
    abstract void evaluateAnswer(String answer);
}

interface QuizGameListener {
    void onQuestionAsked(String question);
    void onAnswerEvaluated(boolean isCorrect);
}

class QuizGameServer extends QuizGame {
    private String[] quizQuestions;
    private QuizGameClient client;
    private int currentQuestion;
    public QuizGameServer(QuizGameClient client) {
        this.client = client;
        currentQuestion = -1;
        initializeQuestions();
    }
    private void initializeQuestions() {
        /* Creating the array wihch has the questions for the quiz */
        quizQuestions = new String[3];
        quizQuestions[0] = "What is Java?";
        quizQuestions[1] = "Who invented Java?";
        quizQuestions[2] = "Which language was used to replace Java in creating mobile applications?";
    }

    @Override
    public void startGame() {
        System.out.println("Game started in the server");
        currentQuestion = -1;
        askQuestion();
    }

    @Override
        /* needed only for the server */
    void askQuestion() {
        currentQuestion++;
        if (currentQuestion < quizQuestions.length && client != null) {
            String question = quizQuestions[currentQuestion];
            client.onQuestionAsked(question);
        } else {
            declareWinner();
        }
    }

    @Override
        /* needed only for the server */
    void evaluateAnswer(String answer) {
        boolean isCorrect = false;
        String correctAnswer = getCorrectAnswer();
        if (correctAnswer != null) {
            isCorrect = correctAnswer.equalsIgnoreCase(answer);
        }
        if (client != null) {
            client.onAnswerEvaluated(isCorrect);
        }
        askQuestion();
    }

    private String getCorrectAnswer() {
        if (currentQuestion >= 0 && currentQuestion < quizQuestions.length) {
            String question = quizQuestions[currentQuestion];
            return question.split("\\?")[1].trim();
        }
        return null;
    }
    private void declareWinner() {
        System.out.println("Quiz game over in the server");
    }
}
class QuizGameClient extends QuizGame implements QuizGameListener {
    private String name;
    private QuizGameServer server;
    private int correctAnswers;
    public QuizGameClient(String name) {
        this.name = name;
        correctAnswers = 0;
    }
    public String getName() {
        return name;
    }
    public int getCorrectAnswers() {
        return correctAnswers;
    }
    public void setServer(QuizGameServer server) {
        this.server = server;
    }
    @Override
    public void startGame() {
        System.out.println("Client " + name + ": Starting the quiz game.");
        if (server != null) {
            server.startGame();
        }
    }
    @Override
        /* not needed for the client */
    void askQuestion() {}
    @Override
        /* not needed for the client */
    void evaluateAnswer(String answer) {}
    @Override
    public void onQuestionAsked(String question) {
        System.out.println("Client " + name + ": Received question - " + question);
        String answer = "Sample Answer";
        evaluateAnswer(answer);
    }
    @Override
    public void onAnswerEvaluated(boolean isCorrect) {
        if (isCorrect) {
            correctAnswers++;
        }
        System.out.println("Client " + name + ": Answer evaluated. Correct: " + isCorrect);
    }
}

public class periodical {
    public static void main(String[] args) {
        /* creating the server and its client objects */
        QuizGameServer server = new QuizGameServer(null);
        QuizGameClient client = new QuizGameClient("Knightfall");
        /* setting the server for the client knightfall */
        client.setServer(server);
        /* Starting the quiz game */
        client.startGame();
    }
}

