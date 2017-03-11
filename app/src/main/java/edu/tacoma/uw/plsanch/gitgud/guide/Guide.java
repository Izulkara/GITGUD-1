package edu.tacoma.uw.plsanch.gitgud.guide;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.List;

/**
 * Guide is a data object that holds information about a user submitted guide
 */
public class Guide implements Serializable {

    //the data being held
    private String mGuideTitle;
    private String mGuideAuthor;
    private String mGuideHero;
    private String mGuideText;
    private String mGuideId;

    //the names of the tables in the database
    private static final String TITLE = "title", AUTHOR = "username"
            , HERO = "heroname", TEXT = "content", ID = "id";

    /**
     * Guide is a constructor that builds the data object
     *
     * @param theIdText is the guide id
     * @param theGuideTitle is the guide title
     * @param theGuideAuthor is the author username
     * @param theGuideHero is the hero the guide is for
     * @param theGuideText is the content of the guide
     */
    public Guide(String theIdText, String theGuideTitle, String theGuideAuthor, String theGuideHero, String theGuideText) {
        mGuideTitle = theGuideTitle;
        mGuideAuthor = theGuideAuthor;
        mGuideHero = theGuideHero;
        mGuideText = theGuideText;
        mGuideId = theIdText;
    }


    /**
     * getter method
     * @return the guide id
     */
    public String getmGuideId() {
        return mGuideId;
    }

    /**
     * setter method
     * @param mGuideId is the id to be set
     */
    public void setmGuideId(String mGuideId) {
        this.mGuideId = mGuideId;
    }

    /**
     * getter method
     * @return the guide title
     */
    public String getmGuideTitle() {
        return mGuideTitle;
    }

    /**
     * setter method
     * @param mGuideTitle is the guide title
     */
    public void setmGuideTitle(String mGuideTitle) {
        this.mGuideTitle = mGuideTitle;
    }

    /**
     * getter method
     * @return the guide author
     */
    public String getmGuideAuthor() {
        return mGuideAuthor;
    }

    /**
     * setter method
     * @param mGuideAuthor is the guide author to be set
     */
    public void setmGuideAuthor(String mGuideAuthor) {
        this.mGuideAuthor = mGuideAuthor;
    }

    /**
     * getter method
     * @return the guide hero
     */
    public String getmGuideHero() {
        return mGuideHero;
    }

    /**
     * setter method
     * @param mGuideHero is the hero to be set
     */
    public void setmGuideHero(String mGuideHero) {
        this.mGuideHero = mGuideHero;
    }

    /**
     * getter method
     * @return the guide content
     */
    public String getmGuideText() {
        return mGuideText;
    }

    /**
     * setter method
     * @param mGuideText is the content to be set
     */
    public void setmGuideText(String mGuideText) {
        this.mGuideText = mGuideText;
    }

    /**
     * Parses the json string, returns an error message if unsuccessful.
     * Returns course list if success.
     * @param courseJSON
     * @return reason or null if successful.
     */
    public static String parseGuideJSON(String courseJSON, List<Guide> courseList) {
        String reason = null;
        if (courseJSON != null) {
            try {
                JSONArray arr = new JSONArray(courseJSON);

                for (int i = 0; i < arr.length(); i++) {
                    JSONObject obj = arr.getJSONObject(i);
                    Guide course = new Guide(obj.getString(Guide.ID), obj.getString(Guide.TITLE), obj.getString(Guide.AUTHOR)
                            , obj.getString(Guide.HERO), obj.getString(Guide.TEXT));
                    courseList.add(course);
                }
            } catch (JSONException e) {
                reason =  "Unable to parse data, Reason: " + e.getMessage();
            }

        }
        return reason;
    }
}
