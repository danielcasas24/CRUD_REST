<%-- 
    Document   : index
    Created on : Mar 9, 2017, 11:12:58 AM
    Author     : ecasas
--%>

<%@page import="com.cliente.CRUD"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/styles.css" rel="stylesheet">
        <link href="css/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet">
	<title>Inscripci&oacute;n de Asignaturas</title>
    </head>
    <body>
        <div class="container-fluid">
            <div class="col-md-7">
                <h1>Inscripci&oacute;n de Asignaturas</h1>
                
                <h2>Inscribir asignaturas</h2>
                <form action="AccederDatos" method="get">
                    <input id="action" name="action" value="create">
                    <div class="row">
                        <div class="col-md-5">Seleccione un estudiante:</div>
                        <div class="col-md-7">
                            <select id="estudiante" name="estudiante">
                                ${estudiante}
                            </select>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-5">Seleccione una asignatura:</div>
                        <div class="col-md-7">
                            <select id="asignatura" name="asignatura">
                                ${asignatura}
                            </select>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-5">Seleccione un profesor:</div>
                        <div class="col-md-7">
                            <select id="profesor" name="profesor">
                                ${profesor}
                            </select>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-5">Seleccione un horario:</div>
                        <div class="col-md-7">
                            <select id="horario" name="horario">
                                <option value="Mañana">Ma&ntilde;ana</option>
                                <option value="Tarde">Tarde</option>
                            </select>
                        </div>
                    </div>
                    <input type="submit" value="Inscribir" >
                </form>
                <hr/>
                
                <h2>Consultar asignaturas inscritas</h2>
                <form action="AccederDatos" method="get">
                    <input id="action" name="action" value="read">
                    <div class="row">
                        <div class="col-md-5">Digite el ID:</div>
                        <div class="col-md-7"><input id="idpp" name="idpp" type="text" value="0"></div>
                    </div>
                    <div class="row">
                        <div class="col-md-5">Seleccione una opci&oacute;n:</div>
                        <div class="col-md-7">
                            <select id="operacion" name="operacion">
                                <option value="todo" selected>Mostrar todas las inscripciones</option>
                                <option value="inscripcion">Por n&uacute;mero de inscrpci&oacute;n</option>
                                <option value="asignatura">Por c&oacute;digo de asignatura</option>
                                <option value="profesor">Por c&oacute;digo de profesor</option>
                                <option value="estudiante">Por c&oacute;digo de estudiante</option>
                            </select>
                        </div>
                    </div>
                    <input type="submit" value="Consultar" >
                </form>
                <hr/>
                <h2>Actualizaci&oacute;n de Inscripci&oacute;n</h2>
                <form action="AccederDatos" method="get">
                    <input id="action" name="action" value="update">
                    <div class="row">
                        <div class="col-md-5">Digite la inscripci&oacute;n a modificar:</div>
                        <div class="col-md-7"><input id="idpp" name="idpp" type="text" value="0"></div>
                    </div>
                    <div class="row">
                        <div class="col-md-5">Seleccione el nuevo horario:</div>
                        <div class="col-md-7">
                            <select id="operacion" name="operacion">
                                <option value="Mañana" selected>Mañana</option>
                                <option value="Tarde">Tarde</option>
                            </select>
                        </div>
                    </div>
                    <input type="submit" value="Actualizar" >
                </form>
                <hr/>
                <h2>Eliminaci&oacute;n de Inscripci&oacute;n</h2>
                <form action="AccederDatos" method="get">
                    <input id="action" name="action" value="delete">
                    <div class="row">
                        <div class="col-md-5">Digite la inscripci&oacute;n a eliminar:</div>
                        <div class="col-md-7"><input id="idpp" name="idpp" type="text" value="0"></div>
                    </div>
                    <input type="submit" value="Eliminar" >
                </form>
                
            </div>
            <div class="col-md-5">
                <table class="table-bordered table-hover table-responsive text-center">
                    ${message}
                </table>
            </div>
        </div>
    </body>
</html>

