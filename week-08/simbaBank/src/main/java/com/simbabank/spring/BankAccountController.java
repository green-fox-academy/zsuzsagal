package com.simbabank.spring;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class BankAccountController {
  private List<BankAccount> accounts;

  public BankAccountController() {
    accounts = new ArrayList<>();
    accounts.add(new BankAccount("Simba", 2000.543, "lion King", "King"));
    accounts.add(new BankAccount("Scar", 1576.653, "lion", "not King"));
    accounts.add(new BankAccount("Banzai", 3754.0712, "hyena", "not King"));
    accounts.add(new BankAccount("Sarabi", 856.543, "lion", "not King"));
    accounts.add(new BankAccount("Shenzi", 4895.1287, "hyena", "not King"));
    accounts.add(new BankAccount("Timon", 643.46758, "meerkat", "not King"));
  }

  @GetMapping("/show")
  public String showBankAccounts(Model model) {
    model.addAttribute("accounts", accounts);
    return "index";
  }

  @GetMapping("/enjoy")
  public String displayText(Model model) {
    model.addAttribute("myString", "This is an <em>HTML</em> text. </p> <b>Enjoy yourself!</b>");
    return "enjoy";
  }

  @GetMapping("/accounts")
  public String displayBankAccounts(Model model) {
    model.addAttribute("accounts", accounts);
    return "table";
  }

  @PostMapping("/raise-all-accounts")
  public String raiseBalanceForAll(Model model) {
    model.addAttribute("accounts", accounts.stream()
            .peek(account -> account.raiseAccount())
            .collect(Collectors.toList()));
    return "table";
  }

  @GetMapping("/addnew")
  public String addAccount(Model model) {
    model.addAttribute("bankAccount", new BankAccount("", 0, "", ""));
    return "create";
  }

  @PostMapping("/add")
  public String addAccount(@ModelAttribute BankAccount bankaccount) {
    accounts.add(bankaccount);
    return "redirect:/accounts";
  }
}
