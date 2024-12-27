<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
            <!DOCTYPE html>
            <html lang="en">

            <head>
                <meta charset="utf-8" />
                <meta http-equiv="X-UA-Compatible" content="IE=edge" />
                <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
                <meta name="description" content="" />
                <meta name="author" content="" />
                <title>Dashboard - Admin Laptopshop</title>
                <link href="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/style.min.css" rel="stylesheet" />
                <link href="\css\styles.css" rel="stylesheet" />
                <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>
                <!-- Latest compiled and minified CSS -->
                <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

                <!-- Latest compiled JavaScript -->
                <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

                <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
                <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
                    integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
                    crossorigin="anonymous">
                <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
                    integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
                    crossorigin="anonymous"></script>
                <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
                    integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
                    crossorigin="anonymous"></script>
                <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
                    integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
                    crossorigin="anonymous"></script>
                <script>
                    $(document).ready(() => {
                        const avatarFile = $("#avatarFile");
                        avatarFile.change(function (e) {
                            const imgURL = URL.createObjectURL(e.target.files[0]);
                            $("#avatarPreview").attr("src", imgURL);
                            $("#avatarPreview").css({ "display": "block" });
                        });
                    });  
                </script>
            </head>

            <body class="sb-nav-fixed">
                <jsp:include page="../layout/header.jsp" />
                <div id="layoutSidenav">
                    <jsp:include page="../layout/sidebar.jsp" />
                    <div id="layoutSidenav_content">
                        <main>
                            <div class="container-fluid px-4">
                                <h1 class="mt-4">Manage Products</h1>
                                <ol class="breadcrumb mb-4">
                                    <li class="breadcrumb-item"><a href="/admin"></a></li>
                                    <li class="breadcrumb-item active">Dashboard</li>
                                </ol>
                                <div class=" mt-5">
                                    <div class="row">
                                        <div class="col-md-6 col-12 mx-auto">
                                            <h3>Create a product</h3>
                                            <hr />
                                            <form:form method="post" action="/admin/product/create"
                                                modelAttribute="newProduct" class="row" enctype="multipart/form-data">

                                                <div class="mb-3 col-12 col-md-6">
                                                    <label class="form-label">Name:</label>
                                                    <form:input type="text" class="form-control" path="name" />
                                                </div>


                                                <div class=" input-group mb-3 col-12 col-md-6">
                                                    <label class="form-label">Price:</label>
                                                    <div class="input-group mb-3">
                                                        <div class="input-group-prepend">
                                                            <span class="input-group-text">$</span>
                                                            <span class="input-group-text">0.0</span>
                                                        </div>
                                                        <form:input type="number " class="form-control"
                                                            aria-label="Amount (to the nearest dollar)" path="price" />
                                                    </div>

                                                </div>



                                                <div class="mb-3 ">
                                                    <label class="form-label">Detail desciption:</label>
                                                    <form:textarea type="text" class="form-control" path="detailDesc"
                                                        rows="3" />
                                                </div>

                                                <div class="mb-3 col-12 col-md-6">
                                                    <label class="form-label">Short desciption:</label>
                                                    <form:input type="text" class="form-control" path="shortDesc" />
                                                </div>

                                                <div class="mb-3 col-12 col-md-6">
                                                    <label class="form-label">Quantity:</label>
                                                    <form:input type="number" class="form-control" path="quantity" />
                                                </div>

                                                <div class="mb-3 col-12 col-md-6">
                                                    <label class="form-label">Factory:</label>
                                                    <div class="input-group ">
                                                        <div class="input-group-prepend">
                                                            <label class="input-group-text"
                                                                for="inputGroupSelect01">Select:</label>
                                                        </div>

                                                        <form:select class="custom-select" id="inputGroupSelect01"
                                                            path="factory">
                                                            <form:option value="ASIA">Asia</form:option>
                                                            <form:option value="EUROPE">Europe</form:option>
                                                            <form:option value="NORTH-AMERICA">North America
                                                            </form:option>
                                                            <form:option value="CENTRAL-ASIA">Central Asia</form:option>
                                                            <form:option value="WESTERN-EUROPE">Western Europe
                                                            </form:option>
                                                            <form:option value="WORLDWIDE">Worldwide</form:option>
                                                            <form:option value="TROPICAL-REGIONS-WORLDWIDE">Tropical
                                                                regions worldwide</form:option>
                                                            <form:option value="MEDITERRANEAN">Mediterranean region
                                                            </form:option>
                                                            <form:option value="TROPICAL-REGIONS-WORLDWIDE">Tropical
                                                                regions worldwide</form:option>
                                                        </form:select>
                                                    </div>
                                                </div>

                                                <div class="mb-3 col-12 col-md-6">
                                                    <label class="form-label">Target:</label>
                                                    <div class="input-group ">
                                                        <div class="input-group-prepend">
                                                            <label class="input-group-text"
                                                                for="inputGroupSelect01">Select:</label>
                                                        </div>

                                                        <form:select class="custom-select" id="inputGroupSelect01"
                                                            path="target">
                                                            <form:option value="ROSE">Rose</form:option>
                                                            <form:option value="LILY">Lily</form:option>
                                                            <form:option value="TULIP">Tulip</form:option>
                                                            <form:option value="ORCHID">Orchid</form:option>
                                                            <form:option value="SUNFLOWER">Sunflower</form:option>
                                                            <form:option value="DAISY">Daisy</form:option>
                                                            <form:option value="JASMINE">Jasmine</form:option>
                                                            <form:option value="LAVENDER">Lavender</form:option>
                                                            <form:option value="HIBISCUS">Hibiscus</form:option>
                                                            <form:option value="MARIGOLD">Marigold</form:option>
                                                        </form:select>
                                                    </div>
                                                </div>

                                                <div class="mb-3 col-12 col-md-6">
                                                    <label class="form-label">Target:</label>
                                                    <div class="input-group">

                                                        <div class="custom-file">
                                                            <label class="custom-file-label"
                                                                for="avatarFile">Image:</label>
                                                            <input type="file" class="custom-file-input" id="avatarFile"
                                                                accept=".png, .jpg, .jpeg" name="hoidanitFile" />

                                                        </div>

                                                    </div>
                                                </div>



                                                <div class="col-12 mb-3">
                                                    <img style="max-height: 250px;display: none;" alt="avatar preview"
                                                        id="avatarPreview">
                                                </div>
                                                <div class="col-12 mb-5">
                                                    <button type="submit" class="btn btn-primary">Create</button>
                                                </div>
                                            </form:form>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </main>
                        <jsp:include page="../layout/footer.jsp" />
                    </div>
                </div>
                <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
                    crossorigin="anonymous"></script>
                <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js"
                    crossorigin="anonymous"></script>
                <script src="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/umd/simple-datatables.min.js"
                    crossorigin="anonymous"></script>
                <script src="js/script.js"></script>
            </body>

            </html>