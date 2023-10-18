package com.girlscity.hauntingrequestserver.domain.hauntingRequest.services;

import com.girlscity.hauntingrequestserver.domain.core.exceptions.ResourceCreationException;
import com.girlscity.hauntingrequestserver.domain.core.exceptions.ResourceNotFoundException;
import com.girlscity.hauntingrequestserver.domain.hauntingRequest.models.HauntingRequest;
import org.springframework.stereotype.Service;

import java.util.List;


public interface HauntingRequestService {
    HauntingRequest create(HauntingRequest hauntingRequest) throws ResourceCreationException;

    HauntingRequest getById(Long id) throws ResourceNotFoundException;

    HauntingRequest getByName(String name) throws ResourceNotFoundException;

    List<HauntingRequest> getAll();

    HauntingRequest update(Long id, HauntingRequest hauntingRequestDetail);

    void delete(Long id);
}
