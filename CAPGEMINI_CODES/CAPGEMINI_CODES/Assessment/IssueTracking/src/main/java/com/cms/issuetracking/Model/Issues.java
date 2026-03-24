package com.cms.issuetracking.Model;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
public class Issues {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "issue_id")


    private Long id;
    @ManyToOne
    @JoinColumn(name = "emp_id")

    private emp employee;

    private String AccessIssue;

    private String CloudIssue;

    private String DesktopIssue;

    private String OtherIssue;

    private Boolean status;

    private Date issueDate;

    public Date getDate() {
        return issueDate;
    }

    public void setDate(Date date) {
        this.issueDate = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
       id = id;
    }

    public String getAccessIssue() {
        return AccessIssue;
    }

    public void setAccessIssue(String accessIssue) {
        AccessIssue = accessIssue;
    }

    public String getCloudIssue() {
        return CloudIssue;
    }

    public void setCloudIssue(String cloudIssue) {
        CloudIssue = cloudIssue;
    }

    public String getDesktopIssue() {
        return DesktopIssue;
    }

    public void setDesktopIssue(String desktopIssue) {
        DesktopIssue = desktopIssue;
    }

    public String getOtherIssue() {
        return OtherIssue;
    }

    public void setOtherIssue(String otherIssue) {
        OtherIssue = otherIssue;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
