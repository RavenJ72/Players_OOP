package hero.player;

public class Player implements Identifiable,Experienced{

    protected String username;
    protected int level;

    public Player(String username,int level){
        setUsername(username);
        setLevel(level);
    }

    protected void setUsername(String username) {
        if (username.length() < 5) {
            throw new IllegalArgumentException("Wrong value to hero's username");
        } else this.username = username;
    }

    protected void setLevel(int level) {
        if (level < 0) {
            throw new IllegalArgumentException("Wrong value to hero's level");
        } else this.level = level;
    }


    @Override
    public int getLevel() {
        return level;
    }

    @Override
    public void levelUp() {
        level++;
        System.out.println(username + " level up");
    }

    @Override
    public String getUserName() {
        return username;
    }
}
