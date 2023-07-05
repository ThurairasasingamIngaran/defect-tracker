package com.defect.tracker.service;

import com.defect.tracker.resquest.dto.PriorityRequest;

public interface PriorityService {
  public void savePriority(PriorityRequest priorityRequest);
  
  public boolean isPriorityNameExists(String name);
  
}
