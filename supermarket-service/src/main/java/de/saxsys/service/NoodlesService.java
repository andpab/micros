package de.saxsys.service;

import de.saxsys.model.NoodlesPackage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface NoodlesService extends JpaRepository<NoodlesPackage,Long> {

}
