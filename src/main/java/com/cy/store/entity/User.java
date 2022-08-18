package com.cy.store.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 用户实体类
 */


@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User extends BaseEntity  {

  private Integer uid;;
  private String  username;
  private String  password;
  private String  salt;
  private String  phone;
  private String  email;
  private Integer gender;
  private String  avatar;
  private Integer isDelete;

}
