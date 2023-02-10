package com.example.API_InterceptorMiddleware02.interceptors;

import com.example.API_InterceptorMiddleware02.entities.Month;
import io.micrometer.common.lang.Nullable;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
public class MonthInterceptor implements HandlerInterceptor {

    public static List<Month> months = new ArrayList<>(Arrays.asList(
            new Month(1, "January", "Gennaio","Januar"),
            new Month(2, "February", "Febbraio","Februar"),
            new Month(3, "March", "Marzo","Marsch"),
            new Month(4, "April", "Aprile","April"),
            new Month(5, "May", "Maggio","Dürfen"),
            new Month(6, "June", "Giugno","Juni")
    ));

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String monthNumStr = request.getHeader("monthNumber");

        if (monthNumStr == null) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return false;
        }
        long monthNum = Long.parseLong(monthNumStr);
        Optional<Month> month = months.stream().filter(singleMonth ->{
            return singleMonth.getMonthNumber() == monthNum;
        }).findFirst();

        if (month.isPresent()){
            request.setAttribute("month", month.get());

        }
        response.setStatus(HttpServletResponse.SC_OK);

        return true;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
    }
}
