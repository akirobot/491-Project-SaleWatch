
public interface Attack {

    // Defender cannot be Illuminatis, so that's why the defender's type is a Group.
    // Basically, you can't attack Illuminatis.
    // Attacker is a CombatCard type, because an Illuminati is a CombatCard that can attack.
    // A Group type is still a CombatCard. A Dog is still an Animal. Sub-class and Super-class.
    public void attackToControl(CombatCard attacker, Group defender);
    public void attackToDestroy(CombatCard attacker, Group defender);
    public void attackToNeutralize(CombatCard attacker, Group defender);

}
