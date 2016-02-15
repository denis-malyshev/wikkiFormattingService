package com.teamdev.wikiformatting.web;

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

import static com.teamdev.wikiformatting.business.utils.JsonHelper.fromJson;
import static com.teamdev.wikiformatting.business.utils.JsonHelper.toJson;

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
        final String inputJson = requestToString(req);

        RequestDTO requestDTO = fromJson(inputJson, RequestDTO.class);
        String json = toJson(new RequestDTO(formattingService.wikiToHTML(requestDTO.text)));
        writer.append(json);
        writer.close();
    }


    private String requestToString(HttpServletRequest req) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream()));
        String data;
        data = br.readLine();
        br.close();
        return data;
    }
}
