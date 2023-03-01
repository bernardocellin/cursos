public class Movie implements Content{
    private String title;
    private String image;
    private Double rating;
    private Integer year;
    
    public String getTitle() {
    	return this.title;
    }
    public void setTitle(String title) {
    	this.title = title;
    }
    public String getImage() {
    	return this.image;
    }
    public void setImage(String image) {
    	this.image = image;
    }
    public Double getRating() {
    	return this.rating;
    }
    public void setRating(Double rating) {
    	this.rating = rating;
    }
    public Integer getYear() {
    	return this.year;
    }
    public void setYear(Integer year) {
    	this.year = year;
    }

    public int compareTo(Content outro) {
        return this.getRating().compareTo(outro.getRating());
    }
}

