package com.cms.issuetracking.Repository;

import com.cms.issuetracking.Model.Issues;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IssueRepo extends JpaRepository<Issues, Long> {

    @Query("SELECT i FROM Issues i WHERE i.status = :status")
    List<Issues> findByStatus(Boolean status);


    @Query("SELECT i FROM Issues i WHERE i.issueDate BETWEEN :start AND :end")
    List<Issues> getIssuesThisMonth(LocalDate start, LocalDate end);
}
