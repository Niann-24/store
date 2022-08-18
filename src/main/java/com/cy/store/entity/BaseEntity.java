package com.cy.store.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * 实体类的基类
 * @author 年年
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class BaseEntity implements Serializable {
      private String  createdUser;
      private Date    createdTime;
      private String  modifiedUser;
      private Date  modifiedTime;
}
