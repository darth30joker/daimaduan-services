package com.daimaduan.resource;

import org.springframework.hateoas.ResourceSupport;

public class SyntaxResource extends ResourceSupport {
    private String key;

    private String name;

    public void setKey(String key) {
        this.key = key;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKey() {
        return key;
    }

    public String getName() {
        return name;
    }
}
