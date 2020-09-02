package tms.findjops.controller;

import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public String ex (HttpRequestMethodNotSupportedException ex, Model model){
        String message = ex.getMessage();
        model.addAttribute("message", "Error");
        return "/error";
    }


    @ExceptionHandler(BindException.class)
    public String ex (BindException ex, Model model){
        String message = ex.getMessage();
        model.addAttribute("message", "Error");
        return "/error";
    }

    @ExceptionHandler(NumberFormatException.class)
    public String ex (NumberFormatException ex, Model model){
        String message = ex.getMessage();
        model.addAttribute("message", "Error");
        return "/error";
    }
}
