package bsu.suzdalev.lab8.servlet;


import bsu.suzdalev.lab8.entity.ChatMessage;
import bsu.suzdalev.lab8.entity.ChatUser;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;


public class ChatServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    // Карта текущих пользователей
    protected HashMap<String, ChatUser> activeUsers;
    // Список сообщений чата
    protected ArrayList<ChatMessage> messages;

    protected static boolean messages_blocked;
    protected static long messages_unblock_time;

    @SuppressWarnings("unchecked")
    public void init() throws ServletException {
        // Вызвать унаследованную от HttpServlet версию init()
        super.init();
        messages_blocked = false;
        messages_unblock_time = Calendar.getInstance().getTimeInMillis();
        // Извлечь из контекста карту пользователей и список сообщений
        activeUsers = (HashMap<String, ChatUser>) getServletContext().getAttribute("activeUsers");
        messages = (ArrayList<ChatMessage>) getServletContext().getAttribute("messages");
        // Если карта пользователей не определена ...
        if (activeUsers == null) {
            // Создать новую карту
            activeUsers = new HashMap<String, ChatUser>();
            // Поместить её в контекст сервлета, чтобы другие сервлеты могли до него добраться
            getServletContext().setAttribute("activeUsers", activeUsers);
        }
        // Если список сообщений не определён ...
        if (messages == null) {
            // Создать новый список
            messages = new ArrayList<ChatMessage>(100);
            // Поместить его в контекст сервлета, чтобы другие сервлеты могли до него добрать
            getServletContext().setAttribute("messages", messages);
        }
    }
}
