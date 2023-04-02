<!DOCTYPE html>
<html lang="">
<head>
    <meta charset="UTF-8">
    <title>Movie Chat Room</title>
</head>
<body>
<h1>${film.name}</h1>

<div id="chat-messages" align="center">
    <table id="message-list" border="1" cellpadding="5">
        <#list messages as message>
            <tr>
                <td>${message.author}: ${message.content}</td>
            </tr>
        </#list>
    </table>
</div>

<div id="chat-form" align="center">
    <form>
        <label for="message-text"></label>
        <input type="text" id="message-text" name="message" placeholder="Placeholder"> <button type="submit">Send</button>
    </form>
</div>

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-ui-bootstrap/0.5pre/assets/css/bootstrap.min.css"/>
<script src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.6.1/sockjs.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.min.js"></script>
<script>
    let stompClient = null;
    const userId = getCookie('userId');

    function connect() {
        const socket = new SockJS('/films/${film.id}/chat');
        stompClient = Stomp.over(socket);
        stompClient.connect({}, function(frame) {
            console.log('Connected: ' + frame);
            stompClient.subscribe('/films/${film.id}/chat/messages', function(message) {
                console.log('Message Received: ' + message.body);
                updateChat(JSON.parse(message.body));
            });
        });
    }

    function updateChat(message) {
        const chatMessages = document.getElementById('message-list');
        const newMessage = document.createElement('tr');
        newMessage.textContent = message.author + ': ' + message.content;
        chatMessages.appendChild(newMessage);
    }

    function sendMessage() {
        const messageInput = document.getElementById('message-text');
        const message = messageInput.value;
        stompClient.send("/app/films/${film.id}/chat/messages", {}, JSON.stringify({author: userId, content: message}));
        messageInput.value = '';
    }

    connect();

    const chatForm = document.getElementById('chat-form');
    chatForm.addEventListener('submit', function(event) {
        event.preventDefault();
        sendMessage();
    });

    function getCookie(name) {
        const cookies = document.cookie.split(';');
        for (let i = 0; i < cookies.length; i++) {
            const cookie = cookies[i].trim();
            if (cookie.indexOf(name + '=') === 0) {
                return cookie.substring(name.length + 1);
            }
        }
        return null;
    }
</script>
</body>
</html>