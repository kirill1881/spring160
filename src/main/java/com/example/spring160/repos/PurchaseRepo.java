package com.example.spring160.repos;

import com.example.spring160.models.PurchaseRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PurchaseRepo extends JpaRepository<PurchaseRequest, Long> {
    PurchaseRequest findById(long id);
    List<PurchaseRequest> findAllByIfWorked(Boolean ifWorked);
}
