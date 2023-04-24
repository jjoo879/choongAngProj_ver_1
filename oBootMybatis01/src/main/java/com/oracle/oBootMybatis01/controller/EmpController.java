package com.oracle.oBootMybatis01.controller;

import java.util.HashMap;
import java.util.List;

import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oracle.oBootMybatis01.model.Dept;
import com.oracle.oBootMybatis01.model.DeptVO;
import com.oracle.oBootMybatis01.model.Emp;
import com.oracle.oBootMybatis01.model.EmpDept;
import com.oracle.oBootMybatis01.model.Member1;
import com.oracle.oBootMybatis01.service.EmpService;
import com.oracle.oBootMybatis01.service.Paging;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequiredArgsConstructor
public class EmpController {
	private final EmpService es = null;
	private final JavaMailSender mailSender = null;

	@RequestMapping(value = "listEmp")
	public String empList(Emp emp , String currentPage, Model model) {
		System.out.println("EmpController Start listEmp..." );
		// Emp �쟾泥� Count  21
		int totalEmp =  es.totalEmp();
		System.out.println("EmpController totalEmp=>" + totalEmp);
		// Paging �옉�뾽
		Paging   page = new Paging(totalEmp, currentPage);
		// Parameter emp --> Page留� 異붽� Setting
		emp.setStart(page.getStart());   // �떆�옉�떆 1       11
		emp.setEnd(page.getEnd());       // �떆�옉�떆 10      20 

		List<Emp> listEmp = es.listEmp(emp);
		System.out.println("EmpController list listEmp.size()=>" + listEmp.size());
		
		model.addAttribute("totalEmp", totalEmp);
		model.addAttribute("listEmp" , listEmp);
		model.addAttribute("page"    , page);

		return "list";

	}

	@GetMapping(value = "detailEmp")
	public String detailEmp(int empno , Model model) {
		System.out.println("EmpController Start detailEmp..." );
		System.out.println("EmpController detailEmp empno->"+empno );

		//		1. EmpService�븞�뿉 detailEmp method �꽑�뼵
		//		   1) parameter : empno
		//		   2) Return      Emp
		//
		//		2. EmpDao   detailEmp method �꽑�뼵 
		////		                    mapper ID   ,    Parameter
		//		emp = session.selectOne("tkEmpSelOne",    empno);
		Emp emp = es.detailEmp(empno);
		model.addAttribute("emp",emp);
		
		return "detailEmp";

	}	

	@GetMapping(value = "updateFormEmp")
	public String updateFormEmp(int empno , Model model) {
		System.out.println("EmpController Start updateForm..." );
		
		Emp emp = es.detailEmp(empno);
		System.out.println("EmpController updateFormEmp emp->"+emp);
		// 臾몄젣 
		// 1. DTO  String hiredate
		// 2.View : �떒�닚議고쉶 OK ,JSP�뿉�꽌 input type="date" 臾몄젣 諛쒖깮
		// 3.�빐寃곗콉  : �뀈�썡�씪留� 吏ㅻ씪 �꽔�뼱 二쇱뼱�빞 �븿 
		String hiredate = "";
		if (emp.getHiredate() != null) {
			hiredate = emp.getHiredate().substring(0, 10);
			emp.setHiredate(hiredate);
		}

		model.addAttribute("emp",emp);
		return "updateFormEmp";
	}
	
	@PostMapping(value="updateEmp")
	public String updateEmp(Emp emp, Model model) {
        log.info("updateEmp Start...");
//      1. EmpService�븞�뿉 updateEmp method �꽑�뼵
//      1) parameter : Emp
//      2) Return      updateCount (int)
//
//   2. EmpDao updateEmp method �꽑�뼵
////                              mapper ID   ,    Parameter
//   updateCount = session.update("tkEmpUpdate",emp);
   		int updateCount = es.updateEmp(emp);
		System.out.println("empController es.updateEmp updateCount-->"+updateCount);
		model.addAttribute("uptCnt",updateCount);   // Test Controller媛� Data �쟾�떖
		model.addAttribute("kk3","Message Test");   // Test Controller媛� Data �쟾�떖
        // �씠�룞View �떒�뿉 model �쟾�떖 X
		// return "redirect:listEmp";   
        // �씠�룞View �떒�뿉 model �쟾�떖 O
		return "forward:listEmp";   
	}

