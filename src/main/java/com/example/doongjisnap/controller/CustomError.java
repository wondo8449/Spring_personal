package com.example.doongjisnap.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CustomError implements ErrorController {
    @GetMapping("/error")
    public String error(HttpServletRequest request) {
        final Object requestAttribute = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        if(requestAttribute != null) {
            int statusCode = Integer.valueOf(requestAttribute.toString());
            if (statusCode == HttpStatus.NOT_FOUND.value()) {
                return "/error/404";
            }
        }
        return "/error/500";
    }
}
