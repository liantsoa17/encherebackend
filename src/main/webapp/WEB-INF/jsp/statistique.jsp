<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
        <title>Index</title>
        <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="assets/fonts/ionicons.min.css">
        <link rel="stylesheet" href="assets/css/Footer-Basic.css">
        <link rel="stylesheet" href="assets/css/Login-Form-Clean.css">
        <link rel="stylesheet" href="assets/css/styles.css">
        

        <link href="assets/stat/assets/img/favicon.png" rel="icon">
        <link href="assets/stat/assets/img/apple-touch-icon.png" rel="apple-touch-icon">

        <!-- Google Fonts -->
        <link href="https://fonts.gstatic.com" rel="preconnect">
        <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Nunito:300,300i,400,400i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet">

        <!-- Vendor CSS Files -->
        <link href="assets/stat/assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link href="assets/stat/assets/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
        <link href="assets/stat/assets/vendor/boxicons/css/boxicons.min.css" rel="stylesheet">
        <link href="assets/stat/assets/vendor/quill/quill.snow.css" rel="stylesheet">
        <link href="assets/stat/assets/vendor/quill/quill.bubble.css" rel="stylesheet">
        <link href="assets/stat/assets/vendor/remixicon/remixicon.css" rel="stylesheet">
        <link href="assets/stat/assets/vendor/simple-datatables/style.css" rel="stylesheet">

        <!-- Template Main CSS File -->
        <link href="assets/css/style.css" rel="stylesheet">
        
    </head>
        <body>
            <nav class="navbar navbar-light navbar-expand-lg fixed-top bg-white clean-navbar">
                <div class="container"><a class="navbar-brand logo" href="#">Enchere</a><button data-bs-toggle="collapse" class="navbar-toggler" data-bs-target="#navcol-1"><span class="visually-hidden">Toggle navigation</span><span class="navbar-toggler-icon"></span></button>
                    <div class="collapse navbar-collapse" id="navcol-1">
                        <ul class="navbar-nav ms-auto">
                            <li class="nav-item"><a class="nav-link" href="http://localhost:8080/stat">STAT PAR USER</a></li>
                            <li class="nav-item"><a class="nav-link" href="http://localhost:8080/listeEnchere">LISTE ENCHERE</a></li>
                            <li class="nav-item"><a class="nav-link" href="http://localhost:8080/pourcentage">COMISSION</a></li>
                            <li class="nav-item"><a class="nav-link" href="http://localhost:8080/demandeRecharge">RECHARGEMENT</a></li>
                        </ul>
                    </div>
                </div>
            </nav>
            <center>
            <br>
            <br>
            <br>
            <br><br>
            <br><br>
                 <div class="col-md-6">
                    <div class="card">
                        <div class="card-body">
                        <input type="hidden" value="${list_enchere}" id="test" />
                        <h5 class="card-title">enchere par categorie</h5>
                        
                        <!-- Line Chart -->
                        <canvas id="lineChart" style="max-height: 400px;"></canvas>
                        <script>
                        
                            var donnee = test.value.split("/")
                            var count = []
                            var nom = []
                            for (let index = 0; index < donnee.length-1; index++) {
                                count[index] = donnee[index].split(",")[0]
                                nom[index] = donnee[index].split(",")[1]
                            }
                            document.addEventListener("DOMContentLoaded", () => {
                            new Chart(document.querySelector('#lineChart'), {
                                type: 'line',
                                data: {
                                labels: nom,
                                datasets: [{
                                    label: 'Enchere par Categorie',
                                    data: count,
                                    fill: false,
                                    borderColor: 'rgb(75, 192, 192)',
                                    tension: 0.1
                                }]
                                },
                                options: {
                                scales: {
                                    y: {
                                    beginAtZero: true
                                    }
                                }
                                }
                            });
                            });
                        </script>
                        <!-- End Line CHart -->

                        </div>
                    </div>
                </div>
            </center>
           
            

           
        <script src="assets/bootstrap/js/bootstrap.min.js"></script>
        

        <script src="assets/stat/assets/vendor/apexcharts/apexcharts.min.js"></script>
        <script src="assets/stat/assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
        <script src="assets/stat/assets/vendor/chart.js/chart.min.js"></script>
        <script src="assets/stat/assets/vendor/echarts/echarts.min.js"></script>
        <script src="assets/stat/assets/vendor/quill/quill.min.js"></script>
        <script src="assets/stat/assets/vendor/simple-datatables/simple-datatables.js"></script>
        <script src="assets/stat/assets/vendor/tinymce/tinymce.min.js"></script>
        <script src="assets/stat/assets/vendor/php-email-form/validate.js"></script>

        <!-- Template Main JS File -->
        <script src="/stat/assetsassets/js/main.js"></script>
        </body>
</html>
