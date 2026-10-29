package org.gerdoc.dao;

import org.gerdoc.model.Rol;

import java.util.List;

public interface RolDao
{
    List<Rol> findAll( );
    Rol findById(Long id);
    Rol save(Rol rol);
    void deleteById(Long id);
    Rol update(Rol rol);
}
