package com.lgx.java.stream;

import lombok.Data;

@Data
public class UserPojo {
    private long id;
    private String name;
    private String age;

    public UserEntity convertTo() {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(this.id);
        userEntity.setName(this.name);
        userEntity.setAge(this.age);
        return userEntity;
    }
}
