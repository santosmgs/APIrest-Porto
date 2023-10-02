package br.com.fiap.domain.resource;

import jakarta.ws.rs.core.Response;

/**
 * Interface para métodos de Recurso da nossa API
 *
 * @param <T>
 * @param <U>
 * @author Benefrancis
 * @version 1.0
 */
public interface Resource<T, U> {

    /**
     * <strong>Método para persistencia da Entidade</strong>
     *
     * @param t
     * @return
     */
    public Response persist(T t);

    /**
     * Método que retorna todas as Entidades
     *
     * @return
     */
    public Response findAll();

    /**
     * Método que retorna uma entidade pelo seu identificador
     *
     * @param u
     * @return
     */
    public Response findById(U u);

    /**
     * Update object
     *
     * @param id
     * @param t
     * @return
     */
    public Response update(U id, T t);

    /**
     * Delete resource
     *
     * @param id
     * @return
     */
    public Response delete(U id);
}