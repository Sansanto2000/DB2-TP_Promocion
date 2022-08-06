package com.mitocode.repo.postgre;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mitocode.model.postgre.Admin;

public interface IAdminRepo extends JpaRepository<Admin, Integer>{

}
