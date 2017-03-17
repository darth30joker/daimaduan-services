package com.daimaduan.resource;

import org.springframework.hateoas.ResourceSupport;

import java.util.Collection;

public class SyntaxListResource extends ResourceSupport {
    private Collection<SyntaxResource> resources;

    public SyntaxListResource(Collection<SyntaxResource> resources) {
        this.resources = resources;
    }

    public Collection<SyntaxResource> getResources() {
        return resources;
    }
}
