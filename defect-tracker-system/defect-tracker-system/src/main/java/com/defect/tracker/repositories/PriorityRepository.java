package com.defect.tracker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.defect.tracker.entities.Priority;

public interface PriorityRepository extends JpaRepository<Priority, Long> {
}