	@RequestMapping(value = "writeFormEmp" )
	public String writeFormEmp(Model model) {
		System.out.println("EmpController  writeFormEmp Start..." );
		// 愿�由ъ옄 �궗踰� 留� Get
		List<Emp> empList =  es.listManager();
		System.out.println("EmpController writeForm empList.size->"+empList.size());
		model.addAttribute("empMngList",empList); // emp Manager List

		// 遺��꽌(肄붾뱶,遺��꽌紐�)
		List<Dept> deptList = es.deptSelect();
		model.addAttribute("deptList", deptList); // dept
		System.out.println("EmpController writeForm deptList.size->"+deptList.size());
		
		 return "writeFormEmp";
	}
	
	@RequestMapping(value = "writeFormEmp3" )
	public String writeFormEmp3(Model model) {
		System.out.println("EmpController  writeFormEmp3 Start..." );
		// 愿�由ъ옄 �궗踰� 留� Get
		List<Emp> empList =  es.listManager();
		System.out.println("EmpController writeForm3 empList.size->"+empList.size());
		model.addAttribute("empMngList",empList); // emp Manager List

		// 遺��꽌(肄붾뱶,遺��꽌紐�)
		// 遺��꽌(肄붾뱶,遺��꽌紐�)
		List<Dept> deptList = es.deptSelect();
		model.addAttribute("deptList", deptList); // dept
		System.out.println("EmpController writeForm3 deptList.size->"+deptList.size());
		
		 return "writeFormEmp3";
	}

	@PostMapping(value = "writeEmp")
	public String writeEmp(Emp emp , Model model) {
		System.out.println("EmpController Start writeEmp..." );
		
		// Service, Dao , Mapper紐�[insertEmp] 源뚯� -> insert
		int insertResult = es.insertEmp(emp); 
		System.out.println("EmpController writeEmp insertResult->"+insertResult );
		
		if (insertResult > 0) return "redirect:listEmp";
		else {
			model.addAttribute("msg","�엯�젰 �떎�뙣 �솗�씤�빐 蹂댁꽭�슂");
			return "forward:writeFormEmp";
		}
	}	
	// Validation�떆 李몄“�븯�꽭�슂
	@PostMapping(value = "writeEmp3")
	public String writeEmp3 (  @ModelAttribute("emp") @Valid Emp emp
			                ,  BindingResult result
			                ,  Model model
			                ) 
	    {
			System.out.println("EmpController Start writeEmp3..." );
			
			// Validation �삤瑜섏떆 Result
			if(result.hasErrors()) {
				System.out.println("EmpController writeEmp3 hasErrors... ");
				model.addAttribute("msg","BindingResult �엯�젰 �떎�뙣 �솗�씤�빐 蹂댁꽭�슂");
				return "forward:writeFormEmp3";
			}
			
			// Service, Dao , Mapper紐�[insertEmp] 源뚯� -> insert
			int insertResult = es.insertEmp(emp); 
			if (insertResult > 0) return "redirect:listEmp";
			else {
				model.addAttribute("msg","�엯�젰 �떎�뙣 �솗�씤�빐 蹂댁꽭�슂");
				return "forward:writeFormEmp3";
			}
			
		}
	
	@GetMapping(value="confirm")
	public String confirm(int empno, Model model) {
		Emp emp = es.detailEmp(empno);
		model.addAttribute("empno", empno);
		if (emp !=null) {
			System.out.println("empController confirm 以묐났�맂 �궗踰�.. ");
			model.addAttribute("msg","以묐났�맂 �궗踰덉엯�땲�떎");			
			return "forward:writeFormEmp";
		} else {
			System.out.println("empController confirm �궗�슜 媛��뒫�븳 �궗踰�.. ");
			model.addAttribute("msg","�궗�슜 媛��뒫�븳 �궗踰덉엯�땲�떎");
			return "forward:writeFormEmp";
		}
	}
	
	// Controller -->  deleteEmp    1.parameter : empno
	//     name -> Service, dao , mapper

	@RequestMapping(value="deleteEmp")
	public String deleteEmp(int empno, Model model) {
		System.out.println("EmpController Start delete..." );
		int result = es.deleteEmp(empno);
		return "redirect:listEmp";
	}
	
