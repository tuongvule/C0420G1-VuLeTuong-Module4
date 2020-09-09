package com.example.blogupgrade.model;

import javax.validation.constraints.NotBlank;

public class SearchCriteria {
    @NotBlank(message = "nameBlog can't empty!")
    String nameBlog;

    public String getNameBlog() {
        return nameBlog;
    }

    public void setNameBlog(String nameBlog) {
        this.nameBlog = nameBlog;
    }
}
