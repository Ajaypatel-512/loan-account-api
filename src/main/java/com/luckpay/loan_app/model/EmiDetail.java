package com.luckpay.loan_app.model;

import jakarta.persistence.*;

@Entity
public class EmiDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "emi_month")
    private String emiMonth;
    private double emiAmount;
    private boolean paidStatus;
    private boolean dueStatus;

    @ManyToOne
    @JoinColumn(name = "loan_account_number")
    private LoanAccount loanAccount;

    // getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmiMonth() {
        return emiMonth;
    }

    public void setEmiMonth(String month) {
        this.emiMonth = month;
    }

    public double getEmiAmount() {
        return emiAmount;
    }

    public void setEmiAmount(double emiAmount) {
        this.emiAmount = emiAmount;
    }

    public boolean isPaidStatus() {
        return paidStatus;
    }

    public void setPaidStatus(boolean paidStatus) {
        this.paidStatus = paidStatus;
    }

    public boolean isDueStatus() {
        return dueStatus;
    }

    public void setDueStatus(boolean dueStatus) {
        this.dueStatus = dueStatus;
    }

    public LoanAccount getLoanAccount() {
        return loanAccount;
    }

    public void setLoanAccount(LoanAccount loanAccount) {
        this.loanAccount = loanAccount;
    }

}
