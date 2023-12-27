package com.verystrong.car_loan_project.repository;

import com.verystrong.car_loan_project.entity.Article;
import org.springframework.data.repository.CrudRepository;

public interface ArticleRepository extends CrudRepository<Article, Long> {
}
