package org.gerdoc.service;

import org.gerdoc.model.Rol;

import java.util.List;

public interface RolService
{
    List<Rol> findAll( );
    Rol findById( Long id );
    void save( Rol rol );
    void deleteById( Long id );
    void update( Rol rol );
}
