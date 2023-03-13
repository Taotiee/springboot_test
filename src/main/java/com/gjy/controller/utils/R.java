package com.gjy.controller.utils;

import com.gjy.domain.Book;
import lombok.Data;

@Data
public class R {
    private Boolean flag;
    private Object data;
    private String msg;
    public R(){}
    public R(boolean flag){
        this.flag=flag;
    }
    public R(boolean flag,Object data){
        this.flag=flag;
        this.data=data;
    }
    public R(boolean flag,String msg){
        this.flag=flag;
        this.msg=msg;
    }
    public R(String msg){
        this.flag=false;
        this.msg=msg;
    }
}
