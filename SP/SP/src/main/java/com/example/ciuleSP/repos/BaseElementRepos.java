package com.example.ciuleSP.repos;

import com.example.ciuleSP.Book.BaseElement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BaseElementRepos extends JpaRepository<BaseElement, Integer> {
}
