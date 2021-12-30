package com.line.mall.data.repository;

import com.line.mall.data.model.LineAdmin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LineAdminRepository extends JpaRepository<LineAdmin, Long> {
    LineAdmin findLineAdminById(Long id);
}
