package edu.andrews.cptr252.ksolomon.quoteoftheday;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.content.Intent;

public class QuoteActivity extends AppCompatActivity {
    private static final String KEY_QUOTE_INDEX = "quoteIndex";
    public static final String EXTRA_AUTHOR_FACT = "edu.andrews.cptr252.ksolomon.quoteoftheday.author_fact";

    private TextView mQuoteTextView;
    private TextView mAuthorTextView;
    private Button mNextButton;



    private Quote[] mQuoteList = new Quote[] {
            new Quote(R.string.quote_text_0, R.string.quote_author_0, R.string.author_fact_0),
            new Quote(R.string.quote_text_1, R.string.quote_author_1, R.string.author_fact_1),
            new Quote(R.string.quote_text_2, R.string.quote_author_2, R.string.author_fact_2)
    };

    private int mCurrentIndex = 0;

    private void displayAuthorFact(){

        Intent i = new Intent(QuoteActivity.this, AuthorFactActivity.class);

        i.putExtra(EXTRA_AUTHOR_FACT, mQuoteList[mCurrentIndex].getAuthorFact());

        startActivity(i);

    }

    private void updateQuote() {
        int quote = mQuoteList[mCurrentIndex].getQuote();
        int author = mQuoteList[mCurrentIndex].getAuthor();

        mQuoteTextView.setText(quote);
        mAuthorTextView.setText(author);

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quote);

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