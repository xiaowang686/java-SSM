package com.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Member {

    private Integer memberId;
    private String memberNick;
    private String memberGender;
    private Integer memberAge;
    private String memberCity;

}
