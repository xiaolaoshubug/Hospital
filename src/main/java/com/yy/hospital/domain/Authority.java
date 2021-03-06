package com.yy.hospital.domain;

import java.io.Serializable;

public class Authority implements Serializable{

    private Integer id;
    private AuthorityName name;  //角色名是必须限定好的枚举

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public AuthorityName getName() {
        return name;
    }

    public void setName(AuthorityName name) {
        this.name = name;
    }
}
