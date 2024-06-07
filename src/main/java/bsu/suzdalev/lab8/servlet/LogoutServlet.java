package bsu.suzdalev.lab8.servlet;

import java.io.IOException;


import bsu.suzdalev.lab8.entity.ChatUser;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LogoutServlet extends ChatServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse
            response) throws ServletException, IOException {
        String name = (String) request.getSession().getAttribute("name");
        // Если в сессии имеется имя пользователя...
        if (name!=null) {
            // Получить объект, описывающий пользователя с таким именем
            ChatUser aUser = activeUsers.get(name);
            // Если идентификатор сессии пользователя, вошедшего под
            // этим именем, совпадает с идентификатором сессии
            // пользователя, пытающегося выйти из чата
            // (т.е. выходит тот же, кто и входил)
            if (aUser.getSessionId().equals((String) request.getSession().getId())) {
                // Удалить пользователя из списка активных
                // Т.к. запросы обрабатываются одновременно,
                // нужна синхронизация
                synchronized (activeUsers) {
                    activeUsers.remove(name);
                }
                // Сбросить имя пользователя в сессии
                request.getSession().setAttribute("name", null);
                // Сбросить ID сессии в cookie
                response.addCookie(new Cookie("sessionId", null));
                // Перенаправить на главную страницу
                response.sendRedirect(response.encodeRedirectURL("/lab8_war_exploded/"));
            } else {
                // Пользователь пытается аннулировать чужую сессию –
                // не делать ничего
                response.sendRedirect(response.encodeRedirectURL("/lab8_war_exploded/view.html"));
            }
        } else {
            // Перенаправить пользователя на главное окно чата
            response.sendRedirect(response.encodeRedirectURL("/lab8_war_exploded/view.html"));
        }
    }
}