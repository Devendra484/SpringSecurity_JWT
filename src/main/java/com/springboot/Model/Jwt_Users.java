package com.springboot.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;


@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Jwt_Users {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user"

    )
    @SequenceGenerator(
            name = "user",
            sequenceName = "users_sequence",
            initialValue = 1,
            allocationSize = 1
    )
    private  Long id;
    @NotBlank(message = "Name is required")
    @Size(min = 3, max = 20, message = "Name must be between 3 to 20 characters")
    @Pattern(regexp = "^[a-zA-Z ]+$", message = "Name can only contain letters ")
    private  String name;
    @NotBlank(message = "Password is required")
    @Size(min = 8, message = "Password must be 8 characters")
   // @Pattern(regexp = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$)", message = "Password must be combination of Upper Case ,Lower Case, Numbers and Special characters")
    private  String  password;
}
