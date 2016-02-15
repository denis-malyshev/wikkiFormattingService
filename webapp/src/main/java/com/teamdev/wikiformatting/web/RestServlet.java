package com.teamdev.wikiformatting.web;

import com.google.gson.Gson;
import com.teamdev.wikiformatting.business.FormattingService;
import com.teamdev.wikiformatting.business.impl.FormattingServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class RestServlet extends HttpServlet {

    private FormattingService formattingService;

    @Override
    public void init() throws ServletException {
        formattingService = new FormattingServiceImpl();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("application/json;charset=UTF-8");
        resp.setHeader("success", "yes");

        final PrintWriter writer = resp.getWriter();
        final String inputData = requestToString(req);
        String json = toJson(new ResponseDTO(formattingService.wikiToHTML(inputData)));
        writer.append(json);
        writer.close();
    }

    private String toJson(ResponseDTO text) {
        Gson gson = new Gson();
        return gson.toJson(text);
    }

    private String requestToString(HttpServletRequest req) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream()));
        String data = "";
        if(br != null){
            data = br.readLine();
        }
        br.close();
        return data;
    }
}
