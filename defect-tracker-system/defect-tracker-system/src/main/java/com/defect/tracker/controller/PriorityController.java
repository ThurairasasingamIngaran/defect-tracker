package com.defect.tracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.defect.tracker.resquest.dto.PriorityRequest;
import com.defect.tracker.service.PriorityService;
import com.defect.tracker.utils.EndpointURI;

@RestController
@CrossOrigin
public class PriorityController {
  @Autowired
  private PriorityService priorityService;

  @PostMapping(value = EndpointURI.PRIORITY)
  public ResponseEntity<Object> savePriority(@RequestBody PriorityRequest priorityRequest) {
    priorityService.savePriority(priorityRequest);
    return ResponseEntity.ok("Successfully added");
  }

}


