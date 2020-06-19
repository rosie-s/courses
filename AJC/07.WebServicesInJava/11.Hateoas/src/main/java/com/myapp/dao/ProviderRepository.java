package com.myapp.dao;

import com.myapp.model.Provider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//@Repository
@RepositoryRestResource(path="providers")
public interface ProviderRepository extends JpaRepository<Provider, Long> {
}