package org.eu.konworkers.myweibodemo.domain.enties;

import org.eu.konworkers.myweibodemo.domain.pojo.Message;
import org.eu.konworkers.myweibodemo.domain.pojo.User;

import java.util.List;

public class UserResult {
    private Long total;
    private List<User> data;
    private Integer pages;

    public UserResult() {
    }

    public UserResult(Long total, List<User> data, Integer pages) {
        this.total = total;
        this.data = data;
        this.pages = pages;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<User> getData() {
        return data;
    }

    public void setData(List<User> data) {
        this.data = data;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }
}
