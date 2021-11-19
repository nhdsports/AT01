package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class RegisterW3SUserModel {

    private String email;
    private String password;
    private String firstName;
    private String lastName;

}
