package br.com.roberto.hrworker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.roberto.hrworker.entities.Worker;

public interface WorkerRepository extends JpaRepository<Worker, Long> {

}
