package com.mingri.vo;

import lombok.Data;
import java.util.Date;

@Data
public class UserOperatedVO {
    private String id;
    private String userId;
    private String avatar;
    private String name;
    private String nickName;
    private String email;
    private String type;
    private String address;
    private Date createTime;
}
