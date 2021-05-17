package pojo.currentweather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Rain {

    private float _1h;

    public float get_1h() {
        return _1h;
    }

    public void set_1h(float _1h) {
        this._1h = _1h;
    }

}
