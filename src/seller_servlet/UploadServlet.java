package seller_servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import seller_dao.Add_picture;

import com.jspsmart.upload.File;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

public class UploadServlet extends HttpServlet {

	public UploadServlet() {
		super();
	}

	public void destroy() {
		super.destroy(); 
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String goodsName = (String) session.getAttribute("goodsName");	//获取商品名称
		SmartUpload smartUpload = new SmartUpload();
		//初始化
		ServletConfig config = this.getServletConfig();
		smartUpload.initialize(config,request,response);
			//上传文件
			try {
				smartUpload.upload();
			} catch (SmartUploadException e) {
				e.printStackTrace();
			}
			//得到上传的文件对象
			File smartFile = smartUpload.getFiles().getFile(0);
			//保存文件
			try {
				smartFile.saveAs("/picture/"+smartFile.getFileName(),smartUpload.SAVE_VIRTUAL);
			} catch (SmartUploadException e) {
				e.printStackTrace();
			}
			String path = smartFile.getFileName();
			path = "../picture/" + path;
			Add_picture add_picture = new Add_picture();	//创建DAO对象
			boolean bool = add_picture.add_picture(goodsName, path);
			if(bool){
				response.sendRedirect("/MyProject_Demo_one/sellerView/findGoods.jsp");
			}else{
				response.sendRedirect("/MyProject_Demo_one/sellerView/pictureFail.jsp");
			}
		
	}

	public void init() throws ServletException {
	}

}
