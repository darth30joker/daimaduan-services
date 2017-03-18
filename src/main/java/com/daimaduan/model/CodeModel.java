package com.daimaduan.model;

import org.hibernate.validator.constraints.NotEmpty;

public class CodeModel {
    private String title;

    private String syntax;

    @NotEmpty
    private String content;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSyntax() {
        return syntax;
    }

    public void setSyntax(String syntax) {
        this.syntax = syntax;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
