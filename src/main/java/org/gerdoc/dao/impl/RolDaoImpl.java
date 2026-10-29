package org.gerdoc.dao.impl;

import org.gerdoc.dao.RolDao;
import org.gerdoc.model.Rol;
import org.gerdoc.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class RolDaoImpl implements RolDao
{
    private Session session;

    public RolDaoImpl( )
    {
        session = HibernateUtil
                .getSessionFactory( )
                .openSession( );
    }

    @Override
    public List<Rol> findAll()
    {
        CriteriaBuilder builder = session.getCriteriaBuilder();

        CriteriaQuery<Rol> criteria =
                builder.createQuery(Rol.class);
        criteria.from(Rol.class);
        return session
                .createQuery(criteria)
                .getResultList();
    }

    @Override
    public Rol findById(Long id)
    {
        return session.get( Rol.class, id );
    }

    @Override
    public Rol save(Rol rol)
    {
        Transaction transaction = null;
        try
        {
            transaction = session.beginTransaction();
            session.save( rol );
            transaction.commit( );
            return rol;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            transaction.rollback( );
            return null;
        }
    }

    @Override
    public void deleteById(Long id)
    {
        Transaction transaction = null;
        Rol rol = null;
        try
        {
            rol = findById( id );
            if( rol != null )
            {
                transaction = session.beginTransaction();
                session.delete( rol );
                transaction.commit( );
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            transaction.rollback( );
        }
    }

    @Override
    public Rol update(Rol rol)
    {
        Transaction transaction = null;
        Rol updatedRol = null;
        try
        {
            transaction = session.beginTransaction();
            updatedRol = (Rol) session.merge( rol );
            transaction.commit( );
            return updatedRol;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            transaction.rollback( );
            return null;
        }
    }
}
