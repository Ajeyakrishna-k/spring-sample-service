package com.example.demo.entity.dto;

import com.example.demo.constant.PatternConstants;
import com.example.demo.entity.dao.UserEntity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public record UserDTO(@NotBlank(message = "User Name is required.")
                      @Size(min = 2, max = 100, message = "The length of full name must be between 2 and 100 characters.")
                      String userName,
                      @NotBlank(message = "Phone number is required.")
                      @Pattern(regexp = PatternConstants.PHONE_NUMBER, message = "The phone number is invalid.")
                      String userPhone
        ) {


    public UserDTO(UserEntity userEntity){
        this(userEntity.getName(), userEntity.getPhone_number()
        );
    }

    public UserEntity convertToEntity(){
        UserEntity userEntity = new UserEntity();
        userEntity.setName(this.userName);
        userEntity.setPhone_number(this.userPhone);
        return userEntity;
    }
}
