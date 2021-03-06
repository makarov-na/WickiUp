package com.linnyk.jpa.pluralsight.rest;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriBuilder;

import com.linnyk.jpa.pluralsight.model.Publisher;

/**
 * @author Antonio Goncalves
 *         http://www.antoniogoncalves.org
 *         --
 */
@Stateless
@Path("/publishers")
public class PublisherEndpoint {

  // ======================================
  // =             Attributes             =
  // ======================================

  @PersistenceContext(unitName = "module07PU")
  private EntityManager em;

  // ======================================
  // =           Public Methods           =
  // ======================================

  @POST
  @Consumes("application/xml")
  public Response create(Publisher entity) {
    em.persist(entity);
    return Response.created(UriBuilder.fromResource(PublisherEndpoint.class).path(String.valueOf(entity.getId())).build()).build();
  }

  @DELETE
  @Path("/{id:[0-9][0-9]*}")
  public Response deleteById(@PathParam("id") Long id) {
    Publisher entity = em.find(Publisher.class, id);
    if (entity == null) {
      return Response.status(Status.NOT_FOUND).build();
    }
    em.remove(entity);
    return Response.noContent().build();
  }

  @GET
  @Path("/{id:[0-9][0-9]*}")
  @Produces("application/xml")
  public Response findById(@PathParam("id") Long id) {
    TypedQuery<Publisher> findByIdQuery = em.createQuery("SELECT DISTINCT p FROM Publisher p WHERE p.id = :entityId ORDER BY p.id", Publisher.class);
    findByIdQuery.setParameter("entityId", id);
    Publisher entity;
    try {
      entity = findByIdQuery.getSingleResult();
    } catch (NoResultException nre) {
      entity = null;
    }
    if (entity == null) {
      return Response.status(Status.NOT_FOUND).build();
    }
    return Response.ok(entity).build();
  }

  @GET
  @Produces("application/xml")
  public List<Publisher> listAll(@QueryParam("start") Integer startPosition, @QueryParam("max") Integer maxResult) {
    TypedQuery<Publisher> findAllQuery = em.createQuery("SELECT DISTINCT p FROM Publisher p ORDER BY p.id", Publisher.class);
    if (startPosition != null) {
      findAllQuery.setFirstResult(startPosition);
    }
    if (maxResult != null) {
      findAllQuery.setMaxResults(maxResult);
    }
    final List<Publisher> results = findAllQuery.getResultList();
    return results;
  }

  @PUT
  @Path("/{id:[0-9][0-9]*}")
  @Consumes("application/xml")
  public Response update(Publisher entity) {
    entity = em.merge(entity);
    return Response.noContent().build();
  }
}