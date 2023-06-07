package com.example.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;

import com.example.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/users")
public class GetUsersServlet extends HttpServlet{

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Warehouse wr = Warehouse.getInstance();
        Set<User> peoples = wr.getUsers();
        req.setAttribute("users", peoples);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("jsp/users.jsp");
        requestDispatcher.forward(req, resp);
    }
}
