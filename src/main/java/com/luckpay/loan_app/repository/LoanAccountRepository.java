package com.luckpay.loan_app.repository;

import com.luckpay.loan_app.model.LoanAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanAccountRepository extends JpaRepository<LoanAccount, String> {
}
