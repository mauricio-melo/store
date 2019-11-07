package com.mmelo.store.integration;

import com.mmelo.store.dto.ProviderAddressDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@FeignClient("provider")
public interface ProviderClient {

    @GetMapping(path = "provider/info/{state}", produces = APPLICATION_JSON_VALUE)
    ResponseEntity<ProviderAddressDTO> getLocalization(@PathVariable("state") final String state);
}
