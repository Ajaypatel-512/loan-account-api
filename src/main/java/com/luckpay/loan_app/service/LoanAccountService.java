package com.luckpay.loan_app.service;

import com.luckpay.loan_app.http.response.EmiResponse;

public interface LoanAccountService {
    EmiResponse fetchAndSaveLoanAccount(String accountNumber);
}
