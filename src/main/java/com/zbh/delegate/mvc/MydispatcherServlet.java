package com.zbh.delegate.mvc;

import com.zbh.delegate.mvc.controller.MemberController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class MydispatcherServlet extends HttpServlet {

    private List<Handler> handlerList = new ArrayList<Handler>();

    @Override
    public void init() throws ServletException {
        Class<?> memberController = MemberController.class;
        try {
            handlerList.add(new Handler().setController(memberController.newInstance())
            .setMethod(memberController.getMethod("getMemberById", new Class[]{String.class}))
            .setUrl("/web/getMemberById.json"));
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //他去完成调度
        doDispach(req,resp);
    }

    //策略模式的基本应用，把url跟method以及controller的对应关系放在一个handlermapping里面
    //用户去获得url之后就可以直接去handlermapping里面取值，就不需要像原来一样if else去判断了
    private void doDispach(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String uri = req.getRequestURI();
        Handler handler = null;
        for (Handler h: handlerList) {
            if(uri.equals(h.getUrl())){
                handler=h;
                break;
            }
        }
        try {
            Object obj =handler.getMethod().invoke(handler.getController(),req.getParameter("mid"));
            resp.getWriter().write(obj.toString());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    class Handler{
        private Object controller;
        private Method method;
        private String url;

        public Object getController() {
            return controller;
        }

        public Handler setController(Object controller) {
            this.controller = controller;
            return this;
        }

        public Method getMethod() {
            return method;
        }

        public Handler setMethod(Method method) {
            this.method = method;
            return this;
        }

        public String getUrl() {
            return url;
        }

        public Handler setUrl(String url) {
            this.url = url;
            return this;
        }
    }
}
