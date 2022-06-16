package com.parameta.prueba.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.parameta.prueba.model.Persona;

public interface PersonaDAO extends JpaRepository<Persona, Integer>{

}