	@RequestMapping(value = "listSearch3")
	public String listSearch3(Emp emp , String currentPage, Model model) {
		System.out.println("EmpController listSearch3 Start ..." );
		// Emp �쟾泥� Count  25
		int totalEmp =  es.conditionEmpCount(emp);
		System.out.println("EmpController listSearch3 totalEmp=>" + totalEmp);
		// Paging �옉�뾽
		Paging   page = new Paging(totalEmp, currentPage);
		// Parameter emp --> Page留� 異붽� Setting
		emp.setStart(page.getStart());   // �떆�옉�떆 1
		emp.setEnd(page.getEnd());       // �떆�옉�떆 10 

		List<Emp> listSearchEmp = es.listSearchEmp(emp);
		System.out.println("EmpController listSearch3 listSearchEmp.size()=>" + 
		                           listSearchEmp.size());
		
		model.addAttribute("totalEmp", totalEmp);
		model.addAttribute("listEmp" , listSearchEmp);
		model.addAttribute("page"    , page);
		
		return "list";	
	}

	@GetMapping(value="listEmpDept")
	public String listEmpDept(Model model) {
		System.out.println("EmpController listEmpDept Start...");
		// Service , DAO(ed) -> listEmpDept
		// Mapper留� ->tkListEmpDept
		List<EmpDept> listEmpDept = es.listEmpDept();
		model.addAttribute("listEmpDept",listEmpDept);
		return "listEmpDept";
	}
	
	@RequestMapping(value="mailTransport")
	public String mailTransport(HttpServletRequest request, Model model) {
		System.out.println("mailSending...");
		String tomail = "ttaekwang3@naver.com";              // 諛쏅뒗 �궗�엺 �씠硫붿씪
		System.out.println(tomail);
		String setfrom = "ttaekwang3@gmail.com";
		String title = "mailTransport �엯�땲�떎";                 // �젣紐�

		try {
			//  Mime �쟾�옄�슦�렪 Internet �몴以� Format
			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper messageHelper = new MimeMessageHelper(message, true , 
					                                                "UTF-8");
			messageHelper.setFrom(setfrom);    // 蹂대궡�뒗�궗�엺 �깮�왂�븯嫄곕굹 �븯硫� �젙�긽�옉�룞�쓣 �븞�븿
			messageHelper.setTo(tomail);       // 諛쏅뒗�궗�엺 �씠硫붿씪
			messageHelper.setSubject(title);   // 硫붿씪�젣紐⑹� �깮�왂�씠 媛��뒫�븯�떎
			String tempPassword = (int) (Math.random() * 999999) + 1 + "";
			messageHelper.setText("�엫�떆 鍮꾨�踰덊샇�엯�땲�떎 : " + tempPassword); // 硫붿씪 �궡�슜
			System.out.println("�엫�떆 鍮꾨�踰덊샇�엯�땲�떎 : " + tempPassword);
			DataSource dataSource = new FileDataSource("c:\\log\\2.gif");
			messageHelper.addAttachment(MimeUtility.encodeText("hwa3.png", "UTF-8", "B"),
					                    dataSource);
			mailSender.send(message);
			model.addAttribute("check", 1);   // �젙�긽 �쟾�떖
		    // DB tempPassword Logic 援ъ꽦 
		} catch (Exception e) {
			System.out.println("mailTransport e.getMessage()->"+e.getMessage());
			model.addAttribute("check", 2);  // 硫붿씪 �쟾�떖 �떎�뙣
		}
		
		return "mailResult";
	}
	
	// Procedure Test �엯�젰�솕硫� 
	@RequestMapping(value = "writeDeptIn")
	public String writeDeptIn(Model model) {
		 System.out.println("writeDeptIn Start..");
	     return "writeDept3";
	}

	// Procedure �넻�븳 Dept �엯�젰�썑 VO �쟾�떖 
	@PostMapping(value="writeDept")
	public String writeDept(DeptVO deptVO , Model model) {
		es.insertDept(deptVO);
		if (deptVO == null) {
			System.out.println("deptVO NULL");
		}else {
			System.out.println("deptVO.getOdeptno()->"+deptVO.getOdeptno());
			System.out.println("deptVO.getOdname()->"+deptVO.getOdname());
			System.out.println("deptVO.getOloc()->"+deptVO.getOloc());
			model.addAttribute("msg", "�젙�긽 �엯�젰 �릺�뿀�뒿�땲�떎 ^^");
			model.addAttribute("dept", deptVO);
		}
		return "writeDept3";
	}
	
