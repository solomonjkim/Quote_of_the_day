package edu.andrews.cptr252.ksolomon.quoteoftheday;

import android.support.v4.app.Fragment;

/**
 * Created by solomonjkim on 3/11/18.
 */

public class AuthorFactActivity extends SingleFragmentActivity{

    protected Fragment createFragment(){
        return new AuthorFactFragment();
    }

}
