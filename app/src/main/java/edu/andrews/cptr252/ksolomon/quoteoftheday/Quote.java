package edu.andrews.cptr252.ksolomon.quoteoftheday;

/**
 * Created by solomonjkim on 1/24/18.
 */

public class Quote {

    private int mQuote;

    private int mAuthor;

    private int mAuthorFact;

    private int mImage;


    public Quote(int quote, int author, int authorFact, int image){
        mQuote = quote;
        mAuthor = author;
        mAuthorFact = authorFact;
        mImage = image;
    }


    public int getQuote()   {return mQuote;}
    public void setQuote(int quote) {mQuote = quote;}
    public int getAuthor()  {return mAuthor;}
    public void setAuthor(int author)   {mAuthor = author;}
    public int getAuthorFact() {return mAuthorFact;}
    public void setAuthorFact(int mAuthorFact) {this.mAuthorFact = mAuthorFact;}
    public int getImage() {return mImage;}
    public void setImage(int mImage) {this.mImage = mImage;}

}
