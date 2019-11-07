package com.mmelo.store.service;

import com.mmelo.store.dto.ProviderAddressDTO;
import com.mmelo.store.integration.ProviderClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProviderService {
    private final ProviderClient client;

    public ProviderAddressDTO getAddress(final String state) {
        return this.client.getLocalization(state).getBody();
    }
}
