<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="es_AR"/>
<section id="pets">
    <div class="container">
        <div class="row">
            <div class="col-md-10">
                <div class="card">
                    <div class="card-header">
                        <h4>Listado de Mascotas</h4>
                    </div>
                    <table class="table table-striped table-dark">
                        <thead class="thead-dark">
                            <tr>
                                <th>#</th>
                                <th>Nombre</th>
                                <th>Especie</th>
                                <th>Raza</th>
                                <th>Fecha de Nacimiento</th>
                                <th>Nombre del dueño</th>
                                <th>Tratamiento</th>
                                <th>Nombre de la vacuna</th>
                                <th>Fecha aplicacion vacuna</th>
                                <th>Accion</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="pet" items="${petsList}" varStatus="status">
                                <tr>
                                    <td>${status.count}</td>
                                    <td>${pet.name}</td>
                                    <td>${pet.specie}</td>
                                    <td>${pet.breed}</td>
                                    <td>${pet.dateOfBirth}</td>
                                    <td>${pet.ownerName}</td>
                                    <td>${pet.treatment}</td>
                                    <td>${pet.vaccineName}</td>
                                    <td>${pet.dateVaccineApplied}</td>                                    
                                    <td>
                                        <a href="${pageContext.request.contextPath}/servletControlador?accion=edit&idPet=${pet.idPets}" 
                                           class="btn btn-secondary">
                                            <i class="fas fa-angle-double-right"></i>
                                            Editar
                                        </a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
            <div class="col-md-2">
                <div class="card text-center mb-3" style="background-color: #f2f4f6">
                    <div class="card-body">
                        <h6>Cantidad de mascotas desparasitadas</h6>
                        <h5>
                            ${cantPets}
                        </h5>
                    </div>
                </div>
                <div class="card text-center mb-3" style="background-color: #e6e9ed">
                    <div class="card-body">
                        <h6>Total de dosis aplicadas Bagovac</h6>
                        <h5>
                            ${cantDosisBagovac}
                        </h5>
                    </div>
                </div>
                <div class="card text-center mb-3" style="background-color: #f2f4f6">
                    <div class="card-body">
                        <h6>Total de dosis aplicadas Nobivac</h6>
                        <h5>
                            ${cantDosisNobivac}
                        </h5>
                    </div>
                </div>
                <div class="card text-center mb-3" style="background-color: #e6e9ed">
                    <div class="card-body">
                        <h6>Total dosis aplicadas Felocel</h6>
                        <h5>
                            ${cantDosisFelocel}
                        </h5>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

<jsp:include page="/WEB-INF/paginas/operaciones/addPets.jsp"/>