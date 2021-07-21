package sahab.singh.samplecopy;
public class MoviesData {

    private String fileurl;
    boolean mActionChecked;
    boolean mAdventureChecked;
    boolean mComedyChecked;
    boolean mCrimeChecked;
    boolean mEnglishChecked;
    boolean mFantasyChecked;
    boolean mHindiChecked;
    boolean mHistoricalChecked;
    boolean mHorrorChecked;
    boolean mPunjabiChecked;
    boolean mRomanceChecked;
    boolean mScience_fictionChecked;
    boolean mTamilChecked;
    boolean mTeluguChecked;
    boolean mThrillerChecked;
    boolean mWebSeries;
    private String name;
    private String official_source;
    private String photoUrl;
    private String year;
    private String zTrailer;
    public MoviesData() {
    }

    public MoviesData(String fileurl, boolean mActionChecked, boolean mAdventureChecked, boolean mComedyChecked,
                      boolean mCrimeChecked, boolean mEnglishChecked, boolean mFantasyChecked, boolean mHindiChecked,
                      boolean mHistoricalChecked, boolean mHorrorChecked, boolean mPunjabiChecked, boolean mRomanceChecked,
                      boolean mScience_fictionChecked, boolean mTamilChecked, boolean mTeluguChecked, boolean mThrillerChecked,
                      boolean mWebSeries, String name, String official_source, String photoUrl, String year,String zTrailer) {
        this.fileurl = fileurl;
        this.mActionChecked = mActionChecked;
        this.mAdventureChecked = mAdventureChecked;
        this.mComedyChecked = mComedyChecked;
        this.mCrimeChecked = mCrimeChecked;
        this.mEnglishChecked = mEnglishChecked;
        this.mFantasyChecked = mFantasyChecked;
        this.mHindiChecked = mHindiChecked;
        this.mHistoricalChecked = mHistoricalChecked;
        this.mHorrorChecked = mHorrorChecked;
        this.mPunjabiChecked = mPunjabiChecked;
        this.mRomanceChecked = mRomanceChecked;
        this.mScience_fictionChecked = mScience_fictionChecked;
        this.mTamilChecked = mTamilChecked;
        this.mTeluguChecked = mTeluguChecked;
        this.mThrillerChecked = mThrillerChecked;
        this.mWebSeries = mWebSeries;
        this.name = name;
        this.official_source = official_source;
        this.photoUrl = photoUrl;
        this.year = year;
        this.zTrailer= zTrailer;
    }

    public String getzTrailer() {
        return zTrailer;
    }

    public void setzTrailer(String zTrailer) {
        this.zTrailer = zTrailer;
    }

    public String getFileurl() {
        return fileurl;
    }

    public void setFileurl(String fileurl) {
        this.fileurl = fileurl;
    }

    public boolean ismActionChecked() {
        return mActionChecked;
    }

    public void setmActionChecked(boolean mActionChecked) {
        this.mActionChecked = mActionChecked;
    }

    public boolean ismAdventureChecked() {
        return mAdventureChecked;
    }

    public void setmAdventureChecked(boolean mAdventureChecked) {
        this.mAdventureChecked = mAdventureChecked;
    }

    public boolean ismComedyChecked() {
        return mComedyChecked;
    }

    public void setmComedyChecked(boolean mComedyChecked) {
        this.mComedyChecked = mComedyChecked;
    }

    public boolean ismCrimeChecked() {
        return mCrimeChecked;
    }

    public void setmCrimeChecked(boolean mCrimeChecked) {
        this.mCrimeChecked = mCrimeChecked;
    }

    public boolean ismEnglishChecked() {
        return mEnglishChecked;
    }

    public void setmEnglishChecked(boolean mEnglishChecked) {
        this.mEnglishChecked = mEnglishChecked;
    }

    public boolean ismFantasyChecked() {
        return mFantasyChecked;
    }

    public void setmFantasyChecked(boolean mFantasyChecked) {
        this.mFantasyChecked = mFantasyChecked;
    }

    public boolean ismHindiChecked() {
        return mHindiChecked;
    }

    public void setmHindiChecked(boolean mHindiChecked) {
        this.mHindiChecked = mHindiChecked;
    }

    public boolean ismHistoricalChecked() {
        return mHistoricalChecked;
    }

    public void setmHistoricalChecked(boolean mHistoricalChecked) {
        this.mHistoricalChecked = mHistoricalChecked;
    }

    public boolean ismHorrorChecked() {
        return mHorrorChecked;
    }

    public void setmHorrorChecked(boolean mHorrorChecked) {
        this.mHorrorChecked = mHorrorChecked;
    }

    public boolean ismPunjabiChecked() {
        return mPunjabiChecked;
    }

    public void setmPunjabiChecked(boolean mPunjabiChecked) {
        this.mPunjabiChecked = mPunjabiChecked;
    }

    public boolean ismRomanceChecked() {
        return mRomanceChecked;
    }

    public void setmRomanceChecked(boolean mRomanceChecked) {
        this.mRomanceChecked = mRomanceChecked;
    }

    public boolean ismScience_fictionChecked() {
        return mScience_fictionChecked;
    }

    public void setmScience_fictionChecked(boolean mScience_fictionChecked) {
        this.mScience_fictionChecked = mScience_fictionChecked;
    }

    public boolean ismTamilChecked() {
        return mTamilChecked;
    }

    public void setmTamilChecked(boolean mTamilChecked) {
        this.mTamilChecked = mTamilChecked;
    }

    public boolean ismTeluguChecked() {
        return mTeluguChecked;
    }

    public void setmTeluguChecked(boolean mTeluguChecked) {
        this.mTeluguChecked = mTeluguChecked;
    }

    public boolean ismThrillerChecked() {
        return mThrillerChecked;
    }

    public void setmThrillerChecked(boolean mThrillerChecked) {
        this.mThrillerChecked = mThrillerChecked;
    }

    public boolean ismWebSeries() {
        return mWebSeries;
    }

    public void setmWebSeries(boolean mWebSeries) {
        this.mWebSeries = mWebSeries;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOfficial_source() {
        return official_source;
    }

    public void setOfficial_source(String official_source) {
        this.official_source = official_source;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}