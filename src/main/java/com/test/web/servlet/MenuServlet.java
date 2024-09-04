package com.test.web.servlet;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.test.web.service.MenuService;
import com.test.web.util.CmdUtil;
import com.test.web.vo.MenuVO;

public class MenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MenuService ms = new MenuService();
	
	private static final String UPLOAD_PATH ="C:\\div\\workspace\\web-test2\\src\\main\\webapp\\upload\\";
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*menu-list, menu-view, menu-update*/
		
		String uri = request.getRequestURI();
		String cmd = CmdUtil.getCmd(uri);
		
		if("menu-list".equals(cmd)) {
			List<MenuVO> menus = ms.selectMenus();
			request.setAttribute("menus", menus);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views" + uri + ".jsp");
			rd.forward(request, response);
		}else if("menu-view".equals(cmd) || "menu-update".equals(cmd)) {
			int miNum = Integer.parseInt(request.getParameter("miNum"));
			MenuVO menu = ms.selectMenu(miNum);
			request.setAttribute("menu", menu);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views" + uri + ".jsp");
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
//		String uri = request.getRequestURI();
//		String cmd = CmdUtil.getCmd(uri);
//		MenuVO menu = new MenuVO();
//		menu.setMiName(request.getParameter("miName"));
//		String miPriceStr = request.getParameter("miPrice");
//		int miPrice = Integer.parseInt(miPriceStr);
//		menu.setMiPrice(miPrice);
//		menu.setMiDesc(request.getParameter("miDesc"));
//		if("menu-insert".equals(cmd)) {
//			int result = ms.insertMenu(menu);
//			String msg = "메뉴 등록에 실패했습니다";
//			String url = "/views/menu/menu-insert";
//			if(result==1) {
//				msg = "메뉴 등록에 성공했습니다";
//				url = "/menu/menu-list";
//			}
//			request.setAttribute("msg", msg);
//			request.setAttribute("url", url);
//			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
//			rd.forward(request, response);
//			return;
//		}else if("menu-update".equals(cmd)) {
//			int miNum = Integer.parseInt(request.getParameter("miNum"));
//			menu.setMiNum(miNum);
//			int result = ms.updateMenu(menu);
//			String msg = "메뉴 수정에 실패했습니다";
//			String url = "/views/menu/menu-update?miNum=" + miNum;
//			if(result==1) {
//				msg = "메뉴 수정에 성공했습니다";
//				url = "/menu/menu-view?miNum="+miNum;
//			}
//			request.setAttribute("msg", msg);
//			request.setAttribute("url", url);
//			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
//			rd.forward(request, response);
//			return; 
//		}
		
		boolean isMultiPart = ServletFileUpload.isMultipartContent(request);
		System.out.println(isMultiPart);
		
		DiskFileItemFactory factory = new DiskFileItemFactory(); //임시저장 팩토리
		factory.setSizeThreshold(1024*1024*1024);
		factory.setRepository(new File(UPLOAD_PATH));
		
		ServletFileUpload sfu = new ServletFileUpload(factory);
		
		try {
			List<FileItem> items = sfu.parseRequest(request); 
			for(FileItem item : items) {
				
				if(item.isFormField()) { //input태그 등등
					System.out.print(item.getString("UTF-8")+", ");
				}else {
					File f = new File(UPLOAD_PATH + item.getName());
					try {
						item.write(f);
					}catch(Exception e) {
						e.printStackTrace();
					}
				}
				System.out.print(item.isFormField()+", ");
				System.out.print(item.getContentType()+", ");
				System.out.print(item.getFieldName()+", ");
				System.out.print(item.getName()+", ");
				System.out.println(item.getSize());
			}
		} catch (FileUploadException e) {
			e.printStackTrace();
		}
		
	}

}