	// Map �쟻�슜
	@GetMapping(value = "writeDeptCursor")
	public String writeDeptCursor(Model model) {
	    System.out.println("EmpController writeDeptCursor Start...");
	    // 遺��꽌踰붿쐞 議고쉶
		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put("sDeptno", 10);
		map.put("eDeptno", 51);

        es.selListDept(map);
        List<Dept> deptLists = (List<Dept>) map.get("dept");
        for(Dept dept : deptLists) {
        	System.out.println("dept.getDname->"+dept.getDname());
			System.out.println("dept.getLoc->"+dept.getLoc());
        }
		System.out.println("deptList Size->"+ deptLists.size());
		model.addAttribute("deptList", deptLists);
		
		 return "writeDeptCursor";
	}	
	
	// interCeptor �떆�옉 �솕硫� 
	@RequestMapping(value = "interCeptorForm")
	public String interCeptorForm(Model model) {
		System.out.println("interCeptorForm Start");
	    return "interCeptorForm";
	}

	// 2.interCeptor Number 2
	@RequestMapping(value="interCeptor")
	public String interCeptor(String id, Model model) {
		System.out.println("EmpController  interCeptor  Test Start");
		System.out.println("EmpController  interCeptor id->"+id);
		// 議댁옱 : 1  , 鍮꾩〈�옱 : 0
		int memCnt = es.memCount(id); 
		
		System.out.println("EmpController interCeptor memCnt ->"+ memCnt);

		model.addAttribute("id",id);
		model.addAttribute("memCnt",memCnt);
		System.out.println("interCeptor  Test End");
	
		return "interCeptor";   // User 議댁옱�븯硫�  User �씠�슜 議고쉶 Page
	}
	
	 // SampleInterceptor �궡�슜�쓣 諛쏆븘 泥섎━ 
	@RequestMapping(value = "doMemberWrite", method = RequestMethod.GET)
	public String doMemberWrite( Model model,  HttpServletRequest request) {
		 String ID =  (String) request.getSession().getAttribute("ID");
		 System.out.println("doMemberWrite 遺��꽣 �븯�꽭�슂");
		 model.addAttribute("id",ID);
		 return "doMemberWrite";
	 }  

	 // interCeptor 吏꾪뻾 Test
	 @RequestMapping(value="doMemberList")
	 public String doMemberList(Model model, HttpServletRequest request){
		String ID =  (String) request.getSession().getAttribute("ID");
		System.out.println("doMemberList  Test Start  ID ->"+ID);
		Member1 member1 = null;
		// Member1 List Get Service
		List<Member1> listMem = es.listMem(member1);
		model.addAttribute("ID",ID);
		model.addAttribute("listMem",listMem);
		return "doMemberList";   // User 議댁옱�븯硫�  User �씠�슜 議고쉶 Page
	 }		

		//  ajaxForm Test �엯�젰�솕硫� 
		@RequestMapping(value = "ajaxForm")
		public String ajaxForm(Model model) {
			 System.out.println("ajaxForm Start..");
		     return "ajaxForm";
		}

        @ResponseBody
		@RequestMapping(value = "getDeptName")
		public String getDeptName(int  deptno, Model model) {
			System.out.println("deptno->"+deptno);
			String deptName = es.deptName(deptno);		
			System.out.println("deptName->"+deptName);
			return  deptName;
		}

    	// Ajax  List Test
    	@RequestMapping(value="listEmpAjaxForm")
    	public String listEmpAjaxForm(Model model) {
    		Emp emp = new Emp();
    		System.out.println("Ajax  List Test Start");
    		// Parameter emp --> Page留� 異붽� Setting
    		emp.setStart(1);   // �떆�옉�떆 1
    		emp.setEnd(10);    // �떆�옉�떆 10 

    		List<Emp> listEmp = es.listEmp(emp);
    		System.out.println("EmpController listEmpAjax listEmp.size()->"+listEmp.size());
    		model.addAttribute("result","kkk");
    		model.addAttribute("listEmp",listEmp);
    		return "listEmpAjaxForm";
    	 }
        
        @RequestMapping(value = "listEmpAjaxForm2")
        public String listEmpAjaxForm2(Model model) {
    		System.out.println("listEmpAjaxForm2 Start..");
    		Emp emp = new Emp();
    		System.out.println("Ajax  List Test Start");
    		// Parameter emp --> Page留� 異붽� Setting
    		emp.setStart(1);   // �떆�옉�떆 1
    		emp.setEnd(10);    // �떆�옉�떆 10 
    		List<Emp> listEmp = es.listEmp(emp);
    		model.addAttribute("listEmp",listEmp);
        	return "listEmpAjaxForm2";
        }     
        
        
        
        
        
        
        

}
