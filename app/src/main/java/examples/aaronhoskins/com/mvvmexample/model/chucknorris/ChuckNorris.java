
package examples.aaronhoskins.com.mvvmexample.model.chucknorris;

import java.util.List;
import com.google.gson.annotations.Expose;


@SuppressWarnings("unused")
public class ChuckNorris {

    @Expose
    private String type;
    @Expose
    private List<Value> value;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Value> getValue() {
        return value;
    }

    public void setValue(List<Value> value) {
        this.value = value;
    }

}
