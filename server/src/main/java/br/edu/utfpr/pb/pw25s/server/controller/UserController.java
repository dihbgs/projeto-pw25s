package br.edu.utfpr.pb.pw25s.server.controller;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.http.HttpStatus;

import br.edu.utfpr.pb.pw25s.server.shared.GenericResponse;
import br.edu.utfpr.pb.pw25s.server.service.UserService;
import br.edu.utfpr.pb.pw25s.server.error.APIError;
import jakarta.servlet.http.HttpServletRequest;
import br.edu.utfpr.pb.pw25s.server.model.User;
import jakarta.validation.Valid;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public GenericResponse createUser(@Valid @RequestBody User user) {
        userService.save(user);

        GenericResponse genericResponse = new GenericResponse();
        genericResponse.setMessage("User succesfully saved!");

        return genericResponse;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({MethodArgumentNotValidException.class})
    public APIError handlerValidationException(
        MethodArgumentNotValidException exception,
        HttpServletRequest request
    ) {
        BindingResult result = exception.getBindingResult();
        Map<String, String> validationErrors = new HashMap<>();

        for(FieldError error : result.getFieldErrors()) {
            validationErrors.put(error.getField(), error.getDefaultMessage());
        }

        return new APIError(400, "Validation error", request.getServletPath(), validationErrors);
    }
}