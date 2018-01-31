package edu.andrews.cptr252.ksolomon.quoteoftheday;

/**
 * Created by solomonjkim on 1/24/18.
 */

public class Quote {

    private int mQuote;

    private int mAuthor;

    private int mAuthorFact;


    public Quote(int quote, int author, int authorFact){
        mQuote = quote;
        mAuthor = author;
        mAuthorFact = authorFact;
    }


    public int getQuote()   {return mQuote;}
    public void setQuote(int quote) {mQuote = quote;}
    public int getAuthor()  {return mAuthor;}
    public void setAuthor(int author)   {mAuthor = author;}
    public int getAuthorFact() {return mAuthorFact;}
    public void setAuthorFact(int mAuthorFact) {this.mAuthorFact = mAuthorFact;}

}
