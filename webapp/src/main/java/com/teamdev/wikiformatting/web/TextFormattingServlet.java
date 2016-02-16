package com.teamdev.wikiformatting.web;

import com.teamdev.wikiformatting.business.TextFormattingService;
import com.teamdev.wikiformatting.business.impl.WikiTextFormattingService;
import com.teamdev.wikkiformatting.web.dto.RequestDTO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Enumeration;

import static com.teamdev.wikiformatting.web.utils.JsonHelper.fromJson;
import static com.teamdev.wikiformatting.web.utils.JsonHelper.toJson;

public class TextFormattingServlet extends HttpServlet {

    private final TextFormattingService textFormattingService = new WikiTextFormattingService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("application/json;charset=UTF-8");
        resp.setHeader("success", "yes");

        final PrintWriter writer = resp.getWriter();
        final String inputJson = requestToString(req);

        final RequestDTO requestDTO = fromJson(inputJson, RequestDTO.class);
        final String json = toJson(new RequestDTO(textFormattingService.format(requestDTO.text)));
        writer.append(json);
        writer.close();
    }


    private String requestToString(HttpServletRequest req) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream()));
        final String data = br.readLine();
        br.close();
        return data;
    }
}
