package com.goutampersonal.springboot.Controller;

import com.goutampersonal.springboot.Helpers.Binders.LowerCaseStringTransformation;
import org.springframework.validation.DataBinder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api")
public class TestController {

    @InitBinder
    protected  void initBinder(DataBinder binder) {
        binder.registerCustomEditor(String.class,"firstName",new LowerCaseStringTransformation());
    }

    @GetMapping(path = "/users")
    public String getUserDetails() {
        return "This is a dummy User";
    }
    @GetMapping(path = "/user")
    public String getUser(
            @RequestParam(name="firstName")String firstName,
            @RequestParam(name = "lastName",required = false)String lastName,
            @RequestParam(name="age")int age) {
        return "Details :"+ " " +firstName + " " + lastName + " Age: " + age;
    }

    @GetMapping(path="/user/{ID}")
    public String getUsersByID(@PathVariable (value="ID") String ID) {
        return "Selected User ID: " + ID;
    }
}
