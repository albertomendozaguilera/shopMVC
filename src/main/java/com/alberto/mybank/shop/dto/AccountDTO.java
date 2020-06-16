package com.alberto.mybank.shop.dto;


import java.util.List;

/**
 *
 * @author wutuf
 */
public class AccountDTO {
    
    private UserDTO userDTO;
    private String iban;
    private String name;
    private double balance;
    private List<PaymentTransactionsDTO> transactionsDTOList;
    private List<LoanDTO> loansDTOList;

    
    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public List<PaymentTransactionsDTO> getTransactionsDTOList() {
        return transactionsDTOList;
    }

    public void setTransactionsDTOList(List<PaymentTransactionsDTO> transactionsDTOList) {
        this.transactionsDTOList = transactionsDTOList;
    }

    public List<LoanDTO> getLoansDTOList() {
        return loansDTOList;
    }

    public void setLoansDTOList(List<LoanDTO> loansDTOList) {
        this.loansDTOList = loansDTOList;
    }
}
