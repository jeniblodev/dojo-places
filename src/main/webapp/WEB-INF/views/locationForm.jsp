
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<h1>Formulário de Criação de Local</h1>

<br/>
<br/>

<form:form modelAttribute="locationDTO" method="post" action="/form">

    <label>Nome:</label>
    <form:input path="name"/>
    <form:errors path="name" cssStyle="color: red"/>

    <br/>
    <br/>

    <label>Código:</label>
    <form:input path="code"/>
    <form:errors path="code" cssStyle="color: red"/>

    <br/>
    <br/>

    <label>Bairro:</label>
    <form:input path="address"/>
    <form:errors path="address" cssStyle="color: red"/>

    <br/>
    <br/>

    <label>Cidade:</label>
    <form:input path="city"/>
    <form:errors path="city" cssStyle="color: red"/>

    <br/>
    <br/>

    <form:button type="submit">Cadastrar</form:button>

</form:form>

<script src="/assets/js/locais/buscarLocal.js"></script>

