package week8.class_problems;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public abstract class Question {
    private final String id;
    private final String questionText;
    private final int points;

    protected Question(String id, String questionText, int points) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("id cannot be blank");
        }
        if (questionText == null || questionText.trim().isEmpty()) {
            throw new IllegalArgumentException("questionText cannot be blank");
        }
        if (points < 0) {
            throw new IllegalArgumentException("points cannot be negative");
        }
        this.id = id;
        this.questionText = questionText;
        this.points = points;
    }

    public String getId() {
        return id;
    }

    public String getQuestionText() {
        return questionText;
    }

    public int getPoints() {
        return points;
    }

    public abstract boolean evaluate(String answer);

    public static class Student extends ExamStudent {
        public Student(String name) {
            super(name, name);
        }

        public Student(String id, String name) {
            super(id, name);
        }
    }
}

class MultipleChoiceQuestion extends Question {
    private final String correctAnswer;

    public MultipleChoiceQuestion(String id, String questionText, int points, String correctAnswer) {
        super(id, questionText, points);
        if (correctAnswer == null || correctAnswer.trim().isEmpty()) {
            throw new IllegalArgumentException("correctAnswer cannot be blank");
        }
        this.correctAnswer = correctAnswer;
    }

    @Override
    public boolean evaluate(String answer) {
        return answer != null && answer.trim().equalsIgnoreCase(correctAnswer.trim());
    }
}

class TrueFalseQuestion extends Question {
    private final boolean correctAnswer;

    public TrueFalseQuestion(String id, String questionText, int points, boolean correctAnswer) {
        super(id, questionText, points);
        this.correctAnswer = correctAnswer;
    }

    @Override
    public boolean evaluate(String answer) {
        if (answer == null) {
            return false;
        }
        return Boolean.parseBoolean(answer.trim()) == correctAnswer;
    }
}

class ShortAnswerQuestion extends Question {
    private final String expectedKeyword;

    public ShortAnswerQuestion(String id, String questionText, int points, String expectedKeyword) {
        super(id, questionText, points);
        if (expectedKeyword == null || expectedKeyword.trim().isEmpty()) {
            throw new IllegalArgumentException("expectedKeyword cannot be blank");
        }
        this.expectedKeyword = expectedKeyword;
    }

    @Override
    public boolean evaluate(String answer) {
        return answer != null && answer.trim().equalsIgnoreCase(expectedKeyword.trim());
    }
}

class ExamStudent {
    private final String id;
    private final String name;

    public ExamStudent(String id, String name) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("id cannot be blank");
        }
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("name cannot be blank");
        }
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

class Examination {
    private final String title;
    private final List<Question> questions = new ArrayList<>();

    public Examination(String title) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("title cannot be blank");
        }
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void addQuestion(Question question) {
        if (question != null) {
            questions.add(question);
        }
    }

    public List<Question> getQuestions() {
        return new ArrayList<>(questions);
    }

    public int getTotalPoints() {
        int total = 0;
        for (Question q : questions) {
            total += q.getPoints();
        }
        return total;
    }
}

enum AttemptState {
    InProgress, Submitted
}

class Attempt {
    private final ExamStudent student;
    private final Examination examination;
    private final Map<String, String> recordedAnswers = new LinkedHashMap<>();
    private AttemptState state = AttemptState.InProgress;

    public Attempt(ExamStudent student, Examination examination) {
        if (student == null || examination == null) {
            throw new IllegalArgumentException("Student and examination cannot be null");
        }
        this.student = student;
        this.examination = examination;
    }

    public ExamStudent getStudent() {
        return student;
    }

    public Examination getExamination() {
        return examination;
    }

    public AttemptState getState() {
        return state;
    }

    public String recordAnswer(String questionId, String answer) {
        if (state == AttemptState.Submitted) {
            return "Cannot change answers for a submitted examination.";
        }
        recordedAnswers.put(questionId, answer);
        return "Answer recorded for " + questionId + ".";
    }

    public String submit() {
        if (state == AttemptState.Submitted) {
            return "Cannot change answers for a submitted examination.";
        }
        state = AttemptState.Submitted;
        int totalScore = 0;
        List<String> results = new ArrayList<>();

        for (Question q : examination.getQuestions()) {
            String ans = recordedAnswers.get(q.getId());
            boolean isCorrect = q.evaluate(ans);
            int awarded = isCorrect ? q.getPoints() : 0;
            totalScore += awarded;
            results.add(q.getId() + ": " + (isCorrect ? "Correct" : "Incorrect") + " (" + awarded + " points)");
        }

        return examination.getTitle() + " submitted by " + student.getName() + ". Result: " +
                String.join(", ", results) + ". Total score: " + totalScore + "/" + examination.getTotalPoints() + ".";
    }
}

class ExamOperations {
    public static String startExam(ExamStudent student, Examination exam) {
        if (student == null || exam == null) {
            throw new IllegalArgumentException("Student and examination cannot be null");
        }
        return exam.getTitle() + " started by " + student.getName() + ".";
    }
}
