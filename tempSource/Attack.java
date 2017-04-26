package theilluminatigame;
/** Interface for different types of attacks for CombatCards */

public interface Attack {

    // Defender cannot be Illuminatis, so that's why the defender's type is a Group.
    // Basically, you can't attack Illuminatis.
    // Attacker is a Card type, because an Illuminati is a Card that can attack.
    // A Group type is still a Card. A Dog is still an Animal. Sub-class and Super-class.
    
    public void attackToControl(Card attacker, GroupCard defender);
    public void attackToDestroy(Card attacker, GroupCard defender);
    public void attackToNeutralize(Card attacker, GroupCard defender);

}
