package com.anoystick.controller.user;

import jakarta.annotation.security.RolesAllowed;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserAuthController {

    @RolesAllowed("ADMIN")
    @GetMapping("/vip")
    public String vip(){
        return "Vip";
    }

    @RolesAllowed({"USER"})
    @GetMapping("/normal")
    public String normal(){
        return "Normal";
    }


    @GetMapping("/info")
    public Authentication info(){
        return SecurityContextHolder.getContext().getAuthentication();
    }
}
