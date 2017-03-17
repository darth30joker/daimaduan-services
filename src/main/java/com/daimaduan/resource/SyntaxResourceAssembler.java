package com.daimaduan.resource;

import com.daimaduan.controller.SyntaxController;
import com.daimaduan.domain.Syntax;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

public class SyntaxResourceAssembler extends ResourceAssemblerSupport<Syntax, SyntaxResource> {
    public SyntaxResourceAssembler() {
        super(SyntaxController.class, SyntaxResource.class);
    }

    @Override
    public SyntaxResource toResource(Syntax entity) {
        SyntaxResource syntaxResource = new SyntaxResource();
        syntaxResource.setKey(entity.key);
        syntaxResource.setName(entity.name);
        syntaxResource.add(linkTo(methodOn(SyntaxController.class).get(entity.key)).withSelfRel());
        return syntaxResource;
    }
}
