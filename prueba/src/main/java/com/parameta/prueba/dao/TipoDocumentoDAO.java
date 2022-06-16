package com.parameta.prueba.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.parameta.prueba.model.TipoDocumento;

public interface TipoDocumentoDAO extends JpaRepository<TipoDocumento, Integer>{

}
