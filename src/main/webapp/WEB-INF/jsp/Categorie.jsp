<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
        <title>Categorie</title>
        <link rel="stylesheet" href="assets/cat/assets/bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat:400,400i,700,700i,600,600i">
        <link rel="stylesheet" href="assets/cat/assets/fonts/ionicons.min.css">
        <link rel="stylesheet" href="assets/cat/assets/fonts/simple-line-icons.min.css">
        <link rel="stylesheet" href="assets/cat/assets/css/Contact-Form-Clean.css">
        <link rel="stylesheet" href="assets/cat/assets/css/Footer-Basic.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/baguettebox.js/1.10.0/baguetteBox.min.css">
        <link rel="stylesheet" href="assets/cat/assets/css/vanilla-zoom.min.css">
    </head>
        <body>
            <nav class="navbar navbar-light navbar-expand-lg fixed-top bg-white clean-navbar">
                <div class="container"><a class="navbar-brand logo" href="#">Enchere</a><button data-bs-toggle="collapse" class="navbar-toggler" data-bs-target="#navcol-1"><span class="visually-hidden">Toggle navigation</span><span class="navbar-toggler-icon"></span></button>
                    <div class="collapse navbar-collapse" id="navcol-1">
                        <ul class="navbar-nav ms-auto">
                            <li class="nav-item"><a class="nav-link active" href="#">CATEGORIE</a></li>
                            <li class="nav-item"><a class="nav-link" href="http://localhost:8080/listeEnchere">LISTE ENCHERE</a></li>
                            <li class="nav-item"><a class="nav-link" href="http://localhost:8080/pourcentage">COMISSION</a></li>
                            <li class="nav-item"><a class="nav-link" href="http://localhost:8080/demandeRecharge">RECHARGEMENT</a></li>
                        </ul>
                    </div>
                </div>
            </nav>
            <section class="contact-clean" style="margin-top: 50px">
            <br>
            <form method="post" action="http://localhost:8080/newCategorie">
                <h2 class="text-center">Insert nouveau</h2>
                <div class="mb-3"></div>
                <div class="mb-3"><input position="floating" class="form-control is-invalid" type="text" name="categorie" placeholder="categorie"></div>
                <div class="mb-3"></div>
                <div class="mb-3"><button class="btn btn-primary" type="submit">send </button></div>
            </form>
            <h1 class="text-center">Listes des Categories</h1>
            <div class="table-responsive">
                <table class="table">
                    <thead>
                        <tr>
                            <th>idCategorie</th>
                            <th>nom Categorie</th>
                        </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="listCategorie" items="${listCategorie}" >
                        <tr>
                            <td>${listCategorie.id}</td>
                            <td>${listCategorie.nom}</td>
                            <td>
                                <a href="http://localhost:8080/updateCategorie?id=${listCategorie.id}&&nom=${listCategorie.nom}">update</a>
                            </td>
                            <td>
                                <a href="http://localhost:8080/deleteCategorie?id=${listCategorie.id}&&nom=${listCategorie.nom}">delete</a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                    
                </table>
            </div>
        </section>
            <script src="assets/cat/assets/bootstrap/js/bootstrap.min.js"></script>
            <script src="assets/cat/https://cdnjs.cloudflare.com/ajax/libs/baguettebox.js/1.10.0/baguetteBox.min.js"></script>
            <script src="assets/cat/assets/js/vanilla-zoom.js"></script>
            <script src="assets/cat/assets/js/theme.js"></script>
        </body>
</html>
