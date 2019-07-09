
package examples.aaronhoskins.com.mvvmexample.model.chucknorris;

import java.util.List;
import com.google.gson.annotations.Expose;


@SuppressWarnings("unused")
public class Value {

    @Expose
    private List<Object> categories;
    @Expose
    private Long id;
    @Expose
    private String joke;

    public List<Object> getCategories() {
        return categories;
    }

    public void setCategories(List<Object> categories) {
        this.categories = categories;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getJoke() {
        return joke;
    }

    public void setJoke(String joke) {
        this.joke = joke;
    }

}
