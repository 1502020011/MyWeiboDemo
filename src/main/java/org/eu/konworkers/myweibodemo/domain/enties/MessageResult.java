package org.eu.konworkers.myweibodemo.domain.enties;

import org.eu.konworkers.myweibodemo.domain.pojo.Message;

import java.util.List;

public class MessageResult {
    private Long total;
    private List<Message> data;
    private Integer pages;

    public MessageResult() {
    }

    public MessageResult(Long total, List<Message> data, Integer pages) {
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

    public List<Message> getData() {
        return data;
    }

    public void setData(List<Message> data) {
        this.data = data;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }
}
