package sayingsDatabase;

import java.util.List;
import java.util.Scanner;

/**
 * Creates a SayingsDatabase object to hold all the sayings managed by the AVL
 * tree. Insert
 * sayings using the insert method along with their translations and
 * explanations. Tests functions
 * by printing the first and last sayings in alphabetical order. Checks if a
 * saying exists in the
 * database. Retrieves and prints the predecessor and successor of a saying.
 * Finds sayings that contain
 * a word in the Hawaiian language. Searches for sayings that contain English
 * words as well.
 * 
 * @author Binh Tran and Ellie Ishii
 *
 */
public class Main {
        public static void main(String[] args) {
                // create an instance of SayingsDatabase to store and manage Hawaiian sayings
                SayingsDatabase db = new SayingsDatabase();

                // Adding Hawaiian sayings with hardcoded explanations 
                db.insert(new Saying(
                                "He huewai ola ke kanaka na Kāne.",
                                "People are Kāne’s living water gourd. (Water is life and Kāne is the keeper of it.)",
                                "This saying emphasizes the importance of water and life, linking people to their sustenance."));

                db.insert(new Saying(
                                "ʻAu i ke kai me he manu ala.",
                                "Cross the sea as a bird. (To sail across the sea.)",
                                "A metaphor for overcoming challenges and navigating through life."));

                db.insert(new Saying(
                                "E ʻai i kekahi, e kāpī i kekahi.",
                                "Eat some, salt some.",
                                "Encourages balance in life."));

                db.insert(new Saying(
                                "E hume i ka malo, e hoʻokala i ka ihe.",
                                "Gird the loincloth, sharpen the spear. (A call to prepare for the project at hand.)",
                                "A reminder to prepare and focus on the tasks ahead."));

                db.insert(new Saying(
                                "E kuahui like i ka hana.",
                                "Let everybody pitch in and work together.",
                                "Highlights the importance of collaboration and teamwork."));

                db.insert(new Saying(
                                "E lawe i ke aʻo a mālama, a e ʻoi mau ka naʻauao.",
                                "He who takes his teachings and applies them increases his knowledge.",
                                "Stresses the value of applying knowledge to gain wisdom."));

                db.insert(new Saying(
                                "He aliʻi ka ʻāina; He kauā ke kanaka.",
                                "The land is chief; People are its servant.",
                                "Emphasizes the respect for land and nature."));

                db.insert(new Saying(
                                "He lepo ka ʻai a Oʻahu, a māʻona nō i ka lepo.",
                                "Earth is the food of Oʻahu, and it is satisfied with its earth.",
                                "Expresses the abundance and sustenance provided by the land."));

                db.insert(new Saying(
                                "He pūkoʻa kani ʻāina.",
                                "A coral reef that grows into an island. (A person beginning in a small way gains steadily until he becomes firmly established.)",
                                "Represents growth and stability over time."));

                db.insert(new Saying(
                                "He ʻuala ka ʻai hoʻōla koke i ka wī.",
                                "The sweet potato is the food that ends famine quickly.",
                                "Symbolizes nourishment and the importance of food security."));

                db.insert(new Saying(
                                "ʻIke i ke au nui, me ke au iki.",
                                "Know the big currents and the little currents. (Is very well versed.)",
                                "Refers to being knowledgeable and aware of one's surroundings."));

                db.insert(new Saying(
                                "Ka iʻa hāhā i kahawai.",
                                "The fish groped for in the streams.",
                                "Illustrates persistence in seeking opportunities."));

                db.insert(new Saying(
                                "Kū i ka welo.",
                                "Fits into the family behavior.",
                                "Describes adapting to familial norms and values."));

                db.insert(new Saying(
                                "Lele ka ʻiwa, mālie kai koʻo.",
                                "When the ʻiwa bird flies (out to sea) the rough sea will be calm.",
                                "Indicates that wisdom brings peace and tranquility."));

                db.insert(new Saying(
                                "Mai hoʻomāuna i ka ʻai o huli mai auaneʻi o Hāloa e nānā.",
                                "Do not be wasteful of food lest Hāloa turn around and stare (at you).",
                                "Teaches respect for resources and the consequences of wastefulness."));

                db.insert(new Saying(
                                "Mai ka lā hiki a ka lā kau.",
                                "From the sun’s arrival to the sun’s rest.",
                                "Speaks to the passage of time and the cycle of life."));

                db.insert(new Saying(
                                "Nā ʻOle ka pō, ʻo nā ʻOle ke ao, he ʻole ka loaʻa.",
                                "The nights are ʻOle, the days are ʻOle – nothing to be gotten.",
                                "Reflects feelings of emptiness or lack."));

                db.insert(new Saying(
                                "ʻO nā hōkū nō nā kiu o ka lani.",
                                "The stars are the spies of heaven.",
                                "Suggests that the heavens are always watching."));

                db.insert(new Saying(
                                "Pā ka makani ʻo ka Moaʻe, hele ka lepo o Kahoʻolawe i Māʻalaea.",
                                "When the Moaʻe wind blows, the dust of Kahoʻolawe goes toward Māʻalaea.",
                                "Illustrates the connection between natural elements and locations."));

                db.insert(new Saying(
                                "Ulu o ka lā.",
                                "Growth of the sun.",
                                "Represents new beginnings and hope."));

                db.insert(new Saying(
                                "Waipahē wale.",
                                "As gentle as still water.",
                                "Conveys tranquility and calmness."));

                db.insert(new Saying(
                                "I ka wā ma mua, ka wā ma hope.",
                                "The future is found in the past.",
                                "Encourages reflection on history for guidance."));

                db.insert(new Saying(
                                "Ka naʻauao o nā kūpuna ka lama e hoʻomālamalama i ke ala no nā keiki.",
                                "The wisdom of the elders is the torch that enlightens the path of the children.",
                                "Highlights the importance of wisdom in guiding future generations."));

                db.insert(new Saying(
                                "Hoʻokahi ka ʻilau like ʻana.",
                                "Wield the paddles together.",
                                "Promotes unity and cooperation."));

                db.insert(new Saying(
                                "E ʻōpū aliʻi.",
                                "Have the heart of a chief.",
                                "Encourages leadership qualities in oneself."));

                db.insert(new Saying(
                                "Hoʻokahi nō lā o ka malihini.",
                                "A stranger only for a day.",
                                "Indicates the temporary nature of unfamiliarity."));

                db.insert(new Saying(
                                "Aloha kekahi i kekahi.",
                                "Love one another.",
                                "Emphasizes the importance of love and community."));

                db.insert(new Saying(
                                "ʻAʻohe hua o ka maiʻa i ka lā hoʻokahi.",
                                "No task is too big when done together by all.",
                                "Encourages collaboration and teamwork for success."));

                // Print all sayings
                System.out.println("All Sayings:");
                for (Saying s : db.getAllSayings()) {
                        // print each saying
                        System.out.println(s + "\n");
                }

                // Check if a specific saying is a member in the database 
                String checkWord = "Aloha kekahi i kekahi.";
                System.out.println("Is '" + checkWord + "' a member? " + db.member(checkWord) + "\n");

                // Retrieve and print the first and last sayings in the database
                System.out.println("First saying: \n" + db.first() + "\n");
                System.out.println("Last saying: \n" + db.last() + "\n");

                // Find and print the predecessor and successor of a saying
                System.out.println("Predecessor of 'Kuleana': \n" + db.predecessor("Kuleana") + "\n");
                System.out.println("Successor of 'Kuleana': \n" + db.successor("Kuleana") + "\n");

                // Find sayings with a specific word (Hawaiian word)
                String specificWord = "Aloha"; // word to search for in Hawaiian sayings
                List<Saying> hawaiianSayings = db.withWord(specificWord);

                // Print the sayings that contain the specific word
                System.out.println("Results for MeHua (Hawaiian word search): " + specificWord);
                if (hawaiianSayings.isEmpty()) {
                        System.out.println("No sayings contain the Hawaiian word '" + specificWord + "'.");
                } else {
                        for (Saying saying : hawaiianSayings) {
                                System.out.println(saying + "\n"); // This will call the toString method of Saying
                        }
                }

                // Add a similar block for the English word search
                String englishWord = "Rain"; // word to search for in English translation
                List<Saying> englishSayings = db.withWord(englishWord); // Assuming this method checks English words

                // Print the rseults of the English word search
                System.out.println("Results for WithWord (English word search): " + englishWord);
                if (englishSayings.isEmpty()) {
                        System.out.println("No sayings contain the English word '" + englishWord + "'.");
                } else {
                        for (Saying saying : englishSayings) {
                                System.out.println(saying + "\n"); // This will call the toString method of Saying
                        }
                }
        }
}
