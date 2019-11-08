package com.mmelo.store.service;

import com.mmelo.store.dto.DemandDTO;
import com.mmelo.store.dto.ItemDTO;
import com.mmelo.store.dto.ProviderAddressDTO;
import com.mmelo.store.integration.ProviderClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProviderService {
    private final ProviderClient client;

    public ProviderAddressDTO getAddress(final String state) {
        return client.getLocalization(state).getBody();
    }

    public DemandDTO doDemand(final List<ItemDTO> itens) {
        return client.doDemand(itens);
    }
}
