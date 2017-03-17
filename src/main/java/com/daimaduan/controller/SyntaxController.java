package com.daimaduan.controller;

import com.daimaduan.repository.SyntaxRepository;
import com.daimaduan.resource.SyntaxResource;
import com.daimaduan.resource.SyntaxResourceAssembler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

@RestController
@RequestMapping(path = "/api/v1/syntax")
public class SyntaxController {
    private final SyntaxRepository syntaxRepository;
    private final SyntaxResourceAssembler assembler = new SyntaxResourceAssembler();

    @Autowired
    public SyntaxController(SyntaxRepository syntaxRepository) {
        this.syntaxRepository = syntaxRepository;
    }

    @RequestMapping(path = "", method= RequestMethod.GET)
    public HttpEntity<Resources<SyntaxResource>> list() {
        Resources<SyntaxResource> wrapped = new Resources<>(assembler.toResources(syntaxRepository.findAll()),
                linkTo(SyntaxController.class).withSelfRel());

        return new ResponseEntity<>(wrapped, HttpStatus.OK);
    }

    @RequestMapping(path="/{key}", method= RequestMethod.GET)
    public HttpEntity<Resource<SyntaxResource>> get(@PathVariable String key) {
        Resource<SyntaxResource> wrapped = new Resource<>(assembler.toResource(syntaxRepository.findByKey(key)),
                linkTo(SyntaxController.class).withSelfRel());
        return new ResponseEntity<>(wrapped, HttpStatus.OK);
    }
}
