package com.sir.tech.bd.web;

import com.sir.tech.bd.dto.UserSignupDTO;
import com.sir.tech.bd.util.ValidationUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/signup")
public class Signup extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp)
            throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/signup.jsp");
        rd.forward(req,resp);
    }
    @Override
    protected void doPost(HttpServletRequest req,
                          HttpServletResponse resp)
            throws ServletException, IOException {

        UserSignupDTO userSignupDTO = Copy(req);
        var errors = ValidationUtil.getInstance().validate(userSignupDTO);
        if (errors.isEmpty()) {
            resp.sendRedirect("/home");
        } else {
            req.setAttribute("errors", errors);
            req.setAttribute("userSignupDTO", userSignupDTO);
            req.getRequestDispatcher("/WEB-INF/signup.jsp")
                    .forward(req, resp);
        }
    }

    // Coping all Input field's values to the UserSignupDTO
    private UserSignupDTO Copy(HttpServletRequest req) {
        UserSignupDTO userSignupDTO = new UserSignupDTO();
        userSignupDTO.setFirstName(req.getParameter("firstName"));
        userSignupDTO.setLastName(req.getParameter("lastName"));
        userSignupDTO.setEmail(req.getParameter("email"));
        userSignupDTO.setUsername(req.getParameter("username"));
        userSignupDTO.setPassword(req.getParameter("password"));
        userSignupDTO.setConfirmPassword(req.getParameter("confirmPassword"));

        return userSignupDTO;
    }
}
