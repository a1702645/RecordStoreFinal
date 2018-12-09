import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/artists")
public class ArtistServlet extends HttpServlet {

  
	private static final long serialVersionUID = 1L;
	private ArtistDao artistDao = new ArtistDao();
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        PrintWriter writer = response.getWriter();
        List<Artist> artists = artistDao.getAllArtists();

        for (Artist a : artists) {
            writer.println(a.getName());
        }

        
        
    }
	
		
	@Override
	public void init() throws ServletException {
	    super.init();
	    this.artistDao = new ArtistDao();
	}

	
	@Override
	public void destroy() {
	    super.destroy();
	}

}
