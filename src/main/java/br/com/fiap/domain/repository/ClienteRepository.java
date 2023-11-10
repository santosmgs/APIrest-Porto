package br.com.fiap.domain.repository;

import br.com.fiap.domain.entity.Cliente;
import br.com.fiap.infra.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

public class ClienteRepository implements Repository<Cliente, Long> {

    private ConnectionFactory factory;

    private static final AtomicReference<ClienteRepository> instance = new AtomicReference<>();

    private ClienteRepository() {
        this.factory = ConnectionFactory.build();
    }

    public static ClienteRepository build() {
        instance.compareAndSet(null, new ClienteRepository());
        return instance.get();
    }

    @Override
    public Cliente persist(Cliente cliente) {
        var sql = "INSERT INTO TB_CLIENTE (ID_CLIENTE, ENDERECO, NM_CLIENTE, NR_CPF) VALUES (0,?,?,?)";

        Connection con = factory.getConnection();
        PreparedStatement ps = null;

        try {
            ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setString(1,cliente.getNome());
            ps.setString(2,cliente.getEndereco());
            ps.setString(3, cliente.getCpf());

            ps.executeUpdate();

            final  ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()){
                final Long id = rs.getLong(1);
                cliente.setId(id);
            }
        }catch (SQLException e){
            System.err.println("Não foi possível inserir os dados!\n" + e.getMessage());
        }finally {
            fecharObjetos(null, ps, con);
        }
        return cliente;
    }

    @Override
    public List<Cliente> findAll() {
        List<Cliente> list = new ArrayList<>();
        Connection con = factory.getConnection();
        ResultSet rs = null;
        Statement st = null;
        try {
            String sql = "SELECT * FROM TB_CLIENTE";
            st = con.createStatement();
            rs = st.executeQuery(sql);
            if (rs.isBeforeFirst()){
                while(rs.next()){
                    Long id = rs.getLong("ID_CLIENTE");
                    String nome = rs.getString("NM_CLIENTE");
                    String endereco = rs.getString("ENDERECO");
                    String cpf = rs.getString("NR_CPF");
                    list.add(new Cliente(id, nome, endereco, cpf));
                }
            }
        }catch (SQLException e){
            System.err.println("Não foi possível consultar os dados!\n" + e.getMessage());
        }finally {
            fecharObjetos(rs,st,con);
        }
        return list;
    }

    @Override
    public Cliente findById(Long id) {
        Cliente cliente = null;
        var sql  = "SELECT * FROM TB_CLIENTE where ID_CLIENTE = ?";
        Connection con = factory.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setLong(1, id);
            rs = ps.executeQuery();
            if (rs.isBeforeFirst()){
                while(rs.next()){
                    String nome = rs.getString("NM_CLIENTE");
                    String endereco = rs.getString("ENDERECO");
                    String cpf = rs.getString("NR_CPF");
                    cliente = new Cliente(id, nome, endereco, cpf);
                }
                }else {
                System.out.println("Dados não encontrados com o id: " + id);
            }
        }catch (SQLException e){
            System.err.println("Não foi possível consultar os dados!\n" + e.getMessage());
        }finally {
            fecharObjetos(rs, ps, con);
        }
        return cliente;
    }
}