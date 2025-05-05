package com.luckpay.loan_app.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class LoanAccount {
    @Id
    private String loanAccountNumber;

    @OneToMany(mappedBy = "loanAccount", cascade = CascadeType.ALL)
    private List<EmiDetail> emiDetails;

    // Getters and Setters
    public String getLoanAccountNumber() {
        return loanAccountNumber;
    }

    public void setLoanAccountNumber(String loanAccountNumber) {
        this.loanAccountNumber = loanAccountNumber;
    }

    public List<EmiDetail> getEmiDetails() {
        return emiDetails;
    }

    public void setEmiDetails(List<EmiDetail> emiDetails) {
        this.emiDetails = emiDetails;
    }
}
