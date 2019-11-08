package com.mmelo.store.controller;

import com.mmelo.store.dto.BuyDTO;
import com.mmelo.store.dto.StoreDTO;
import com.mmelo.store.service.BuyService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping(BuyController.STORE_ENDPOINT)
public class BuyController {

    public static final String STORE_ENDPOINT = "/store";
    private final BuyService service;

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public BuyDTO save(@Valid @RequestBody final StoreDTO dto) {
        return service.save(dto);
    }
}
