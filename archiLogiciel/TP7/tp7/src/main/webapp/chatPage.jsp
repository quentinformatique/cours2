<%@ page import="but2.s4.tp7.engine.ChatRoom" %><%--
  Created by IntelliJ IDEA.
  User: jonathan
  Date: 06/03/2024
  Time: 16:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Salle de discussion — ChatRoom</title>

    <link rel="stylesheet" href="src/css/accueil.css" />
</head>
<body>

<div class="container">
    <fieldset>
        <legend>
            Salle de discussion
        </legend>

        <p>
            <strong>
                Pseudo :
            </strong>

            <%= session.getAttribute("nickname") %>
        </p>

        <p>
            <strong>
                Messages déposés :
            </strong>
        </p>

        <textarea name="sent_messages" id="sent_messages" cols="30" rows="10"><%= ChatRoom.getMessages() %></textarea>

        <p>
            <strong>
                Message à envoyer :
            </strong>
        </p>

        <form action="" method="post">
            <input type="text" name="new_message" id="new_message" />

            <button type="submit">
                Envoyer
            </button>
        </form>

        <div class="buttons">
            <button type="button">
                Rafraîchir
            </button>

            <button type="button">
                Se déconnecter
            </button>
        </div>
    </fieldset>
</div>

</body>
</html>
