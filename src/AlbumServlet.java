import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/albums")
public class AlbumServlet extends HttpServlet {

  
	private static final long serialVersionUID = 1L;
	private AlbumDao albumDao = new AlbumDao();
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        PrintWriter writer = response.getWriter();
        List<Album> album = albumDao.getAllAlbums();

        for (Album a : album) {
            writer.println(a.getName());
        }

        
        
    }
	
		
	@Override
	public void init() throws ServletException {
	    super.init();
	    this.albumDao = new AlbumDao();
	}

	
	@Override
	public void destroy() {
	    super.destroy();
	}

}
