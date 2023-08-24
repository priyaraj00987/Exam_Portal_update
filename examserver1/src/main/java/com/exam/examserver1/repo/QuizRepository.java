package com.exam.examserver1.repo;

import com.exam.examserver1.model.exam.Category;
import com.exam.examserver1.model.exam.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QuizRepository extends JpaRepository<Quiz,Long> {
    List<Quiz> findByActive(boolean b);

    List<Quiz> findBycategory(Category category);

    List<Quiz> findByCategoryAndActive(Category c, boolean b);
}
