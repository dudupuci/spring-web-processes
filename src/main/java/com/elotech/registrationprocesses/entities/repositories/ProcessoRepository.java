package com.elotech.registrationprocesses.entities.repositories;

import com.elotech.registrationprocesses.entities.Processo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
// extends PagingAndSort é opcional, pois o JpaRepository também implementa tal interface
public interface ProcessoRepository extends JpaRepository<Processo, Long> {
}
