package com.daimaduan.domain;

import org.springframework.data.annotation.Id;

import java.util.Collection;

public class Paste {
    @Id
    public String id;

    public Collection<Code> codes;
}
