import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/index")
public class IndexServlet extends HttpServlet {

  
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/index.jsp").include(request, response);
    }
@WebServlet("/artists")
	public class ArtistListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
		private ArtistDao artistDao;

	    @Override
	    public void init() throws ServletException {
	        super.init();
	        this.setArtistDao(new ArtistDao());
	    }

		public ArtistDao getArtistDao() {
			return artistDao;
		}

		public void setArtistDao(ArtistDao artistDao) {
			this.artistDao = artistDao;
		}
	}

	
	@Override
	public void init() throws ServletException {
	    super.init();
	}

	
	@Override
	public void destroy() {
	    super.destroy();
	}

}
