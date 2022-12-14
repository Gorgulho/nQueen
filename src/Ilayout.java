import java.util.List;

interface Ilayout {
    /**
     @return the children of the receiver.
     */
    List<Ilayout> children();

    /**
     @return true if the receiver's attack number is zero; return false otherwise.
     */
    boolean isGoal();
    /**
     @return the cost for moving from the input config to the receiver.
     */
    double getG();

    /**
     *
     * @return the receiver's board's number of attacks
     */
    double getH();
}