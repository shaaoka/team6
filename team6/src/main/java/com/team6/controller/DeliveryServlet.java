package com.team6.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team6.DAO.DeliveryDao;
import com.team6.bean.DeliveryBean;


@WebServlet("/DeliveryServlet")
public class DeliveryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DeliveryServlet() {
		super();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		
		String id = request.getParameter("id");
		String cname = request.getParameter("cname");
		String product = request.getParameter("product");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		String price = request.getParameter("price");
		
		System.out.printf("id:%s,cname:%s,product:%s,address:%s,phone:%s,price:%s%n",id,cname,product,address,phone,price);
		
		DeliveryBean deliveryBean = new DeliveryBean();
		if(id != null) {
			deliveryBean.setId(Integer.parseInt(id));
		}
		deliveryBean.setCname(cname);
		deliveryBean.setPhone(phone);
		deliveryBean.setProduct(product);
		deliveryBean.setAddress(address);
		if (price != null) {
			deliveryBean.setPrice(Integer.parseInt(price));
		}
//		deliveryBean.setPrice(Integer.parseInt(price));
//		deliveryBean.setTime(Integer.parseInt(time));

		String message = request.getParameter("message");
		DeliveryDao deliveryDao = new DeliveryDao();

		switch (message) {

		case "ins": { 
			boolean isSccuess = deliveryDao.Insertd(deliveryBean);
			System.out.println(isSccuess);
			if (isSccuess) {
				request.getRequestDispatcher("/delivery/jsp/insert.jsp").forward(request, response);
			} else {
				request.getRequestDispatcher("/delivery/jsp/Error.jsp").forward(request, response);
			} 
			break;
		}
		
		case "upd": { 
			deliveryBean = deliveryDao.SelectOne(Integer.parseInt(id));
			request.setAttribute("deliveryBean", deliveryBean);
			request.getRequestDispatcher("/delivery/jsp/DoUpdate.jsp").forward(request, response);
			break;
		}
		
		case "Update": { 
			boolean isSccuess = deliveryDao.Update(deliveryBean);
			if(isSccuess) {
				request.getRequestDispatcher("/delivery/html/index.html").forward(request, response);
			} else {
				request.getRequestDispatcher("/delivery/jsp/Error.jsp").forward(request, response);
			}	
			break;
			
		}
		
		case "del": {	
			boolean isSccuess = deliveryDao.Deleted(Integer.parseInt(id));
			if (isSccuess) {
				List<DeliveryBean> deliveryBeans = deliveryDao.SelectAll();
				request.setAttribute("deliveryBeans", deliveryBeans);
				request.getRequestDispatcher("/delivery/jsp/GetAll.jsp").forward(request, response);
			} else {
				request.getRequestDispatcher("/delivery/jsp/Error.jsp").forward(request, response);
			}
			break;
		}
			
		case "Get": {
			List<DeliveryBean> deliveryBeans = deliveryDao.SelectAll();
			request.setAttribute("deliveryBeans", deliveryBeans);
			request.getRequestDispatcher("/delivery/jsp/GetAll.jsp").forward(request, response);
			break;
		}
		
		case "Getone": {
			System.out.println(id);
			if(id.equals("")) {
				request.getRequestDispatcher("/delivery/jsp/Fail.jsp").forward(request, response);
			} else {
				deliveryBean = deliveryDao.SelectOne(Integer.parseInt(id));
				request.setAttribute("deliveryBean", deliveryBean);
				request.getRequestDispatcher("/delivery/jsp/Getone.jsp").forward(request, response);			
				}
			break;
		}
		
		case "GetName": {
			List<DeliveryBean> deliveryBeans = deliveryDao.SelectName(cname);
			request.setAttribute("deliveryBeans", deliveryBeans);
			request.getRequestDispatcher("/delivery/jsp/GetAll.jsp").forward(request, response);
			break;
		}
		default :
			request.getRequestDispatcher("/delivery/jsp/Error.jsp").forward(request, response);
			break;
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}

