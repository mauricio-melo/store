package com.mmelo.store.service;

import com.mmelo.store.dto.AddressDTO;
import com.mmelo.store.dto.StoreDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StoreService {

    private final ProviderService providerService;

    public StoreDTO save(final StoreDTO dto) {
        return StoreDTO.builder()
                .address(AddressDTO.builder()
                        .address(this.providerService.getAddress(dto.getAddress().getState()).getAddress())
                        .build())
                .build();
    }
}
