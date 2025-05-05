package com.luckpay.loan_app.controller;

import com.luckpay.loan_app.http.response.EmiResponse;
import com.luckpay.loan_app.http.response.LoanAccountResponse;
import com.luckpay.loan_app.service.LoanAccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.luckpay.loan_app.http.constants.constant.BASE_URL;
import static com.luckpay.loan_app.http.constants.constant.GET_LOAN_ACCOUNT;

@RestController
@RequestMapping(BASE_URL)
public class LoanAccountController {
    private static final Logger logger = LoggerFactory.getLogger(LoanAccountController.class);

    private final LoanAccountService service;

    public LoanAccountController(LoanAccountService service) {
        this.service = service;
    }

    @GetMapping(GET_LOAN_ACCOUNT)
    public ResponseEntity<EmiResponse> getLoanAccount(@PathVariable String accountNumber) {
        logger.info("Fetching loan account details for account number: {}", accountNumber);
        EmiResponse response = service.fetchAndSaveLoanAccount(accountNumber);
        return ResponseEntity.ok(response);
    }
}
