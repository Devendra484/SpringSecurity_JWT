package com.springboot.Controller;

import com.springboot.Model.Jwt_Users;
import com.springboot.Service.JwtService;
import com.springboot.Service.Jwt_UsersService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/home")
public class Jwt_UsersController {

    @Autowired
    private Jwt_UsersService jwtUsersService;
    @Autowired
    private JwtService jwtService;
    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/reg")
    public ResponseEntity<Object> save(@Valid @RequestBody Jwt_Users user, BindingResult result){
       if(result.hasErrors()){
         //   Map<String, Object> errors = new HashMap<>();
           // for (FieldError error : result.getFieldErrors()) {
            //    errors.put("DefaultMessage", error.getDefaultMessage());
            //    errors.put("ObjectName",error.getObjectName());
               // errors.put("field",error.getField());
               // errors.put("rejectedValue",error.getRejectedValue());
              //  errors.put("code",error.getCode());

            //}
           // return ResponseEntity.badRequest().body(errors);
           // return new ResponseEntity<>(errors,HttpStatus.BAD_REQUEST);

           List<FieldError> errors = result.getFieldErrors()
                   .stream()
                   .filter(error -> error.getField().equals("name") || error.getField().equals("password"))
                   .collect(Collectors.toList());
           if (!errors.isEmpty()) {
               FieldError error = errors.get(0);
               ErrorResponse errorResponse = new ErrorResponse(error.getDefaultMessage(), error.getObjectName(), error.getField(), error.getRejectedValue().toString(), error.getCode());
               return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
           }

        }


        return new ResponseEntity<>(jwtUsersService.reg(user),HttpStatus.OK);
    }

    @GetMapping("/list")
    public List<Jwt_Users> list(){
        return  jwtUsersService.list();
    }
    @GetMapping("/list/{id}")
    public ResponseEntity<Object> userById(@PathVariable Long id){
        try {
            Jwt_Users users=jwtUsersService.userById(id);
            return new ResponseEntity<>(users, HttpStatus.OK);
        }catch (ResponseStatusException ex){
            ErrorResponseBody errorResponseBody= new ErrorResponseBody( ex.getStatusCode().value(),ex.getStatusCode(), ex.getReason(),"/mobiles/"+id);

            return new ResponseEntity<>(errorResponseBody,HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/authenticate")
    public String login( @RequestBody Jwt_Users user) throws Exception {
        Authentication authentication=authenticationManager.
                authenticate(new UsernamePasswordAuthenticationToken(user.getName(),user.getPassword()));
        if (authentication.isAuthenticated()){
            System.out.println(jwtService.generateToken(user.getName()));
            return  jwtService.generateToken(user.getName());

        }
        else {
            throw new UsernameNotFoundException("invalid user request !");
        }
    }

}
