package board.write.web;

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

import board.createBoard.model.BoardVo;
import board.createBoard.service.BoardService;
import board.createBoard.service.BoardServiceInf;

/**
 * Servlet Filter implementation class WriteFilter
 */
@WebFilter("/*")
public class WriteFilter implements Filter {

	private Logger logger = LoggerFactory.getLogger(WriteFilter.class);
	
    /**
     * Default constructor. 
     */
    public WriteFilter() {
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
		
		//left 게시판 생성
		BoardServiceInf boardService = new BoardService();
		List<BoardVo> boardList = boardService.getAllBoards();
		
		request.setAttribute("boardList",boardList );

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
