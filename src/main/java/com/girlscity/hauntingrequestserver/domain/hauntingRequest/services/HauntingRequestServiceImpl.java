package com.girlscity.hauntingrequestserver.domain.hauntingRequest.services;

import com.girlscity.hauntingrequestserver.domain.core.exceptions.ResourceCreationException;
import com.girlscity.hauntingrequestserver.domain.core.exceptions.ResourceNotFoundException;
import com.girlscity.hauntingrequestserver.domain.hauntingRequest.models.HauntingRequest;
import com.girlscity.hauntingrequestserver.domain.hauntingRequest.repos.HauntingRequestRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HauntingRequestServiceImpl implements HauntingRequestService{
    private HauntingRequestRepo hauntingRequestRepo;

    @Autowired
    public HauntingRequestServiceImpl(HauntingRequestRepo hauntingRequestRepo){
        this.hauntingRequestRepo = hauntingRequestRepo;
    }

    @Override
    public HauntingRequest create(HauntingRequest hauntingRequest) throws ResourceCreationException {
        Optional<HauntingRequest> optional = hauntingRequestRepo.findByName(hauntingRequest.getName());
        if (optional.isPresent())
            throw new ResourceCreationException("Haunted Location with name exists: " + hauntingRequest.getName());
        hauntingRequest = hauntingRequestRepo.save(hauntingRequest);
        return hauntingRequest;
    }


    @Override
    public HauntingRequest getById(Long id) throws ResourceNotFoundException {
        HauntingRequest hauntingRequest = hauntingRequestRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No Location With the Id: " + id));
        return hauntingRequest;
    }

    @Override
    public HauntingRequest getByName(String name) throws ResourceNotFoundException {
        HauntingRequest hauntingRequest = hauntingRequestRepo.findByName(name)
                .orElseThrow(() -> new ResourceNotFoundException("No Location with That Name: " + name));
        return hauntingRequest;
    }

    @Override
    public List<HauntingRequest> getAll() {
        return hauntingRequestRepo.findAll();
    }

    @Override
    public HauntingRequest update(Long id, HauntingRequest hauntingRequestDetail) {
        HauntingRequest hauntingRequest = getById(id);
        hauntingRequest.setName(hauntingRequestDetail.getName());
        hauntingRequest.setAddress(hauntingRequestDetail.getAddress());
        return hauntingRequest;
    }

    @Override
    public void delete(Long id) {
        HauntingRequest hauntingRequest = getById(id);
        hauntingRequestRepo.delete(hauntingRequest);
    }
}
