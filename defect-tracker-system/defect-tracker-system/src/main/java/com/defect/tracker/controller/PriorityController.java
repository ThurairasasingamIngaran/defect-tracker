package com.defect.tracker.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.defect.tracker.common.response.BaseResponse;
import com.defect.tracker.resquest.dto.PriorityRequest;
import com.defect.tracker.rest.enums.RequestStatus;
import com.defect.tracker.service.PriorityService;
import com.defect.tracker.utils.EndpointURI;
import com.defect.tracker.utils.ValidationFailureResponseCode;

@RestController
@CrossOrigin
public class PriorityController {
  @Autowired
  private PriorityService priorityService;
  @Autowired
  private ValidationFailureResponseCode validationFailureResponseCode;
  
  private static final Logger logger = LoggerFactory.getLogger(PriorityController.class);


  @PostMapping(value = EndpointURI.PRIORITY)
  public ResponseEntity<Object> savePriority(@RequestBody PriorityRequest priorityRequest) {
    if(priorityService.isPriorityNameExists(priorityRequest.getName()))
    {
      logger.info("Priority already exits");
      return ResponseEntity.ok(new BaseResponse(RequestStatus.FAILURE.getStatus(),
          validationFailureResponseCode.getPriorityAlreadyExists(),
          validationFailureResponseCode.getValidationPriorityAlreadyExists()));
    }
    logger.info("Priority added successfull");
    priorityService.savePriority(priorityRequest);
    return ResponseEntity.ok("Successfully added");
  }
}


