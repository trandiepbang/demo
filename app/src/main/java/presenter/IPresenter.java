package presenter;

import java.util.List;

/**
 * Created by darklegend on 7/6/17.
 */

public interface IPresenter {
    void addData(final String title);
    void deleteData(final String title);
    void returnData();
}
