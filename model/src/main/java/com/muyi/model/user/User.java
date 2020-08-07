package com.muyi.model.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

@ApiModel(description = "Class representing a user")
public class User {

    private Integer userId;

    @ApiModelProperty(example = "John", position = 1)
    @NotBlank(message = "Firstname cannot be blank")
    private String firstName;

    @ApiModelProperty(example = "Doe", position = 2)
    @NotBlank(message = "Lastname cannot be blank")
    private String lastName;

    @ApiModelProperty(example = "20", position = 3)
    @Max(value = 200, message = "Age cannot be more than 200")
    @Positive(message = "Age cannot be negative")
    private Integer age;

    @ApiModelProperty(example = "female", position = 4)
    @NotBlank(message = "Sex cannot be blank")
    private String sex;

    public User() {
    }

    public User(Integer userId, String firstName, String lastName, Integer age, String sex) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.sex = sex;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
