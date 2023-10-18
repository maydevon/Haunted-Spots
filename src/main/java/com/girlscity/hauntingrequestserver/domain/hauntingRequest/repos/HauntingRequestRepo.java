package com.girlscity.hauntingrequestserver.domain.hauntingRequest.repos;

import com.girlscity.hauntingrequestserver.domain.hauntingRequest.models.HauntingRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HauntingRequestRepo extends JpaRepository<HauntingRequest, Long> {
    Optional<HauntingRequest> findByName(String name);
}
