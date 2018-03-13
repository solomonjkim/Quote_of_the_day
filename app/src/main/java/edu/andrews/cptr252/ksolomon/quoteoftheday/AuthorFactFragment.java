package edu.andrews.cptr252.ksolomon.quoteoftheday;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/** Activity that displays a fact about the author of a quote and extends QuoteFragment.
 *
 */
public class AuthorFactFragment extends Fragment {
    private TextView mAuthorFactTextView;


    /** Inflate layout. Display the fact sent by QuoteFragment
     *
     * @param savedInstanceState Bundle object used to save activity state.
     */

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    /** When created to display the fact from QuoteFragment and set the textview. Replaces a traditional onCreate method and uses a view since we are not using fragments
     * @param inflater Inflates the widgets.
     * @param container Allows us to use .xml constraints.
     * @param savedInstanceState Bundle object used to save activity state.
     * @author Solomon Kim
     * @since 03/11/18
     * @return
     */

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

        View v = inflater.inflate(R.layout.activity_author_fact, container, false);

        mAuthorFactTextView = (TextView) v.findViewById(R.id.authorFactTextView);
        int authorFact = getActivity().getIntent().getIntExtra(QuoteFragment.EXTRA_AUTHOR_FACT, R.string.fact_error);
        mAuthorFactTextView.setText(authorFact);

        return v;
    }
}
