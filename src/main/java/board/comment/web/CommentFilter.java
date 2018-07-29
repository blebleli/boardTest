package board.comment.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import board.boardFile.model.BoardFileVo;
import board.boardFile.service.BoardFileService;
import board.boardFile.service.BoardFileServiceInf;
import board.comment.model.CommentVo;
import board.comment.service.CommentService;
import board.comment.service.CommentServiceInf;
import board.createBoard.model.BoardVo;
import board.createBoard.service.BoardService;
import board.createBoard.service.BoardServiceInf;
import board.write.web.WriteFilter;

/**
 * Servlet Filter implementation class CommentFilter
 */
@WebFilter(filterName="CommentFilter", urlPatterns="/writeDetailView/*")
public class CommentFilter implements Filter {


	private Logger logger = LoggerFactory.getLogger(CommentFilter.class);
	
    /**
     * Default constructor. 
     */
    public CommentFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		//전처리
		if(request instanceof HttpServletRequest) {
		HttpServletRequest req = (HttpServletRequest)request;
		logger.debug(req.getRequestURI() + " : DefCompFilter doFilter");
		
		CommentServiceInf commentService = new CommentService();
		BoardFileServiceInf fileService = new BoardFileService();
		
		//선택한 게시글번호 가져오기
		int w_id = Integer.parseInt(request.getParameter("w_id"));
		//댓글 ======
		List<CommentVo> commentList = commentService.getAllComments(w_id);
		int commentCnt = commentService.getCountComments(w_id);
		
		//파일======
		List<BoardFileVo> fileList = fileService.getAllFiles(w_id);
		int fileCnt = commentService.getCountComments(w_id);
		
		
		request.setAttribute("commentList", commentList);
		request.setAttribute("commentCnt", commentCnt);
		request.setAttribute("fileList", fileList);
		request.setAttribute("fileCnt", fileCnt);
		
		
		
		
		}
		
		
		
		
		
		//fileter - servlet 요청 처리
		chain.doFilter(request, response);
		
		//후처리
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
