package web;

import data.PetsDAO;
import entity.Pets;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/servletControlador")
public class ServletControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String accion = req.getParameter("accion");

        if (accion != null) {
            switch (accion) {
                case "edit":
                    editPet(req, res);
                    break;
                case "delete":
                    deletePet(req, res);
                    break;
                default:
                    actionDefault(req, res);
                    break;
            }
        } else {
            actionDefault(req, res);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String accion = req.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "add":
                    savePet(req, res);
                    break;
                case "update":
                    updatePet(req, res);
                    break;
                default:
                    actionDefault(req, res);
                    break;
            }
        }
    }

    private void actionDefault(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        List<Pets> pets = new PetsDAO().findAll();
        HttpSession sesion = req.getSession();
        sesion.setAttribute("petsList", pets);
        sesion.setAttribute("cantPets", calcularCantPets(pets));
        sesion.setAttribute("cantDosisBagovac", calcularCantDosisBagovac(pets));
        sesion.setAttribute("cantDosisNobivac", calcularCantDosisNobivac(pets));
        sesion.setAttribute("cantDosisFelocel", calcularCantDosisFelocel(pets));
        res.sendRedirect("pets.jsp");
    }

    private void savePet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String name = req.getParameter("name");
        String specie = req.getParameter("specie");
        String breed = req.getParameter("breed");
        LocalDate dateOfBirth = LocalDate.parse(req.getParameter("dateOfBirth"));
        String ownerName = req.getParameter("ownerName");
        String treatment = req.getParameter("treatment");
        String vaccineName = req.getParameter("vaccineName");
        LocalDate dateVaccineApplied = LocalDate.parse(req.getParameter("dateVaccineApplied"));

        Pets pet = new Pets(name, specie, breed, dateOfBirth, ownerName, treatment, vaccineName, dateVaccineApplied);

        int regMod = new PetsDAO().create(pet);
        System.out.println("INSERTADOS: " + regMod);
        actionDefault(req, res);
    }

    private void editPet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        int idPet = Integer.parseInt(req.getParameter("idPet"));
        Pets pet = new PetsDAO().findPetById(idPet);
        req.setAttribute("pet", pet);
        req.getRequestDispatcher("/WEB-INF/paginas/operaciones/editPet.jsp").forward(req, res);
    }

    private void updatePet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String name = req.getParameter("name");
        String specie = req.getParameter("specie");
        String breed = req.getParameter("breed");
        LocalDate dateOfBirth = LocalDate.parse(req.getParameter("dateOfBirth"));
        String ownerName = req.getParameter("ownerName");
        String treatment = req.getParameter("treatment");
        String vaccineName = req.getParameter("vaccineName");
        LocalDate dateVaccineApplied = LocalDate.parse(req.getParameter("dateVaccineApplied"));
        int idPets = Integer.parseInt(req.getParameter("idPets"));

        Pets pet = new Pets(idPets, name, specie, breed, dateOfBirth, treatment, ownerName, vaccineName, dateVaccineApplied);

        int regMod = new PetsDAO().update(pet);

        System.out.println("SE ACTUALIZARON: " + regMod + " REGISTROS");

        actionDefault(req, res);
    }

    private void deletePet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        int idPet = Integer.parseInt(req.getParameter("idPet"));

        int regDel = new PetsDAO().delete(idPet);

        System.out.println("REGISTROS ELIMINADOS: " + regDel);

        actionDefault(req, res);
    }

    private int calcularCantPets(List<Pets> lista) {
        return lista.size();
    }

    private int calcularCantDosisBagovac(List<Pets> lista) {
        int cantidad = 0;
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getVaccineName().equals("Bagovac")) {
                cantidad++;
            }
        }
        return cantidad;
    }

    private int calcularCantDosisNobivac(List<Pets> lista) {
        int cantidad = 0;
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getVaccineName().equals("Nobivac")) {
                cantidad++;
            }
        }
        return cantidad;
    }

    private int calcularCantDosisFelocel(List<Pets> lista) {
        int cantidad = 0;
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getVaccineName().equals("Felocel")) {
                cantidad++;
            }
        }
        return cantidad;
    }

}
