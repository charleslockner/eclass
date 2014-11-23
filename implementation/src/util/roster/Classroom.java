package util.roster;

/**
 * Class implementation of a classroom
 */
public class Classroom {

    private long id;

    private String name;
    private String url;
    private long duration;

    public Classroom() {
    }

    public Classroom(String name, String url, long duration) {
        super();
        this.name = name;
        this.url = url;
        this.duration = duration;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
