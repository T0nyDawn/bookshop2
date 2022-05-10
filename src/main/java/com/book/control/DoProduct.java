package com.book.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.book.entity.Product;
import com.book.model.BookService;
import com.mysql.cj.x.protobuf.MysqlxResultset.ContentType_BYTES;

/**
 * Servlet implementation class DoProduct
 * Controller---C
 * һ��servlet��һ���£���κϲ�---todo
 */
@WebServlet("/doproduct")
public class DoProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoProduct() {
        super();
        // TODO Auto-generated constructor stub
    }
    private Product Request2Product(HttpServletRequest request) {
    	return null;
    }
    
    private <T> T  Request2Entity(Class<T> cls,HttpServletRequest request) {
    	//????
    	//����	bean�������Ը�ֵ
    	//request.getParameterMap();
    	return null;
    }
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//ÿ�ζ��ü� ������ todo
    	request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setHeader("Content-Type","text/html;charset=UTF-8");
    	
		//out=response.getWriter();
		String cmd=request.getParameter("cmd");
		//ͨ�����Ƶ��÷���	java����
		
		
		//Method method=this.getClass().getMethod(cmd, HttpServletRequest.class,HttpServletResponse.class);
		
		//(1)��ȡ����
		String lb_str=request.getParameter("lb");//������� *�� todo
		int lb=0;
		if(lb_str!=null) {
			lb=Integer.parseInt(lb_str);
		}
		Product proc=Request2Entity(Product.class,request);
		//(2)ִ��ҵ���߼�������Model--Service
		//out.println("a="+a);
		//com.book.dao.ProductDao book = new ProductDao();
		//book.setLb(lb);
		BookService bs =new BookService();
		List<Product> bookList=bs.getBookListByLb(lb);
		//(3)��ʽת����ΪV׼��ת��
		request.setAttribute("books", bookList);
		//VIEW-V
		request.getRequestDispatcher("product.jsp").forward(request, response);;
	}
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served-doGet at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		response.getWriter().append("Served-doPost at: ").append(request.getContextPath());
	}

}
