package pojo.currentcitiesweather;

public class CurrentCitiesWeather {

    public CurrentCitiesWeather(){}

    private String message;
    private String cod;
    private String count;
    private List[] list;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public List[] getList() {
        return list;
    }

    public void setList(List[] list) {
        this.list = list;
    }

}
