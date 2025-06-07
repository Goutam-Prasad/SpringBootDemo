package com.goutampersonal.springboot.Controller;

import com.goutampersonal.springboot.Components.TransactionalUserService;
import com.goutampersonal.springboot.Helpers.Binders.LowerCaseStringTransformation;
import com.goutampersonal.springboot.Helpers.DTO.CreateUserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.DataBinder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api")
public class TestController {

    @InitBinder
    protected void initBinder(DataBinder binder) {
        binder.registerCustomEditor(String.class, "firstName", new LowerCaseStringTransformation());
    }

    @GetMapping(path = "/users")
    public String getUserDetails() {
        return "This is a dummy User";
    }

    @GetMapping(path = "/user")
    public String getUser(
            @RequestParam(name = "firstName") String firstName,
            @RequestParam(name = "lastName", required = false) String lastName,
            @RequestParam(name = "age") int age) {
        return "Details :" + " " + firstName + " " + lastName + " Age: " + age;
    }

    @GetMapping(path = "/user/{ID}")
    public String getUsersByID(@PathVariable(value = "ID") String ID) {
        return "Selected User ID: " + ID;
    }

    @PostMapping(path = "/users")
    public String createUser(@RequestBody CreateUserDTO user) {
        return "User Created with userName " + " " + user.getUserName() + " " + user.getUserEmail();
    }

    @PostMapping(path = "/users/v2")
    public ResponseEntity<String> createUserV2(@RequestBody CreateUserDTO user) {
        String responseMessage = "User Created with userName " + " " + user.getUserName() + " " + user.getUserEmail();
        return ResponseEntity.status(HttpStatus.CREATED).body(responseMessage);
    }
}
