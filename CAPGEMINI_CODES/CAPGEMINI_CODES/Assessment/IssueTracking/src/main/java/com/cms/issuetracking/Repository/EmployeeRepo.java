package com.cms.issuetracking.Repository;

import com.cms.issuetracking.Model.emp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface EmployeeRepo extends JpaRepository<emp, Long> {


    @Query("SELECT i FROM Issues i WHERE i.issueDate BETWEEN :start AND :end")
    List<emp> getEmpNames(LocalDate start, LocalDate end);
}