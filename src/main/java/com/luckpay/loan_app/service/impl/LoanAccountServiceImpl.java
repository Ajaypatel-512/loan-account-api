package com.luckpay.loan_app.service.impl;

import com.luckpay.loan_app.http.response.EmiResponse;
import com.luckpay.loan_app.http.response.LoanAccountResponse;
import com.luckpay.loan_app.integration.LoanAccountClient;
import com.luckpay.loan_app.model.EmiDetail;
import com.luckpay.loan_app.model.LoanAccount;
import com.luckpay.loan_app.repository.LoanAccountRepository;
import com.luckpay.loan_app.service.LoanAccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LoanAccountServiceImpl implements LoanAccountService {
    private static final Logger logger = LoggerFactory.getLogger(LoanAccountServiceImpl.class);

    private final LoanAccountClient client;
    private final LoanAccountRepository repository;

    public LoanAccountServiceImpl(LoanAccountClient client, LoanAccountRepository repository) {
        this.client = client;
        this.repository = repository;
    }

    @Override
    public EmiResponse fetchAndSaveLoanAccount(String accountNumber) {
        logger.info("Fetching loan account details for account number: {}", accountNumber);
        LoanAccountResponse response = client.getLoanAccountFromExternalAPI(accountNumber);

        EmiResponse emiResponse = new EmiResponse();
        emiResponse.setLoanAccountNumber(response.getLoanAccountNumber());
        LoanAccountResponse.EmiDetail dueEmi = null;
        for (LoanAccountResponse.EmiDetail emi : response.getEmiDetails()) {
            if (emi.isDueStatus()) {
                dueEmi = emi;
                break;
            }
        }

        if (dueEmi != null) {
            emiResponse.setDueDate(dueEmi.getEmiMonth());
            emiResponse.setEmiAmount(dueEmi.getEmiAmount());
        }


        LoanAccount loanAccount = new LoanAccount();
        loanAccount.setLoanAccountNumber(response.getLoanAccountNumber());

        List<EmiDetail> emiEntities = new ArrayList<>();
        for (LoanAccountResponse.EmiDetail dto : response.getEmiDetails()) {
            EmiDetail e = new EmiDetail();
            e.setEmiMonth(dto.getEmiMonth());
            e.setEmiAmount(dto.getEmiAmount());
            e.setPaidStatus(dto.isPaidStatus());
            e.setDueStatus(dto.isDueStatus());
            e.setLoanAccount(loanAccount);
            emiEntities.add(e);
        }
        loanAccount.setEmiDetails(emiEntities);

        logger.info("Saving loan account details to the database: {}", emiResponse);
        repository.save(loanAccount);

        return emiResponse;
    }
}
