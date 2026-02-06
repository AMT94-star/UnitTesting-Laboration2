package se.amt.unittestinglaboration2.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import se.amt.unittestinglaboration2.Service.ATMService;

@Controller
@RequestMapping("/balance")
public class ATMController {

    private final ATMService atmService;

    public ATMController(ATMService atmService) {
        this.atmService = atmService;
    }

    @GetMapping
    public String getBalance(Model model) {
        model.addAttribute("balance", atmService.getBalance());
        return "balance";
    }

    @PostMapping("/deposit")
    public String deposit(Model model, @RequestParam int amount) {
        atmService.deposit(amount);
        model.addAttribute("balance", atmService.getBalance());
        return "balance";
    }
}
