package data;

import static data.Conexion.close;
import static data.Conexion.getConexion;
import entity.Pets;
import java.sql.*;
import java.time.LocalDate;
import java.util.*;

public class PetsDAO {

    private static final String SQL_CREATE = "INSERT INTO pets(name, specie, breed, dateOfBirth, ownerName, treatment, vaccineName, dateVaccineApplied) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String SQL_READ = "SELECT * FROM pets";
    private static final String SQL_UPDATE = "UPDATE pets SET name = ?, specie = ?, breed = ?, dateOfBirth = ?, ownerName = ?, treatment = ?, vaccineName = ?, dateVaccineApplied = ? WHERE idPets = ?";
    private static final String SQL_DELETE = "DELETE FROM pets WHERE idPets = ?";
    private static final String SQL_SELECT_BY_ID = "SELECT * FROM pets WHERE idPets = ?";

    public List<Pets> findAll() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Pets pet = null;
        List<Pets> pets = new ArrayList();

        try {
            conn = getConexion();
            stmt = conn.prepareStatement(SQL_READ);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int idPets = rs.getInt(1);
                String name = rs.getString(2);
                String specie = rs.getString(3);
                String breed = rs.getString(4);
                LocalDate dateOfBirth = LocalDate.parse(rs.getString(5));
                String ownerName = rs.getString(6);
                String treatment = rs.getString(7);
                String vaccineName = rs.getString(8);
                LocalDate dateVaccineApplied = LocalDate.parse(rs.getString(9));

                pet = new Pets(idPets, name, specie, breed, dateOfBirth, ownerName, treatment, vaccineName, dateVaccineApplied);

                pets.add(pet);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(rs);
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }

        return pets;
    }

    public Pets findPetById(int id) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Pets pet = null;

        try {
            conn = getConexion();
            stmt = conn.prepareStatement(SQL_SELECT_BY_ID);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int idPets = rs.getInt(1);
                String name = rs.getString(2);
                String specie = rs.getString(3);
                String breed = rs.getString(4);
                LocalDate dateOfBirth = LocalDate.parse(rs.getString(5));
                String ownerName = rs.getString(6);
                String treatment = rs.getString(7);
                String vaccineName = rs.getString(8);
                LocalDate dateVaccineApplied = LocalDate.parse(rs.getString(9));

                pet = new Pets(idPets, name, specie, breed, dateOfBirth, ownerName, treatment, vaccineName, dateVaccineApplied);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(rs);
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return pet;
    }

    public int create(Pets pet) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = getConexion();
            stmt = conn.prepareStatement(SQL_CREATE);
            stmt.setString(1, pet.getName());
            stmt.setString(2, pet.getSpecie());
            stmt.setString(3, pet.getBreed());
            stmt.setDate(4, java.sql.Date.valueOf(pet.getDateOfBirth()));
            stmt.setString(5, pet.getOwnerName());
            stmt.setString(6, pet.getTreatment());
            stmt.setString(7, pet.getVaccineName());
            stmt.setDate(8, java.sql.Date.valueOf(pet.getDateVaccineApplied()));
            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }

    public int update(Pets pet) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = getConexion();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, pet.getName());
            stmt.setString(2, pet.getSpecie());
            stmt.setString(3, pet.getBreed());
            stmt.setDate(4, java.sql.Date.valueOf(pet.getDateOfBirth()));
            stmt.setString(5, pet.getTreatment());
            stmt.setString(6, pet.getOwnerName());
            stmt.setString(7, pet.getVaccineName());
            stmt.setDate(8, java.sql.Date.valueOf(pet.getDateVaccineApplied()));
            stmt.setInt(9, pet.getIdPets());
            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }

    public int delete(int id) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = getConexion();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, id);
            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }
}
