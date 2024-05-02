package com.sneakerTag.sneakerservice.controller;

import com.sneakerTag.sneakerservice.dto.SneakerRequest;
import com.sneakerTag.sneakerservice.dto.SneakerResponse;
import com.sneakerTag.sneakerservice.service.SneakerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sneaker")
@RequiredArgsConstructor
public class SneakerController {
    private final SneakerService sneakerService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createSneaker(@RequestBody SneakerRequest sneakerRequest){
        sneakerService.createSneaker(sneakerRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<SneakerResponse> getAllSneakers(){
        return sneakerService.getAllSneakers();
    }
}
