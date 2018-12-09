import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class ArtistDao {

    public List<Artist> getAllArtists() {
        ChinookDatabase db = new ChinookDatabase();

        Connection connection = db.connect();
        PreparedStatement statement = null;
        ResultSet results = null;

        List<Artist> list = new ArrayList<>();
        try {
            statement = connection.prepareStatement("SELECT * FROM Artist");
            results = statement.executeQuery();

            while (results.next()) {
                long id = results.getLong("ArtistId");
                String name = results.getString("Name");
                list.add(new Artist(id, name));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            db.close(results, statement, connection);
        }
        return list;
    }
}
