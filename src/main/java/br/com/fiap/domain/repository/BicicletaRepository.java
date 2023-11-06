package br.com.fiap.domain.repository;

import br.com.fiap.domain.entity.Bicicleta;
import br.com.fiap.domain.entity.Cliente;
import br.com.fiap.domain.service.ClienteService;
import br.com.fiap.infra.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

public class BicicletaRepository implements Repository<Bicicleta, Long> {

    private ConnectionFactory factory;

    private static final AtomicReference<BicicletaRepository> instance = new AtomicReference<>();

    private BicicletaRepository() {
    }

    public static BicicletaRepository build() {
        BicicletaRepository result = instance.get();
        if (Objects.isNull( result )) {
            BicicletaRepository repo = new BicicletaRepository();
            if (instance.compareAndSet( null, repo )) {
                result = repo;
            } else {
                result = instance.get();
            }
        }
        return result;
    }
    @Override
    public Bicicleta persist(Bicicleta bicicleta) {
        var sql = "INSERT INTO TB_BICICLETA" +
                "(ID_BICICLETA, NM_BICICLETA)" +
                "values(0, ?)";

        Connection conn = factory.getConnection();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, bicicleta.getNome());

            ps.executeUpdate();

            final ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()){
                final Long id = rs.getLong(1);
                bicicleta.setId(id);
            }
        }catch (SQLException e){
            System.err.println("Não foi posivel salvar a bicicleta no banco de dados: " + e.getMessage());
        }finally {
            fecharObjetos(null, ps, conn);
        }
        return bicicleta;
    }

    @Override
    public List<Bicicleta> findAll() {
        List<Bicicleta> list = new ArrayList<>();
        Connection con = factory.getConnection();
        ResultSet rs = null;
        Statement st = null;

        var sql = "SELECT * FROM TB_BICICLETA";

        try {
            st = con.createStatement();

            rs = st.executeQuery(sql);

            if (rs.isBeforeFirst()){
                while (rs.next()){
                    Long id = rs.getLong("ID_BICICLETA");
                    String nome = rs.getString("NM_BICICLETA");
                    list.add(new Bicicleta(id, nome));
                }
            }

        }catch (SQLException e){
            System.err.println("Não foi possível consultar o Animal");
        }finally {
            fecharObjetos(rs,st,con);
        }
        return list;
    }

    @Override
    public Bicicleta findById(Long id) {
        Bicicleta bicicleta = null;
        var sql = "SELECT * FROM TB_BICICLETA where ID_BICICLETA=?";

        Connection conn = factory.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setLong(1, id);
            rs = ps.executeQuery();

            if (rs.isBeforeFirst()){
                while (rs.next()){
                    String nome = rs.getString("NM_BICICLE");
                    bicicleta = new Bicicleta(nome);
                }
            }
        }catch (SQLException e){
            System.err.println("Não foi possível consultar o Animal");
        }finally {
            fecharObjetos(conn, ps, rs);
        }
        return bicicleta;
    }

}
