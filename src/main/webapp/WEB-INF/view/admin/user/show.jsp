<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

            <html lang="en">

            <head>
                <meta charset="UTF-8">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <title>User Detail ${user.id}</title>
                <!-- Latest compiled and minified CSS -->
                <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

                <!-- Latest compiled JavaScript -->
                <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

                <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
                <!-- <link rel="stylesheet" href="/css/demo.css"> -->
            </head>

            <body>

                <div class="container mt-5">
                    <div class="row">
                        <div class="col-12 mx-auto">
                            <div class="d-flex justify-content-between">
                                <h3>User Detail With ID = ${user.id}</h3>
                            </div>
                            <hr />
                            <div class="d-flex justify-content-center">
                                <div class="card" style="width: 60%;">
                                    <img src="..." class="card-img-top" alt="...">
                                    <div class="card-body">
                                        <h5 class="card-title">User Information</h5>
                                        <p class="card-text">Some quick example text to build on the card title and make
                                            up
                                            the bulk of the card's content.</p>
                                    </div>
                                    <ul class="list-group list-group-flush">
                                        <li class="list-group-item">ID: ${user.id}</li>
                                        <li class="list-group-item">Email: ${user.email}</li>
                                        <li class="list-group-item">Full Name: ${user.fullName}</li>
                                        <li class="list-group-item">Address: ${user.address}</li>
                                    </ul>
                                    <div class="card-body">
                                        <a href="/admin/user" class="btn btn-success">Back</a>
                                        <a href="" class="card-link" style="margin-left: 2%;">Another link</a>
                                    </div>
                                </div>
                            </div>


                        </div>

                    </div>
                </div>


            </body>

            </html>