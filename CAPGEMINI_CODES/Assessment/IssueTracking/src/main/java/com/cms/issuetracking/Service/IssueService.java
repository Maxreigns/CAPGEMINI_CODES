package com.cms.issuetracking.Service;

import com.cms.issuetracking.Model.Issues;
import com.cms.issuetracking.Repository.IssueRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;


@Service
@Slf4j

public class IssueService {
    private final IssueRepo issueRepo;


   public IssueService(IssueRepo issueRepo) {
      this.issueRepo = issueRepo;
   }

   public List<Issues> getIssuesByMonth(int month, int year) {

      LocalDate start = LocalDate.of(year, month, 1);
      LocalDate end = start.withDayOfMonth(start.lengthOfMonth());

      return issueRepo.getIssuesThisMonth(start, end);
   }


   public List<Issues> getUnresolved(){

      return issueRepo.findByStatus(true);
   }

   public void getLogging(){
      log.debug("here come me");
      log.info("Here is me in Issue Service");
   }
}
