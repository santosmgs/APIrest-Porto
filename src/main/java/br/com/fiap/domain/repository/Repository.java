package br.com.fiap.domain.repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Objects;

/**
 * Interface para métodos de Repository
 * @author Francis
 * @version 1.0
 * @param <T>
 * @param <U>
 */
public interface Repository<T, U> {

    /**
     * <strong>Método para persistencia da Entidade</strong>
     *
     * @param t
     * @return
     */
    public T persist(T t);

    /**
     * Método que retorna todas as Entidades
     *
     * @return
     */
    public List<T> findAll();

    /**
     * Método que retorna uma entidade pelo seu identificador
     *
     * @param u
     * @return
     */
    public T findById(U u);


    default void fecharObjetos(ResultSet rs, Statement st, Connection con) {
        try {
            if (Objects.nonNull(rs) && !rs.isClosed()) rs.close();
            if (Objects.nonNull(st) && !st.isClosed()) st.close();
            if (Objects.nonNull(con) && !con.isClosed()) con.close();
        } catch (SQLException e) {
            System.err.println("Erro ao encerrar o ResultSet, a Connection e o Statment!\n" + e.getMessage());
        }
    }
}