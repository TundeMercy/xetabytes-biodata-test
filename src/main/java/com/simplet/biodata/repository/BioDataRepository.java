package com.simplet.biodata.repository;

import com.simplet.biodata.model.Biodata;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BioDataRepository extends JpaRepository<Biodata, Long> {
}
