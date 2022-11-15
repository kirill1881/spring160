package com.example.spring160.repos;

import com.example.spring160.models.PurchaseRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseRepo extends JpaRepository<PurchaseRequest, Long> {
}
