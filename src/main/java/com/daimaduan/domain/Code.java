package com.daimaduan.domain;

import org.springframework.data.annotation.Id;

public class Code {
    @Id
    public String id;

    public String title;

    public Syntax syntax;
}
