package com.example.demo.domain;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@Slf4j
@RequestMapping(path = "/api/v1/apps",  produces = {MediaType.APPLICATION_JSON_VALUE})
public class DoLaterController {

    private final DoLaterService doLaterService;

    @Operation(summary = "List all Do Laters")
    @GetMapping
    public ResponseEntity<List<DoLaterGetDTO>> getDoLaters(
    ) {
        log.info("Get all Do Laters");

        List<DoLaterGetDTO> response = doLaterService.getAllDoLaters();

        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Fetch Do Later")
    @GetMapping("/{id}")
    public ResponseEntity<DoLaterGetDTO> getDoLater(
            @Parameter(description = "Id of Do Later", required = true) @PathVariable("id") Long id
    ) {
        log.info("Get Do Later {}", id);

        DoLaterGetDTO response = doLaterService.fetchDoLater(id);

        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Create Do Later")
    @PostMapping
    public ResponseEntity<DoLaterGetDTO> createDoLaters(
            @Parameter(description = "Details of the Do Later to be created", required = true) @RequestBody DoLaterPostDTO dto
    ) {
        log.info("Create Do Later");

        DoLaterGetDTO response = doLaterService.createDoLater(dto);

        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Update Do Later")
    @PutMapping("/{id}")
    public ResponseEntity<DoLaterGetDTO> updateDoLaters(
            @Parameter(description = "Id of Do Later", required = true) @PathVariable("id") Long id,
            @Parameter(description = "Details of the Do Later to be updated", required = true) @RequestBody DoLaterPostDTO dto
    ) {
        log.info("Update Do Later {}", id);

        DoLaterGetDTO response = doLaterService.updateDoLater(id, dto);

        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Delete Do Later")
    @DeleteMapping
    public ResponseEntity<Void> deleteDoLater(
            @Parameter(description = "Id of Do Later", required = true) @PathVariable("id") Long id
    ) {
        log.info("Delete Do Later {}", id);

        doLaterService.deleteDoLater(id);

        return ResponseEntity.ok().build();
    }
}
