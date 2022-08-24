package com.elotech.registrationprocesses.entities.repositories;

import com.elotech.registrationprocesses.entities.Processo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProcessoRepository extends JpaRepository<Processo, Long> {
}
