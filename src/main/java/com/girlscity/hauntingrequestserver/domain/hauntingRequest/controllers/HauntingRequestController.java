package com.girlscity.hauntingrequestserver.domain.hauntingRequest.controllers;

import com.girlscity.hauntingrequestserver.domain.hauntingRequest.models.HauntingRequest;
import com.girlscity.hauntingrequestserver.domain.hauntingRequest.services.HauntingRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping ("api/v1/hauntingrequest")
public class HauntingRequestController {

    private HauntingRequestService hauntingRequestService;
    @Autowired
    public HauntingRequestController(HauntingRequestService hauntingRequestService) {
        this.hauntingRequestService = hauntingRequestService;
    }

    @GetMapping
    public ResponseEntity<List<HauntingRequest>> getAll(){
        List<HauntingRequest> hauntingRequests = hauntingRequestService.getAll();
        return new ResponseEntity<>(hauntingRequests, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<HauntingRequest> create(@RequestBody HauntingRequest hauntingRequest) {
        hauntingRequest = hauntingRequestService.create(hauntingRequest);
        return new ResponseEntity<>(hauntingRequest, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<HauntingRequest> getById(@PathVariable("id")Long id) {
        HauntingRequest hauntingRequest = hauntingRequestService.getById(id);
        return new ResponseEntity<>(hauntingRequest, HttpStatus.CREATED);
    }

    @GetMapping("lookup")
    public ResponseEntity<HauntingRequest> getByName(@RequestParam String name){
        HauntingRequest hauntingRequest = hauntingRequestService.getByName(name);
        return new ResponseEntity<>(hauntingRequest, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<HauntingRequest> update(@PathVariable("id") Long id, @RequestBody HauntingRequest hauntingRequestDetail) {
        hauntingRequestDetail = hauntingRequestService.update(id, hauntingRequestDetail);
        return new ResponseEntity<>(hauntingRequestDetail, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable("id") Long id){
        hauntingRequestService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
