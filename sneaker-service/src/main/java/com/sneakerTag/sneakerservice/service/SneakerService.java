package com.sneakerTag.sneakerservice.service;

import com.sneakerTag.sneakerservice.dto.SneakerRequest;
import com.sneakerTag.sneakerservice.dto.SneakerResponse;
import com.sneakerTag.sneakerservice.model.Sneaker;
import com.sneakerTag.sneakerservice.repository.SneakerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.Response;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class SneakerService {

    private final SneakerRepository sneakerRepository;

    public void createSneaker(SneakerRequest sneakerRequest) {
        Sneaker sneaker = Sneaker.builder()
                .name(sneakerRequest.getName())
                .description(sneakerRequest.getDescription())
                .price(sneakerRequest.getPrice())
                .build();

        sneakerRepository.save(sneaker);
        log.info("Sneaker {} is saved", sneaker.getId());
    }

    public List<SneakerResponse> getAllSneakers() {
        List<Sneaker> sneakers = sneakerRepository.findAll();
        return sneakers.stream().map(this::mapToProductResponse).toList();
    }

    private SneakerResponse mapToProductResponse(Sneaker sneaker) {
        return SneakerResponse.builder()
                .id(sneaker.getId())
                .name(sneaker.getName())
                .description(sneaker.getDescription())
                .price(sneaker.getPrice())
                .build();
    }
}
