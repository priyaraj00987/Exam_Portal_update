package com.exam.examserver1.service;

import com.exam.examserver1.model.exam.Quiz;
import com.exam.examserver1.model.exam.Question;

import java.util.Set;

public interface QuestionService {
    public Question addQuestion(Question question);

    public Question updateQuestion(Question question);

    public Set<Question> getQuestions();

    public Question getQuestion(Long questionId);

    public Set<Question> getQuestionsOfQuiz(Quiz quiz);

    public void deleteQuestion(Long quesId);

    public Question get(Long questionsId);

}
