package br.ufc.qxd.dsp.trabalho1.entity;

public class Line {

    private Integer id;
    private City city;
    private String name;
    private String urlName;
    private String color;

    public Line(Integer id, City city, String name, String urlName, String color) {
        this.id = id;
        this.city = city;
        this.name = name;
        this.urlName = urlName;
        this.color = color;
    }

    public Line() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrlName() {
        return urlName;
    }

    public void setUrlName(String urlName) {
        this.urlName = urlName;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Line{" +
                "id=" + id +
                ", city=" + city +
                ", name='" + name + '\'' +
                ", urlName='" + urlName + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
