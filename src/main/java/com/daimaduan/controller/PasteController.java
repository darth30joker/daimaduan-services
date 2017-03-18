package com.daimaduan.controller;


import com.daimaduan.domain.Paste;
import com.daimaduan.model.PasteModel;
import com.daimaduan.repository.PasteRepository;
import com.daimaduan.resource.PasteResource;
import com.daimaduan.resource.PasteResourceAssembler;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

@RestController
@RequestMapping(path = "/api/v1/pastes")
public class PasteController {
    private final PasteRepository pasteRepository;

    private final PasteResourceAssembler assembler = new PasteResourceAssembler();

    @Autowired
    public PasteController(PasteRepository pasteRepository) {
        this.pasteRepository = pasteRepository;
    }

    @RequestMapping(path = "", method= RequestMethod.GET)
    public HttpEntity<Resources<PasteResource>> list() {
        Resources<PasteResource> wrapped = new Resources<>(assembler.toResources(pasteRepository.findAll()));
        return new ResponseEntity<>(wrapped, HttpStatus.OK);
    }

    @RequestMapping(path = "", method = RequestMethod.PUT)
    public HttpEntity<Resource<PasteResource>> create(@RequestBody PasteModel pasteModel) {
        ModelMapper modelMapper = new ModelMapper();
        Paste paste = pasteRepository.save(modelMapper.map(pasteModel, Paste.class));

        Resource<PasteResource> wrapped = new Resource<>(assembler.toResource(pasteRepository.findByHashId(paste.getHashId())),
                linkTo(PasteController.class).withSelfRel());
        return new ResponseEntity<>(wrapped, HttpStatus.OK);
    }

    @RequestMapping(path = "/{hashId}", method= RequestMethod.GET)
    public HttpEntity<Resource<PasteResource>> get(@PathVariable String hashId) {
        Resource<PasteResource> wrapped = new Resource<>(assembler.toResource(pasteRepository.findByHashId(hashId)),
                linkTo(PasteController.class).withSelfRel());
        return new ResponseEntity<>(wrapped, HttpStatus.OK);
    }
}
