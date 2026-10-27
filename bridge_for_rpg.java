public class bridge_for_rpg {
    interface Weapon{
        public void use();
    }

    static class Sword implements Weapon{
        @Override
        public void use(){
            System.out.println("Slash! Dealing 20 physical damage.");
        }
    }

    static class MagicWang implements Weapon{
        @Override
        public void use(){
            System.out.println("Zap! Dealing 35 magic damage");
        }
    }

    abstract class Hero{
        protected Weapon weapon;

        Hero(Weapon weapon){
            this.weapon = weapon;
        }
    }

    public class Knight extends Hero{

    }
}
