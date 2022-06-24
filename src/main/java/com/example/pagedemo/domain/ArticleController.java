package com.example.pagedemo.domain;

import com.example.pagedemo.service.ArticleService;
import com.example.pagedemo.service.ArticleServiceImpl;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.inject.Inject;
import java.util.logging.Logger;

@Controller
@RequestMapping("/article")
public class ArticleController {

//    Logger: slf4j의 로깅 라이브러리, 로그관리
//  private static final Logger logger = LoggerFactory.getLogger(ArticleController.class);
    private static final Logger logger = (Logger) LoggerFactory.getLogger(ArticleController.class);
    private final ArticleService articleService;

    @Inject
    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    //    등록 페이지 이동
//    RequestMapping에 method를 명시하면 똑같은 URI라도 다른 메서드로 매핑해 줄 수 있음
//    url이 /write인 요청 중 GET 메서드인 경우 호출 됨
    @RequestMapping(value = "/write", method = RequestMethod.GET)
    public String writeGET(){
        logger.info("write GET...");

        return "/article/write";
    }

//    목록 페이지 이동
//    Model: 정보를 담아 jsp에 넘겨주는 역할
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model) throws Exception{
        logger.info("list ...");
//        addAttribute: Model에 데이터를 담을 때 사용하는 메서드
        model.addAttribute("articles", articleService.listAll());

        return "/article/list";
    }

//    조회 페이지 이동
    @RequestMapping(value = "/read", method = RequestMethod.GET)
//    @RequestParam: RequestMapping 어노테이션이 적용된 메서드에서 사용, HTTP 요청 파라미터를 매핑
//    JSP에서 String name = request.getParameter("name")과 같음
    public String read(@RequestParam("article_no") int article_no, Model model) throws Exception{
        logger.info("read");
        model.addAttribute("article", articleService.read(article_no));

        return "/article/read";
    }

//    수정 처리
    @RequestMapping(value = "/modify", method = RequestMethod.POST)
//    RedirectAttribute: redirect 시 데이터를 전달
    public String modifyPOST(ArticleVO articleVO, RedirectAttributes redirectAttributes) throws Exception {
        logger.info("modifyPOST ...");
        articleService.update(articleVO);
        redirectAttributes.addFlashAttribute("msg", "modSuccess");

        return "redirect:/article/list";
    }

//    삭제 처리
    @RequestMapping(value = "/remove", method = RequestMethod.POST)
    public String remove(@RequestParam("article_no") int article_no, RedirectAttributes redirectAttributes) throws Exception{
        logger.info("remove ...");
        articleService.delete(article_no);
//        addFlashAttribute: 일회성으로 URL에 붙지 않고 세션 후 재지정 요청이 들어오면 값이 사라짐 (addAttribute는 URL에 붙어서 전달되어 값이 유지), 성공 여부를 가리기 위해 임시적으로 값을 전달 할 때 사용
        redirectAttributes.addFlashAttribute("msg", "delSuccess");

        return "redirect:/article/list";
    }
}
