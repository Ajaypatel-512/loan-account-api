package com.luckpay.loan_app.http.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;

import java.util.List;

public class LoanAccountResponse {
    private String loanAccountNumber;
    private List<EmiDetail> emiDetails;

    // getters and setters

    public static class EmiDetail {
        @JsonProperty("month")
        @Column(name = "emi_month")
        private String emiMonth;
        private double emiAmount;
        private boolean paidStatus;
        private boolean dueStatus;

        // getters and setters
        public String getEmiMonth() {
            return emiMonth;
        }

        public void setEmiMonth(String emiMonth) {
            this.emiMonth = emiMonth;
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

        @Override
        public String toString() {
            return "EmiDetail{" +
                    "emiMonth='" + emiMonth + '\'' +
                    ", emiAmount=" + emiAmount +
                    ", paidStatus=" + paidStatus +
                    ", dueStatus=" + dueStatus +
                    '}';
        }

    }

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
