<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Libreria</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet">
        <script src="https://kit.fontawesome.com/382381b436.js" crossorigin="anonymous"></script>
    </head>
    <body>

        <jsp:include page="/WEB-INF/paginas/comunes/header.jsp"/>

        <form action = "${pageContext.request.contextPath}/servletControlador?accion=update&idPets=${pet.idPets}"
              method="POST" class="was-validated">
            <jsp:include page="/WEB-INF/paginas/comunes/editNav.jsp"/>

            <section id="details">
                <div class="container">
                    <div class="row">
                        <div class="col">
                            <div clas="card">
                                <div class="card-header">
                                    <h4>Editar Mascota</h4>
                                </div>
                                <div class="card-body">
                                    <div class="form-group">
                                        <label for="name">Nombre</label>
                                        <input type="text" class="form-control" name="name" required="" value="${pet.name}">
                                    </div>
                                    <div class="form-group">
                                        <label for="specie">Especie</label>
                                        <input type="text" class="form-control" name="specie" required="" value="${pet.specie}">
                                    </div>
                                    <div class="form-group">
                                        <label for="breed">Raza</label>
                                        <input type="text" class="form-control" name="breed" required="" value="${pet.breed}">
                                    </div>
                                    <div class="form-group">
                                        <label for="dateOfBirth">Fecha de nacimiento</label>
                                        <input type="date" class="form-control" name="dateOfBirth" required="" value="${pet.dateOfBirth}">
                                    </div>
                                    <div class="form-group">
                                        <label for="ownerName">Nombre del dueño</label>
                                        <input type="text" class="form-control" name="ownerName" required="" value="${pet.ownerName}">
                                    </div>
                                    <div class="form-group">
                                        <label for="treatment">Nombre de la vacuna aplicada</label>
                                        <select name="treatment" class="form-select" required="" >
                                            <option value="">Seleccione una opcion</option>
                                            <option value="Antirabica" ${pet.treatment == 'Antirabica' ? 'selected="selected"' : ''}>Antirabica</option>
                                            <option value="Moquillo" ${pet.treatment == 'Moquillo' ? 'selected="selected"' : ''}>Moquillo</option>
                                            <option value="Parvo" ${pet.treatment == 'Parvo' ? 'selected="selected"' : ''}>Parvo</option>
                                            <option value="Vif" ${pet.treatment == 'Vif' ? 'selected="selected"' : ''}>Vif</option>
                                        </select>
                                        <!--<input type="text" class="form-control" name="vaccineName" value="${pet.vaccineName}">-->
                                    </div>
                                    <div class="form-group">
                                        <label for="vaccineName">Nombre de la vacuna aplicada</label>
                                        <select name="vaccineName" class="form-select" required="" >
                                            <option value="">Seleccione una opcion</option>
                                            <option value="Bagovac" ${pet.vaccineName == 'Bagovac' ? 'selected="selected"' : ''}>Bagovac</option>
                                            <option value="Nobivac" ${pet.vaccineName == 'Nobivac' ? 'selected="selected"' : ''}>Nobivac</option>
                                            <option value="Felocel" ${pet.vaccineName == 'Felocel' ? 'selected="selected"' : ''}>Felocel</option>
                                        </select>
                                        <!--<input type="text" class="form-control" name="vaccineName" value="${pet.vaccineName}">-->
                                    </div>
                                    <div class="form-group">
                                        <label for="dateVaccineApplied">Fecha de la aplicacion de la vacuna</label>
                                        <input type="date" class="form-control" name="dateVaccineApplied" required="" value="${pet.dateVaccineApplied}">
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
        </form>


        <jsp:include page="/WEB-INF/paginas/comunes/footer.jsp"/>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"></script>
    </body>
</html>
