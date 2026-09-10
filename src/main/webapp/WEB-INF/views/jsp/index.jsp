<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>${title}</title>

    <style>
        body {
            margin: 0;
            font-family: Arial, sans-serif;
            background: #f5f7fa;
            color: #222;
        }

        .navbar {
            background: #212529;
            padding: 18px 40px;
        }

        .navbar a {
            color: white;
            text-decoration: none;
            font-size: 22px;
            font-weight: bold;
        }

        .hero {
            text-align: center;
            padding: 80px 20px;
            background: white;
        }

        .hero h1 {
            font-size: 48px;
            margin-bottom: 20px;
        }

        .hero p {
            font-size: 20px;
            color: #666;
        }

        .container {
            max-width: 1000px;
            margin: auto;
        }

        .info {
            text-align: center;
            padding: 50px 20px;
        }

        .info h2 {
            font-size: 30px;
        }

        .info h3 {
            color: #555;
            font-weight: normal;
        }

        footer {
            text-align: center;
            padding: 30px;
            border-top: 1px solid #ddd;
            color: #666;
        }
    </style>
</head>

<body>

<nav class="navbar">
    <div class="container">
        <a href="/">Java 21 Web Application first change done  </a>
    </div>
</nav>

<section class="hero">
    <div class="container">

        <h1>${title}</h1>

        <p>${msg}</p>

    </div>
</section>

<section class="info">
    <div class="container">

        <h2>Maven + Spring MVC + Java 21</h2>

        <h3>
            CI/CD deployment with Jenkins and Docker
        </h3>

    </div>
</section>

<footer>
    <p>&copy; 2026 Java Web Application</p>
</footer>

</body>
</html>
