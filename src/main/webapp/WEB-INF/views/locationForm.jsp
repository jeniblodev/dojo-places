<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Formulário de cadastro de local</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>

<div class="container mt-5">
    <h1>Cadastro de local</h1>
    <hr class="mb-4">


        <form:form modelAttribute="locationDTO" method="post" action="/form">
            <div class="mb-3">
            <div class="input group">
            <label for="name" class="form-label">Nome do local:</label>
            <form:input path="name" class="form-control"/>
            <form:errors path="name" cssStyle="color: red"/>

            <br/>

            <label for="code" class="form-label">Código:</label>
            <form:input path="code" class="form-control"/>
            <form:errors path="code" cssStyle="color: red"/>

            <br/>

            <label for="address" class="form-label">Bairro:</label>
            <form:input path="address" class="form-control"/>
            <form:errors path="address" cssStyle="color: red"/>

            <br/>

            <label for="city" class="form-label">Cidade:</label>
            <form:input path="city" class="form-control"/>
            <form:errors path="city" cssStyle="color: red"/>

            <br/>

            <form:button type="submit" class="btn btn-primary">Cadastrar</form:button>

        </form:form>
        </div>
        </div>

        </div>
    </div>
</div>

<script src="/assets/js/locais/buscarLocal.js"></script>
</body>
</html>
