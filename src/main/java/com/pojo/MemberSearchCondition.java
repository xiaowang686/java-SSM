package com.pojo;

import lombok.Data;

@Data
public class MemberSearchCondition {

    private String gender;
    private Integer minAge;
    private Integer maxAge;
    private String city;

}
