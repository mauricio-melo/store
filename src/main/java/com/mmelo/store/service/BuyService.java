package com.mmelo.store.service;

import com.mmelo.store.dto.BuyDTO;
import com.mmelo.store.dto.DemandDTO;
import com.mmelo.store.dto.StoreDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BuyService {

    private final ProviderService providerService;

    public BuyDTO save(final StoreDTO dto) {
        final DemandDTO demandDTO = providerService.doDemand(dto.getItens());
        return BuyDTO.builder()
                .demandId(demandDTO.getId())
                .itens(demandDTO.getItens())
                .address(providerService.getAddress(dto.getAddress().getState()).getAddress())
                .build();
    }
}
