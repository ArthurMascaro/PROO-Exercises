package teams_exercise;

public class Player {
    private final String name;
    private int number;
    private int position;
    private boolean isFielded;
    private Team team;

    public Player(String name, int number, int position) {
        this.name = name;
        this.number = number;
        this.position = position;
        this.isFielded = true;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public boolean isFielded() {
        return isFielded;
    }

    public void setFielded(boolean fielded) {
        isFielded = fielded;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public String getStateAsString(){
        return '\n' + "Name: " + name + '\n' +
                "Number: " + number + '\n' +
                "Position: " + position + '\n' +
                "Is Fielded: " + isFielded + '\n';
    }
}
