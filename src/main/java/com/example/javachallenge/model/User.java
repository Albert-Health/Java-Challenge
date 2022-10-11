package com.example.javachallenge.model;

import com.example.javachallenge.entity.UserEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class User {
    private Long Id;
    private String username;
    private String email;

    public static User toModel(UserEntity userEntity){
        User user = new User();
        user.setId(userEntity.getId());
        user.setUsername(userEntity.getUsername());
        user.setEmail(userEntity.getEmail());
        return user;
    }

}
