package com.daimaduan.domain;

import org.springframework.data.annotation.Id;

import java.util.List;

public class Paste {
    @Id
    private String id;

    private String hashId;

    private String title;

    private List<Code> codes;

    public Paste() {}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHashId() {
        return hashId;
    }

    public void setHashId(String hashId) {
        this.hashId = hashId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Code> getCodes() {
        return codes;
    }

    public void setCodes(List<Code> codes) {
        this.codes = codes;
    }
}
