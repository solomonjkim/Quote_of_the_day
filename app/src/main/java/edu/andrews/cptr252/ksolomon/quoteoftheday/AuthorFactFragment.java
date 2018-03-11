package edu.andrews.cptr252.ksolomon.quoteoftheday;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

/** Activity that displays a fact about the author of a quote.
 *
 */
public class AuthorFactFragment extends AppCompatActivity {
    private TextView mAuthorFactTextView;

    /** Inflate layout. Display the fact sent by QuoteActivity
     *
     * @param savedInstanceState Bundle object used to save activity state.
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_author_fact);

        mAuthorFactTextView = (TextView) findViewById(R.id.authorFactTextView);

        int authorFact = getIntent().getIntExtra(QuoteActivity.EXTRA_AUTHOR_FACT, R.string.fact_error);

        mAuthorFactTextView.setText(authorFact);

    }
}
