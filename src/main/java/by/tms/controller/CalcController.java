package by.tms.controller;

import by.tms.service.CalcService;
import by.tms.service.OperationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/calc")
public class CalcController {
    private final CalcService calcService;
    private final OperationService operationService;

    public CalcController(CalcService calcService, OperationService operationService) {
        this.calcService = calcService;
        this.operationService = operationService;
    }

    @GetMapping("/simple")
    public String simple() {
        return "simpleCalc";
    }

    @PostMapping("/simple")
    public String simple(float first, String sign, float second, Model model, HttpSession httpSession) {
        model.addAttribute("first",first);
        model.addAttribute("second",second);
        model.addAttribute("result",calcService.calculate((String) httpSession.getAttribute("user"),first,second,sign));
        model.addAttribute("history",operationService.getAllHistory((String) httpSession.getAttribute("user")));
        return "simpleCalc";
    }
}
