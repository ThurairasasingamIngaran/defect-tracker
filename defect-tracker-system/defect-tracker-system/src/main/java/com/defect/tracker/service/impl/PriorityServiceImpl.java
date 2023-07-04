package com.defect.tracker.service.impl;

import javax.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.defect.tracker.entities.Priority;
import com.defect.tracker.repositories.PriorityRepository;
import com.defect.tracker.resquest.dto.PriorityRequest;
import com.defect.tracker.service.PriorityService;

@Service
public class PriorityServiceImpl implements PriorityService{
  @Autowired
  private PriorityRepository priorityRepository;

  @Transactional
  public void savePriority(PriorityRequest priorityRequest) {
  Priority priority =new Priority();
  BeanUtils.copyProperties(priorityRequest, priority);
  priorityRepository.save(priority);
  }

}
