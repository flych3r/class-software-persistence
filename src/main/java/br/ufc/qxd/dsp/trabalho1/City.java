package br.ufc.qxd.dsp.trabalho1;

public class City {

    private Integer id;
    private String name;
    private String coords;
    private Integer startYear;
    private String urlName;
    private String country;
    private String countryState;

    public City(Integer id, String name, String coords, Integer startYear, String urlName, String country, String countryState) {
        this.id = id;
        this.name = name;
        this.coords = coords;
        this.startYear = startYear;
        this.urlName = urlName;
        this.country = country;
        this.countryState = countryState;
    }

    public City() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCoords() {
        return coords;
    }

    public void setCoords(String coords) {
        this.coords = coords;
    }

    public Integer getStartYear() {
        return startYear;
    }

    public void setStartYear(Integer startYear) {
        this.startYear = startYear;
    }

    public String getUrlName() {
        return urlName;
    }

    public void setUrlName(String urlName) {
        this.urlName = urlName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountryState() {
        return countryState;
    }

    public void setCountryState(String countryState) {
        this.countryState = countryState;
    }

    @Override
    public String toString() {
        return "Cities{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", coords='" + coords + '\'' +
                ", startYear=" + startYear +
                ", urlName='" + urlName + '\'' +
                ", country='" + country + '\'' +
                ", countryState='" + countryState + '\'' +
                '}';
    }
}
