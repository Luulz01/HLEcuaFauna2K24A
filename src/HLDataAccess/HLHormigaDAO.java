package HLDataAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import HLDataAccess.DTO.HLHormigaDTO;

public class HLHormigaDAO extends HLDataHelper implements IHLDAO<HLHormigaDTO> {

    @Override
    public boolean create(HLHormigaDTO entity) throws Exception {
        String query = "INSERT INTO HLHormiga (IdCatalogoRegion, IdCatalogoProvincia, IdCatalogoSexo, IdCatalogoIngestaNativa, IdCatalogoGenoAlimento, TipoHormiga) VALUES (?,?,?,?,?,?)";
        try (Connection conn = openConnection(); 
            PreparedStatement pstmt = conn.prepareStatement(query)) {

            // Asignando los valores a los placeholders
            pstmt.setInt(1, entity.getIdCatalogoRegion());
            pstmt.setInt(2, entity.getIdCatalogoProvincia());
            pstmt.setInt(3, entity.getIdCatalogoSexo());
            pstmt.setInt(4, entity.getIdCatalogoIngestaNativa());
            pstmt.setInt(5, entity.getIdCatalogoGenoAlimento());
            pstmt.setString(6, entity.getTipoHormiga());

            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new Exception("Error al crear la hormiga: " + e.getMessage());
        }
    }

    @Override
    public List<HLHormigaDTO> readAll() throws Exception {
        String query = "SELECT * FROM HLHormiga";
        List<HLHormigaDTO> hormigas = new ArrayList<>();

        try (Connection conn = openConnection(); 
            PreparedStatement pstmt = conn.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                HLHormigaDTO hormiga = new HLHormigaDTO();
                hormiga.setIdHormiga(rs.getInt("IdHormiga"));
                hormiga.setIdCatalogoRegion(rs.getInt("IdCatalogoRegion"));
                hormiga.setIdCatalogoProvincia(rs.getInt("IdCatalogoProvincia"));
                hormiga.setIdCatalogoSexo(rs.getInt("IdCatalogoSexo"));
                hormiga.setIdCatalogoIngestaNativa(rs.getInt("IdCatalogoIngestaNativa"));
                hormiga.setIdCatalogoGenoAlimento(rs.getInt("IdCatalogoGenoAlimento"));
                hormiga.setTipoHormiga(rs.getString("TipoHormiga"));
                
                hormigas.add(hormiga);
            }
        } catch (SQLException e) {
            throw new Exception("Error al leer todas las hormigas: " + e.getMessage());
        }
        return hormigas;
    }

    @Override
    public boolean update(HLHormigaDTO entity) throws Exception {
        String query = "UPDATE HLHormiga SET IdCatalogoRegion = ?, IdCatalogoProvincia = ?, IdCatalogoSexo = ?, IdCatalogoIngestaNativa = ?, IdCatalogoGenoAlimento = ?, TipoHormiga = ? WHERE IdHormiga = ?";
        try (Connection conn = openConnection(); 
            PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, entity.getIdCatalogoRegion());
            pstmt.setInt(2, entity.getIdCatalogoProvincia());
            pstmt.setInt(3, entity.getIdCatalogoSexo());
            pstmt.setInt(4, entity.getIdCatalogoIngestaNativa());
            pstmt.setInt(5, entity.getIdCatalogoGenoAlimento());
            pstmt.setString(6, entity.getTipoHormiga());
            pstmt.setInt(7, entity.getIdHormiga());

            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new Exception("Error al actualizar la hormiga: " + e.getMessage());
        }
    }

    @Override
    public boolean delete(Integer id) throws Exception {
        String query = "DELETE FROM HLHormiga WHERE IdHormiga = ?";
        try (Connection conn = openConnection(); 
            PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new Exception("Error al eliminar la hormiga: " + e.getMessage());
        }
    }

    @Override
    public HLHormigaDTO readBy(Integer id) throws Exception {
        String query = "SELECT * FROM HLHormiga WHERE IdHormiga = ?";
        HLHormigaDTO hormiga = null;

        try (Connection conn = openConnection(); 
            PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    hormiga = new HLHormigaDTO();
                    hormiga.setIdHormiga(rs.getInt("IdHormiga"));
                    hormiga.setIdCatalogoRegion(rs.getInt("IdCatalogoRegion"));
                    hormiga.setIdCatalogoProvincia(rs.getInt("IdCatalogoProvincia"));
                    hormiga.setIdCatalogoSexo(rs.getInt("IdCatalogoSexo"));
                    hormiga.setIdCatalogoIngestaNativa(rs.getInt("IdCatalogoIngestaNativa"));
                    hormiga.setIdCatalogoGenoAlimento(rs.getInt("IdCatalogoGenoAlimento"));
                    hormiga.setTipoHormiga(rs.getString("TipoHormiga"));
                }
            }
        } catch (SQLException e) {
            throw new Exception("Error al leer la hormiga por ID: " + e.getMessage());
        }
        return hormiga;
    }

    public int getRowCount() throws Exception {
        String query = "SELECT COUNT(*) AS total FROM HLHormiga";
        int rowCount = 0;

        try (Connection conn = openConnection(); 
            PreparedStatement pstmt = conn.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery()) {

            if (rs.next()) {
                rowCount = rs.getInt("total");
            }
        } catch (SQLException e) {
            throw new Exception("Error al contar las hormigas: " + e.getMessage());
        }
        return rowCount;
    }
}