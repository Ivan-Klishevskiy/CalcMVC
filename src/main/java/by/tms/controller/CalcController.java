package by.tms.controller;

import by.tms.dto.CalculatorDto;
import by.tms.service.CalcService;
import by.tms.service.OperationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/calc")
public class CalcController {
    private final CalcService calcService;
    private final OperationService operationService;

    public CalcController(CalcService calcService, OperationService operationService) {
        this.calcService = calcService;
        this.operationService = operationService;
    }

    @GetMapping
    public String calculator(Model model) {
        model.addAttribute("calcModel",new CalculatorDto());
        return "simpleCalc";
    }

    @PostMapping
    public String simple(@ModelAttribute("calcModel") @Valid CalculatorDto calculatorDto, BindingResult bindingResult, Model model, HttpSession httpSession) {
        if (bindingResult.hasErrors()) {
            return "simpleCalc";
        }
        calculatorDto.setResult(calcService.calculate((String) httpSession.getAttribute("user"),
                calculatorDto.getFirst(), calculatorDto.getSecond(), calculatorDto.getSign()));
        model.addAttribute("calcModel",calculatorDto);
        model.addAttribute("resultValue",calculatorDto.getResult());
        model.addAttribute("history", operationService.getAllHistory((String) httpSession.getAttribute("user")));
        return "simpleCalc";
    }
}
