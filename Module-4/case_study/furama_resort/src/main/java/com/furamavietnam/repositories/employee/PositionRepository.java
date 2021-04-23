package com.furamavietnam.repositories.employee;

import com.furamavietnam.models.Position;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PositionRepository extends JpaRepository<Position, Integer> {
}
