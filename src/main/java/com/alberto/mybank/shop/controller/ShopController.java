package com.alberto.mybank.shop.controller;

import com.alberto.mybank.shop.dto.AccountDTO;
import com.alberto.mybank.shop.dto.PaymentTransactionsDTO;
import com.alberto.mybank.shop.dto.UserDTO;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import java.net.ConnectException;
import java.util.Arrays;
import java.util.Date;
import java.util.concurrent.ExecutionException;

@Controller
public class ShopController {

    @GetMapping("/product")
    public String product(@RequestParam(name="name", required=false, defaultValue="User") String name, Model model) {
        model.addAttribute("name", name);
        return "index";
    }

    @GetMapping("/buy")
    public String buy(Model model) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        UserDTO userDTO = new UserDTO();
        userDTO.setAccountsList(null);
        userDTO.setBlacklist(false);
        userDTO.setEmail("shop@mybank.com");
        userDTO.setId("mybankshop1234");
        userDTO.setName("My Bank Shop");

        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setUserDTO(userDTO);
        accountDTO.setBalance(3000d);
        accountDTO.setIban("ES12355890128");
        accountDTO.setLoansDTOList(null);
        accountDTO.setName("Account Shop");
        accountDTO.setTransactionsDTOList(null);

        PaymentTransactionsDTO paymentTransactionsDTO = new PaymentTransactionsDTO();
        paymentTransactionsDTO.setAccountDTO(accountDTO);
        paymentTransactionsDTO.setBeneficiary("My Bank Shop");
        paymentTransactionsDTO.setConcept("Asus Zenbook Pro Duo");
        paymentTransactionsDTO.setDatetime("2020-06-17");
        paymentTransactionsDTO.setDestinyAccount("ES2412345678098765432109");
        paymentTransactionsDTO.setQuantity(-1399d);
        paymentTransactionsDTO.setOriginAccount("MyBankShop");


        HttpEntity<PaymentTransactionsDTO> entity = new HttpEntity<PaymentTransactionsDTO>(paymentTransactionsDTO, headers);
        try{
            ResponseEntity<String> s = restTemplate.exchange("http://localhost:8080/transactions/addtransaction", HttpMethod.POST, entity, String.class);
            System.out.println(s.getStatusCode().toString());
            model.addAttribute("code",s.getStatusCode());
        }catch (Exception e){
            model.addAttribute("code", "FAILED TO PERFORM REQUEST - " + e.getMessage());
            return "error";
        }

        return "product";
    }
}
