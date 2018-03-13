package edu.andrews.cptr252.ksolomon.quoteoftheday;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.content.Intent;

/**
 * Main activity for the application.
 * Displays a series of quotes.
 *
 * @author Solomon Kim
 * @since 03/11/18
 */

public class QuoteFragment extends Fragment {
    /** Key for fact about author stored in Intent sent to AuthorFactFragment. */
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

    /** Establishing variables for each text. */
    private TextView mQuoteTextView;
    private TextView mAuthorTextView;
    private Button mNextButton;
    private ImageView mImageView;



    /** Creates the array used to set and reference all text values and images*/
    private Quote[] mQuoteList = new Quote[] {
            new Quote(R.string.quote_text_0, R.string.quote_author_0, R.string.author_fact_0, R.drawable.waterpic),
            new Quote(R.string.quote_text_1, R.string.quote_author_1, R.string.author_fact_1, R.drawable.mountain_pic),
            new Quote(R.string.quote_text_2, R.string.quote_author_2, R.string.author_fact_2, R.drawable.fire),
            new Quote(R.string.quote_text_3, R.string.quote_author_3, R.string.author_fact_3, R.drawable.wind),
            new Quote(R.string.quote_text_4, R.string.quote_author_4, R.string.author_fact_4, R.drawable.airbender)
    };


    private int mCurrentIndex = 0;

/** Display the quote at the current index */
    private void updateQuote() {
        int quote = mQuoteList[mCurrentIndex].getQuote();
        int author = mQuoteList[mCurrentIndex].getAuthor();
        int image = mQuoteList[mCurrentIndex].getImage();

        mQuoteTextView.setText(quote);
        mAuthorTextView.setText(author);
        mImageView .setImageResource(image);
    }

    /** Setup layout, but not displaying that is left up to the view.
     * @param savedInstanceState previously saved Bundle
     */

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        if (savedInstanceState != null) {
            mCurrentIndex = savedInstanceState.getInt(KEY_QUOTE_INDEX);
        }
    }

    /** This method creates the view that will display the author, quote, and image. The only change when using fragments is that
     * now there must be intents used in order to display the Author Fact because we are then referencing another fragment. At the end
     * we call for updateQuote() in order to set those values in the fragment.
     *
     * @author Solomon Kim
     * @since 03/11/18
     *
     * @param container Allows us to use .xml constraints.
     * @param inflater Inflates the widgets
     * @param savedInstanceState Bundle object used to save activity state.
     *
     * @return View
     * */

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

        View v = inflater.inflate(R.layout.activity_quote, container, false);

        mImageView = (ImageView) v.findViewById(R.id.imageView);
        int image = mQuoteList[mCurrentIndex].getImage();
        mImageView.setImageResource(image);
        mImageView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i = new Intent(getContext(), AuthorFactActivity.class);
                i.putExtra(EXTRA_AUTHOR_FACT, mQuoteList[mCurrentIndex].getAuthorFact());
                startActivity(i);
            }
        });

        mQuoteTextView = v.findViewById(R.id.quoteTextView);
        int quote = mQuoteList[mCurrentIndex].getQuote();
        mQuoteTextView.setText(quote);
        mQuoteTextView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i = new Intent(getContext(), AuthorFactActivity.class);
                i.putExtra(EXTRA_AUTHOR_FACT, mQuoteList[mCurrentIndex].getAuthorFact());
                startActivity(i);
            }
        });

        mAuthorTextView = v.findViewById(R.id.authorTextView);
        int author = mQuoteList[mCurrentIndex].getAuthor();
        mAuthorTextView.setText(author);
        mAuthorTextView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i = new Intent(getContext(), AuthorFactActivity.class);
                i.putExtra(EXTRA_AUTHOR_FACT, mQuoteList[mCurrentIndex].getAuthorFact());
                startActivity(i);
            }
        });

        mNextButton = (Button) v.findViewById(R.id.nextButton);
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

        return v;
    }

    }

