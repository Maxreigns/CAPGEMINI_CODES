package com.cms.issuetracking.Controller;


import com.cms.issuetracking.Model.emp;
import com.cms.issuetracking.Model.Issues;
import com.cms.issuetracking.Service.EmpService;
import com.cms.issuetracking.Service.IssueService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

@RequestMapping("/employee")
public class IssueTrackingController {

    private final EmpService empService;
    private final IssueService issueService;


    public IssueTrackingController(IssueService issueService, EmpService empService) {
        this.issueService = issueService;
        this.empService = empService;
    }



    @GetMapping("/unresolved")
    public List<Issues> getUnresolved(){
      return  issueService.getUnresolved();
    }

    @GetMapping("/month")
        public List<Issues> getThisMonth(){
            return issueService.getIssuesByMonth(3, 2026);
        }


     @GetMapping("/EmpRaisedIssue")
    public List<emp> getEmpRaisedIssue(){
        return empService.getEmpName(2026, 3);
    }



}
