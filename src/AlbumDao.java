import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class AlbumDao {

    public List<Album> getAllAlbums() {
        ChinookDatabase db = new ChinookDatabase();

        Connection connection = db.connect();
        PreparedStatement statement = null;
        ResultSet results = null;

        List<Album> list = new ArrayList<>();
        try {
            statement = connection.prepareStatement("SELECT * FROM Album");
            results = statement.executeQuery();

            while (results.next()) {
                long albumId = results.getLong("albumId");
                String title = results.getString("title");
                list.add(new Album(title, albumId));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            db.close(results, statement, connection);
        }
        return list;
    }
}
