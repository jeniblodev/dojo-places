<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="pt-br">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Formulário de edição de local</title>
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>

<div class="container mt-5">
  <h1>Edição de Local</h1>
  <hr class="mb-4">

  <form:form modelAttribute="locationUpdate" method="post" action="/form/update/${locationUpdate.id}">
  <div class="mb-3">
  <div class="input group">
      <label for="name" class="form-label">Nome:</label>
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

      <form:button type="submit" class="btn btn-primary">Editar</form:button>

  </div>
  </div>
  </form:form>
</div>

<script src="/assets/js/locais/buscarLocal.js"></script>
