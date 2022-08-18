package com.cy.store.util;

import com.cy.store.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class JsonResultVO<E> implements Serializable {

    //状态码
    private Integer state;

    //描述信息
    private String message;
    private E data;

    public JsonResultVO(Integer state){
        this.state=state;
    }

    //异常的捕获
    public JsonResultVO(Throwable e){
        this.message=e.getMessage();
    }

    public JsonResultVO(Integer state, E data){
        this.state=state;
        this.data=data;
    }

}
