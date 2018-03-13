package edu.andrews.cptr252.ksolomon.quoteoftheday;

import android.support.v4.app.Fragment;

/** Activity meant to use the AuthorFactFragment as the single fragment.
 *
 * @author Solomon Kim
 * @since 03/11/18.
 */
public class AuthorFactActivity extends SingleFragmentActivity{

    protected Fragment createFragment(){
        return new AuthorFactFragment();
    }

}
