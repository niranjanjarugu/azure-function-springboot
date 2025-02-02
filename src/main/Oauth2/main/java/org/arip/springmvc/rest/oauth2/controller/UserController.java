package org.arip.springmvc.rest.oauth2.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping("/user")
    public String user(@AuthenticationPrincipal OidcUser oidcUser, Model model) {
        if (oidcUser != null) {
            String email = oidcUser.getAttribute("email");
            model.addAttribute("email", email);
        }
        return "user"; // This will return a JSP page with email info
    }
}

