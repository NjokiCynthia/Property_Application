package com.example.demo.repository;

import com.example.demo.model.Tenants;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TenantRepository extends JpaRepository<Tenants, Integer> {
}
