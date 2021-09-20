package com.miu.springbootproject.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Size;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Login {
    @Size(min = 1)
    private String username;
    @Size(min = 1)
    private String password;
}
