package com.cms.issuetracking.Service;


import com.cms.issuetracking.Model.emp;
import com.cms.issuetracking.Repository.EmployeeRepo;
import com.cms.issuetracking.Repository.IssueRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.logging.Logger;

@Service
@Slf4j

public class EmpService {


   private EmployeeRepo employeeRepo;
    private IssueRepo issueRepo;


    public List<emp> getEmpName(int year, int month){
        LocalDate start = LocalDate.of(year, month, 1);
        LocalDate end = start.withDayOfMonth(start.lengthOfMonth());

        return employeeRepo.getEmpNames(start, end);
    }

    public void process() {
        log.debug("Debugging process...");
        log.info("Processing started");
        log.warn("Potential issue detected");
    }

}
