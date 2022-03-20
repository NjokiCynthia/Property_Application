package com.example.demo.controller;

import com.example.demo.model.Tenants;
import com.example.demo.repository.TenantRepository;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping(value = "/property_db/tenants")
@RestController
@CrossOrigin

public class TenantController {

    @Autowired
    TenantRepository tenantRepository;

    @GetMapping("/all")
    public List<Tenants> getAllTenants() {
        return tenantRepository.findAll();
    }

    @GetMapping("/all/{tenant_id}")
    public ResponseEntity<Tenants> getTenant_id(@PathVariable(value = "tenant_id") int tenant_id)
            throws ResourceNotFoundException {
        Tenants tenants = tenantRepository.findById(tenant_id)
                .orElseThrow(() -> new ResourceNotFoundException("Tenant not found for this id :: " + tenant_id));
        return ResponseEntity.ok().body(tenants);
    }

    @PostMapping("/all")
    public Tenants createTenants(@Valid @RequestBody Tenants tenants) {
        return tenantRepository.save(tenants);
    }

    @PutMapping("/all/{tenant_id}")
    public ResponseEntity<Tenants> updateTenants(@PathVariable(value = "tenant_id") int tenant_id,
                                                   @Valid @RequestBody Tenants tenantDetails) throws ResourceNotFoundException {
        Tenants tenants = tenantRepository.findById(tenant_id)
                .orElseThrow(() -> new ResourceNotFoundException("Tenant not found for this id :: " + tenant_id));

        tenants.setTenant_fname(tenantDetails.getTenant_fname());
        tenants.setTenant_lname(tenantDetails.getTenant_lname());
        tenants.setTenant_desc(tenantDetails.getTenant_desc());
        tenants.setTenant_county(tenantDetails.getTenant_county());
        final Tenants updatedTenants = tenantRepository.save(tenants);
        return ResponseEntity.ok(updatedTenants);
    }

    @DeleteMapping("/all/{tenant_id}")
    public Map<String, Boolean> deleteTenant(@PathVariable(value = "tenant_id") int tenant_id)
            throws ResourceNotFoundException {
        Tenants tenants = tenantRepository.findById(tenant_id)
                .orElseThrow(() -> new ResourceNotFoundException("Tenant not found for this id :: " + tenant_id));

        tenantRepository.delete(tenants);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}