
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<h1>Lista de Locais cadastrados</h1>

<br/>
<br/>
    <table>
        <thead>
        <tr>
            <th>Nome</th>
            <th>Código</th>
            <th>Cidade</th>
            <th>Estado</th>
            <th>Data de criação</th>
            <th>Data de atualização</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${locationListDTO}" var="location">
        <tr>
            <td>${location.name}</td>
            <td>${location.code}</td>
            <td>${location.city}</td>
            <td>${location.address}</td>
            <td>${location.dateCreation}</td>
            <td>${location.dateUpdate}</td>
            <td>
                <form action="/form/update/${location.id}" method="post">
                    <button type="submit">Alterar</button>
                </form>
                <form action="/delete/${location.id}" method="post">
                    <button type="submit" onclick="return confirm('Deseja remover o local ${location.name}?')">Remover</button>
                </form>
            </td>
        </tr>
        </c:forEach>
        </tbody>
    </table>

<script src="/assets/js/locais/buscarLocal.js"></script>