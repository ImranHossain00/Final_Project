<%--<%@taglib prefix="sec" uri="http://imran.com/functions" %>--%>
<%@include file="includes/header.jsp"%>
<%@include file="includes/navigation.jsp"%>

<div class="container">
    <form class="form-horizontal" role="form"
          method="post"
          action="<c:url value="/home"/>">
        <div class="form-group">
            <label for="inputValues">
                Input values
            </label>
            <input type="text"
                   class="form-control"
                   id="inputValues"
                   value="${numberListDTO.inputValues}"
                   name="inputValues"
                   placeholder="The input only contains digits, spaces and commas."/>

            <c:if test="${errors.inputValues != null}">
                <small class="text-danger">${errors.inputValues}</small>
            </c:if>
        </div>
        <div class="form-group">
            <label for="searchValue">
                Search Values
            </label>
            <input type="text"
                   class="form-control"
                   id="searchValue"
                   value="${numberListDTO.searchValue}"
                   name="searchValue"
                   placeholder="you can search multiple numbers. use only digits, commas and spaces"/>
            <c:if test="${errors.searchValue != null}">
                <small class="text-danger">${errors.searchValue}</small>
            </c:if>
        </div>
    </form>
</div>

<%@include file="includes/footer.jsp"%>
