package com.daimaduan.resource;

import com.daimaduan.controller.PasteController;
import com.daimaduan.domain.Paste;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

public class PasteResourceAssembler extends ResourceAssemblerSupport<Paste, PasteResource> {
    public PasteResourceAssembler() {
        super(PasteController.class, PasteResource.class);
    }

    @Override
    public PasteResource toResource(Paste entity) {
        PasteResource pasteResource = new PasteResource();
        pasteResource.setHashId(entity.hashId);
        pasteResource.setTitle(entity.title);
        pasteResource.setCodes(entity.codes);
        pasteResource.add(linkTo(methodOn(PasteController.class).get(entity.hashId)).withSelfRel());
        return pasteResource;
    }
}
