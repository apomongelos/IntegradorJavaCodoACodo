<div class="modal fade" id="addPetModal">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header bg-info text-white">
                <h5 class="modal-title">Agregar mascota</h5>
            </div>
            <form action="${pageContext.request.contextPath}/servletControlador?accion=add" method="POST" class="was-validated">
                <div class="modal-body">
                    <div class="form-group">
                        <label for="name">Nombre</label>
                        <input type="text" class="form-control" name="name" required="">
                    </div>
                    <div class="form-group">
                        <label for="specie">Especie</label>
                        <input type="text" class="form-control" name="specie" required="">
                    </div>
                    <div class="form-group">
                        <label for="breed">Raza</label>
                        <input type="text" class="form-control" name="breed" required="">
                    </div>
                    <div class="form-group">
                        <label for="dateOfBirth">Fecha de nacimiento</label>
                        <input type="date" class="form-control" name="dateOfBirth" required="">
                    </div>
                    <div class="form-group">
                        <label for="ownerName">Nombre del dueño</label>
                        <input type="text" class="form-control" name="ownerName" required="">
                    </div>
                    <div class="form-group">                        
                        <label for="treatment">Tratamiento</label>
                        <select name="treatment" class="form-select" required="">
                            <option selected value="">Seleccione una opcion</option>
                            <option value="Antirabica">Antirabica</option>
                            <option value="Moquillo">Moquillo</option>
                            <option value="Parvo">Parvo</option>
                            <option value="Vif">Vif</option>
                        </select>
                        <!--<input type="text" class="form-control" name="vaccineName" required="">-->
                    </div>
                    <div class="form-group">                        
                        <label for="vaccineName">Nombre de la vacuna aplicada</label>
                        <select name="vaccineName" class="form-select" required="">
                            <option selected value="">Seleccione una opcion</option>
                            <option value="Bagovac">Bagovac</option>
                            <option value="Nobivac">Nobivac</option>
                            <option value="Felocel">Felocel</option>
                        </select>
                        <!--<input type="text" class="form-control" name="vaccineName" required="">-->
                    </div>
                    <div class="form-group">
                        <label for="dateVaccineApplied">Fecha de la aplicacion de la vacuna</label>
                        <input type="date" class="form-control" name="dateVaccineApplied" required="">
                    </div>
                </div>
                <div class="modal-footer">
                    <button class="btn btn-primary" type="submit">
                        Guardar
                    </button>
                </div>
            </form>
        </div>
    </div>
</div>
