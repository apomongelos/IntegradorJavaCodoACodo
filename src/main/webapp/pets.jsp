<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Petfy</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet">
        <script src="https://kit.fontawesome.com/382381b436.js" crossorigin="anonymous"></script>
    </head>
    <body>
       
        <jsp:include page="/WEB-INF/paginas/comunes/header.jsp"/>
        
        <jsp:include page="/WEB-INF/paginas/comunes/nav.jsp"/>
        
        <jsp:include page="/WEB-INF/paginas/operaciones/petsList.jsp"/>
        
        <jsp:include page="/WEB-INF/paginas/comunes/footer.jsp"/>
        
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"></script>
    </body>
</html>
