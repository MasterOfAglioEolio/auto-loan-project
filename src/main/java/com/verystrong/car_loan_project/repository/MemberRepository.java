package com.verystrong.car_loan_project.repository;

import com.verystrong.car_loan_project.entity.Article;
import com.verystrong.car_loan_project.entity.Member;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface MemberRepository extends CrudRepository<Member, Long> {
    @Override
    ArrayList<Member> findAll();
}
