import java.util.Random;

public class LuckyCardFacade {
    private final static ArrayList<JailCard> luckyCard = {new GoToJailCard(), new GoToJailCard(), new PayJailFeeCard(), new PayJailFeeCard(), new JailExceptionCard()};
    private JailCard pickedCard;
    private Random randomizer = new Random();

    public LuckyCardFacade() {}

    public void draw(Player p, Location jail) {
        int randomIndex = randomizer.nextInt(luckyCard.size());
        this.pickedCard = luckyCard.get(randomIndex);
        this.pickedCard.action(p, jail);
    }
}