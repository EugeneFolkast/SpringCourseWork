package course.work.meogol.controller;

import course.work.meogol.model.Person;
import course.work.security.PersonDetails;
import course.work.services.RegistrationService;
import course.work.util.PersonValidator;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@Controller
public class AuthController {

    private final RegistrationService registrationService;
    private final PersonValidator personValidator;

    @Autowired
    public AuthController(RegistrationService registrationService, PersonValidator personValidator) {
        this.registrationService = registrationService;
        this.personValidator = personValidator;
    }

    @GetMapping("/login")
    public String loginPage() {
        return "auth/login";
    }

    @GetMapping("/registration")
    public String registrationPage(@ModelAttribute("person") Person person) {
        return "auth/registration";
    }

    @PostMapping("/registration")
    public String performRegistration(@ModelAttribute("person") @Valid Person person,  @RequestParam("radioName") String role,
                                      BindingResult bindingResult) {
        person.setRole(role);
        personValidator.validate(person, bindingResult);

        if (bindingResult.hasErrors())
            return "/auth/registration";

        registrationService.register(person);

        return "redirect:/registration";
    }

    @GetMapping("/get_home")
    public String getHome(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        PersonDetails personDetails = (PersonDetails) authentication.getPrincipal();

        var person = personDetails.getPerson();
        var role = person.getRole();

        if(Objects.equals(role, "ROLE_KASIR"))
            return "redirect:/cashier/home";
        if(Objects.equals(role, "ROLE_POVAR"))
            return "redirect:/cook/cook_orders";
        if(Objects.equals(role, "ROLE_ADMIN"))
            return "redirect:/registration";
        // TODO: 10.01.2022  !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! add admin page
        return "/";
    }
}
