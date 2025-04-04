<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Lista de Locais Cadastrados</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>

<div class="container mt-5">
    <h1>Locais Cadastrados</h1>
    <hr class="mb-4">

    <div class="row row-cols-1 row-cols-md-3 g-4">
        <c:forEach items="${locationListDTO}" var="location">
            <div class="col">
                <div class="card h-100 border border-dark">
                    <div class="card-body">
                        <h5 class="card-title">${location.name}</h5>
                        <p class="card-text">
                            <strong>Código:</strong> ${location.code}<br>
                            <strong>Cidade:</strong> ${location.city}<br>
                            <strong>Estado:</strong> ${location.address}<br>
                            <strong>Criação:</strong> ${location.dateCreation}<br>
                            <strong>Atualização:</strong> ${location.dateUpdate}
                        </p>
                        <div class="d-flex justify-content-between">
                            <form action="/form/update/${location.id}" method="post">
                                <button type="submit" class="btn btn-primary btn-sm">Alterar</button>
                            </form>
                            <form action="/delete/${location.id}" method="post">
                                <button type="submit" class="btn btn-danger btn-sm" onclick="return confirm('Deseja remover o local ${location.name}?')">Remover</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>

<script src="/assets/js/locais/buscarLocal.js"></script>
</body>
</html>