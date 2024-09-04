package com.test.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.web.service.CarService;
import com.test.web.util.CmdUtil;
import com.test.web.vo.CarVO;


public class CarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CarService cs = new CarService();
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		String cmd = CmdUtil.getCmd(uri);
		
		if("car-list".equals(cmd)) {
			List<CarVO> cars = cs.selectCars();
			request.setAttribute("cars", cars);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views" + uri + ".jsp");
			rd.forward(request, response);
		}else if("car-view".equals(cmd) || "car-update".equals(cmd)){
			String ciNumStr = request.getParameter("ciNum");
			int ciNum = Integer.parseInt(ciNumStr);
			//int ciNum = Integer.parsInt(request.getParameter("ciNum"));
			CarVO car = cs.selectCar(ciNum);
			request.setAttribute("car", car);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views" + uri + ".jsp");
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String uri = request.getRequestURI();
		String cmd = CmdUtil.getCmd(uri);
		CarVO car = new CarVO();
		car.setCiName(request.getParameter("ciName"));
		car.setCiYear(request.getParameter("ciYear"));
		if("car-insert".equals(cmd)) {
			int result = cs.insertCar(car);
			String msg = "차량등록에 실패했습니다";
			String url = "/views/car/car-insert";
			if(result==1) {
				msg="차량등록에 성공했습니다";
				url="/car/car-list";
			}
			request.setAttribute("msg", msg);
			request.setAttribute("url", url);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
			rd.forward(request, response);
			return; 
		}else if("car-update".equals(cmd)) {
			String ciNumStr = request.getParameter("ciNum");
			int ciNum = Integer.parseInt(ciNumStr);
			car.setCiNum(ciNum);
			int result = cs.updateCar(car);
			String msg = "차량수정이 실패했습니다";
			String url = "/views/car/car-update?ciNum=" + ciNum;
			if(result==1) {
				msg="차량수정에 성공했습니다";
				url="/car/car-view?ciNum=" + ciNum;
			}
			request.setAttribute("msg", msg);
			request.setAttribute("url", url);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
			rd.forward(request, response);
			return; 
		}else if("car-delete".equals(cmd)) {
			String ciNumStr = request.getParameter("ciNum");
			int ciNum = Integer.parseInt(ciNumStr);
			car.setCiNum(ciNum);
			int result = cs.deleteCar(ciNum);
			String msg = "차량삭제가 실패했습니다";
			String url = "/views/car/car-view?ciNum=" + ciNum;
			if(result==1) {
				msg="차량삭제에 성공했습니다";
				url="/car/car-list";
			}
			request.setAttribute("msg", msg);
			request.setAttribute("url", url);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
			rd.forward(request, response);
			return; 
		}
		
	}

}
