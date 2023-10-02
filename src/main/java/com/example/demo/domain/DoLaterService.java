package com.example.demo.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class DoLaterService {

    private final DoLaterRepo doLaterRepo;

    public List<DoLaterGetDTO> getAllDoLaters() {
        List<DoLaterEntity> doLaters = doLaterRepo.findAll();

        List<DoLaterGetDTO> dto = doLaters.stream()
                .map(doLater -> new DoLaterGetDTO(doLater))
                .toList();

        return dto;
    }

    public DoLaterGetDTO fetchDoLater(Long id) {

        DoLaterEntity doLater = doLaterRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Do Later not found"));

        return new DoLaterGetDTO(doLater);
    }

    public DoLaterGetDTO createDoLater(DoLaterPostDTO dto) {

        DoLaterEntity doLater = new DoLaterEntity();

        doLater.setName(dto.getName());

        doLater = doLaterRepo.save(doLater);

        return new DoLaterGetDTO(doLater);
    }

    public DoLaterGetDTO updateDoLater(Long id, DoLaterPostDTO dto) {

        DoLaterEntity doLater = doLaterRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Do Later not found"));

        doLater.setName(dto.getName());

        doLater = doLaterRepo.save(doLater);

        return new DoLaterGetDTO(doLater);
    }

    public void deleteDoLater(Long id) {

        doLaterRepo.deleteById(id);
    }
}
