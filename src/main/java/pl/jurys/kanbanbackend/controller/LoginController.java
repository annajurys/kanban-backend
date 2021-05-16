package pl.jurys.kanbanbackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.jurys.kanbanbackend.model.Column;
import pl.jurys.kanbanbackend.repository.UserRepository;
import pl.jurys.kanbanbackend.utils.PasswordSHA1;
import pl.jurys.kanbanbackend.utils.SessionUtil;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/login")
public class LoginController {

    @Autowired
    private PasswordSHA1 passwordSHA1;
    @Autowired
    private SessionUtil sessionUtil;
    @Autowired
    private UserRepository userRepository;

}
