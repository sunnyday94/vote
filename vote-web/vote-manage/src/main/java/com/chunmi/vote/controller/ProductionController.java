package com.chunmi.vote.controller;

import java.io.File;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.chunmi.vote.controller.filter.MySessionListener;
import com.chunmi.vote.po.VoteProduction;
import com.chunmi.vote.service.VoteActiveService;
import com.chunmi.vote.service.VoteProductionService;
import com.chunmi.vote.utils.Constant;
import com.chunmi.vote.utils.FileUtils;
import com.chunmi.vote.utils.MessageExceptionEnum;
import com.chunmi.vote.utils.PageBean;
import com.chunmi.vote.utils.PageUtil;
import com.chunmi.vote.utils.Response;

@Controller
@RequestMapping(value="/admin")
public class ProductionController {
	
	private Logger logger = LoggerFactory.getLogger(ProductionController.class);
	
	@Autowired
	private VoteProductionService productionService;
	
	
	@Autowired
	private VoteActiveService activeService;
	
	
	
	
	/**
	 * 创建作品页面
	 * @param request
	 * @param model
	 * @return
	 */
	@GetMapping(value="createProduction")
	public String createProduction(HttpServletRequest request,Model model) {
		model.addAttribute(Constant.LOGIN_MANAGER,request.getSession().getAttribute(Constant.LOGIN_MANAGER));
		model.addAttribute("startActiveList",activeService.selectVoteActiveListWithStart());
		model.addAttribute(Constant.ACTIVE_SESSION,MySessionListener.getActiveSession());
		return "production/createProduction";
	}
	

	/**
	 * 保存作品
	 * @param production
	 * @return
	 */
	@PostMapping(value="saveProduction")
	@ResponseBody
	public Response saveProduction(VoteProduction production) {
		try {
			List<VoteProduction> productions= productionService.selectProdutionByActiveIdAndGroupId(production);
			if(productions!=null && productions.size()>0)
				return Response.getError(MessageExceptionEnum.CANNOT_UPLOAD_REPEATEDLY);
			productionService.saveVoteProduction(production);
			return Response.getSuccess();
		} catch (Exception e) {
			logger.debug(e.getMessage());
			return Response.getError(MessageExceptionEnum.ERROR_HANDLE);
		}
	}
	

	/**
	 * 上传作品
	 * @param file
	 * @param request
	 * @return
	 */
	@PostMapping(value="uploadProduction")
	@ResponseBody
	public Response uploadProduction(MultipartFile file,HttpServletRequest request) {
		if (file.getSize() > 50 * 1024 * 1024) 
			return Response.getError(MessageExceptionEnum.PIC_TOO_LARGE);
		try {
			String targetPath = request.getServletContext().getRealPath("/").concat("/production");
			File saveDir = new File(targetPath);
			if(!saveDir.exists())
				saveDir.mkdir();     //创建文件夹
			String newFileName = UUID.randomUUID().toString().replace("-","").concat(".zip");
			File newFile = new File(saveDir, newFileName);
			FileUtils.copyInputStreamToFile(file.getInputStream(),newFile);
			String saveNewFilePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+
					request.getContextPath()+"/production/"+newFile.getName();
			return Response.getSuccess(saveNewFilePath);
		} catch (Exception e) {
			logger.debug(e.getMessage());
			return Response.getError(MessageExceptionEnum.ERROR_HANDLE);
		}
	}
	
	/**
	 * 作品列表(分页显示)
	 * @param request
	 * @param model
	 * @param pageCurrent
	 * @param pageSize
	 * @param pageCount
	 * @return
	 */
	@GetMapping(value="productionList_{pageCurrent}_{pageSize}_{pageCount}")
	public String productionList(HttpServletRequest request,Model model,@PathVariable("pageCurrent")Integer pageCurrent,
			@PathVariable("pageSize")Integer pageSize,@PathVariable("pageCount")Integer pageCount) {
		PageBean<VoteProduction> pb = productionService.selectProductionListByPage(pageCurrent,pageSize,pageCount);
		String pageHTML = PageUtil.getPageContent("productionList_{pageCurrent}_{pageSize}_{pageCount}", pb.getPageCurrent(), pb.getPageSize(), pb.getPageCount());
		model.addAttribute("pb",pb);
		model.addAttribute("pageHTML",pageHTML);
		model.addAttribute(Constant.LOGIN_MANAGER,request.getSession().getAttribute(Constant.LOGIN_MANAGER));
		model.addAttribute(Constant.ACTIVE_SESSION,MySessionListener.getActiveSession());
		return "production/productionList";		
	}
	
	
	/**
	 * 根据活动id查询作品列表
	 * @param request
	 * @param model
	 * @param activeId
	 * @return
	 */
	@GetMapping(value="activeProductionList_{activeId}")
	public String activeProductionList(HttpServletRequest request,Model model,@PathVariable("activeId") Long activeId) {
		List<VoteProduction> activeProductions = productionService.selectProductionListByActiveId(activeId);
		model.addAttribute("activeProductions", activeProductions);
		model.addAttribute(Constant.LOGIN_MANAGER,request.getSession().getAttribute(Constant.LOGIN_MANAGER));
		model.addAttribute(Constant.ACTIVE_SESSION,MySessionListener.getActiveSession());
		return "production/activeProductionList";			
	}
	
	
	/**
	 * 根据作品id删除作品
	 * @param productionId
	 * @return
	 */
	@PostMapping(value="delProductionById")
	@ResponseBody
	public Response delProductionById(Long productionId) {
		try {
			//删除作品
			productionService.delProduction(productionId);
			return Response.getSuccess();
		} catch (Exception e) {
			return Response.getError(MessageExceptionEnum.ERROR_HANDLE);
		}
	}
	
}
