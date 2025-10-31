<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <!DOCTYPE html>
        <html lang="en">

        <head>
            <meta charset="utf-8" />
            <meta http-equiv="X-UA-Compatible" content="IE=edge" />
            <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
            <meta name="description" content="Phạm Lâm - Dự án laptopshop" />
            <meta name="author" content="Phạm Lâm" />
            <title>Dashboard - Phạm Lâm</title>
            <link href="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/style.min.css" rel="stylesheet" />
            <link href="css/styles.css" rel="stylesheet" />
            <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>
        </head>

        <body class="sb-nav-fixed">
            <jsp:include page="../layout/header.jsp" />
            <div id="layoutSidenav">
                <jsp:include page="../layout/sidebar.jsp" />
                <div id="layoutSidenav_content">
                    <main>
                        <div class="container-fluid px-4">
                            <h1 class="mt-4">Dashboard</h1>
                            <ol class="breadcrumb mb-4">
                                <li class="breadcrumb-item active">Dashboard</li>
                            </ol>
                            <div class="row">
                                <div class="col-xl-3 col-md-6">
                                    <div class="card bg-primary text-white mb-4">
                                        <div class="card-body">Primary Card</div>
                                        <div class="card-footer d-flex align-items-center justify-content-between">
                                            <a class="small text-white stretched-link" href="#">View Details</a>
                                            <div class="small text-white"><i class="fas fa-angle-right"></i></div>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-xl-3 col-md-6">
                                    <div class="card bg-warning text-white mb-4">
                                        <div class="card-body">Warning Card</div>
                                        <div class="card-footer d-flex align-items-center justify-content-between">
                                            <a class="small text-white stretched-link" href="#">View Details</a>
                                            <div class="small text-white"><i class="fas fa-angle-right"></i></div>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-xl-3 col-md-6">
                                    <div class="card bg-success text-white mb-4">
                                        <div class="card-body">Success Card</div>
                                        <div class="card-footer d-flex align-items-center justify-content-between">
                                            <a class="small text-white stretched-link" href="#">View Details</a>
                                            <div class="small text-white"><i class="fas fa-angle-right"></i></div>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-xl-3 col-md-6">
                                    <div class="card bg-danger text-white mb-4">
                                        <div class="card-body">Danger Card</div>
                                        <div class="card-footer d-flex align-items-center justify-content-between">
                                            <a class="small text-white stretched-link" href="#">View Details</a>
                                            <div class="small text-white"><i class="fas fa-angle-right"></i></div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-xl-6">
                                    <div class="card mb-4">
                                        <div class="card-header">
                                            <i class="fas fa-chart-area me-1"></i>
                                            Area Chart Example
                                        </div>
                                        <div class="card-body"><canvas id="myAreaChart" width="100%"
                                                height="40"></canvas></div>
                                    </div>
                                </div>
                                <div class="col-xl-6">
                                    <div class="card mb-4">
                                        <div class="card-header">
                                            <i class="fas fa-chart-bar me-1"></i>
                                            Bar Chart Example
                                        </div>
                                        <div class="card-body"><canvas id="myBarChart" width="100%"
                                                height="40"></canvas></div>
                                    </div>
                                </div>
                            </div>
                            <div class="card mb-4">
                                <div class="card-header">
                                    <i class="fas fa-table me-1"></i>
                                    Danh sách sản phẩm
                                </div>
                                <div class="card-body">
                                    <table id="datatablesSimple">
                                        <thead>
                                            <tr>
                                                <th>Tên sản phẩm</th>
                                                <th>Hãng</th>
                                                <th>Danh mục</th>
                                                <th>Số lượng</th>
                                                <th>Ngày thêm</th>
                                                <th>Giá (VNĐ)</th>
                                            </tr>
                                        </thead>
                                        <tfoot>
                                            <tr>
                                                <th>Tên sản phẩm</th>
                                                <th>Hãng</th>
                                                <th>Danh mục</th>
                                                <th>Số lượng</th>
                                                <th>Ngày thêm</th>
                                                <th>Giá (VNĐ)</th>
                                            </tr>
                                        </tfoot>
                                        <tbody>
                                            <tr>
                                                <td>Asus TUF Gaming F15</td>
                                                <td>Asus</td>
                                                <td>Laptop Gaming</td>
                                                <td>12</td>
                                                <td>2024/03/15</td>
                                                <td>25,900,000</td>
                                            </tr>
                                            <tr>
                                                <td>MacBook Air M2</td>
                                                <td>Apple</td>
                                                <td>Ultrabook</td>
                                                <td>8</td>
                                                <td>2024/05/10</td>
                                                <td>31,500,000</td>
                                            </tr>
                                            <tr>
                                                <td>Dell XPS 13</td>
                                                <td>Dell</td>
                                                <td>Văn phòng</td>
                                                <td>5</td>
                                                <td>2024/02/08</td>
                                                <td>29,900,000</td>
                                            </tr>
                                            <tr>
                                                <td>HP Victus 16</td>
                                                <td>HP</td>
                                                <td>Laptop Gaming</td>
                                                <td>10</td>
                                                <td>2024/04/02</td>
                                                <td>22,800,000</td>
                                            </tr>
                                            <tr>
                                                <td>Lenovo IdeaPad 5</td>
                                                <td>Lenovo</td>
                                                <td>Văn phòng</td>
                                                <td>15</td>
                                                <td>2024/01/12</td>
                                                <td>17,900,000</td>
                                            </tr>
                                            <tr>
                                                <td>Acer Nitro 5</td>
                                                <td>Acer</td>
                                                <td>Laptop Gaming</td>
                                                <td>9</td>
                                                <td>2024/03/20</td>
                                                <td>23,500,000</td>
                                            </tr>
                                            <tr>
                                                <td>MSI Modern 14</td>
                                                <td>MSI</td>
                                                <td>Học tập - Văn phòng</td>
                                                <td>7</td>
                                                <td>2024/02/25</td>
                                                <td>16,700,000</td>
                                            </tr>
                                            <tr>
                                                <td>Gigabyte G5 GE</td>
                                                <td>Gigabyte</td>
                                                <td>Laptop Gaming</td>
                                                <td>6</td>
                                                <td>2024/06/01</td>
                                                <td>24,200,000</td>
                                            </tr>
                                            <tr>
                                                <td>Asus ZenBook 14 OLED</td>
                                                <td>Asus</td>
                                                <td>Ultrabook</td>
                                                <td>11</td>
                                                <td>2024/04/12</td>
                                                <td>28,900,000</td>
                                            </tr>
                                            <tr>
                                                <td>HP Pavilion 15</td>
                                                <td>HP</td>
                                                <td>Văn phòng</td>
                                                <td>14</td>
                                                <td>2024/05/20</td>
                                                <td>18,500,000</td>
                                            </tr>
                                            <tr>
                                                <td>Dell Inspiron 15 3520</td>
                                                <td>Dell</td>
                                                <td>Học tập - Văn phòng</td>
                                                <td>20</td>
                                                <td>2024/03/05</td>
                                                <td>15,900,000</td>
                                            </tr>
                                            <tr>
                                                <td>Apple MacBook Pro M3</td>
                                                <td>Apple</td>
                                                <td>Ultrabook</td>
                                                <td>5</td>
                                                <td>2024/07/14</td>
                                                <td>42,500,000</td>
                                            </tr>
                                            <tr>
                                                <td>Acer Aspire 7</td>
                                                <td>Acer</td>
                                                <td>Laptop Gaming</td>
                                                <td>9</td>
                                                <td>2024/02/28</td>
                                                <td>21,700,000</td>
                                            </tr>
                                            <tr>
                                                <td>MSI Katana 15</td>
                                                <td>MSI</td>
                                                <td>Laptop Gaming</td>
                                                <td>8</td>
                                                <td>2024/06/08</td>
                                                <td>26,300,000</td>
                                            </tr>
                                            <tr>
                                                <td>Lenovo Legion 5 Pro</td>
                                                <td>Lenovo</td>
                                                <td>Laptop Gaming</td>
                                                <td>6</td>
                                                <td>2024/04/25</td>
                                                <td>32,900,000</td>
                                            </tr>
                                            <tr>
                                                <td>HP Envy x360</td>
                                                <td>HP</td>
                                                <td>Ultrabook</td>
                                                <td>10</td>
                                                <td>2024/01/30</td>
                                                <td>27,600,000</td>
                                            </tr>
                                            <tr>
                                                <td>Asus VivoBook 15</td>
                                                <td>Asus</td>
                                                <td>Học tập - Văn phòng</td>
                                                <td>18</td>
                                                <td>2024/05/18</td>
                                                <td>16,200,000</td>
                                            </tr>
                                            <tr>
                                                <td>Razer Blade 15</td>
                                                <td>Razer</td>
                                                <td>Laptop Gaming</td>
                                                <td>3</td>
                                                <td>2024/03/14</td>
                                                <td>58,900,000</td>
                                            </tr>
                                            <tr>
                                                <td>Dell G15 5530</td>
                                                <td>Dell</td>
                                                <td>Laptop Gaming</td>
                                                <td>7</td>
                                                <td>2024/06/10</td>
                                                <td>25,400,000</td>
                                            </tr>
                                            <tr>
                                                <td>Acer Swift 3</td>
                                                <td>Acer</td>
                                                <td>Ultrabook</td>
                                                <td>12</td>
                                                <td>2024/05/11</td>
                                                <td>19,500,000</td>
                                            </tr>
                                            <tr>
                                                <td>MSI Prestige 14</td>
                                                <td>MSI</td>
                                                <td>Ultrabook</td>
                                                <td>8</td>
                                                <td>2024/02/18</td>
                                                <td>30,100,000</td>
                                            </tr>
                                            <tr>
                                                <td>Gigabyte Aorus 17</td>
                                                <td>Gigabyte</td>
                                                <td>Laptop Gaming</td>
                                                <td>4</td>
                                                <td>2024/04/29</td>
                                                <td>45,900,000</td>
                                            </tr>
                                            <tr>
                                                <td>Lenovo ThinkPad X1 Carbon</td>
                                                <td>Lenovo</td>
                                                <td>Doanh nhân</td>
                                                <td>9</td>
                                                <td>2024/03/09</td>
                                                <td>38,800,000</td>
                                            </tr>
                                            <tr>
                                                <td>HP Omen 16</td>
                                                <td>HP</td>
                                                <td>Laptop Gaming</td>
                                                <td>10</td>
                                                <td>2024/07/01</td>
                                                <td>29,700,000</td>
                                            </tr>
                                            <tr>
                                                <td>Asus ROG Zephyrus G14</td>
                                                <td>Asus</td>
                                                <td>Laptop Gaming</td>
                                                <td>5</td>
                                                <td>2024/02/10</td>
                                                <td>39,900,000</td>
                                            </tr>
                                            <tr>
                                                <td>Apple MacBook Air M3</td>
                                                <td>Apple</td>
                                                <td>Ultrabook</td>
                                                <td>6</td>
                                                <td>2024/06/24</td>
                                                <td>33,500,000</td>
                                            </tr>
                                            <tr>
                                                <td>Dell Latitude 7440</td>
                                                <td>Dell</td>
                                                <td>Doanh nhân</td>
                                                <td>11</td>
                                                <td>2024/05/05</td>
                                                <td>34,600,000</td>
                                            </tr>
                                            <tr>
                                                <td>Acer Predator Helios 300</td>
                                                <td>Acer</td>
                                                <td>Laptop Gaming</td>
                                                <td>6</td>
                                                <td>2024/03/12</td>
                                                <td>37,900,000</td>
                                            </tr>
                                            <tr>
                                                <td>MSI Bravo 15</td>
                                                <td>MSI</td>
                                                <td>Laptop Gaming</td>
                                                <td>9</td>
                                                <td>2024/02/27</td>
                                                <td>22,200,000</td>
                                            </tr>
                                            <tr>
                                                <td>HP Spectre x360</td>
                                                <td>HP</td>
                                                <td>Ultrabook</td>
                                                <td>4</td>
                                                <td>2024/05/17</td>
                                                <td>41,800,000</td>
                                            </tr>
                                            <tr>
                                                <td>Asus ExpertBook B5</td>
                                                <td>Asus</td>
                                                <td>Doanh nhân</td>
                                                <td>10</td>
                                                <td>2024/04/10</td>
                                                <td>27,900,000</td>
                                            </tr>
                                            <tr>
                                                <td>Lenovo Yoga 7i</td>
                                                <td>Lenovo</td>
                                                <td>Ultrabook</td>
                                                <td>9</td>
                                                <td>2024/06/13</td>
                                                <td>24,600,000</td>
                                            </tr>
                                            <tr>
                                                <td>Apple MacBook Pro M1</td>
                                                <td>Apple</td>
                                                <td>Ultrabook</td>
                                                <td>7</td>
                                                <td>2024/02/03</td>
                                                <td>35,000,000</td>
                                            </tr>
                                            <tr>
                                                <td>Dell Vostro 14</td>
                                                <td>Dell</td>
                                                <td>Học tập - Văn phòng</td>
                                                <td>18</td>
                                                <td>2024/03/19</td>
                                                <td>14,900,000</td>
                                            </tr>
                                            <tr>
                                                <td>Acer Aspire 3</td>
                                                <td>Acer</td>
                                                <td>Học tập - Văn phòng</td>
                                                <td>22</td>
                                                <td>2024/04/27</td>
                                                <td>13,700,000</td>
                                            </tr>
                                            <tr>
                                                <td>MSI Stealth 16</td>
                                                <td>MSI</td>
                                                <td>Laptop Gaming</td>
                                                <td>5</td>
                                                <td>2024/07/19</td>
                                                <td>43,200,000</td>
                                            </tr>
                                            <tr>
                                                <td>HP EliteBook 840</td>
                                                <td>HP</td>
                                                <td>Doanh nhân</td>
                                                <td>8</td>
                                                <td>2024/03/28</td>
                                                <td>29,400,000</td>
                                            </tr>
                                            <tr>
                                                <td>Lenovo LOQ 15</td>
                                                <td>Lenovo</td>
                                                <td>Laptop Gaming</td>
                                                <td>7</td>
                                                <td>2024/04/08</td>
                                                <td>26,500,000</td>
                                            </tr>
                                            <tr>
                                                <td>Asus ProArt StudioBook 16</td>
                                                <td>Asus</td>
                                                <td>Đồ họa - Thiết kế</td>
                                                <td>4</td>
                                                <td>2024/05/09</td>
                                                <td>49,800,000</td>
                                            </tr>
                                            <tr>
                                                <td>Dell Precision 3581</td>
                                                <td>Dell</td>
                                                <td>Đồ họa - Thiết kế</td>
                                                <td>6</td>
                                                <td>2024/06/22</td>
                                                <td>47,600,000</td>
                                            </tr>
                                            <tr>
                                                <td>Acer Extensa 15</td>
                                                <td>Acer</td>
                                                <td>Học tập - Văn phòng</td>
                                                <td>25</td>
                                                <td>2024/01/22</td>
                                                <td>12,900,000</td>
                                            </tr>
                                            <tr>
                                                <td>MSI Creator Z16</td>
                                                <td>MSI</td>
                                                <td>Đồ họa - Thiết kế</td>
                                                <td>5</td>
                                                <td>2024/03/30</td>
                                                <td>55,700,000</td>
                                            </tr>
                                            <tr>
                                                <td>HP Laptop 240 G9</td>
                                                <td>HP</td>
                                                <td>Học tập - Văn phòng</td>
                                                <td>17</td>
                                                <td>2024/05/14</td>
                                                <td>13,200,000</td>
                                            </tr>
                                            <tr>
                                                <td>Apple MacBook Air M1</td>
                                                <td>Apple</td>
                                                <td>Ultrabook</td>
                                                <td>9</td>
                                                <td>2024/02/12</td>
                                                <td>26,900,000</td>
                                            </tr>
                                            <tr>
                                                <td>Gigabyte Aero 16</td>
                                                <td>Gigabyte</td>
                                                <td>Đồ họa - Thiết kế</td>
                                                <td>3</td>
                                                <td>2024/06/04</td>
                                                <td>46,500,000</td>
                                            </tr>
                                            <tr>
                                                <td>Lenovo ThinkBook 14</td>
                                                <td>Lenovo</td>
                                                <td>Học tập - Văn phòng</td>
                                                <td>16</td>
                                                <td>2024/05/01</td>
                                                <td>15,700,000</td>
                                            </tr>

                                        </tbody>
                                    </table>
                                </div>
                            </div>

                        </div>
                    </main>
                    <jsp:include page="../layout/footer.jsp" />
                </div>
            </div>
            <script src="<c:url value='/resources/js/scripts.js' />"></script>
            <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js"
                crossorigin="anonymous"></script>
            <script src="<c:url value='/resources/js/chart-area-demo.js' />"></script>
            <script src="<c:url value='/resources/js/chart-bar-demo.js' />"></script>
            <script src="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/umd/simple-datatables.min.js"
                crossorigin="anonymous"></script>
            <script src="<c:url value='/resources/js/datatables-simple-demo.js' />"></script>

        </body>

        </html>