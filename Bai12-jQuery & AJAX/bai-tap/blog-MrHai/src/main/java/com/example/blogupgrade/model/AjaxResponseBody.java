package com.example.blogupgrade.model;

import java.util.List;

public class AjaxResponseBody {
    String msg;
    List<Blog> result;

    public AjaxResponseBody() {
    }

    public AjaxResponseBody(String msg, List<Blog> result) {
        this.msg = msg;
        this.result = result;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<Blog> getResult() {
        return result;
    }

    public void setResult(List<Blog> result) {
        this.result = result;
    }
}
