package com.mmelo.store.controller;

import com.mmelo.store.dto.StoreDTO;
import com.mmelo.store.service.StoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping(StoreController.STORE_ENDPOINT)
public class StoreController {

    public static final String STORE_ENDPOINT = "/store";
    private final StoreService service;

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity save(@Valid @RequestBody final StoreDTO dto) {
        final StoreDTO entity = service.save(dto);
        final URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(entity.getId())
                .toUri();
        return ResponseEntity.created(uri).build();
    }
}
