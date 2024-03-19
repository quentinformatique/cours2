<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Boutique en ligne</h1>
<fieldset>
    <legend>
        Connexion
    </legend>
    <form action="client" method="post">
        <label for="login">Login</label>
        <input type="text" id="login" name="login" required>
        <label for="password">Mot de passe</label>
        <input type="password" id="password" name="password" required>
        <input type="submit" name="action" value="Se connecter">
        <input type="submit" name="action" value="S'inscrire">
    </form>
</fieldset>

<!-- Use the Boutique JavaBean -->
<jsp:useBean id="boutique" class="javabeans.Boutique" scope="application" />

</body>
</html>