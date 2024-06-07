package bsu.suzdalev.lab8.servlet;

import bsu.suzdalev.lab8.entity.ChatMessage;
import bsu.suzdalev.lab8.entity.ChatUser;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Calendar;

public class BlockMessagesServlet extends ChatServlet{

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse
            response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String block_duration = (String)request.getParameter("block_duration");
        if (block_duration!=null && !"".equals(block_duration)) {
            ChatUser author = activeUsers.get((String) request.getSession().getAttribute("name"));
            if (author.isModerator() && !messages_blocked) {
                synchronized (messages) {
                    messages.add(new ChatMessage("/-----/ Сообщения заблокированы модератором на "
                            + block_duration + " с /-----/",
                            new ChatUser("Chat", Calendar.getInstance().getTimeInMillis(), "0"),
                            Calendar.getInstance().getTimeInMillis()));
                    messages_blocked = true;
                    messages_unblock_time = Calendar.getInstance().getTimeInMillis() + Long.parseLong(block_duration) * 1000;
                }
            }
        }
        response.sendRedirect("/lab8_war_exploded/block_messages.html");
    }
}
