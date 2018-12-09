
public class Album {
	private long albumId;
	private String title;
	
	public Album(String title, long albumId) {
		this.albumId = albumId;
		this.title = title;
	}
	public String getName() {
		return title;
	}
	public Long getId() {
		return albumId;
	}
	

}
