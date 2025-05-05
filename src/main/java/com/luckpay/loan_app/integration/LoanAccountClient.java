package com.luckpay.loan_app.integration;

import com.luckpay.loan_app.http.response.LoanAccountResponse;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import static com.luckpay.loan_app.http.constants.constant.LOAN_ACCOUNT_URL;

@Component
public class LoanAccountClient {
    private final RestTemplate restTemplate;

    public LoanAccountClient(RestTemplateBuilder builder) {
        this.restTemplate = builder.build();
    }

    public LoanAccountResponse getLoanAccountFromExternalAPI(String accountNumber) {
        String url = LOAN_ACCOUNT_URL + accountNumber;
        LoanAccountResponse response = restTemplate.getForObject(url, LoanAccountResponse.class);
        return response;
    }
}
