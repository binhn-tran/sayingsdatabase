package sayingsDatabase;

/**
 * The Saying class represents the Hawaiian words, their English translation,
 * as well as an explanation.
 * 
 * @author Binh Tran and Ellie Ishii
 *
 */
public class Saying {
  private String hawaiianWords; // single string of Hawaiian words in the saying
  private String englishTranslation; // English translation of the saying
  private String sayingExplanation; // explanation of the saying

  // constructor to initialize the Saying object with Hawaiian words, English translation, 
  // and an explanation
  public Saying(String hawaiianWords, String englishTranslation, String sayingExplanation) {
    this.hawaiianWords = hawaiianWords; // assign the Hawaiian words
    this.englishTranslation = englishTranslation; // assign the English translation
    this.sayingExplanation = sayingExplanation; // assign the explanation
  }

  // Overloaded constructor without explanation
  // default explanation is an empty string
  public Saying(String hawaiianWords, String englishTranslation) {
    this(hawaiianWords, englishTranslation, ""); // call the constructor with an empty explanation
  }

  // get the Hawaiian words 
  public String getHawaiianWords() {
    return hawaiianWords;
  }

  // get the English translation
  public String getEnglishTranslation() {
    return englishTranslation;
  }

  // get the explanation
  public String getExplanation() {
    return sayingExplanation;
  }

  // override the toString() method to format the string representation of the Saying object
  @Override
  public String toString() {
    return "Hawaiian: " + hawaiianWords + "\nTranslation: " + englishTranslation + "\nExplanation: "
        + sayingExplanation;
  }

}
