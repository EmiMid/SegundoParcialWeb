package org.gerdoc.service.impl;

import org.gerdoc.dao.RolDao;
import org.gerdoc.dao.impl.RolDaoImpl;
import org.gerdoc.model.Rol;
import org.gerdoc.service.RolService;

import java.util.List;

public class RolServiceImpl implements RolService
{
    private RolDao rolDao;

    public RolServiceImpl( )
    {
        this.rolDao = new RolDaoImpl( );
    }

    @Override
    public List<Rol> findAll()
    {
        return rolDao.findAll( );
    }

    @Override
    public Rol findById(Long id)
    {
        return rolDao.findById( id );
    }

    @Override
    public void save(Rol rol)
    {
        rolDao.save( rol );
    }

    @Override
    public void deleteById(Long id)
    {
        rolDao.deleteById( id );
    }

    @Override
    public void update(Rol rol)
    {
        rolDao.update( rol );
    }
}
