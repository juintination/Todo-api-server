package org.zerock.todoapi.controller;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;

@Controller
public class HelloController {

    @GetMapping("/")
    public String index() {
        return "redirect:/docs";
    }

    @GetMapping("/docs")
    public void redirectToAnotherLink(HttpServletResponse httpServletResponse) throws IOException {
        httpServletResponse.sendRedirect("http://localhost:8080/swagger-ui/index.html");
    }

}
