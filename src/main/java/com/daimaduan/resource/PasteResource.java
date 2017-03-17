package com.daimaduan.resource;

import com.daimaduan.domain.Code;
import org.springframework.hateoas.ResourceSupport;

import java.util.Collection;

public class PasteResource extends ResourceSupport {
    private String hashId;

    private String title;

    private Collection<Code> codes;

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

    public Collection<Code> getCodes() {
        return codes;
    }

    public void setCodes(Collection<Code> codes) {
        this.codes = codes;
    }
}
