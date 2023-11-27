package com.ficticiusclean.repository;

import com.ficticiusclean.entity.VehicleInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<VehicleInfo, Long> {
}
