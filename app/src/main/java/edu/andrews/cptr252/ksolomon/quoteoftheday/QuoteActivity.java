package edu.andrews.cptr252.ksolomon.quoteoftheday;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.content.Intent;

/**
 * Main activity for the application.
 * Displays a series of quotes.
 */

public class QuoteActivity extends AppCompatActivity {
    /** Key for fact about author stored in Intent sent to AuthorFactActivity. */
    public static final String EXTRA_AUTHOR_FACT = "edu.andrews.cptr252.ksolomon.quoteoftheday.author_fact";
    private static final String KEY_QUOTE_INDEX = "quoteIndex";

    /**
     * Remember the current quote when the activity is destroyed.
     * @param savedInstanceState Bundle used for saving identity of current quote.
     */
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState);

        savedInstanceState.putInt(KEY_QUOTE_INDEX, mCurrentIndex);
    }

    private TextView mQuoteTextView;
    private TextView mAuthorTextView;
    private Button mNextButton;




    private Quote[] mQuoteList = new Quote[] {
            new Quote(R.string.quote_text_0, R.string.quote_author_0, R.string.author_fact_0),
            new Quote(R.string.quote_text_1, R.string.quote_author_1, R.string.author_fact_1),
            new Quote(R.string.quote_text_2, R.string.quote_author_2, R.string.author_fact_2)
    };

    private int mCurrentIndex = 0;

    /** Launch activity to display author fact */
    private void displayAuthorFact(){

        Intent i = new Intent(QuoteActivity.this, AuthorFactActivity.class);

        i.putExtra(EXTRA_AUTHOR_FACT, mQuoteList[mCurrentIndex].getAuthorFact());

        startActivity(i);

    }
/** Display the quote at the current index */
    private void updateQuote() {
        int quote = mQuoteList[mCurrentIndex].getQuote();
        int author = mQuoteList[mCurrentIndex].getAuthor();

        mQuoteTextView.setText(quote);
        mAuthorTextView.setText(author);
    }

    /** Setup and inflate layout.
     * @param savedInstanceState previously saved Bundle
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quote);

        if (savedInstanceState != null){
            mCurrentIndex = savedInstanceState.getInt(KEY_QUOTE_INDEX);
        }

        mQuoteTextView = findViewById(R.id.quoteTextView);
        int quote = mQuoteList[mCurrentIndex].getQuote();
        mQuoteTextView.setText(quote);
        mQuoteTextView.setOnClickListener(new View.OnClickListener(){
            @Override
                    public void onClick(View v){
                displayAuthorFact();
            }
        });

        mAuthorTextView = findViewById(R.id.authorTextView);
        int author = mQuoteList[mCurrentIndex].getAuthor();
        mAuthorTextView.setText(author);
        mAuthorTextView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                displayAuthorFact();
            }
        });

        mNextButton = (Button) findViewById(R.id.nextButton);
        mNextButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v){
                mCurrentIndex++;

                if (mCurrentIndex == mQuoteList.length) {
                    mCurrentIndex = 0;
                }
                updateQuote();
            }

        });
    }
}
