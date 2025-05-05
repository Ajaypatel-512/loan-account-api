package com.luckpay.loan_app.http.response;

public class EmiResponse {
    private String loanAccountNumber;
    private String dueDate;
    private double emiAmount;

    // getters & setters
    public String getLoanAccountNumber() {
        return loanAccountNumber;
    }
    public void setLoanAccountNumber(String loanAccountNumber) {
        this.loanAccountNumber = loanAccountNumber;
    }
    public String getDueDate() {
        return dueDate;
    }
    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }
    public double getEmiAmount() {
        return emiAmount;
    }
    public void setEmiAmount(double emiAmount) {
        this.emiAmount = emiAmount;
    }
}
