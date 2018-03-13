package edu.andrews.cptr252.ksolomon.quoteoftheday;

import android.support.v4.app.Fragment;

/** This class operates the exact same way as AuthorFactActivity. Simply creates a single fragment and references the QuoteFragment.
 *
 * @author Solomon Kim
 * @since 3/11/18.
 */
public class QuoteActivity  extends SingleFragmentActivity{

    @Override
    protected Fragment createFragment(){
        return new QuoteFragment();
    }
}
